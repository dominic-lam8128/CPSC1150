import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class SampleFinal {


    public static void programQ1() {
        char[] arr = {'A', 'B', 'C', 'D', 'E'};
//        arr = new char[] {'B', 'C', 'D', 'E'};
        String tmp;
        int i, j;
        for (i = 0; i < arr.length; i++) {
            tmp = "";
            for (j = arr.length - i - 1; j > 0; j--)
                tmp += '*';
            for (j = arr[arr.length - 1]; j > arr[arr.length - i - 1]; j--)
                tmp += (char) j;
            System.out.println(tmp);
        }
    }

    public static void debug2() {
        //Original Code
        int high, low, count = 0;
        final int NUM = 5;
        Scanner input = new Scanner(System.in);
        // Prompt user to enter high and low values
        System.out.println("This application displays " + NUM + " random numbers" +
                "\nbetween (and including) the low and high values you enter");
        System.out.print("\nEnter low value: ");
        low = input.nextInt();
        System.out.print("Enter high value: ");
        high = input.nextInt();
        while (high >= low) {
            System.out.println("The number you entered for high, " +
                    high + ", is not higher than " + low);
        }

        System.out.print("Enter a number higher than " + low + ": ");
        high = input.nextInt();
        while (count < high) {
        // Generate a random number between (and including) low and high
            double result = Math.random();
            int number = (int) (result * (high - low + 1));
            System.out.print(number + " ");
            ++count;
        }
        System.out.println();
    }

    public static void debug2corrected() {
        //Corrected Code
        int high, low, count = 0;
        final int NUM = 5;
        Scanner input = new Scanner(System.in);
        // Prompt user to enter high and low values
        System.out.println("This application displays " + NUM + " random numbers" +
                "\nbetween (and including) the low and high values you enter");
        System.out.print("\nEnter low value: ");
        low = input.nextInt();
        System.out.print("Enter high value: ");
        high = input.nextInt();

        while (high < low) { //1. high >= low -> high < low
            System.out.println("The number you entered for high, " +
                    high + ", is not higher than " + low);
            System.out.print("Enter a number higher than " + low + ": ");
            high = input.nextInt();
        }


        while (count < NUM) { //2. count < high -> count < NUM
            // Generate a random number between (and including) low and high
            double result = Math.random();
            int number = (int) (result * (high - low + 1)) + low; //3. add + low as a offset
            System.out.print(number + " ");
            ++count;
        }
        System.out.println();
    }

    public static void programQ2() {
//        debug2();
        debug2corrected();
    }


    public static String generateVefiCode(int length) {
        String code = "";
        code += (char)((int)(Math.random()*('Z'-'A' + 1)) + 'A');
        code += (char)((int)(Math.random()*('z'-'a' + 1)) + 'a');
        code += (char)((int)(Math.random()*('9'-'0' + 1)) + '0');

        if (length <= 3)
            return code;

        String key = "";
        for (int i = 'A'; i < 'Z' + 1; i++) {
            key += (char)i;
        }
        for (int i = 'a'; i < 'z' + 1; i++) {
            key += (char)i;
        }
        for (int i = '0'; i < '9' + 1; i++) {
            key += (char)i;
        }

        for (int i = 3; i < length; i++) {
            code += key.charAt((int)(Math.random()*(key.length())));
        }
        return code;
    }

    public static void programPart3Q1() {
        for (int i = 0; i < 10; i++) {
            int length = (int)(Math.random()*11) + 3;
            System.out.println(generateVefiCode(length) + ", " + length);
        }
    }


    public static void averagePrecips(int[][] precips) {
        System.out.println("Average precipitation for each month");
        for(int i = 0; i < 12; i++) {
            double average = 0;
            for (int j = 0; j<5; j++) {
                average += precips[j][i];
            }
            System.out.printf((i+1) + " %.1f\n", average/5);
        }
    }
    public static void programPart3Q2() {

        int[][] precips = {{132, 116, 105, 75, 62, 46, 36, 38, 64, 115, 167, 161},
                {133, 118, 115, 73, 63, 48, 34, 35, 65, 114, 163, 160},
                {134, 117, 106, 77, 65, 44, 37, 33, 63, 113, 165, 159},
                {135, 113, 108, 72, 62, 47, 39, 34, 67, 112, 164, 162},
                {131, 116, 107, 79, 68, 43, 33, 39, 68, 112, 162, 160}};

        averagePrecips(precips);
    }


    public static boolean validate(int n) {
        String s = n + "";

        //Check if n contains zero
        for(char ch: s.toCharArray()) {
            if (ch == '0')
                return false;
        }


        //Check if digits are repeated
        for(int i = 0; i < s.length()-1; i++) {
            if ((s.substring(i+1)).indexOf(s.charAt(i)) != -1)
                return false;
        }

        return true;
    }

    public static boolean validate2num(int n) {
        boolean cond1 = validate(n);
        boolean cond2 = validate(2*n);
        boolean cond3 = ((n+"").length() == (2*n + "").length());
        return cond1 && cond2 && cond3;
    }


    public static void selectMagicNumber() throws IOException {
        Scanner s = new Scanner(new File("sample_final_input.txt"));
        PrintWriter pw = new PrintWriter(new File("sample_final_result.txt"));

        pw.println("\t\tn\t\t2n");
        pw.println("--------------------");


        while (s.hasNext()) {
            int num = s.nextInt();
            if (validate2num(num)) {
                pw.println("\t" + num + "\t" + 2*num);
            }
        }

        pw.close();
        s.close();
    }

    public static void programPart3Q3() throws IOException {
        selectMagicNumber();
    }




    public static void main(String[] args) throws IOException {
//        programQ1();

//        programQ2();

//        programPart3Q1();
//        programPart3Q2();
        programPart3Q3();
    }
}
