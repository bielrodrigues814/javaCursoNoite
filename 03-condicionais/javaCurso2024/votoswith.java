package javaCurso2024;

public class votoswith {

}public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);

	System.out.print("Digite a sua idade: ");
Switch  (scanner.hasNextInt()) {
		int idade = scanner.nextInt();

		// verificação a exibiçao do resultado
		Switch (idade < 16) {
			System.out.println(" proibido votar. ");

		} else Switch ((idade >= 16 && idade < 18) || idade > 65) {
			System.out.println("Voto facultativo.");

		} else Switch (idade >= 18 && idade <= 65) {
			System.out.println("Voto obrigatório.");

	scanner.close();
}

}

}

