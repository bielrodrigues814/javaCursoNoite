package javaCurso2024;

public class TexteInterface {
	public static void main(String[] args) {

		Veiculo1 meuCarro = new Carro1();
		Veiculo1 minhaBike = new Bicicleta();

		// usando o carro:
		meuCarro.acelerar();
		meuCarro.frear();
		
		minhaBike.acelerar();
		minhaBike.frear();
	}

}
