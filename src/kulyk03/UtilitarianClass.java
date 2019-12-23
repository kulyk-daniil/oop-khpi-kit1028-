package ua.khpi.oop.kulyk03;

public final class UtilitarianClass {
    public static void change5text(String text){
    StringBuilder word = new StringBuilder(10);
    StringBuilder result = new StringBuilder(text.length());
        for(
    int i = 0, j = 0; i<text.length();i++)

    {
        if (text.charAt(i) != ' ') {
            j = i;
            while (text.charAt(j) != ' ') {
                word.append(text.charAt(j));
                j++;
            }
            if (word.length() == 5) {
                result.append("dulya ");
                i = j;
            } else {
                for (; i < j; i++) {
                    result.append(text.charAt(i));
                }
                result.append(" ");
            }
            word.delete(0, 10);
        }

    }
        System.out.println(result);
}
}