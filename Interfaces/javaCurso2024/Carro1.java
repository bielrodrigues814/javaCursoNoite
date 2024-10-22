package javaCurso2024;

public class Carro1 implements Veiculo1 {
	// Construtor sem parametro(necessario para linha 'new carro()')

	public Carro1() {
		// se houver lógica de inicializaçao, insira-a aqui!

	}

	@Override
	public void acelerar() {
		System.out.println("O carro esta acelerando...");
		System.out.println("O combustivel do carro esta acabando");

	}

	@Override //Sobrescrever!
	public void frear() {
		System.out.println("O carro está freando...");
	}
}
