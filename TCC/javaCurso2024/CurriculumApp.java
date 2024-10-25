package javaCurso2024;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CurriculumApp {
	private static String language = "Português"; // Idioma padrão
	private static JTextArea experienceArea;
	private static JTextArea educationArea;
	private static JTextArea aboutMeArea;
	private static String selectedTip;
	private static List<JTextField> inputFields = new ArrayList<>();
	private static String selectedTemplate;
	private static JLabel photoLabel; // Para exibir a foto

	public static void main(String[] args) {
		SwingUtilities.invokeLater(CurriculumApp::createStartScreen);
	}

	private static void createStartScreen() {
		JFrame startFrame = createFrame("Bem-vindo ao Criador de Currículos", 400, 300);
		startFrame.setContentPane(new JLabel(new ImageIcon("path/to/your/background/image.jpg"))); // Imagem de fundo
		startFrame.setLayout(new BorderLayout());

		JPanel overlayPanel = new JPanel();
		overlayPanel.setOpaque(false); // Torna o painel transparente
		overlayPanel.setLayout(new BoxLayout(overlayPanel, BoxLayout.Y_AXIS));

		JLabel welcomeLabel = new JLabel("Clique para iniciar", SwingConstants.CENTER);
		welcomeLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
		welcomeLabel.setForeground(Color.WHITE); // Texto branco

		JButton startButton = createButton("Iniciar", e -> {
			startFrame.dispose();
			createLanguageSelectionScreen();
		});
		startButton.setFont(new Font("Segoe UI", Font.BOLD, 16));
		startButton.setBackground(new Color(0, 102, 204)); // Azul escuro
		startButton.setForeground(Color.WHITE);
		startButton.setBorderPainted(false); // Remove a borda

		overlayPanel.add(Box.createVerticalGlue());
		overlayPanel.add(welcomeLabel);
		overlayPanel.add(Box.createRigidArea(new Dimension(0, 20))); // Espaço entre o título e o botão
		overlayPanel.add(startButton);
		overlayPanel.add(Box.createVerticalGlue());

		startFrame.add(overlayPanel, BorderLayout.CENTER);
		startFrame.setVisible(true);
	}

	private static void createLanguageSelectionScreen() {
		JFrame langFrame = createFrame("Selecionar Idioma", 400, 200);
		JPanel panel = createModernPanel();

		String[] languages = { "Português", "Inglês", "Espanhol" };
		JComboBox<String> languageSelector = new JComboBox<>(languages);
		languageSelector.setBackground(Color.WHITE);

		panel.add(createLabel("Selecione o Idioma:", 14));
		panel.add(languageSelector);
		panel.add(createButton("Continuar", e -> {
			language = (String) languageSelector.getSelectedItem();
			JOptionPane.showMessageDialog(langFrame, "Idioma selecionado: " + language);
			langFrame.dispose();
			createCurriculumScreen();
		}));

		langFrame.add(panel);
		langFrame.setVisible(true);
	}

	private static void createCurriculumScreen() {
		JFrame frame = createFrame("Criador de Currículos", 600, 600);
		JPanel panel = createModernPanel();
		panel.setLayout(new GridLayout(0, 1, 10, 10)); // Layout com mais espaço entre os botões

		panel.add(createButton("Criar Novo Currículo", e -> createNewCurriculum()));
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
		JPanel newCurriculumPanel = createModernPanel();

		// Adicionar foto primeiro
		JButton addPhotoButton = createButton("Adicionar Foto", e -> addPhoto(newCurriculumPanel));
		newCurriculumPanel.add(addPhotoButton);
		photoLabel = new JLabel(); // Para exibir a foto
		newCurriculumPanel.add(photoLabel);

		addInputField(newCurriculumPanel, "Nome:");
		addInputField(newCurriculumPanel, "Email:");
		addInputField(newCurriculumPanel, "Telefone:");
		addInputField(newCurriculumPanel, "Endereço:");

		// Campo para LinkedIn
		newCurriculumPanel.add(createLabel("Link do LinkedIn:", 14));
		JTextField linkedinField = new JTextField();
		linkedinField.setBorder(BorderFactory.createEmptyBorder()); // Remove a borda
		newCurriculumPanel.add(linkedinField);

		newCurriculumPanel.add(createLabel("Escolha um Modelo:", 14));
		String[] templates = { "Modelo 1", "Modelo 2", "Modelo 3", "Modelo 4", "Modelo 5" };
		JComboBox<String> templateSelector = new JComboBox<>(templates);
		newCurriculumPanel.add(templateSelector);

		newCurriculumPanel.add(createLabel("Experiência Profissional:", 14));
		experienceArea = new JTextArea(3, 20);
		newCurriculumPanel.add(new JScrollPane(experienceArea));

		newCurriculumPanel.add(createLabel("Educação:", 14));
		educationArea = new JTextArea(3, 20);
		newCurriculumPanel.add(new JScrollPane(educationArea));

		newCurriculumPanel.add(createLabel("Sobre mim:", 14));
		aboutMeArea = new JTextArea(3, 20);
		newCurriculumPanel.add(new JScrollPane(aboutMeArea));

		newCurriculumPanel.add(createButton("Visualizar Currículo",
				e -> showPreview(newCurriculumPanel, (String) templateSelector.getSelectedItem())));
		newCurriculumPanel.add(createButton("Salvar em PDF", e -> saveCurriculum(newCurriculumPanel, newCurriculumFrame,
				linkedinField.getText(), (String) templateSelector.getSelectedItem())));
		newCurriculumPanel.add(createButton("Voltar", e -> {
			newCurriculumFrame.dispose();
			createCurriculumScreen();
		}));

		newCurriculumFrame.add(newCurriculumPanel);
		newCurriculumFrame.setVisible(true);
	}

	private static void addPhoto(JPanel panel) {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Selecionar Foto");
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		fileChooser.setAcceptAllFileFilterUsed(false);
		fileChooser.setFileFilter(
				new javax.swing.filechooser.FileNameExtensionFilter("Imagens", "jpg", "jpeg", "png", "gif"));

		int userSelection = fileChooser.showOpenDialog(panel);
		if (userSelection == JFileChooser.APPROVE_OPTION) {
			File file = fileChooser.getSelectedFile();
			ImageIcon imageIcon = new ImageIcon(file.getAbsolutePath());
			photoLabel.setIcon(imageIcon);
			photoLabel.setText(null); // Remove o texto, se houver
			photoLabel.setHorizontalAlignment(JLabel.CENTER);
			photoLabel.setPreferredSize(new Dimension(100, 100)); // Ajusta o tamanho da imagem
			photoLabel.setIcon(new ImageIcon(imageIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH))); // Redimensiona
																														// a
																														// imagem
			panel.revalidate();
			panel.repaint();
		}
	}

	private static void addInputField(JPanel panel, String label) {
		panel.add(createLabel(label, 14));
		JTextField textField = new JTextField();
		inputFields.add(textField);
		textField.setBorder(BorderFactory.createEmptyBorder()); // Remove a borda
		panel.add(textField);
		panel.add(Box.createRigidArea(new Dimension(0, 10)));
	}

	private static boolean isValidEmail(String email) {
		String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
		return email.matches(emailRegex);
	}

	private static void showTips() {
		String[] tips = { "1. Proativo e sempre em busca de aprendizado.",
				"2. Excelente comunicação e habilidades interpessoais.",
				"3. Capacidade de trabalhar em equipe e resolver problemas.", "4. Comprometido e responsável.",
				"5. Adaptabilidade e flexibilidade.", "6. Habilidades de liderança e gerenciamento de projetos.",
				"7. Iniciativa para resolver problemas de forma criativa.", "8. Atenção aos detalhes e organização.",
				"9. Capacidade de trabalhar sob pressão.", "10. Espírito crítico e capacidade de análise.",
				"11. Conhecimento em ferramentas digitais e tecnológicas.", "12. Empatia e habilidade de ouvir." };

		JFrame tipsFrame = createFrame("Frases para o Currículo", 400, 400);
		JPanel tipsPanel = createModernPanel();

		for (String tip : tips) {
			JButton tipButton = createButton(tip, e -> {
				selectedTip = tip;
				enableInsertButton(tipsFrame);
			});
			tipButton.setBorderPainted(false); // Remove a borda
			tipsPanel.add(tipButton);
		}

		tipsFrame.add(tipsPanel);
		tipsFrame.setVisible(true);
	}

	private static void enableInsertButton(JFrame tipsFrame) {
		JButton insertButton = createButton("Inserir Frase", e -> {
			if (selectedTip != null) {
				aboutMeArea.append(selectedTip + "\n");
			}
			tipsFrame.dispose();
		});
		tipsFrame.add(insertButton, BorderLayout.SOUTH);
		tipsFrame.revalidate();
	}

	private static void showInterviewTips() {
		String interviewTips = "1. Pesquise sobre a empresa.\n" + "2. Prepare suas respostas para perguntas comuns.\n"
				+ "3. Vista-se adequadamente.\n" + "4. Chegue no horário.\n" + "5. Mostre confiança e seja educado.";
		JOptionPane.showMessageDialog(null, interviewTips, "Dicas para Entrevista", JOptionPane.INFORMATION_MESSAGE);
	}

	private static void showPreview(JPanel panel, String template) {
		StringBuilder preview = new StringBuilder("Currículo Preview:\n");
		for (JTextField field : inputFields) {
			preview.append(field.getText()).append("\n");
		}
		preview.append("Experiência:\n").append(experienceArea.getText()).append("\n");
		preview.append("Educação:\n").append(educationArea.getText()).append("\n");
		preview.append("Sobre mim:\n").append(aboutMeArea.getText()).append("\n");

		JOptionPane.showMessageDialog(panel, preview.toString(), "Pré-visualização", JOptionPane.INFORMATION_MESSAGE);
	}

	private static void saveCurriculum(JPanel panel, JFrame frame, String linkedin, String template) {
		try {
			String filePath = "curriculo.pdf"; // Caminho do arquivo PDF
			PdfWriter writer = new PdfWriter(filePath);
			PdfDocument pdf = new PdfDocument(writer);
			Document document = new Document(pdf);

			document.add(new Paragraph("Currículo"));
			for (JTextField field : inputFields) {
				document.add(new Paragraph(field.getText()));
			}
			document.add(new Paragraph("LinkedIn: " + linkedin));
			document.add(new Paragraph("Experiência: " + experienceArea.getText()));
			document.add(new Paragraph("Educação: " + educationArea.getText()));
			document.add(new Paragraph("Sobre mim: " + aboutMeArea.getText()));

			document.close();
			JOptionPane.showMessageDialog(panel, "Currículo salvo como PDF!", "Sucesso",
					JOptionPane.INFORMATION_MESSAGE);
			frame.dispose();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(panel, "Erro ao salvar o currículo!", "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}

	private static JFrame createFrame(String title, int width, int height) {
		JFrame frame = new JFrame(title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(width, height);
		frame.setLocationRelativeTo(null);
		return frame;
	}

	private static JPanel createModernPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Ajusta o espaço interno
		return panel;
	}

	private static JLabel createLabel(String text, int fontSize) {
		JLabel label = new JLabel(text);
		label.setFont(new Font("Segoe UI", Font.PLAIN, fontSize));
		return label;
	}

	private static JButton createButton(String text, java.awt.event.ActionListener actionListener) {
		JButton button = new JButton(text);
		button.addActionListener(actionListener);
		button.setFocusPainted(false); // Remove o foco
		button.setBackground(new Color(0, 153, 51)); // Verde
		button.setForeground(Color.WHITE);
		button.setBorder(BorderFactory.createEmptyBorder()); // Remove a borda
		return button;
	}
}
