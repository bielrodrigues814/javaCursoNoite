package
public class Verificação Voto
{

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Digite a sua idade: ");
		if (scanner.hasNextInt()) {
			int idade = scanner.nextInt();

			// verificação a exibiçao do resultado
			if (idade < 16) {
				System.out.println(" proibido votar. ");

			} else if ((idade >= 16 && idade < 18) || idade > 65) {
				System.out.println("Voto facultativo.");

			} else if (idade >= 18 && idade <= 65) {
				System.out.println("Voto obrigatório.");

		scanner.close();
	}

}

}
