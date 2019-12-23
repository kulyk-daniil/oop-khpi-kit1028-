package ua.khpi.oop.kulyk08;

import java.io.File;
import java.util.Scanner;

public class Files {

    	static Scanner scan4 = new Scanner(System.in);
		public static File[] getListOfFiles(String path) {
			File f = new File(path); 
			File[] list =  f.listFiles();
			return list;
			
		}
		
		
		public static void printListOfFiles(File[] list) {
			for (int i = 0; i < list.length; i++) { 
                System.out.println(i+1 + ") " +list[i].getName()); 
            } 
		}
		
		public static String moveHigher(String path) {
		      return new StringBuilder(path).delete(path.lastIndexOf(File.separator),path.length()).toString();
		    }
		
		public static String chooseFile(File[] list) {
			 printListOfFiles(list);
			 System.out.println("Выберите подкаталог или файл:");
			 int index = scan4.nextInt();
			 
			return new String(list[index-1].getAbsolutePath());
			
		}
		
		public static String createFile(String path) {
			String newPath = path + File.separator + inStr();
			return new File(newPath).getAbsolutePath();
			
		}
		
		public  static String inStr() {
		     System.out.println("Ожидание ввода строки");
		      @SuppressWarnings("resource")
		      String user_str = new Scanner(System.in).nextLine();
		      return user_str;
		    }
		
}
