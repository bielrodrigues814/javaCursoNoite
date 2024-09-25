package javaCurso2024;

public class SwitchCase {
	public static void main(String[] args) {
		int mes = 1;
		switch (mes) {
		case 1:
			System.out.println("janeiro");
			break;
		case 2:
			System.out.println("fevereiro");
			break;
		case 3:
			System.out.println("Março");
			break;
		case 4:
			System.out.println("Abril");
			break;
		case 5:
			System.out.println("Maio");
			break;
		case 6:
			System.out.println("Junho");
			break;
		case 7:
			System.out.println("Julho");
			break;
		case 8:
			System.out.println("Agosto");
			break;
		case 9:
			System.out.println("Setembro");
			break;
		case 10:
			System.out.println("Outubro");
			break;
		case 11:
			System.out.println("Novembro");
			break;
		case 12:
			System.out.println("Dezembro");
			break;
        default:
        	System.out.println(" Escolha um mês entre 1 e 12");
        	System.exit(mes);
		}

	}

}
