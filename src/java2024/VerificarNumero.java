package java2024;

  import java.util.Scanner;
  
 
public class VerificarNumero {
   public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);		//pedir  numero para o usuario:
		System.out.println(" digite um numero");
	  int numeroDigitado = scanner.nextInt();
	  if ( numeroDigitado > 0 ) {
		  System.out.println(" o numero é positivo!");
		  
	  }else if (numeroDigitado < 0) {
		System.out.println("o numero è negativo");
		
	  }else {
		  System.out.println("Numero é igual a ZERO");
		 
	  }
   }
	
}
	

}
