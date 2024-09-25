package java2024;

   import java.util.Scanner;
public class Exercicio3 {
   public static void main(String[] args) {
	 
	 Scanner scanner = new Scanner(System.in);
	 System.out.println("digite seu numero");
	 
	 int num = scanner.nextInt();
	 if ( num >= 18){
		 System.out.println(" voce  é de maior");
	 }else{ System.out.println( " voce é de menor ");
	 
   }
   scanner.close();
	 
	 
	
}

}
