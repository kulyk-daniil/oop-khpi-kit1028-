package ua.khpi.oop.kulyk15;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
public class Generator {
	private static String f_name = "C:\\product_name.txt";
	private static String f_surname = "C:\\product_unit.txt";
	private static int size;
	private static Random rand = new Random();
	public static void starter_accountGenerator() {
		System.out.println("Enter the amount of accounts to be generated [0 - 100 000 000]");
		size = Menu.numberEnterer(100_000_000);
		System.out.println("Starting generation...");
		try {
			_gen_add();
		} catch (IOException e) {
			System.out.println("Error" + e);
		}
		System.out.println("\nFinished");
	}
	public static void _gen_add() throws IOException {
		ArrayList<String> name = read_name();
		ArrayList<String> unit = read_unit();
		for(int i = 0; i < size; i++) {
			Product product = new Product();
			product.setName(name.get(rand.nextInt(name.size())));
			product.setUnit(unit.get(rand.nextInt(unit.size())));
			product.setReceiptDate(_gen_birthdays());
			product.setPrice(i);
			product.setAmount(i);
			product.setWeigth(i*20);
			Menu.products.add(product);
			PrintInfo.updateProgress((double)i/size);
		}
	}

	public static Date _gen_birthdays() {
		Date theDate = null;
		try {
			String line = rand.nextInt(3) + rand.nextInt(10) + "/" + rand.nextInt(1) + rand.nextInt(10) + "/" + rand.nextInt(3) + rand.nextInt(10) + rand.nextInt(10) + rand.nextInt(10);
			theDate = new SimpleDateFormat("ddMMyyyy").parse(line.replaceAll("/", ""));
		} catch (ParseException e) {
			System.out.println(e);
		}
		return theDate;
	}

	public static ArrayList<String> read_name() {
		ArrayList<String> name = new ArrayList<String>();
		FileReader filereader;
		try {
			filereader = new FileReader(f_name);
			BufferedReader reader = new BufferedReader(filereader);
			String line = reader.readLine();
			while(!line.equals("----")) {
			    name.add(new String(line));
			    line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			System.out.println(e);
		}
		return name;	
	}
	public static ArrayList<String> read_unit() {
		ArrayList<String> unit = new ArrayList<String>();
		FileReader filereader;
		try {
			filereader = new FileReader(f_surname);
			BufferedReader reader = new BufferedReader(filereader);
			String line = reader.readLine();
			while(!line.equals("----")) {
			    unit.add(new String(line));
			    line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			System.out.println(e);
		}
		return unit;	
	}
}
