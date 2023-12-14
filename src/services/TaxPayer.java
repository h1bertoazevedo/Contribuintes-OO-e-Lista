package services;

public class TaxPayer {
	
	private double salaryIncome;
	private double servicesIncome;
	private double capitalIncome;
	private double healthSpending;
	private double educationSpending;
	
	// Constructor
	public TaxPayer(double salaryIncome, 
					double servicesIncome, 
					double capitalIncome, 
					double healthSpending,
					double educationSpending) {

		this.salaryIncome = salaryIncome;
		this.servicesIncome = servicesIncome;
		this.capitalIncome = capitalIncome;
		this.healthSpending = healthSpending;
		this.educationSpending = educationSpending;
	}
	
	//Getters and Setters
	public double getSalaryIncome() {
		return salaryIncome;
	}
	
    //Salary
	public double getServicesIncome() {
		return servicesIncome;
	}
	
    //Capital
	public double getCapitalIncome() {
		return capitalIncome;
	}
	
    //HealthSpending
	public double getHealthSpending() {
		return healthSpending;
	}
	
    //EducationSpending
	public double getEducationSpending() {
		return educationSpending;
	}

	// salaryTax()
	public double salaryTax() {
		double monthlySalary = getSalaryIncome() / 12.0;
		
	    if (monthlySalary < 3000.00) {
	        return 0.0; // sem desconto
	    } else if (monthlySalary <= 5000.00) {
	    	return getSalaryIncome() * 0.10; // 10% de desconto
	    } else {
	        return getSalaryIncome() * 0.20; // 20% de desconto
	    }
	}
	
	// servicesTax()
	public double servicesTax() {
		return getServicesIncome() * 0.15;
	}
	
	// capitalTax()
	public double capitalTax() {
		return getCapitalIncome() * 0.20;
	}
	
	// grossTax()
	public double grossTax() {
		return salaryTax() + servicesTax() + capitalTax();
	}
	
	// taxRebate()
	public double taxRebate() {
		double rebate = getHealthSpending() + getEducationSpending();
		if (rebate > this.grossTax() * 0.30) {
			return this.grossTax() * 0.30;
		} else {
			return rebate;
		}
	}
	
	// netTax()
	public double netTax() {	
		return grossTax() - taxRebate();
	}
	
	//toString()
	public String toString() {
		return "Imposto bruto total: " +
				String.format("%.2f", this.grossTax()) +
				"\nAbatimento: " +
				String.format("%.2f", this.taxRebate()) +
				"\nImposto devido: " +
				String.format("%.2f", this.netTax());
	}
}
