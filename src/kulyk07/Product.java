package ua.khpi.oop.kulyk07;
import java.util.GregorianCalendar;
import java.io.Serializable;

class ProductProperties implements Serializable {
    	private static final long serialVersionUID = 1L;
    
    	private int expiration_date;
    	private String manufacturer;
    
    	public int getExpirationDate() {
		return expiration_date;
    	}

    	public ProductProperties() {
		setExpirationDate(0);
		setManufacturer("null");	
    	}
    
    	public ProductProperties(int expiration_date, String manufacturer) {
		setExpirationDate(expiration_date);
		setManufacturer(manufacturer);
    	}

    	public void setExpirationDate(int expiration_date) {
		this.expiration_date = expiration_date;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
	    this.manufacturer = manufacturer;
	}

}


public class Product implements Serializable {
    private static final long serialVersionUID = 1L;
 
    private String name;
    private String unit;
    private int amount;
    private int price;
    private int weigth;
    private GregorianCalendar date;
    ProductProperties item;
    
	public Product() {
		setName("null");
		setUnit("null");
		setAmount(0);
		setPrice(0);
		setWeigth(0);
		setDate(new GregorianCalendar(1970, 0 , 1));
		setItem(new ProductProperties(0, "null"));
		
	}
		
		public Product(String name, String unit, int amount, int price, int weigth, GregorianCalendar date, ProductProperties item) {
		    
			setName(name);
			setUnit(unit);
			setAmount(amount);
			setPrice(price);
			setWeigth(weigth);
			setDate(date);
			setItem(item);
		}
		
		
		public String getName() {
			return name;
		}


		public void setName(String name) {
			this.name = name;
		}

		public String getUnit() {
			return unit;
		}


		public void setUnit(String unit) {
			this.unit = unit;
		}


		public int getAmount() {
			return amount;
		}


		public void setAmount(int amount) {
			this.amount = amount;
		}

		public int getPrice() {
			return price;
		}

		public void setPrice(int price) {
			this.price = price;
		}

		public int getWeigth() {
			return weigth;
		}

		public void setWeigth(int weigth) {
			this.weigth = weigth;
		}

		public GregorianCalendar getDate() {
			return date;
		}

		public void setDate(GregorianCalendar date) {
			this.date = date;
		}

		public ProductProperties getItem() {
		    return new ProductProperties();
		}
		
		public void setItem (ProductProperties item) {
		    this.item = item;
		}

}
