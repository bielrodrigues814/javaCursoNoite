package javaCurso2024;

public class Employee {
	protected String name;
	protected double salary;

	// Classe construtora:
	public Employee(String name, double salary) {
		this.name = name;
		this.salary = salary;
	}

	// Método para calcular o bonus de 10% do salário:
	public double calculateBonus() {
		return this.salary * 0.10;
	}

	// Método para exibir os dados do empregado:
	public void showEmployeeData() {
		System.out.println(" nome: " + name);
		System.out.println("Salário: " + salary);
		System.out.println("Bonus: " + calculateBonus());
		System.out.println(" salário Total : " + (salary + calculateBonus()));
	}

}
