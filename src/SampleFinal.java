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
        }

        System.out.print("Enter a number higher than " + low + ": ");
        high = input.nextInt();
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

    }




    public static void main(String[] args) {
        programQ1();
    }
}
