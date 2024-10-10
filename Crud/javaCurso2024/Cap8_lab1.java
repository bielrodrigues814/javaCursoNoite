package javaCurso2024;

public class Cap8_lab1 {

	public int maiorNumero(int[] numeros) {
		int  maior = Integer.MIN_VALUE;
		for (int numero : numeros) {
			if (numero > maior) {
				maior = numero;
			}
		}
		return maior;
	}

	public static void main(String[] args) {
		// instanciando a classe
		Cap8_lab1 util  = new Cap8_lab1 ();
		int[] numeros = { 1, 4 , 8 ,50 , 75 , 94 };
		System.out.println(" o maior número do array é:" + util.maiorNumero(numeros));

	}
}
