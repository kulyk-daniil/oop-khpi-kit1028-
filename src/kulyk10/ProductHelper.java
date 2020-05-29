package ua.khpi.oop.kulyk10;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class ProductHelper {
	private static Scanner scanner = new Scanner(System.in);
	private static ArrayList<Integer> resultOfSearch = new ArrayList<Integer>();
	public static ArrayList<String> enterProperties(){
		ArrayList<String> productProperties = new ArrayList<String>();
		System.out.println("Enter product properties (click double Enter to stop adding): ");
		String current = scanner.nextLine();
		while(!current.equals("")) {
		    productProperties.add(new String(current));
		    current = scanner.nextLine();
		}
		return productProperties;
	}
	public static String enterName() {
		System.out.print("Enter product name: ");
		String name = scanner.nextLine();
		return name;
	}
	public static String enterUnit() {
		System.out.print("Enter product unit: ");
		String unit = scanner.nextLine();
		return unit;
	}
	public static int enterAmount() {
		System.out.print("Enter amount of products: ");
		int amount = scanner.nextInt();
		return amount;
	}
	public static int enterPrice() {
		System.out.print("Enter price of product: ");
		int price = scanner.nextInt();
		return price;
	}
	public static int enterWeigth() {
		System.out.print("Enter weigth of product: ");
		int weigth = scanner.nextInt();
		return weigth;
	}
	public static Date enterReceiptDate() {
	    System.out.print("Enter receipt date of product (in DD/MM/YYYY format): ");
	    Date theReceiptDate = new Date();
	    try {
	    	theReceiptDate = new SimpleDateFormat("ddMMyyyy").parse(scanner.next().replaceAll("/", ""));
	    } catch (ParseException e) {
	        System.out.println(e);
	    }
		return theReceiptDate;
	}

	public static Product newProductAdded() {
	    Product product = new Product();
	    product.setName(enterName());
	    product.setUnit(enterUnit());
	    product.setAmount(enterAmount());
	    product.setPrice(enterPrice());
	    product.setWeigth(enterWeigth());
	    product.setReceiptDate(enterReceiptDate());
	    product.setProductProperties(enterProperties());
	    return product;
	}
	public static Product newProductFromFile(BufferedReader reader) throws IOException {
		Product product = new Product();
		product.setName(reader.readLine());
		product.setUnit(reader.readLine());
		product.setAmount(reader.read());
		product.setPrice(reader.read());
		product.setWeigth(reader.read());
	    try {
	    	Date theReceiptDate = new SimpleDateFormat("ddMMyyyy").parse(reader.readLine().replaceAll("/", ""));
		    product.setReceiptDate(theReceiptDate);
	    } catch (ParseException e) {
	        System.out.println(e);
	    }

		ArrayList<String> productProperties = new ArrayList<String>();
		String current = reader.readLine();
		while(!current.equals("----")) {
		    productProperties.add(new String(current));
		    current = reader.readLine();
		}
		product.setProductProperties(productProperties);
		return product;
	}
	public static void removeProduct() {
		attributePrint();
		int choice = Menu.numberEnterer(5);
		while(choice != 0) {
			if(attributeChoice(choice)) {
				System.out.println("Enter number of account to delete");
				int removeIndex = resultOfSearch.get(Menu.numberEnterer(resultOfSearch.size()));
				Menu.products.remove(removeIndex);
			}
			attributePrint();
			choice = Menu.numberEnterer(5);
		}
	}
	public static void scanProduct() {
		attributePrint();
		int choice = Menu.numberEnterer(5);
		while(choice != 0) {
			attributeChoice(choice);
			attributePrint();
			choice = Menu.numberEnterer(5);
		}
	}
	
	public static void sortProduct() {
		int choice;
		sortPrint();
		while((choice = Menu.numberEnterer(5)) != 0) {
			sortChoice(choice);
			sortPrint();
		}
		System.out.println("Canceled");
	}
	public static void attributePrint() {
		System.out.println("0  - Cancel");
		System.out.println("1  - Name");
		System.out.println("2  - Unit");
		System.out.println("3  - Amount");
		System.out.println("4  - Price");
		System.out.println("5  - Weigth");
		System.out.println("6  - Date");
	}
	public static void sortPrint() {
		System.out.println("0  - Cancel");
		System.out.println("1  - Name");
		System.out.println("2  - Date");
		System.out.println("3  - Price");
	}
	public static boolean attributeChoice(int numMenu) {
		resultOfSearch.clear();
		String search;
		int number;
		int index = 0;
		switch (numMenu) {
		case 0 :
			System.out.println("Canceled");
			break;
		case 1 : 
			search = enterName();
			for (Product product : Menu.products) {
				if(product.getName().indexOf(search) >= 0) {
					resultOfSearch.add(Menu.products.indexOf(product));
					System.out.println(index++ + ") " + "-------------------------------------------------------");
					System.out.println(product.toString());
				}
			}
			break;
		case 2 :
			search = enterUnit();
			for(Product product : Menu.products) {
				if(product.getUnit().indexOf(search) >= 0) {
					resultOfSearch.add(Menu.products.indexOf(product));
					System.out.println(index++ + ") " + "-------------------------------------------------------");
					System.out.println(product.toString());
				}
			}
			break;
		case 3 :
			number = enterAmount();
			for(Product product : Menu.products) {
				if(product.getUnit().indexOf(number) >= 0) {
					resultOfSearch.add(Menu.products.indexOf(product));
					System.out.println(index++ + ") " + "-------------------------------------------------------");
					System.out.println(product.toString());
				}
			}
			break;
		case 4 :
			number = enterPrice();
			for(Product product : Menu.products) {
				if(product.getUnit().indexOf(number) >= 0) {
					resultOfSearch.add(Menu.products.indexOf(product));
					System.out.println(index++ + ") " + "-------------------------------------------------------");
					System.out.println(product.toString());
				}
			}
			break;
		case 5 :
			number = enterWeigth();
			for(Product product : Menu.products) {
				if(product.getUnit().indexOf(number) >= 0) {
					resultOfSearch.add(Menu.products.indexOf(product));
					System.out.println(index++ + ") " + "-------------------------------------------------------");
					System.out.println(product.toString());
				}
			}
			break;
		case 6 :
			Date dateSearch = enterReceiptDate();
			for(Product product : Menu.products) {
				if(product.getReceiptDate().compareTo(dateSearch) == 0) {
					resultOfSearch.add(Menu.products.indexOf(product));
					System.out.println(index++ + ") " + "-------------------------------------------------------");
					System.out.println(product.toString());
				}
			}
			break;
		}
		if(resultOfSearch.size() == 0) {
			System.out.println("Oops... Nothing was found.");
			return false;
		}
		return true;
	}
	
	public static void sortChoice(int numMenu) {
		boolean isSorted = false;
        Product[] o = Menu.products.getArray(Product.class, Menu.products.getSize());
        Product temp;
        while(!isSorted) {
            isSorted = true;
            for (int i = 0; i < o.length-1; i++) {
                if(sortStatement(numMenu,o[i],o[i+1])) {
                    isSorted = false;
 
                    temp = o[i];
                    o[i] = o[i+1];
                    o[i+1] = temp;
                }
            }
        }
        for(Product a : o) {
        	System.out.println(a.toString());
        }
	}
	private static boolean sortStatement(int numMenu, Product o1, Product o2) {
		switch(numMenu) {
		case 1:
			if(o1.getName().compareToIgnoreCase(o2.getName()) >= 0) return true;
			else return false;
		case 2:
			if(o1.getReceiptDate().after(o2.getReceiptDate())) return true;
			else return false;
		case 3:
			if(o1.getPrice() > (o2.getPrice())) return true;
			else return false;
		}
		return false;
	}
}