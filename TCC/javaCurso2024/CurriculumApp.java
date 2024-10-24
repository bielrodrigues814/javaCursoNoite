package javaCurso2024;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.io.image.ImageDataFactory;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class CurriculumApp {
	private static String imagePath = null;
	private static String language = "Português"; // Idioma padrão
	private static JTextArea experienceArea;
	private static JTextArea educationArea;
	private static JTextArea aboutMeArea;
	private static String selectedTip;

	public static void main(String[] args) {
		SwingUtilities.invokeLater(CurriculumApp::createStartScreen);
	}

	private static void createStartScreen() {
		JFrame startFrame = createFrame("Bem-vindo ao Criador de Currículos", 400, 200);
		JLabel welcomeLabel = new JLabel("Clique para iniciar", SwingConstants.CENTER);
		welcomeLabel.setFont(new Font("Arial", Font.BOLD, 16));

		JButton startButton = createButton("Iniciar", e -> {
			startFrame.dispose();
			createLanguageSelectionScreen();
		});

		startFrame.add(welcomeLabel, BorderLayout.CENTER);
		startFrame.add(startButton, BorderLayout.SOUTH);
		startFrame.setVisible(true);
	}

	private static void createLanguageSelectionScreen() {
		JFrame langFrame = createFrame("Selecionar Idioma", 400, 200);
		JPanel panel = createPanel();

		String[] languages = { "Português", "Inglês", "Espanhol" };
		JComboBox<String> languageSelector = new JComboBox<>(languages);
		languageSelector.addActionListener(e -> {
			language = (String) languageSelector.getSelectedItem();
			JOptionPane.showMessageDialog(langFrame, "Idioma selecionado: " + language);
		});

		panel.add(createLabel("Selecione o Idioma:", 14));
		panel.add(languageSelector);
		panel.add(createButton("Continuar", e -> {
			langFrame.dispose();
			createCurriculumScreen();
		}));

		langFrame.add(panel);
		langFrame.setVisible(true);
	}

	private static void createCurriculumScreen() {
		JFrame frame = createFrame("Criador de Currículos", 600, 600);
		JPanel panel = createPanel();

		panel.add(createButton("Novo Currículo", e -> createNewCurriculum()));
		panel.add(createButton("Ver Currículos Salvos", e -> openCurriculumChooser()));
		panel.add(createButton("Frases para o Currículo", e -> showTips()));
		panel.add(createButton("Dicas para Entrevista", e -> showInterviewTips()));
		panel.add(createButton("Voltar", e -> {
			frame.dispose();
			createLanguageSelectionScreen();
		}));

		frame.add(panel);
		frame.setVisible(true);
	}

	private static void createNewCurriculum() {
		JFrame newCurriculumFrame = createFrame("Novo Currículo", 600, 600);
		JPanel newCurriculumPanel = createPanel();

		addInputField(newCurriculumPanel, "Nome:");
		addInputField(newCurriculumPanel, "Email:");
		addInputField(newCurriculumPanel, "Telefone:");
		addInputField(newCurriculumPanel, "Endereço:");

		newCurriculumPanel.add(createLabel("Experiência Profissional:", 14));
		experienceArea = new JTextArea(3, 20);
		newCurriculumPanel.add(new JScrollPane(experienceArea));

		newCurriculumPanel.add(createLabel("Educação:", 14));
		educationArea = new JTextArea(3, 20);
		newCurriculumPanel.add(new JScrollPane(educationArea));

		newCurriculumPanel.add(createLabel("Sobre mim:", 14));
		aboutMeArea = new JTextArea(3, 20);
		newCurriculumPanel.add(new JScrollPane(aboutMeArea));

		JButton photoButton = createButton("Adicionar Foto", e -> addPhoto(newCurriculumFrame));
		newCurriculumPanel.add(photoButton);

		newCurriculumPanel.add(createButton("Visualizar Currículo", e -> showPreview(newCurriculumPanel)));
		newCurriculumPanel
				.add(createButton("Salvar em PDF", e -> saveCurriculum(newCurriculumPanel, newCurriculumFrame)));
		newCurriculumPanel.add(createButton("Voltar", e -> {
			newCurriculumFrame.dispose();
			createCurriculumScreen();
		}));

		newCurriculumFrame.add(newCurriculumPanel);
		newCurriculumFrame.setVisible(true);
	}

	private static void addPhoto(JFrame frame) {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Escolher Foto");
		fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Imagens", "jpg", "jpeg", "png"));
		int returnValue = fileChooser.showOpenDialog(frame);
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fileChooser.getSelectedFile();
			imagePath = selectedFile.getAbsolutePath();
			JOptionPane.showMessageDialog(frame, "Foto selecionada: " + imagePath);
		}
	}

	private static void addInputField(JPanel panel, String label) {
		panel.add(createLabel(label, 14));
		JTextField textField = new JTextField();
		panel.add(textField);
		panel.add(Box.createRigidArea(new Dimension(0, 10)));
	}

	private static void showTips() {
		String[] tips = { "1. Proativo e sempre em busca de aprendizado.",
				"2. Excelente comunicação e habilidades interpessoais.",
				"3. Capacidade de trabalhar em equipe e resolver problemas." };

		JFrame tipsFrame = createFrame("Frases para o Currículo", 400, 400);
		JPanel tipsPanel = createPanel();

		for (String tip : tips) {
			JButton tipButton = createButton(tip, e -> {
				selectedTip = tip;
				enableInsertButton(tipsFrame);
			});
			tipsPanel.add(tipButton);
		}

		tipsFrame.add(tipsPanel);
		tipsFrame.setVisible(true);
	}

	private static void enableInsertButton(JFrame tipsFrame) {
		JButton insertButton = new JButton("Inserir no Currículo");
		insertButton.addActionListener(e -> {
			experienceArea.append(selectedTip + "\n");
			tipsFrame.dispose();
		});
		tipsFrame.add(insertButton);
		tipsFrame.revalidate();
		tipsFrame.repaint();
	}

	private static void showInterviewTips() {
		String[] interviewTips = { "1. Pesquise sobre a empresa antes da entrevista.",
				"2. Vista-se de forma profissional e adequada.", "3. Chegue com antecedência." };

		JFrame tipsFrame = createFrame("Dicas para Entrevista", 400, 400);
		JPanel tipsPanel = createPanel();

		for (String tip : interviewTips) {
			JButton tipButton = createButton(tip, e -> JOptionPane.showMessageDialog(tipsFrame, tip));
			tipsPanel.add(tipButton);
		}

		tipsFrame.add(tipsPanel);
		tipsFrame.setVisible(true);
	}

	private static void openCurriculumChooser() {
		File[] savedCurriculums = new File("caminho/dos/curriculos").listFiles((dir, name) -> name.endsWith(".pdf"));
		if (savedCurriculums != null && savedCurriculums.length > 0) {
			String[] options = new String[savedCurriculums.length];
			for (int i = 0; i < savedCurriculums.length; i++) {
				options[i] = savedCurriculums[i].getName();
			}
			String selectedCurriculum = (String) JOptionPane.showInputDialog(null, "Selecione um currículo salvo:",
					"Currículos Salvos", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
			if (selectedCurriculum != null) {
				openCurriculum(selectedCurriculum);
			}
		} else {
			JOptionPane.showMessageDialog(null, "Nenhum currículo salvo encontrado.");
		}
	}

	private static JFrame createFrame(String title, int width, int height) {
		JFrame frame = new JFrame(title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(width, height);
		frame.setLocationRelativeTo(null);
		return frame;
	}

	private static JPanel createPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		return panel;
	}

	private static JButton createButton(String text, java.awt.event.ActionListener action) {
		JButton button = new JButton(text);
		button.setBackground(Color.LIGHT_GRAY);
		button.setForeground(Color.BLACK);
		button.setFocusPainted(false);
		button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
		button.addActionListener(action);
		return button;
	}

	private static JLabel createLabel(String text, int fontSize) {
		JLabel label = new JLabel(text);
		label.setFont(new Font("Arial", Font.BOLD, fontSize));
		return label;
	}

	private static void showPreview(JPanel panel) {
		JFrame previewFrame = createFrame("Visualização do Currículo", 500, 600);
		previewFrame.setLayout(new GridBagLayout());

		JTextArea previewArea = new JTextArea();
		previewArea.setEditable(false);
		previewArea.setText("Nome: \n" + "Email: \n" + "Telefone: \n" + "Endereço: \n" + "Experiência Profissional: \n"
				+ experienceArea.getText() + "Educação: \n" + educationArea.getText() + "Sobre mim: \n"
				+ aboutMeArea.getText());
		previewFrame.add(new JScrollPane(previewArea));

		JButton backButton = createButton("Voltar", e -> previewFrame.dispose());
		previewFrame.add(backButton, new GridBagConstraints());
		previewFrame.setVisible(true);
	}

	private static void saveCurriculum(JPanel panel, JFrame frame) {
		// Implementar a lógica de salvar o currículo em PDF
		JOptionPane.showMessageDialog(frame, "Currículo salvo com sucesso!");
		frame.dispose();
	}

	private static void openCurriculum(String curriculumName) {
		// Implementar a lógica para abrir o currículo salvo
		JOptionPane.showMessageDialog(null, "Abrindo currículo: " + curriculumName);
	}
}
