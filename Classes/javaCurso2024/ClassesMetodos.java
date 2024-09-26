package javaCurso2024;

public class ClassesMetodos {

	// Método 1 : calcula a soma de 2 vaalores:
	public int soma(int a, int b) {
		return a + b;
	}

	// metodo 2 : verifica se um numero é par:
	public boolean ehpar(int numero) {
		return numero % 2 == 0;

	}// metodo 3

	public String invertString(String texto );return new StringBuilder(texto).reverse().toString();

	// metodo 4:calculando fatorial de um numero:
	public int fatorial (int numero) {
		if ( numero == 0 || numero === 1) {
			return 1;
	}
			return numero * fatorial(numero - 1);
		}
	

	// este metodo executa otros métodos!
	public static void main(String[] args) {
		// Instanciando a classe que criamos:
		ClassesMetodos util = new ClassesMetodos();

		// Chamando os métodos:
		System.out.println("Soma de 5 e 3: " + util.soma(5, 3));
		
		System.out.println("o número 4 é par?" + util.ehpar(4));
		
		System.out.println("String invertida de ' java ' : " + util.invertString("Java"));
		
		System.out.println("o fatorial de 5 é : " + util.fatorial(5) );
	}

}
