package javaCurso2024;

public class laboratorio1 {
	
	//Laboratorio VerificaPrimo {

    public static boolean ehPrimo(int n) {
        if (n <= 1) {
            return false; // Números menores ou iguais a 1 não são primos
        }
        if (n <= 3) {
            return true; // 2 e 3 são primos
        }
        if (n % 2 == 0) {
            return false; // Números pares maiores que 2 não são primos
        }
        
        // Testa divisores ímpares de 3 até a raiz quadrada de n
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
                return false; // Se n for divisível por i, não é primo
            }
        }
        
        return true; // Se não encontrou divisores, é primo
    }

    public static void main(String[] args) {
        int numero = 29; // Altere para testar outros números
        if (ehPrimo(numero)) {
            System.out.println(numero + " é primo.");
        } else {
            System.out.println(numero + " não é primo.");
        }
    }


	
	
	
	
	
	
	
	
	
	
	

	
	
				
				}

			}

		}

	}

}
