package ua.khpi.oop.kulyk09;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;

public class Main {
	private final static String file1 = "C:\\Users\\Daniil\\eclipse-workspace\\kulyk-daniil\\src\\ua\\khpi\\oop\\kulyk09\\Container.xml";
	private final static String file2 = "C:\\Users\\Daniil\\eclipse-workspace\\kulyk-daniil\\src\\ua\\khpi\\oop\\kulyk09\\Container.txt";
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		String[] arr = {"Tomatoes", "Apples", "Orange", "T_shirts"};
		MyLinkedList<String> products = new MyLinkedList<>(arr);
		
		
		
	    System.out.println(products.toString());
	    saveSystem(products);
	    products.deleteAll();
	    System.out.println(products.toString());
	    products = loadSystem();
	    System.out.println(products.toString());
	    products.add("Sausages");
	    System.out.println(products.toString());
	    System.out.println(products.delete("Sausages"));
	    System.out.println(products.toString());

	    System.out.println("---------------------------------------------------");
	   
	    saveContainer(products);
	    products.deleteAll();
	    System.out.println(products.toString());
	    products = recoverContainer();
	    System.out.println(products.toString());
	    products.add("Strawberry");
	    System.out.println(products.toString());
	    System.out.println(products.delete("Tomatoes"));
	    System.out.println(products.toString());
	    
	    System.out.println("---------------------------------------------------");
	    
		for(Object s : products) {
			System.out.println(s.toString());
		}
	}
	
	
	
	static public void saveContainer(@SuppressWarnings("rawtypes") MyLinkedList list) throws IOException {
		FileOutputStream outputStream = new FileOutputStream(file2);
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
	    objectOutputStream.writeObject(list);
	    objectOutputStream.close();
	}
	@SuppressWarnings("rawtypes")
	static public MyLinkedList recoverContainer() throws IOException, ClassNotFoundException {
		MyLinkedList list = new MyLinkedList<>();
		FileInputStream fileInputStream = new FileInputStream(file2);
	    ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
	    list = (MyLinkedList) objectInputStream.readObject();
	    objectInputStream.close();
	    return list;
	}
	
	static void saveSystem(@SuppressWarnings("rawtypes") MyLinkedList list) {
		try{
  			XMLEncoder encoder = new XMLEncoder(new FileOutputStream(file1));
  			encoder.writeObject(list);
  			encoder.close();
  		} catch (Exception e){
  			System.out.println(e);
  		}
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	static MyLinkedList loadSystem() {
		MyLinkedList<Product> list = new MyLinkedList<>();
		try{
			XMLDecoder decoder = new XMLDecoder(new FileInputStream(file1));
			list = (MyLinkedList) decoder.readObject();
			decoder.close();		
		} catch (Exception e){
			System.out.println(e);
		}
		return list;
	}
}
