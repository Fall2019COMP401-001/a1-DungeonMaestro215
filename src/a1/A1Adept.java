package a1;

import java.util.Scanner;

public class A1Adept {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		// Your code follows here.

		/*
		 * First, a list of the items sold at the store along with their prices. Then, a
		 * list of customers and what they bought (like in Novice, just w/o prices).
		 * Finally, the output will be the biggest and smallest spenders as well as an
		 * average amount spent.
		 */

		
		// Inventory List
		// Counter for items in inventory
		int countInv = scan.nextInt();

		// Arrays to hold item names and prices
		String[] itemNames = new String[countInv];
		double[] itemPrices = new double[countInv];

		// Input the names and prices of each item
		for (int i = 0; i < countInv; i++) {
			itemNames[i] = scan.next();
			itemPrices[i] = scan.nextDouble();
		}
		
		
		// Customer List
		// Counter for customers
		int countCustomers = scan.nextInt();

		// Arrays to hold customer names and total amounts spent
		String[] firstNames = new String[countCustomers];
		String[] lastNames = new String[countCustomers];
		double[] spent = new double[countCustomers];

		// Begin taking inputs
		for (int i = 0; i < countCustomers; i++) {

			// get the customer's name and # of items
			firstNames[i] = scan.next();
			lastNames[i] = scan.next();
			int countItems = scan.nextInt();

			// get info for each item
			for (int j = 0; j < countItems; j++) {
				int quantity = scan.nextInt();
				String itemName = scan.next(); 
				
				// Using the item's name, find its price
				for (int k=0; k<itemNames.length; k++) {
					if (itemName.contentEquals(itemNames[k])) {
						// Add the price to the customer's account
						spent[i] += itemPrices[k] * quantity;
					}
				}
			}

		}

		scan.close();
		
		
		// Final Outputs
		// Determine the biggest spender
		int indexBiggestSpender = 0;
		for (int i=0; i<spent.length; i++) {
			if (spent[i] > spent[indexBiggestSpender]) {
				indexBiggestSpender = i;
			}
		}
		
		// Determine the smallest spender
		int indexSmallestSpender = 0;
		for (int i=0; i<spent.length; i++) {
			if (spent[i] < spent[indexSmallestSpender]) {
				indexSmallestSpender = i;
			}
		}
		
		// Calculate Average
		double average = CalculateAverage(spent);
		
		// Output
		System.out.println("Biggest: " + firstNames[indexBiggestSpender] + 
				" " + lastNames[indexBiggestSpender] + " (" + String.format("%.2f",spent[indexBiggestSpender]) + ")");
		System.out.println("Smallest: " + firstNames[indexSmallestSpender] + 
				" " + lastNames[indexSmallestSpender] + " (" + String.format("%.2f",spent[indexSmallestSpender]) + ")");
		System.out.println("Average: " + String.format("%.2f", average));
	}
	
	// Method to calculate the average value of an array of doubles
	static double CalculateAverage(double[] vals) {
		
		double total = 0;
		
		// calculate a total for the array
		for (int i=0; i<vals.length; i++) {
			total += vals[i];
		}
		
		// find the average
		double average = total / vals.length;
		
		return average;
		
	}
	
}
