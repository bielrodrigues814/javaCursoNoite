package javaCurso2024;

import java.util.Scanner;

public class Cap8_Lab2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		// Solicita ao usuário que insira o número de idades
		System.out.print("Quantas idades você deseja inserir? ");
		int n = scanner.nextInt(); // Lê o número de idades
		// Verifica se o número é maior que zero
		if (n > 0) {
			// Cria um array para armazenar as idades
			int[] idades = new int[n];
			int soma = 0; // Variável para somar as idades
			StringBuilder idadesStr = new StringBuilder(); // Usado para armazenar as idades como string
			// Solicita ao usuário que insira as idades
			for (int i = 0; i < n; i++) {
				System.out.print("Insira a idade " + (i + 1) + ": ");
				idades[i] = scanner.nextInt(); // Lê a idade e armazena no array
				soma += idades[i]; // Acumula a soma
				// Adiciona a idade à StringBuilder
				if (i > 0) {
					idadesStr.append(", "); // Adiciona uma vírgula antes das idades subsequentes
				}
				idadesStr.append(idades[i]); // Adiciona a idade atual
			}
			// Calcula a média
			double media = (double) soma / n;
			// Exibe o resultado com as idades e a média
			System.out.println("A média das idades: " + idadesStr.toString() + ".");
			System.out.println("É: " + media + " anos.");
		} else {
			// Mensagem de erro caso o número de idades seja menor ou igual a zero
			System.out.println("Entre com valores válidos para as idades");
		}
		// Fecha o scanner
		scanner.close();
	}
}