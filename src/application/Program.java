package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import services.TaxPayer;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<TaxPayer> list = new ArrayList<>();

	    System.out.print("Quantos contribuintes você vai digitar? ");
	    
	    int n = sc.nextInt();
	    sc.nextLine();
	    
		for (int i=0; i<n; i++) {
				System.out.println();
				System.out.println("Digite os dados do "+(i+1)+"o contribuinte:");
				
				System.out.print("Renda anual com salário: ");
				double salary = sc.nextDouble();
				System.out.print("Renda anual com prestação de serviço: ");
				sc.nextLine(); //limpar o buffer
				double service = sc.nextDouble();
				System.out.print("Renda anual com ganho de capital: ");
				sc.nextLine(); //limpar o buffer
				double capital = sc.nextDouble();
				System.out.print("Gastos médicos: ");
				sc.nextLine(); //limpar o buffer
				double health = sc.nextDouble();
				System.out.print("Gastos educacionais: ");
				sc.nextLine(); //limpar o buffer
				double education = sc.nextDouble();
				
				TaxPayer taxpayer = new TaxPayer(salary, service, capital, health, education);
				list.add(taxpayer);// inserir o objeto na lista
			}
		
			System.out.println();
			
			//Print
			for (TaxPayer x : list) {
				System.out.println("Resumo do "+(list.indexOf(x)+1)+"o contribuinte:");
				System.out.println(x);
				System.out.println();
			}
			
		sc.close();

	}

}
