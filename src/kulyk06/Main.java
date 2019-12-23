package ua.khpi.oop.kulyk06;
import java.io.*;
import java.util.Scanner;

import ua.khpi.oop.mishchenko06.IOClass;

import java.util.Iterator;

public class Main {

	public static void main(String[] args) throws IOException, ClassNotFoundException, FileNotFoundException {
	    int i = 0;
	        Scanner in = new Scanner(System.in);
		
		String[] string = new String[]{"Help me, please ","I really need some help ","OK, gg, boys "};
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
	                            "11.Change an element\n" +
	                            "12.Sort elements in container\n" +
	                            "13.Find required element\n" +
	                            "14.Change all elements in container\n" + 
				    "15.Exit program");
		
		
		
		
		
		
	            System.out.println("\nSelect option:");


	            i = in.nextInt();

	            if (i > 0 && i < 16) {

		                switch (i) {
		                    case 1:
		                       System.out.println(text.toString());
		                       IOClass.printInfo();
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
		                	Scanner scan3 = new Scanner(System.in);
		                	String s4 = new String();
		                	System.out.println("Enter the element of container:");
		                	s4 = scan3.nextLine();
		                	if(text.contains(s4) == true) {
		                	text.remove(s4);
		                	String s5 = new String();
		                	s5 = changeText(s4).toString();
		                	text.add(s5);
		                	System.out.println(text.toString());
		                	}
		                	break;
		                    case 12:
		                	text.sortArray();
		                	System.out.println(text.toString());
		                	break;
		                    case 13:
		                	Scanner scan4 = new Scanner(System.in);
		                	String s5 = new String();
		                	System.out.println("Enter the element of container:");
		                	s5 = scan4.nextLine();
		                	System.out.println(text.getIndex(s5));
		                	break;
		                    case 14:
		                	it = text.iterator();
		                	for (String s: text) {
		                	    text.remove(s);
		                	String s6 = new String();
		                	s6 = changeText(s).toString();
		                	text.add(s6);
		                	}
		                	System.out.println(text.toString());
		                	break;
		                    case 15:
		                	i = 15;
		                        break;
		                }
	                System.out.println("_______________________________________________\n\n\n\n\n");
	            } else {
	                System.out.println("You entered an incorrect value");
	            }
		} while (i != 15);
	        in.close();

	        File f = new File("C:\\Users\\Daniil\\eclipse-workspace\\kulyk-daniil\\src\\Test.txt");
	        FileOutputStream fileOutputStream = new FileOutputStream(f);
	        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
	        objectOutputStream.writeObject(text);
	        objectOutputStream.close();

	        FileInputStream fileInputStream = new FileInputStream(f);
	        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
	        ClassIterator newText = (ClassIterator) objectInputStream.readObject();
	        objectInputStream.close();
	        System.out.println(newText.toString());
	}

	public static StringBuilder changeText(String string) {
	        System.out.print("Enter which word replace current:");
	        Scanner in = new Scanner(System.in);
	        String tmp = in.next();
	        StringBuilder word = new StringBuilder();
	        word.append(tmp);
	        StringBuilder result = new StringBuilder(string.length());
	        result.append(string);


	        for (int i = 0, j = 0; i < string.length(); i++) {
	            if (string.charAt(i) != ' ') {
	                j = i;
	                while (string.charAt(j) != ' ') {
	                    word.append(string.charAt(j));
	                    j++;
	                }
	                if (word.length() == tmp.length()) {
	                    result.append(tmp + " ");
	                    i = j;
	                } else {
	                    for (; i < j; i++) {
	                        result.append(string.charAt(i));
	                    }
	                    result.append(" ");
	                }
	                word.delete(0, word.length());
	            }

	        }
	        return result.delete(0, result.length()/2);
	    }
}