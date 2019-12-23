package ua.khpi.oop.kulyk07;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.ArrayList;

public class Menu {
    
    ArrayList<Product> products = new ArrayList<Product>();
    Scanner in = new Scanner(System.in);
    int k = 0;
    
    public void showMenu() {
	
    
	do {
	System.out.println("Каталог товаров\n" + 
	                   "1. Список товаров\n" + 
	                   "2. Добавить товар в список\n" +
	                   "3. Убрать товар из списка\n" + 
	                   "4. Очистить весь список\n" + 
	                   "5. Завершить работу");
	
	System.out.println("\nВыберите опцию:");
	 
	      k = in.nextInt();

	            if (k > 0 && k < 6) {
	        	switch (k) {
	                    case 1:	
	                	int i = 0;
	                	if (!products.isEmpty()) {
	                	for(Product p: products)
	                	System.out.println(++i + " товар:\n" +
	                		"Название: " + p.getName() + "\n" + 
	                		"Единица измерения: " + p.getUnit() + "\n" +
	                		"Количество: " + p.getAmount() + "\n" +
	                		"Цена: " + p.getPrice() + "\n" +
	                		"Вес: " + p.getWeigth() + "\n" +
	                		"Дата поступления: " + p.getDate().getTime() + "\n" +
	                		"Срок годности: " + p.item.getExpirationDate() + " дней\n" +
	                		"Производитель: " + p.item.getManufacturer() + "\n");       	
	                	} else {
	                	    System.out.println("Список пуст!");
	                	}
	                        break;
	                    case 2:
	                	Scanner scan = new Scanner (System.in);
	                	System.out.println("Введите название:");
	                	String name = scan.nextLine();
	                	
	                	System.out.println("Введите единицу измерения:");
	                	String unit = scan.nextLine();
	                	
	                	System.out.println("Введите количество:");
	                	int amount = scan.nextInt();
	                	
	                	System.out.println("Введите цену:");
	                	int price = scan.nextInt();
	                	
	                	System.out.println("Введите вес:");
	                	int weigth = scan.nextInt();
	                	
	                	System.out.println("Введите год:");
	                	int year = scan.nextInt();
	                	System.out.println("Введите месяц:");
	                	int month = scan.nextInt();
	                	System.out.println("Введите день:");
	                	int day = scan.nextInt();
	                	GregorianCalendar date = new GregorianCalendar(year, month-1,day,12,0,0);
	                	
	                	System.out.println("Введите срок годности в днях:");
	                	int expiration_date = scan.nextInt();             	
	                	
	                	Scanner in2 = new Scanner(System.in);
	                	System.out.println("Введите название производителя:");
	                	String manufacturer = in2.nextLine();
	                	
	                	System.out.println(expiration_date + "  " + manufacturer);
	                	Product product = new Product(name, unit, amount, price, weigth, date, new ProductProperties(expiration_date,manufacturer));
	                	products.add(product);
	                        break;
	                    case 3:
	                	Scanner in1 = new Scanner(System.in);
	         		System.out.println("Введите номер товара, который желаете удалить");
	         		int ind = in1.nextInt();
	         		try {
		         		products.remove(ind-1);
	         		       }catch(ArrayIndexOutOfBoundsException e) {
	         		         System.out.println("Попробуйте ещё раз!");
	         		       }
	         		break;
	                    case 4:
	                	products.clear();                
	                        break;
	                 
	                    case 5:
	                        i = 5;
	                        break;
	                }
	                System.out.println("_______________________________________________\n\n\n\n\n");
	            } else {
	                System.out.println("Вы ввели некорректное значение");
	            }
		} while (k != 5);
	        in.close();
     }
    
}  

