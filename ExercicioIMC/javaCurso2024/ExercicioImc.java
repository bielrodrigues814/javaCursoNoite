package javaCurso2024;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExercicioImc extends JFrame {
	public static void main(String[] args) {
		// Criação do JFrame
		JFrame frame = new JFrame("Calculadora de IMC e IAC");
		frame.setSize(20000, 2000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);

		JButton botao = new JButton(
				"<html><body style='text-align: center;border:solid; padding: 10px; font-size: 16px;'>Clique em Mim</body></html>");

		// Campos de entrada
		JLabel pesoLabel = new JLabel("Peso (kg):");
		pesoLabel.setBounds(20, 20, 100, 30);
		frame.add(pesoLabel);

		JTextField pesoField = new JTextField();
		pesoField.setBounds(120, 20, 150, 30);
		frame.add(pesoField);

		JLabel alturaLabel = new JLabel("Altura (m):");
		alturaLabel.setBounds(20, 60, 100, 30);
		frame.add(alturaLabel);

		JTextField alturaField = new JTextField();
		alturaField.setBounds(120, 60, 150, 30);
		frame.add(alturaField);

		// Botão de cálculo
		JButton calcularButton = new JButton("Calcular");
		calcularButton.setBounds(20, 100, 250, 30);
		frame.add(calcularButton);

		// Área para mostrar resultados
		JTextArea resultadoArea = new JTextArea();
		resultadoArea.setBounds(20, 140, 250, 60);
		resultadoArea.setEditable(false);
		frame.add(resultadoArea);

		// Ação do botão calcular
		calcularButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					double peso = Double.parseDouble(pesoField.getText());
					double altura = Double.parseDouble(alturaField.getText());

					// Cálculos
					double imc = peso / (altura * altura);
					double iac = (1.3 * peso) / (altura * altura) + (0.5 * 30) - 10.5; // Idade fixa

					// Exibição dos resultados
					resultadoArea.setText(String.format("IMC: %.2f\nIAC: %.2f", imc, iac));
				} catch (NumberFormatException ex) {
					resultadoArea.setText("Valores inválidos.");
				}
			}
		});

		// Tornar a janela visível
		frame.setVisible(true);
	}
}
