package javaCurso2024;

import java.util.Scanner;

public class AtividadesFisicas {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		//Exibe o menu de opções 
		System.out.println(" Escolha uma atividade física");
		System.out.println("1. Corrida");
		System.out.println("2. Caminhada");
		System.out.println("3. Ciclismo");
		
		//recebe a escolhe do usuário
		int opcao = scanner.nextInt();
		int calorias = 0;
		String atividade = "";
		
		//Estrutura Switch para selecionar atividade e calcular as calorias:
		switch (opcao) {
	case 1:
		atividade ="corrida";
		calorias = 300;
		
		break;
		case 2:
			atividade ="caminhada";
			calorias = 150;
			break;
		case 3:
			atividade = "Ciclismo";
			calorias = 250;
			break;
		default:
			System.out.println("Opção inválida! tenta novamente.");
			System.exit(0);
		}
			//exibe o resultado da escolha:
			System.out.println("Você escolheu a atividade:" +atividade);
			System.out.println("Calorias queimadas em 30 min: " + calorias +" kcal");
			
			scanner.close();
	

	}

}
