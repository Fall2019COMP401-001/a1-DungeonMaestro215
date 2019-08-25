package a1;

import java.util.Scanner;

public class A1Jedi {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		// Your code follows here.

		/*
		 * First, a list of the items sold at the store along with their prices. Then, a
		 * list of customers and what they bought (like in Novice, just w/o prices).
		 * Finally, the output will list each item the store sells along with
		 * the amount of people who bought that item and the total amount of that item
		 * bought.
		 */

		
		// INVENTORY LIST
		// Counter for items in inventory
		int countInv = scan.nextInt();
		
		// Arrays to hold item names and prices
		String[] itemNames = new String[countInv];
		double[] itemPrices = new double[countInv];
		
		// New arrays to store the # of customers to buy the item
		// and the total number of that item bought.
		int[] customersPerItem = new int[countInv];
		int[] totalItemBought = new int[countInv];

		// Input the names and prices of each item
		for (int i = 0; i < countInv; i++) {
			itemNames[i] = scan.next();
			itemPrices[i] = scan.nextDouble();
		}
		
		
		// CUSTOMER LIST
		// Counter for customers
		int countCustomers = scan.nextInt();

		// Arrays to hold customer names and total amounts spent
		String[] firstNames = new String[countCustomers];
		String[] lastNames = new String[countCustomers];

		// Begin taking inputs
		for (int i = 0; i < countCustomers; i++) {

			// get the customer's name and # of items
			firstNames[i] = scan.next();
			lastNames[i] = scan.next();
			int countItems = scan.nextInt();
			
			// This section will help eliminate double counting customers
			// for inputs like "1 Banana 2 Apple 3 Banana"
			boolean[] counted = new boolean[countInv];

			// get info for each item
			for (int j = 0; j < countItems; j++) {
				int quantity = scan.nextInt();
				String itemName = scan.next(); 
				
				// Using the item's name, increment the 'customersPerItem' and
				// 'totalItemBought' counters.
				for (int k=0; k<itemNames.length; k++) {
					if (itemName.contentEquals(itemNames[k])) {
						if (!counted[k]) {
							customersPerItem[k] += 1;
							counted[k] = true;
						}
						totalItemBought[k] += quantity;
					}
				}
			}

		}

		scan.close();
		
		
		// Final Outputs
		for (int i=0; i<countInv; i++) {
			if (customersPerItem[i] == 0) {
				System.out.println("No customers bought " + itemNames[i]);
			} else {
				System.out.println(customersPerItem[i] + 
						" customers bought " + totalItemBought[i] + " " + itemNames[i]);
			}
		}
		
	}
	
	
	
}
