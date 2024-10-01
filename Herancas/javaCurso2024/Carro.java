package javaCurso2024;

public class Carro extends Veiculo {
	private int numeroDeportas;
	
	public Carro(String marca , String modelo, int ano, int numeroDeportas) {
		super(marca,modelo,ano);
		this.numeroDeportas = numeroDeportas;
		
	}
	@Override
	public void exibirDetalhes() {
		super.exibirDetalhes();
		System.out.println("Número de portas: "+ numeroDeportas);
	}

}
