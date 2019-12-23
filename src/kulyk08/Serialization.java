package ua.khpi.oop.kulyk08;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class Serialization {

	public static void LongTermPersistenceWrite(ArrayList<Product> object,String path) throws FileNotFoundException {	
		
		XMLEncoder encoder = new XMLEncoder(
		           new BufferedOutputStream(
		           new FileOutputStream(path)));

		encoder.writeObject(object);
		encoder.close(); 
	}

	@SuppressWarnings("unchecked")
	public static ArrayList<Product> LongTermPersistenceRead(String path) throws FileNotFoundException {
		XMLDecoder decoder = new XMLDecoder(
			    new BufferedInputStream(
			    new FileInputStream(path)));

			ArrayList<Product> object = (ArrayList<Product>) decoder.readObject();
			decoder.close();
			return object;
	}

}
