package javaCurso2024;

import java.util.Scanner;

public class Exercicio03 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println(" Digite o valor do produto");

		double valor = scanner.nextDouble();

		System.out.println(" Digite o valor do desconto ");

		int desconto = scanner.nextInt();

		double total = (valor * desconto / 100);

		System.out.println("valor do produto com desconto R$" + (valor - total));
	}
}
