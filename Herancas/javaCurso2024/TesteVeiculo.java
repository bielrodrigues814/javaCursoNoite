package javaCurso2024;

public class TesteVeiculo {
	public static void main(String[] args) {
		Carro carro = new Carro("Toyota ", "Corrola ", 2004, 4);
		
		Carro carro2 = new Carro("chevrolet","Camaro",2018,4);
		
		
		Moto moto = new Moto("Honda", "CB500", 2019, true);
		
		Moto moto2 = new Moto("BMW","1250",2024,true);

		System.out.println("Detalhes do Carro:");
		carro.exibirDetalhes();
		carro2.exibirDetalhes();

		System.out.println("\nDetalhes da Moto :");
		moto.exibirDetalhes();
		moto2.exibirDetalhes();
	}

}
