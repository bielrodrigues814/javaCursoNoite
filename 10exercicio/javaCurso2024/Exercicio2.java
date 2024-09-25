package javaCurso2024;

import java.util.Random;

public class Exercicio2 {

	public static void main(String[] args) {

		Random random = new Random();

		for (int i = 0; i < 5; i++) {

			int numeroAleatorio = random.nextInt(100) + 1;

			System.out.println(" Números Aleatorios " + numeroAleatorio);

		}

	}

}
