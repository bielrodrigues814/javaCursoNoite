package javaCurso2024;

import java.util.Scanner;

public class Exercicio1 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		// solicite ao usuario:
		System.out.println("escreva a palavra");
		String palavra = scanner.next();

		String palavraInvertida = new StringBuilder(palavra).reverse().toString();
		System.out.println("palavra Invertida  " + palavraInvertida);

	}

}
