package ua.khpi.oop.kulyk12;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ProductHelper {
	private static Scanner scanner = new Scanner(System.in);
	private static ArrayList<Integer> resultOfSearch = new ArrayList<Integer>();
	
	public static boolean check_string(String str) {
		return str.matches("[A-Z][a-z]");
	}
	
	public static boolean check_number(String number) {
		return number.matches("[1-9]?(\\d+)");
	}
	
	public static boolean check_date(String date) {
		return date.matches("\\d{2}/\\d{2}/\\d{4}");
	}
	
	public static boolean check_expiration_date(ArrayList<String> o, boolean middle_term, 
		boolean long_term, boolean short_term, boolean isOR) {
	
	boolean short_term_found = check_short_term(o);
	boolean middle_term_found = check_middle_term(o);
	boolean long_term_found = check_long_term(o);
	
	boolean result;
	if(isOR) {
		result = false;
		if(short_term && short_term_found) result = true;
		if(middle_term && middle_term_found) result = true;
		if(long_term && long_term_found) result = true;
	} else {
		result = true;
		if(short_term && !short_term_found)	result = false;
		if(middle_term && !middle_term_found)  result = false;
		if(long_term && !long_term_found)  result = false;
	}
		
	return result;
}
	
public static boolean check_short_term(ArrayList<String> o) {
	for(String str : o) {
		if(Pattern.matches("Day", str) || Pattern.matches("day", str))
			return true;
	}
	return false;
}

public static boolean check_middle_term(ArrayList<String> o) {
	for(String str : o) {
		if(Pattern.matches("Week", str) || Pattern.matches("week", str))
		return true;
	}
	return false;
}

public static boolean check_long_term(ArrayList<String> o) {
	for(String str : o) {
		if(Pattern.matches("Month", str) || Pattern.matches("month", str)) 
			return true;
	}
	return false;
}
	
	public static ArrayList<String> enterProperties(){
		ArrayList<String> productProperties = new ArrayList<String>();
		System.out.println("Enter product properties (click double Enter to stop adding): ");
		String current = scanner.nextLine();
		while(!current.equals("")) {
			if(check_string(current)) {
			    productProperties.add(new String(current));
			    current = scanner.nextLine();
			}
			else {
				System.out.print("WARNING: Invalid property. Try again: ");
				current = scanner.nextLine();
			}
		}
		return productProperties;
	}
	public static String enterName() {
		System.out.print("Enter product name: ");
		String name = scanner.nextLine();
		while(!check_string(name)) {
			System.out.print("WARNING: Invalid name. Try again: ");
			name = scanner.nextLine();
		}
		return name;
	}
	public static String enterUnit() {
		System.out.print("Enter product unit: ");
		String unit = scanner.nextLine();
		while(!check_string(unit)) {
			System.out.print("WARNING: Invalid name. Try again: ");
			unit = scanner.nextLine();
		}
		return unit;
	}
	public static int enterAmount() {
		System.out.print("Enter amount of products: ");
		String str = scanner.nextLine();
		while(!check_number(str)) {
			System.out.print("WARNING: Invalid name. Try again: ");
			str = scanner.nextLine();
		}
		int amount = Integer.parseInt(str);
		return amount;
	}
	public static int enterPrice() {
		System.out.print("Enter price of product: ");
		String str = scanner.nextLine();
		while(!check_number(str)) {
			System.out.print("WARNING: Invalid name. Try again: ");
			str = scanner.nextLine();
		}
		int price = Integer.parseInt(str);
		return price;
	}
	public static int enterWeigth() {
		System.out.print("Enter weigth of product: ");
		String str = scanner.nextLine();
		while(!check_number(str)) {
			System.out.print("WARNING: Invalid name. Try again: ");
			str = scanner.nextLine();
		}
		int weigth = Integer.parseInt(str);
		return weigth;
	}
	public static Date enterReceiptDate() {
	    System.out.print("Enter receipt date of product (in DD/MM/YYYY format): ");
	    Date theReceiptDate = null;
	    try {
		String date = scanner.nextLine();
	    	while(!check_date(date)) {
	    		System.out.print("WARNING: Invalid date. Try again: ");
	    		date = scanner.nextLine();
	    	}
	    	theReceiptDate = new SimpleDateFormat("ddMMyyyy").parse(date.replaceAll("/", ""));
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
		PrintInfo.attributePrint();
		int choice = Menu.numberEnterer(5);
		while(choice != 0) {
			if(attributeChoice(choice)) {
				System.out.println("Enter number of account to delete");
				int removeIndex = resultOfSearch.get(Menu.numberEnterer(resultOfSearch.size()));
				Menu.products.remove(removeIndex);
			}
			PrintInfo.attributePrint();
			choice = Menu.numberEnterer(5);
		}
	}
	public static void scanProduct() {
	    PrintInfo.scanPrint();
		int choice = Menu.numberEnterer(7);
		while(choice != 0) {
			attributeChoice(choice);
			PrintInfo.scanPrint();
			choice = Menu.numberEnterer(7);
		}
	}
	
	public static void sortProduct() {
		int choice;
		PrintInfo.sortPrint();
		while((choice = Menu.numberEnterer(5)) != 0) {
			sortChoice(choice);
			PrintInfo.sortPrint();
		}
		System.out.println("Canceled");
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
		
		case 7 :
		int choice;
		boolean is_short_term = false;
		boolean is_middle_term = false;
		boolean is_long_term = false;
		boolean isOR = false;
		PrintInfo.propertiesPrint(isOR, is_short_term, is_middle_term, is_long_term);
		while((choice = Menu.numberEnterer(7)) != 0) {
			switch (choice) {
			case 1:
				if(is_short_term)  is_short_term = false;
				else is_short_term = true;
				break;
			case 2:
				if(is_middle_term)  is_middle_term = false;
				else is_middle_term = true;
				break;
			case 3:
				if(is_long_term)  is_long_term = false;
				else is_long_term = true;
				break;
			case 4:
				for(Product product : Menu.products) {
					if(product.getProductProperties().size() != 0 && check_expiration_date(product.getProductProperties(), is_short_term, is_middle_term, is_long_term, isOR)) {
						System.out.println(index++ + ") " + "-------------------------------------------------------");
						System.out.println(product.toString());
					}
				}
				index = 1;
				break;
			case 5:
				if(isOR)  isOR = false;
				else isOR = true;
				break;
			}
			PrintInfo.propertiesPrint(isOR, is_short_term, is_middle_term, is_long_term);
		}
		System.out.println("Canceled");
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
