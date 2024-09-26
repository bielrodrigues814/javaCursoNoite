package javaCurso2024;

public class Classeseoperacoes {
	
	//01 Multiplicaçao
	public int multiplicaçao (int a, int b) {
		return a*b;
		
	}
	 //02 Subtraçao
	 public int subtracao (int a , int b) {
		 return a-b;
	 }
	 
	 //03Divisão
	 public int divisao (int a , int b) {
		 return a/b;
	 }
	 
	 //04 soma 
	 public int adiciona (int a, int b) {
		 return a+b;
	 }
	 
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		Classeseoperacoes util = new Classeseoperacoes();
		
		System.out.println(" o valor da divisão é " + util.divisao(500,10));
		
	}

}
