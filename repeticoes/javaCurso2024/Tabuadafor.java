4package javaCurso2024;

import java.util.Scanner;

public class Tabuadafor {

	public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	System.out.println(" digite o numero ");
     int n =scanner.nextInt();
     
     
     System.out.println("Tabuada do "+ n + ":");
     for (int i =  1; i <=10; i++) {
    	 int resultado = n * i;
    	 System.out.println(n + "x" + i + "=" + resultado );     
	}

}
}