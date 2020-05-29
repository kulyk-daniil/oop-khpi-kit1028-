package ua.khpi.oop.kulyk13;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.Timer;

public class ThreadHelper {
	private static String f_name = "C:\\product_name.txt";
	private static String f_unit = "C:\\product_unit.txt";
	private static int size;
	private static Random rand = new Random();
	public static void starter_productGenerator() {
		System.out.println("Enter the amount of products to be generated [0 - 100 000]");
		size = Menu.numberEnterer(100_000);
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
			product.setAmount(_gen_values());
			product.setPrice(_gen_values());
			product.setWeigth(_gen_values());
			product.setReceiptDate(_gen_date());
			product.setProductProperties(_gen_term());
			Menu.products.add(product);
			PrintInfo.updateProgress((double)i/size);
		}
	}

	public static Date _gen_date() {
		Date theDate = null;
		try {
			String line = rand.nextInt(3) + rand.nextInt(10) + "/" + rand.nextInt(1) + rand.nextInt(10) + "/" + rand.nextInt(3) + rand.nextInt(10) + rand.nextInt(10) + rand.nextInt(10);
			theDate = new SimpleDateFormat("ddMMyyyy").parse(line.replaceAll("/", ""));
		} catch (ParseException e) {
			System.out.println(e);
		}
		return theDate;
	}
	
	public static int _gen_values() {
	    	int min = 1;
		int max = 10000;
		int value = (int) (Math.random() * ++max) + min;

		return value;
	}
	
	public static ArrayList<String> _gen_term() {
		ArrayList<String> terms = new ArrayList<String>();
		String[] codes = {"Day","Week","Month"};
		String line = codes[rand.nextInt(codes.length)];
		terms.add(line);
		return terms;
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
			filereader = new FileReader(f_unit);
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
	public static void start_all_threads() {
		System.out.println("Set the timer [0 - 100 000 ms]: ");
		int timer_num = Menu.numberEnterer(100000);
		System.out.println("Starting all threads...");
		
		FirstThread first = new FirstThread();
        Thread t1 = new Thread(first,"FirstThread"); 
        
		SecondThread second = new SecondThread();
        Thread t2 = new Thread(second,"SecondThread"); 
        
		ThirdThread third = new ThirdThread();
        Thread t3 = new Thread(third,"ThirdThread"); 

		t1.start();
		t2.start();
		t3.start();
        Timer timer = new Timer(timer_num, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                System.out.println("Interrupting thread...");
    			t1.interrupt();
    			t2.interrupt();
    			t3.interrupt();
            }
        });
        timer.setRepeats(false);
        timer.start();
		try {
			t1.join();
			t2.join();
			t3.join();
			timer.stop();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Finishing all threads...");
	}

}

class FirstThread implements Runnable {
	public void run() {
		int count = 0;
        System.out.println("First Thread started");
        try {
            for (Product product : Menu.products) {
            	Thread.sleep(100);
                if (!Thread.currentThread().isInterrupted()) {
                    if(product.getName().indexOf("Banana") >= 0) { 
                    	count++;
                    }
                } else {
                    throw new InterruptedException();
                }
            }
            System.out.println("First Thread finished. Banana products : " + count);
        } catch (InterruptedException e) {
            System.out.println("First Thread is interrupted");
        }
    }
} 
class SecondThread implements Runnable {
	public void run() {
		int count = 0;
        System.out.println("Second Thread started");
        try {
            for (Product product : Menu.products) {
            	Thread.sleep(100);
                if (!Thread.currentThread().isInterrupted()) {
                    if(ProductHelper.check_middle_term(product.getProductProperties())) { 
                    	count++;
                    }
                } else {
                    throw new InterruptedException();
                }
            }
            System.out.println("Second Thread finished. Products with middle term : " + count);
        } catch (InterruptedException e) {
            System.out.println("Second Thread is interrupted");
        }

    }
} 
class ThirdThread implements Runnable {
    public void run() {
	int count = 0;
System.out.println("Third Thread started");
try {
    for (Product product : Menu.products) {
    	Thread.sleep(100);
        if (!Thread.currentThread().isInterrupted()) {
            if(ProductHelper.check_middle_term(product.getProductProperties())) { 
            	count++;
            }
        } else {
            throw new InterruptedException();
        }
    }
    System.out.println("Third Thread finished. Products with long term : " + count);
} catch (InterruptedException e) {
    System.out.println("Third Thread is interrupted");
}

}
} 