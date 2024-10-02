package javaCurso2024;

public class OperaConta {

	public static void main(String[] args) {
		// criacao de conta com saldo inicial de R$ 1000,00:
		ContaBancaria conta = new ContaBancaria(1000.00);

		// Operando a conta do cliente:
		// 1)Exibir o saldo inicial da conta:
		System.out.println("Saldo Inicial: " + conta.getsaldo() );
		//2)Realizando um depósito:
		conta.depositar(3);
		System.out.println("'Saldo após o depósito de R$ "+ conta.getsaldo() );
		//3)Realizando um saque:
		conta.sacar(100);
		System.out.println("Saldo após o saque de 100 R$ " + conta.getsaldo() );
	}   

}
