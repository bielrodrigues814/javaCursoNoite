package javaCurso2024;

public class TesteVeiculo {
	public static void main(String[] args) {
		Carro carro = new Carro("Toyota ", "Corrola ", 2004, 4);
		
		System.out.println("Detalhes do Carro :");
		carro.exibirDetalhes();
	}

}
