/**
 * Suggested solutions to CPSC1150 PracticeQuestions3
 */







import java.util.Arrays;
import java.util.Scanner;

public class PracticeQuestions3 {
    public static boolean isSumOfTwoSquares(int n) {
        for (int i = 1; i <= n/2 ; i++) {
            if (isSquare((n-i*i)) && i*i >= 1 && (n-i*i) >= 1) {
                System.out.println(n + " = " + i*i + " + " + (n-i*i));
                return true;
            }
        }
        return false;
    }

    public static boolean isSquare(int n) {
        int sqRt = (int)(Math.sqrt(n));
        return sqRt*sqRt == n;
    }

    public static void printSumOfTwoSquaresBelow(int n) {
        for (int i = 0; i < n; i++) {
            isSumOfTwoSquares(i);
        }
    }

    public static int factorial(int n) {
        if (n <= 1) {
            return 1;
        } else {
            return n*factorial(n-1);
        }
    }

    public static int nThFibonacciNumber(int n) {
        if (n <= 1) {
            return n;
        } else {
            return nThFibonacciNumber(n-1) + nThFibonacciNumber(n-2);
        }
    }

    public static int[] getFibonacciArray(int size) {
        int[] fibonacciList = new int[size];
        for (int i = 0; i < size; i++) {
            if (i <= 1) {
                fibonacciList[i] = 1;
            } else {
                fibonacciList[i] = fibonacciList[i-1] + fibonacciList[i-2];
            }
        }
        return fibonacciList;
    }

    public static boolean isPalindrome(String s) {
        return isPalindrome(s, 0, s.length()-1);
    }

    public static boolean isPalindrome(String s, int first, int last) {
        if (last <= first)
            return true;
        else {
            if (s.charAt(first) != s.charAt(last))
                return false;
            else
                return isPalindrome(s, first+1, last-1);
        }
    }

    public static boolean isTwosPower(int n) {
        while (n > 1) {
            if (n%2 != 0)
                return false;
            n /= 2;
        }
        return true;
    }

    public static void findOutTwosPowerInAnArray(int[] list){
        for (int n : list) {
            if (isTwosPower(n))
                System.out.println(n + " is a two's power");
        }
    }

    public static void programQ3() {
        System.out.println("This program finds the largest increase between the integers you entered.");
        System.out.println("You may stop the program by entering a negative integer.");
        Scanner input = new Scanner(System.in);
        int maxIncrease = 0, previousNum = 0, currentNum = 0;
        boolean runProgram = true;
        //To take the first integer.
        System.out.print("Please enter a positive integer: ");
        previousNum = input.nextInt();
        currentNum = previousNum;
        if (previousNum < 0)
            runProgram = false;

        while (runProgram) {
            System.out.print("Please enter a positive integer: ");
            previousNum = currentNum;
            currentNum = input.nextInt();
            if (currentNum < 0)
                break;
            int currentIncrease = currentNum - previousNum;
            if (currentIncrease > maxIncrease)
                maxIncrease = currentIncrease;

        }

        System.out.println("Largest increase between the integers you entered: " + maxIncrease);

    }

    public static int findCorrespondingDigitForLetters(char letter) {
        letter = Character.toUpperCase(letter);
        switch (letter) {
            case 'A':
            case 'B':
            case 'C':
                return 2;
            case 'D':
            case 'E':
            case 'F':
                return 3;
            case 'G':
            case 'H':
            case 'I':
                return 4;
            case 'J':
            case 'K':
            case 'L':
                return 5;
            case 'M':
            case 'N':
            case 'O':
                return 6;
            case 'P':
            case 'R':
            case 'S':
                return 7;
            case 'T':
            case 'U':
            case 'V':
                return 8;
            case 'W':
            case 'X':
            case 'Y':
                return 9;
            default:
                return -1;
        }
    }

    public static void programQ4() {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.print("Please enter a letter: ");
            char letter = input.next().charAt(0);
            System.out.println("The corresponding digit on telephone keypad: " + findCorrespondingDigitForLetters(letter));
        }

    }

    public static void countLetterOccurrenceInString(String s) {
        int[] list = new int[26];
        s = s.toUpperCase();

        for (char ch : s.toCharArray()) {
            if (Character.isLetter(ch)) {
                int index = ch - 'A';
                list[index]++; //list[ch-'A']++; is also ok here
            }
        }

        for (int i = 0; i < list.length; i++) {
            if (list[i] > 0) {
                System.out.println((char)(i+'A') +"\t\thas occurred " + list[i] + " time(s).");
            }
        }
    }

    public static int bitsToRepresent(int n) {
        /** From 0 to 32767
         * 0-1 -> 1 bit
         * 2-3 -> 2 bits
         * 4-7 -> 3 bits
         * 8-15 -> 4 bits
         */
        int count = 0;
        while (Math.pow(2,count+1) < n)
            count++;

        return count+1;


    }

    public static void programQ6() {
        Scanner input = new Scanner(System.in);
        System.out.println("You may stop the program by entering a negative integer.");
        while (true) {
            System.out.print("Please enter a positive integer 0-32767: ");
            int n = input.nextInt();

            if (n < 0)
                break;

            if (n <= 32767)
                System.out.println(bitsToRepresent(n) + " bit(s) is/are required to represent " + n + ".");
        }

    }

    public static void displayOrdinalFormsForNumbers(int[] list) {
        for (int num : list) {

            if (num%100 <= 13 && num%100 >= 11) {
                System.out.print(num + "th ");
            } else {
                String suffix = "th ";
                int lastDigit = num%10;
                switch (lastDigit) {
                    case 1:
                        suffix = "st ";
                    case 2:
                        suffix = "nd ";
                    case 3:
                        suffix = "rd ";
                }
                System.out.print(num + suffix);

            }
        }
    }

    public static String getHexadecimalCharacter(int n) {
        if (n >= 10) {
            return (char)(n-10+'A') + "";
        }
        return n + "";
    }

    public static String decimalToHexadecimal(int n) {
        String result = "";
        while (n > 0) {
            result = getHexadecimalCharacter(n%16) + result;
            n /= 16;
        }
        return result;
    }

    public static void programQ8(){
        for (int i = 0; i < 10; i++) {
            int randomNum = (int)(Math.random()*1000);
            System.out.println(randomNum + " in hexadecimal: " + decimalToHexadecimal(randomNum) );
        }
    }

    public static boolean validateBin(String bin) {
        boolean flag = true;
        if (bin.length() != 16){
            System.out.println("Number of digits of input must be 16");
            flag = false;
        }

        for (char ch: bin.toCharArray()) {
            if (!(ch == '0' || ch == '1')){
                System.out.println("Each digit of input must be 0 or 1");
                flag = false;
            }
        }

        if (!flag)
            return flag;

        return true;
    }

    public static int binToDec(String input) {
        int result = 0;

        char valueCharacter = (input.charAt(0) == '0') ? '1' : '0';

        for (char ch : input.toCharArray()) {
            result *= 2;
            if (ch == valueCharacter)
                result += 1;
        }

        if (input.charAt(0) == '1')
            result = -1 * (result+1);


        return result;
    }

    public static void programQ9Test(){
//        for (int i = 0; i < 10; i++) {
//            String randomStr = "";
//            for (int j = 0; j < 16; j++) {
//                randomStr += (int)(Math.random()*2) + "";
//            }
//            System.out.println(randomStr + ", " + binToDec(randomStr));
//        }
        System.out.println(binToDec("1111111111111111"));
    }

    public static void programQ9(){

        System.out.println("Please enter a 16 digits binary number (signed 2's complement)");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();

        if (validateBin(input))
            binToDec(input);


//        if (input.charAt(0) == '0') {
//            //It's a positive binary number
//            for (char ch : input.toCharArray()) {
//                result *= 2;
//                if (ch == '1')
//                    result += 1;
//            }
//        } else {
//            //It's a negative binary number
//            for (char ch : input.toCharArray()) {
//                result *= 2;
//                if (ch == '0')
//                    result += 1;
//            }
//            result = -1 * (result+1);
//        }



        System.out.println(binToDec(input));

        //0111100110010100 = 31124
        //1111100110010100 = -1644
    }

    public static void programQ10(){
        int x = -270;
        x = -129;
        byte y = (byte)x;
        //-270 = -128 - (127-0) - 15 => y = -14

        //x-> 2's complement, -> get the rightmost 8 digits
        //2 questions, points not much



        System.out.println(y);
    }

    public static void main(String[] args) {
        //Please uncomment each section to see the demonstration of each question.

//        //Question 1
//        printSumOfTwoSquaresBelow(1000);

        //Question 2
//        System.out.println(isTwosPower(8));
//        System.out.println(Arrays.toString(getFibonacciArray(30)));
//        findOutTwosPowerInAnArray(getFibonacciArray(30));

        //Question 3
//        programQ3();

        //Question 4
//        programQ4();

        //Question 5
//        countLetterOccurrenceInString("Hello World");

        //Question 6
//        programQ6();

        //Question 7
//        displayOrdinalFormsForNumbers(new int[] {21, 345, 42, 83, 789, 11,101,111,312});

        //Question 8
//        programQ8();

        //Question 9
//        programQ9();
        programQ9Test();

        //Question 10
//        programQ10();
    }

}
