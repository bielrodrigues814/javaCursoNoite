package javaCurso2024;
import java.util.Scanner;
public class Laboratorio2 {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("digite o numero do mes desejado ");
		
		int mes = scanner.nextInt();
		switch (mes) {
		case 1:
			System.out.println("janeiro tem 31 dias");
			break;
		case 2:
			System.out.println("fevereiro tem29 dias");
			break;
		case 3:
			System.out.println("Março tem 31 dias ");
			break;
		case 4:
			System.out.println("Abril tem 30 dias ");
			break;
		case 5:
			System.out.println("Maio tem 31 dias ");
			break;
		case 6:
			System.out.println("Junho tem 30 dias");
			break;
		case 7:
			System.out.println("Julho tem 31 dias ");
			break;
		case 8:
			System.out.println("Agosto tem 31 dias");
			break;
		case 9:
			System.out.println("Setembro tem 30 dias");
			break;
		case 10:
			System.out.println("Outubro tem 31 dias ");
			break;
		case 11:
			System.out.println("Novembro tem 30 dias ");
			break;
		case 12:
			System.out.println("Dezembro tem ");
			break;
        default:
        	System.out.println(" Escolha um mês entre 1 e 12");
        	System.exit(mes);
		}

	}

}
