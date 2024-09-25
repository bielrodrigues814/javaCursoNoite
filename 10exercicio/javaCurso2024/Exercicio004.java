package javaCurso2024;
import java.util.Scanner;

public class Exercicio004 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicita a frase ao usuário
        System.out.print("Digite uma frase: ");
        String frase = scanner.nextLine();

        // Conta as vogais
        int totalVogais = contarVogais(frase);
        
        // Exibe o resultado
        System.out.println("A frase contém " + totalVogais + " vogais.");
        
        scanner.close();
    }

    public static int contarVogais(String frase) {
        int contador = 0;
        String vogais = "aeiouAEIOU";

        // Percorre cada letra da frase
        for (int i = 0; i < frase.length(); i++) {
            char letra = frase.charAt(i);
            // Verifica se a letra é uma vogal
            if (vogais.indexOf(letra) != -1) {
                contador++;
            }
        }

        return contador;
    }
}
