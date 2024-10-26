package javaCurso2024;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.pdf.font.PdfEncodings;

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
    private static List<JTextField> inputFields = new ArrayList<>();
    private static JLabel photoLabel; // Para exibir a foto

    // Adicionando uma classe para armazenar os estilos de cada modelo
    static class ModelStyle {
        String name;
        String fontName;
        int fontSize;
        boolean isBold;

        ModelStyle(String name, String fontName, int fontSize, boolean isBold) {
            this.name = name;
            this.fontName = fontName;
            this.fontSize = fontSize;
            this.isBold = isBold;
        }
    }

    // Criação de estilos de modelo
    private static ModelStyle[] modelStyles = {
        new ModelStyle("Modelo 1", "Arial", 24, true),
        new ModelStyle("Modelo 2", "Times New Roman", 20, true),
        new ModelStyle("Modelo 3", "Courier New", 18, false)
    };

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CurriculumApp::createStartScreen);
    }

    private static void createStartScreen() {
        JFrame startFrame = createFrame("Bem-vindo ao Criador de Currículos", 600, 400);
        startFrame.setContentPane(new JLabel(new ImageIcon("path/to/your/background/image.jpg"))); // Imagem de fundo
        startFrame.setLayout(new BorderLayout());

        JPanel overlayPanel = new JPanel();
        overlayPanel.setOpaque(false); // Torna o painel transparente
        overlayPanel.setLayout(new BoxLayout(overlayPanel, BoxLayout.Y_AXIS));

        JLabel welcomeLabel = new JLabel("Bem-vindo ao Criador de Currículos", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
        welcomeLabel.setForeground(new Color(0, 51, 102)); // Azul escuro

        JButton startButton = createButton("Iniciar", e -> {
            startFrame.dispose();
            createLanguageSelectionScreen();
        });
        startButton.setFont(new Font("Segoe UI", Font.BOLD, 16));
        startButton.setBackground(new Color(34, 150, 243)); // Azul claro
        startButton.setForeground(Color.WHITE);
        startButton.setBorderPainted(false);
        startButton.setPreferredSize(new Dimension(150, 40));

        overlayPanel.add(Box.createVerticalGlue());
        overlayPanel.add(welcomeLabel);
        overlayPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        overlayPanel.add(startButton);
        overlayPanel.add(Box.createVerticalGlue());

        startFrame.add(overlayPanel, BorderLayout.CENTER);
        startFrame.setVisible(true);
    }

    private static void createLanguageSelectionScreen() {
        JFrame langFrame = createFrame("Selecionar Idioma", 600, 300);
        JPanel panel = createModernPanel();

        String[] languages = { "Português", "Inglês", "Espanhol" };
        JComboBox<String> languageSelector = new JComboBox<>(languages);
        languageSelector.setBackground(Color.WHITE);
        languageSelector.setBorder(BorderFactory.createEmptyBorder()); // Remove a borda

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
        JFrame frame = createFrame("Criador de Currículos", 800, 800);
        JPanel panel = createModernPanel();
        panel.setLayout(new GridLayout(0, 1, 10, 10));

        panel.add(createButton("Criar Novo Currículo", e -> createNewCurriculum()));
        panel.add(createButton("Ver Currículos Salvos", e -> openSavedCurriculums()));
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
        JFrame newCurriculumFrame = createFrame("Novo Currículo", 800, 800);
        JPanel newCurriculumPanel = createModernPanel();

        JButton addPhotoButton = createButton("Adicionar Foto", e -> addPhoto(newCurriculumPanel));
        newCurriculumPanel.add(addPhotoButton);
        photoLabel = new JLabel();
        newCurriculumPanel.add(photoLabel);

        addInputField(newCurriculumPanel, "Nome:");
        addInputField(newCurriculumPanel, "Email:");
        addInputField(newCurriculumPanel, "Telefone:");
        addInputField(newCurriculumPanel, "Endereço:");

        newCurriculumPanel.add(createLabel("Link do LinkedIn:", 14));
        JTextField linkedinField = new JTextField();
        linkedinField.setBorder(BorderFactory.createEmptyBorder()); // Remove a borda
        newCurriculumPanel.add(linkedinField);

        newCurriculumPanel.add(createLabel("Experiência Profissional:", 14));
        experienceArea = new JTextArea(3, 20);
        newCurriculumPanel.add(new JScrollPane(experienceArea));

        newCurriculumPanel.add(createLabel("Educação:", 14));
        educationArea = new JTextArea(3, 20);
        newCurriculumPanel.add(new JScrollPane(educationArea));

        newCurriculumPanel.add(createLabel("Sobre mim:", 14));
        aboutMeArea = new JTextArea(3, 20);
        newCurriculumPanel.add(new JScrollPane(aboutMeArea));

        // Adicionando o JComboBox para seleção de modelo
        newCurriculumPanel.add(createLabel("Escolha um modelo:", 14));
        String[] modelos = { "Modelo 1", "Modelo 2", "Modelo 3" };
        JComboBox<String> modeloSelector = new JComboBox<>(modelos);
        newCurriculumPanel.add(modeloSelector);

        newCurriculumPanel.add(createButton("Visualizar Currículo", e -> showPreview(newCurriculumPanel, modeloSelector.getSelectedItem().toString())));
        newCurriculumPanel.add(createButton("Salvar em PDF", e -> saveCurriculum(newCurriculumPanel, linkedinField.getText(), modeloSelector.getSelectedItem().toString())));
        newCurriculumPanel.add(createButton("Voltar", e -> {
            newCurriculumFrame.dispose();
            createCurriculumScreen();
        }));

        newCurriculumFrame.add(newCurriculumPanel);
        newCurriculumFrame.setVisible(true);
    }

    private static void openSavedCurriculums() {
        File savedDir = new File("Currículos Salvos");
        if (!savedDir.exists()) {
            savedDir.mkdirs(); // Cria a pasta se não existir
        }

        File[] curriculums = savedDir.listFiles((dir, name) -> name.endsWith(".pdf"));
        if (curriculums != null && curriculums.length > 0) {
            StringBuilder fileList = new StringBuilder("Currículos Salvos:\n");
            for (File file : curriculums) {
                fileList.append(file.getName()).append("\n");
            }
            JOptionPane.showMessageDialog(null, fileList.toString(), "Currículos Salvos", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum currículo salvo encontrado.", "Currículos Salvos", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static void addPhoto(JPanel panel) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Selecionar Foto");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Imagens", "jpg", "jpeg", "png", "gif"));

        int userSelection = fileChooser.showOpenDialog(panel);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            ImageIcon imageIcon = new ImageIcon(file.getAbsolutePath());
            photoLabel.setIcon(new ImageIcon(imageIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
            panel.revalidate();
            panel.repaint();
        }
    }

    private static void addInputField(JPanel panel, String label) {
        panel.add(createLabel(label, 14));
        JTextField textField = new JTextField();
        textField.setBorder(BorderFactory.createEmptyBorder()); // Remove a borda
        inputFields.add(textField);
        panel.add(textField);
    }

    private static void showTips() {
        String[] tips = {
            "1. Boa comunicação verbal e escrita.",
            "2. Habilidade de trabalhar em equipe e resolver problemas.",
            "3. Comprometido e responsável.",
            "4. Adaptabilidade e flexibilidade.",
            "5. Habilidades de liderança e gerenciamento de projetos.",
            "6. Iniciativa para resolver problemas de forma criativa.",
            "7. Atenção aos detalhes e organização.",
            "8. Capacidade de trabalhar sob pressão.",
            "9. Espírito crítico e capacidade de análise.",
            "10. Conhecimento em ferramentas digitais e tecnológicas.",
            "11. Empatia e habilidade de ouvir."
        };

        JFrame tipsFrame = createFrame("Frases para o Currículo", 400, 400);
        JPanel tipsPanel = createModernPanel();

        for (String tip : tips) {
            JButton tipButton = createButton(tip, e -> {
                aboutMeArea.append(tip + "\n");
                tipsFrame.dispose();
            });
            tipsPanel.add(tipButton);
        }

        tipsFrame.add(tipsPanel);
        tipsFrame.setVisible(true);
    }

    private static void showInterviewTips() {
        String interviewTips = "1. Pesquise sobre a empresa.\n" +
                               "2. Prepare suas respostas para perguntas comuns.\n" +
                               "3. Vista-se adequadamente.\n" +
                               "4. Chegue no horário.\n" +
                               "5. Mostre confiança e seja educado.";
        JOptionPane.showMessageDialog(null, interviewTips, "Dicas para Entrevista", JOptionPane.INFORMATION_MESSAGE);
    }

    private static void showPreview(JPanel panel, String modelo) {
        StringBuilder preview = new StringBuilder("Currículo Preview - " + modelo + ":\n");
        for (JTextField field : inputFields) {
            preview.append(field.getText()).append("\n");
        }
        preview.append("Experiência:\n").append(experienceArea.getText()).append("\n");
        preview.append("Educação:\n").append(educationArea.getText()).append("\n");
        preview.append("Sobre mim:\n").append(aboutMeArea.getText()).append("\n");

        JOptionPane.showMessageDialog(panel, preview.toString(), "Pré-visualização", JOptionPane.INFORMATION_MESSAGE);
    }

    private static void saveCurriculum(JPanel panel, String linkedin, String modelo) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Salvar Currículo como PDF");
        fileChooser.setSelectedFile(new File("Currículos Salvos/curriculo_" + System.currentTimeMillis() + ".pdf")); // Sugestão de nome

        int userSelection = fileChooser.showSaveDialog(panel);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            try {
                if (!fileToSave.getName().endsWith(".pdf")) {
                    fileToSave = new File(fileToSave.getAbsolutePath() + ".pdf");
                }

                PdfWriter writer = new PdfWriter(fileToSave);
                PdfDocument pdf = new PdfDocument(writer);
                Document document = new Document(pdf);

                // Aplicando estilos diferentes baseados no modelo selecionado
                ModelStyle selectedStyle = getModelStyle(modelo);
                Paragraph title = new Paragraph("Currículo - " + modelo)
                        .setFont(PdfFontFactory.createFont(selectedStyle.fontName, PdfEncodings.IDENTITY_H, true))
                        .setFontSize(selectedStyle.fontSize)
                        .setBold(selectedStyle.isBold);
                document.add(title);

                for (JTextField field : inputFields) {
                    document.add(new Paragraph(field.getText()).setFontSize(12));
                }
                document.add(new Paragraph("LinkedIn: " + linkedin).setFontSize(12));
                document.add(new Paragraph("Experiência: " + experienceArea.getText()).setFontSize(12));
                document.add(new Paragraph("Educação: " + educationArea.getText()).setFontSize(12));
                document.add(new Paragraph("Sobre mim: " + aboutMeArea.getText()).setFontSize(12));

                document.close();
                JOptionPane.showMessageDialog(panel, "Currículo salvo como PDF em " + fileToSave.getAbsolutePath(), "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(panel, "Erro ao salvar o currículo: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private static ModelStyle getModelStyle(String modelName) {
        for (ModelStyle style : modelStyles) {
            if (style.name.equals(modelName)) {
                return style;
            }
        }
        return modelStyles[0]; // Retorna o padrão se não encontrar
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
        panel.setBackground(new Color(240, 240, 240)); // Cor de fundo clara
        return panel;
    }

    private static JLabel createLabel(String text, int fontSize) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Segoe UI", Font.PLAIN, fontSize));
        label.setForeground(new Color(0, 51, 102)); // Azul escuro
        return label;
    } 

    private static JButton createButton(String text, java.awt.event.ActionListener actionListener) {
        JButton button = new JButton(text);
        button.addActionListener(actionListener);
        button.setFocusPainted(false);
        button.setBackground(new Color(34, 150, 243)); // Azul claro
        button.setForeground(Color.WHITE);
        button.setBorderPainted(false); // Remove a borda
        return button;
    }
}
