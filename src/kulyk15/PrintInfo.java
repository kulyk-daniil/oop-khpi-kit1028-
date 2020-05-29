package ua.khpi.oop.kulyk15;

public class PrintInfo {

    static void menuPrint() {
	System.out.println("0  - Exit");
	System.out.println("1  - Add product");
	System.out.println("2  - Show all products");
	System.out.println("3  - Remove product");
	System.out.println("4  - Remove all products");
	System.out.println("5  - Scan product");
	System.out.println("6  - Use XML encoder");
	System.out.println("7  - Use XML decoder");
	System.out.println("8  - Serialize data");
	System.out.println("9  - Deserialize data");
	System.out.println("10 - Sort data");
	System.out.println("11 - Generate products");
    	}
    	
	public static void attributePrint() {
		System.out.println("0  - Cancel");
		System.out.println("1  - Name");
		System.out.println("2  - Unit");
		System.out.println("3  - Amount");
		System.out.println("4  - Price");
		System.out.println("5  - Weigth");
		System.out.println("6  - Date");
	}
	
	public static void sortPrint() {
		System.out.println("0  - Cancel");
		System.out.println("1  - Name");
		System.out.println("2  - Date");
		System.out.println("3  - Price");
	}
	
	public static void scanPrint() {
		System.out.println("0  - Cancel");
		System.out.println("1  - Name");
		System.out.println("2  - Unit");
		System.out.println("3  - Amount");
		System.out.println("4  - Price");
		System.out.println("5  - Weigth");
		System.out.println("6  - Date");
		System.out.println("7  - Properties");
	}
	
	public static void propertiesPrint(boolean isOR, boolean is_short_term, boolean is_middle_term, boolean is_long_term) {
		System.out.println("0  - Back");
		System.out.println("1  - Short term product" + ((is_short_term) ? "   [chosen]" : ""));
		System.out.println("2  - Middle term product" + ((is_middle_term) ? "   [chosen]" : ""));
		System.out.println("3  - Long term product" + ((is_long_term) ? "   [chosen]" : ""));
		System.out.println("4  - Scan");
		System.out.println("5  - Change scan mode [mode chosen: " + ((isOR) ? "OR]" : "AND]"));
	}
	
	static void updateProgress(double progressPercentage) {
		final int width = 50; // progress bar width in chars
		System.out.print("\r[");
		int i = 0;
		for (; i <= (int)(progressPercentage*width); i++) {
			System.out.print("#");
		}
		for (; i < width; i++) {
			System.out.print(" ");
		}
		System.out.printf("] %.1f%%", progressPercentage*100);
	}
	
}
