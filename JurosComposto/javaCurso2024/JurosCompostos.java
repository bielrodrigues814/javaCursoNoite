package javaCurso2024;

import java.util.Scanner;

public class JurosCompostos {

	public static void main(String[] args) {
	
		//instanciando o scanner para usá-lo:
	Scanner sc = new Scanner (System.in);
	
	
	//pegar dados dos Usuarios
	//capturando o capital
	System.out.println("Digite o Capital:");
	double capital = sc.nextDouble();
	//capturando a taxa de juros:
	System.out.println("Digite a taxa de juros anual:");
	double taxa = sc.nextDouble();
	//pegar o tempo da aplicação;
	System.out.println("Digite o tempo:");
	int tempo = sc.nextInt();
	
	//cálculo dos juros compostos(anual):
	double montante = capital * Math.pow(1+ (taxa/100),tempo);
	double juros = montante - capital;
	
	//resultados:
	System.out.println("o valor dos juros compostos é: " + juros);
	System.out.println("o valor total (principal + juros) é: " + montante);
	
	sc.close();
	
	}

}
