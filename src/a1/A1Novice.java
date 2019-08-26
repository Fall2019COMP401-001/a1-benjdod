package a1;

import java.util.Scanner;

public class A1Novice {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		// Your code follows here.
		
		// customer count
		int customer_count = scan.nextInt();
		
		// initialize aligned lists for all necessary values 
		String[] firstname = new String[customer_count];
		String[] lastname = new String[customer_count];
		int[] itemct = new int[customer_count];
		double[] itemtotal = new double[customer_count];
		
		// customer data filling loop 
		for (int i = 0; i < customer_count; i++) {
			firstname[i] = scan.next();
			lastname[i] = scan.next();
			itemct[i] = scan.nextInt();
			itemtotal[i] = 0;
			
			// item loop for each customer
			// don't need the names or quantities of the items!! 
			for (int j = 0; j < itemct[i]; j++) {
				scan.nextInt(); // throwaway quantity
				scan.next(); // throwaway item name
				itemtotal[i] += scan.nextDouble(); 
			}
		}
		
		// closing the scanner
		scan.close();
		
		// output
		for (int k = 0; k < customer_count; k++) {
			System.out.print(firstname[k].toUpperCase().charAt(0) + ". ");
			System.out.print(lastname[k].toUpperCase().charAt(0) + lastname[k].toLowerCase().substring(1) + ": ");
			System.out.print(String.format("%.2f", itemtotal[k]));
			System.out.print("\n");
		}
		
	}
}
