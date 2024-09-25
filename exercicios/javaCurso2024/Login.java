package javaCurso2024;

import java.util.Scanner;

public class Login {

	public static void main(String[] args) {
		// variaveis fixas de nome de usuario e senha:
		String usuarioCorreto = "admin";
		String senhaCorreta = "123";

		// Número máximo de tentativas:
		int tentativasmaximas = 3;
		int tentativas = 0; // contador de tentativas

		// Entradas do usuario:
		Scanner scanner = new Scanner(System.in);

		// Tentativa de login 01:
		System.out.println(" digite o usuario: ");
		String usuario = scanner.next();

		System.out.println(" digite a senha: ");
		String senha = scanner.next();

		if (usuario.equals(usuarioCorreto) && senha.equals(senhaCorreta)) {
			System.out.println("login realizado com sucesso! bem vindo.");
		} else {
			tentativas = tentativas + 1;
			tentativas++; // mesma coisa que a linha de cima!

			System.out.println("Usuário ou senha incorretos, tente novamente!");

			// tentativa de login 02:
			System.out.println("digite o nome de usuário");
			usuario = scanner.nextLine();

			System.out.println("digite a senha: ");
			senha = scanner.nextLine();

			if (usuario.equals(usuarioCorreto) && senha.equals(senhaCorreta)) {
				System.out.println("Login realizado com sucesso! bem vindo.");
			} else {
				// tentativas++;
				System.out.println("Usuário ou senha incorretos. tente novamente.");

				// tentativa final:
				System.out.println("Tentativa final, seu login será bloqueado !");
				System.out.println(" digite o nome do usuário: ");
				usuario = scanner.nextLine();

				System.out.println(" Digite a senha: ");
				senha = scanner.nextLine();

				if (usuario.equals(usuarioCorreto) && senha.equals(senhaCorreta)) {
					System.out.println("login bem sucedido! bem-vindo.");
				} else {
					tentativas++;
					System.out.println("Acesso bloqueado após a 3 tentativas erradas!");

				}

			}
		}
		scanner.close();

	}
}
