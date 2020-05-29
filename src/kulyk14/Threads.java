package ua.khpi.oop.kulyk14;

public class Threads {
	public static void task_1() throws InterruptedException {
		int count = 0;
    for (Product product : Menu.products) {
        if (!Thread.currentThread().isInterrupted()) {
            if(ProductHelper.check_long_term(product.getProductProperties())) { 
            	count++;
            }
				Thread.sleep(100);
        } else {
            throw new InterruptedException();
        }
    }
    System.out.println("First Task finished. Products with long term : " + count);
	}
	public static void task_2() throws InterruptedException {
		int count = 0;
    for (Product product : Menu.products) {
        if (!Thread.currentThread().isInterrupted()) {
            if(product.getName().indexOf("Banana") >= 0) { 
            	count++;
            }
				Thread.sleep(100);
        } else {
            throw new InterruptedException();
        }
    }
    System.out.println("Second Task finished. Banana products : " + count);
	}
	public static void task_3() throws InterruptedException {
		int count = 0;
    for (Product product : Menu.products) {
        if (!Thread.currentThread().isInterrupted()) {
            if(ProductHelper.check_middle_term(product.getProductProperties())) { 
            	count++;
            }
				Thread.sleep(100);
        } else {
            throw new InterruptedException();
        }
    }
    System.out.println("Third Task finished. Products with long term : " + count);
	}
}
class FirstThread implements Runnable {
	public void run() {
    System.out.println("First Thread started");
    try {
    	Threads.task_1();
        System.out.println("First Thread finished");
    } catch (InterruptedException e) {
        System.out.println("First Thread is interrupted");
    }
}
} 
class SecondThread implements Runnable {
	public void run() {
    System.out.println("Second Thread started");
    try {
    	Threads.task_2();
        System.out.println("Second Thread finished");
    } catch (InterruptedException e) {
        System.out.println("Second Thread is interrupted");
    }
}
} 
class ThirdThread implements Runnable {
	public void run() {
    System.out.println("Third Thread started");
    try {
    	Threads.task_3();
        System.out.println("Third Thread finished");
    } catch (InterruptedException e) {
        System.out.println("Third Thread is interrupted");
    }
}
} 
