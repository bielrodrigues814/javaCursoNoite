package javaCurso2024;

import java.util.Scanner;

public class Exercicio05 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println(" Digite o numero ");
	     int  numero = scanner.nextInt();
	     
	    int soma = 0 ;
	    int temp = Math.abs(numero);
	    
	    while( temp > 0 ) {
	    	soma += temp % 10;
	    	temp/=10;
	    	
	    }
	    System.out.println("A soma dos digitos de " + numero + " é " + soma + ".");
	}
}
