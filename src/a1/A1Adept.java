package a1;

import java.util.Scanner;

public class A1Adept {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		// Your code follows here.
		
		// inventory
		int inventoryct = scan.nextInt();
		String[] items = new String[inventoryct];
		double[] itemprice = new double[inventoryct];
		
		// building the inventory
		for (int i = 0; i < inventoryct; i++) {
			items[i] = scan.next().toLowerCase();
			itemprice[i] = scan.nextDouble();
		}
		
		// customer data initialization
		int custcount = scan.nextInt();
		String[] firstname = new String[custcount];
		String[] lastname = new String[custcount];
		int itemspurchased = 0;
		double[] totals = new double[custcount];
		
		// customer data input
		for (int i = 0; i < custcount; i++) {
			firstname[i] = firstcap(scan.next());
			lastname[i] = firstcap(scan.next());
			itemspurchased = scan.nextInt();
			
			String item;
			int itemquant;
			
			// gettin their items
			for (int j = 0; j < itemspurchased; j++) {
				itemquant = scan.nextInt();
				item = scan.next();
				
				// comparing items to inventory to build price total
				for (int k = 0; k < items.length; k++) {
					if (item.toLowerCase().equals(items[k])) {
						totals[i] += itemprice[k] * itemquant;
					}
				}
			}
		}
		
		// close the scanner
		scan.close();
		
		// output variable initialization
		double mintotal = totals[0];
		double maxtotal = totals[0];
		double averagetotal = 0;
		int mindex = 0;
		int maxdex = 0;
		
		// min, max total values for the output
		for (int i = 0; i < totals.length; i++) {
			if (totals[i] < mintotal) {
				mintotal = totals[i];
				mindex = i;
			}
			if (totals[i] > maxtotal) {
				maxtotal = totals[i];
				maxdex = i;
			}
		}
		
		// average total value for the output
		for (int i = 0; i < totals.length; i++) {
			averagetotal += totals[i];
		}
		averagetotal = averagetotal/totals.length;
		
		// output!!	
		System.out.println("Biggest: " + firstname[maxdex] + " " + lastname[maxdex] + " (" + String.format("%.2f", maxtotal) + ")");
		System.out.println("Smallest: " + firstname[mindex] + " " + lastname[mindex] + " (" + String.format("%.2f", mintotal) + ")");
		System.out.println("Average: " + String.format("%.2f", averagetotal));
	}
	
	// firstcap method (for names)
	public static String firstcap(String s) {
		return s.toUpperCase().charAt(0) + s.substring(1).toLowerCase();
	}
}
