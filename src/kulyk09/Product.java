package ua.khpi.oop.kulyk09;

import java.util.ArrayList;
import java.util.Date;

public class Product {
    private String name;
    private String unit;
    private int amount;
    private int price;
    private int weigth;
    private Date receiptDate = new Date();
    private ArrayList<String> productProperties = new ArrayList<String>();

    public String getName() {
        return name;
    }

    public String getUnit() {
        return unit;
    }

    public int getAmount() {
        return amount;
    }

    public int getPrice() {
        return price;
    }
    
    public int getWeight() {
        return weigth;
    }
    
    public Date getReceiptDate() {
        return receiptDate;
    }
    
    public ArrayList<String> getProductProperties() {
        return productProperties;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    
    public void setPrice(int price) {
        this.price = price;
    }
    
    public void setWeigth(int weigth) {
        this.weigth = weigth;
    }
    
    public void setProductProperties(ArrayList<String> productProperties) {
        this.productProperties = productProperties;
    }

}