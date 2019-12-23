package ua.khpi.oop.kulyk05;

import java.util.Scanner;
import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
	    int i = 0;
	        Scanner in = new Scanner(System.in);
		
		String[] string = new String[]{"Help me, please","I really need some help","OK, gg, boys"};
		ClassIterator text = new ClassIterator(string);
		Iterator<String> it = text.iterator();
		
		do {
		    
		System.out.println(
	                    "\n_______________________________________________\n" +
	                            "Menu:\n" +
	                            "1.Show contents\n" +
	                            "2.Add new text\n" +
	                            "3.Remove all of elements\n" +
	                            "4.Remove found element\n" +
	                            "5.Show array\n" +
	                            "6.Show amount of elements in array\n" +
	                            "7.Check for a specific element\n" +
	                            "8.Check for source elements\n" +
	                            "9.Iterator 'while' cycle\n" +
	                            "10.Iterator 'for each' cycle\n" + 
				    "11.Exit program");
		
		
		
		
		
		
	            System.out.println("\nSelect option:");

	            
	            i = in.nextInt();

	            if (i > 0 && i < 12) {
	        	switch (i) {
	                    case 1:
	                       System.out.println(text.toString());
	                        break;
	                    case 2:
	                	Scanner scan = new Scanner(System.in);
	                	String s1 = new String();
	                	System.out.println("Enter the text:");
	                	s1 = scan.nextLine();
	                	text.add(s1);
	                	System.out.println(text.toString());
	                        break;
	                    case 3:
	                	text.clear();
	                	System.out.println(text.toString());
	                        break;
	                    case 4:
	                	Scanner scan1 = new Scanner(System.in);
	                	String s2 = new String();
	                	System.out.println("Enter the text to remove:");
	                	s2 = scan1.nextLine();
	                	text.remove(s2);
	                	System.out.println(text.toString());
	                        break;
	                    case 5:
	                	String[] text3 = (String[])text.toArray();
	                	System.out.println(text3[0] + " " + text3[1] + " " + text3[2]);
	                	break;
	                    case 6:
	                	System.out.println(text.size() + " elements");
	                	break;
	                    case 7:
	                	Scanner scan2 = new Scanner(System.in);
	                	String s3 = new String();
	                	System.out.println("Enter the text:");
	                	s3 = scan2.nextLine();
	                	System.out.println(text.contains(s3));
	                	break;
	                    case 8:
	                	System.out.println(text.containsAll(text));
	                	break;
	                    case 9:
	                	it = text.iterator();
	        		while (it.hasNext()) {
	        		    System.out.println(it.next());
	        		}
	                	break;
	                    case 10:
	                	it = text.iterator();
	                	for (String s: text)
	                	    System.out.println(s);
	                	break;
	                    case 11:
	                        i = 11;
	                        break;
	                }
	                System.out.println("_______________________________________________\n\n\n\n\n");
	            } else {
	                System.out.println("You entered an incorrect value");
	            }
		} while (i != 11);
	        in.close();

	}

}