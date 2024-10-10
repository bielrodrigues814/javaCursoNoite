package javaCurso2024;

public class Manager extends Employee {

	private String department;

	public Manager(String name, double salary, String department) {
		super(name, salary);
		this.department = department;

	}

	// Método para calcular o bonus de 20% do salário:
	@Override
	public double calculateBonus() {
		return this.salary * 0.20;
	}

	// Método para exibir dados do gerente:
	@Override
	public void showEmployeeData() {
		super.showEmployeeData();
		System.out.println("Departamento : " + department); {
			
		}
		
	}

}
