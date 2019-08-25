package a1;

import java.util.Scanner;

public class A1Novice {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		// Your code follows here.
		
		/* First, input the total number of customers.
		 * Then, for each customer, give a first name,
		 * last name, # of items purchased.
		 * Finally, each item will have a quantity,
		 * name, and price.
		 * 
		 * The program will end with a report containing
		 * the first initial, last name, and total cost.
		 */
		
		// Counter for customers
		int countCustomers = scan.nextInt();
		
		// Arrays to track first names, last names, and
		// total money spent. Each customer is given
		// an index to locate values in all arrays.
		
		String[] firstNames = new String[countCustomers];
		String[] lastNames = new String[countCustomers];
		double[] spent = new double[countCustomers];
		
		// Begin taking inputs
		for (int i=0; i<countCustomers; i++) {
			
			// get the customer's name and # of items
			firstNames[i] = scan.next();
			lastNames[i] = scan.next();
			int countItems = scan.nextInt();
			
			// get info for each item
			for (int j=0; j<countItems; j++) {
				int quantity = scan.nextInt();
				String itemName = scan.next();  // not used in this code, but can be useful later
				double itemPrice = scan.nextDouble();
				
				// add this item's price to the customer's total
				spent[i] += itemPrice * quantity;
			}
			
		}
		
		// while this may seem a little redundant, hopefully
		// it will ease the transition to Adept and Jedi
			// This also formats the first names and the 
			// costs to have 2 decimal places
		for (int i=0; i<countCustomers; i++) {
			System.out.println(firstNames[i].charAt(0) + ". " + lastNames[i] + ": " + String.format("%.2f", spent[i]));
		}
		
		// close scanner
		scan.close();
		
		
	}
	
}
