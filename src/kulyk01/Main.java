package ua.khpi.oop.kulyk01;

public class Main {

    public static void main(String[] args) {

        final int gradebook = 0x4678;  
        final long phone = +380939377183L;
        final int last2 = 0b1010011;
        final int last4 = 016017;
        final int number = ((11 - 1) % 26) + 1;  
        final char letter = 75; 
        int z = (int) letter;

        int[] resPaired = new int[6];
        int[] resUnpaired = new int[6];
        {
            resPaired[0] = countPaired(gradebook);
            resPaired[1] = countPaired(phone);
            resPaired[2] = countPaired(last2);
            resPaired[3] = countPaired(last4);
            resPaired[4] = countPaired(number);
            resPaired[5] = countPaired(z);

            resUnpaired[0] = countSIZE(gradebook) - resPaired[0];
            resUnpaired[1] = countSIZE(phone) - resPaired[1];
            resUnpaired[2] = countSIZE(last2) - resPaired[2];
            resUnpaired[3] = countSIZE(last4) - resPaired[3];
            resUnpaired[4] = countSIZE(number) - resPaired[4];
            resUnpaired[5] = countSIZE(z) - resPaired[5];
        }


        int[] resWithOne = new int[6];
        {
            resWithOne[0] = countChar(Integer.toBinaryString(gradebook), '1');
            resWithOne[1] = countChar(Long.toBinaryString(phone), '1');
            resWithOne[2] = countChar(Integer.toBinaryString(last2), '1');
            resWithOne[3] = countChar(Integer.toBinaryString(last4), '1');
            resWithOne[4] = countChar(Integer.toBinaryString(number), '1');
            resWithOne[5] = countChar(Integer.toBinaryString(z), '1');
        }


        {
            System.out.println("Number 1 in binary representation will be in parentheses");
            System.out.println("Gradebook number " + gradebook + "(" + resWithOne[0] + "| " + resPaired[0] + "\\" + resUnpaired[0] + ")");
            System.out.println("My phone number is " + phone + "(" + resWithOne[1] + "| " + resPaired[1] + "\\" + resUnpaired[1] + ")");
            System.out.println("Last 2 digits of my number is " + last2 + "(" + resWithOne[2] + "| " + resPaired[2] + "\\" + resUnpaired[2] + ")");
            System.out.println("Last 4 digits of my number is " + last4 + "(" + resWithOne[3] + "| " + resPaired[3] + "\\" + resUnpaired[3] + ")");
            System.out.println("My group number is " + number + "(" + resWithOne[4] + "| " + resPaired[4] + "\\" + resUnpaired[4] + ")");
            System.out.println("My letter is " + letter + "(" + resWithOne[5] + "| " + resPaired[5] + "\\" + resUnpaired[5] + ")");
        }


    }

    static int countSIZE(long a) {
        int count = 0;

        while (a != 0) {
            a /= 10;
            count++;
        }

        return count;
    }

    static int countPaired(long a) {
        int count = 0;

        while (a != 0) {
            long z = a % 10;
            if (z % 2 == 0)
                count++;
            a /= 10;
        }
        return count;
    }


    static int countChar(String str, char c) {
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == c)
                count++;
        }

        return count;
    }


}