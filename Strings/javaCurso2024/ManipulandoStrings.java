package javaCurso2024;

public class ManipulandoStrings {

	public static void main(String[] args) {
		// criando Strings:
		String texto = "bem vindo ao curso intermediário de Java";
		String texto2 = "vamos aprender sobre Strings!";
		// 1.Comprimento da strings :
		System.out.println(" Comprimento da strings: " + texto.length());

		// 2.Concatenar Strings:
		String textoCompleto = texto + "\n" + texto2;
		System.out.println("texto Completo: " + textoCompleto);

		// 3.Converter para MAIÚSCULAS e minúsculas:
		System.out.println("MAIÚSCULAS : " + texto.toUpperCase());

		System.out.println(" MAIÚSCULAS " + texto.toLowerCase());
		System.out.println(" minúsculas " + texto2.toLowerCase());

		// 4.substituir uma parte da Strings;
		String novotexto = texto.replace("Java", "PHP");
		System.out.println("texto após a subistituição: " + novotexto);

		// 5. buscar por uma substring:
		int posição = texto.indexOf("curso");
		System.out.println("Posição da palavra 'curso ': " + posição);

		// 6.verificar se uma string começa ou termina com uma substring:
		System.out.println(" Começa com 'bem': " + texto.startsWith("bem"));

		// 7.Dividir uma String:
//		String nomeCompleto = "gabriel souza rodrigues";
//		String[]  parteDoNomeCompleto = nomeCompleto.split("");
//		System.out.println("partes dos nomes: ");
//		for ( String parteDoNome : parteDoNomeCompleto ) {
//			System.out.println(parteDoNome);

		// }

		// 8. Remover espaços:
		String textoComEspacos = " Texto com espaços.       ";
		System.out.println("Texto sem espaços: '" + textoComEspacos.trim().replace("\\s+", " ") + "'");
	}

}
