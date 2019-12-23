package ua.khpi.oop.kulyk08;

import java.util.GregorianCalendar;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;


public class Product implements Externalizable {
    private static final long serialVersionUID = 1L;
 
    private String name;
    private String unit;
    private int amount;
    private int price;
    private int weigth;
    private GregorianCalendar date;
    public ProductProperties item;
    
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
		
		 @Override
		  public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		    setName((String)in.readObject());
		    setUnit((String)in.readObject());
		    setAmount(in.readInt());
		    setPrice(in.readInt());
		    setWeigth(in.readInt());
		    setDate((GregorianCalendar)in.readObject());
		    setItem((ProductProperties)in.readObject());
		    
		  }

		  @Override
		  public void writeExternal(ObjectOutput out) throws IOException {
		    out.writeObject(getName());
		    out.writeObject(getUnit());
		    out.writeObject(getAmount());
		    out.writeObject(getPrice());
		    out.writeObject(getWeigth());
		    out.writeObject(getDate());
		    out.writeObject(getItem());
		  }
		
}

