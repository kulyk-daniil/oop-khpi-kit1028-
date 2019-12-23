package ua.khpi.oop.kulyk08;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class ProductProperties implements Externalizable {
	private static final long serialVersionUID = 1L;

	private  int expiration_date;
	private  String manufacturer;

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
	
	@Override
	  public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
	    setExpirationDate(in.readInt());
	    setManufacturer((String)in.readObject());
	    
	  }

	  @Override
	  public void writeExternal(ObjectOutput out) throws IOException {
	    // TODO Auto-generated method stub
	    out.writeObject(getExpirationDate());
	    out.writeObject(getManufacturer());

	  }
	
}
