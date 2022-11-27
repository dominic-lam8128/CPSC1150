import java.util.Scanner;

public class SumOfTwoStrings {
    //Reverse and return the string passed in
    public static String reverseString(String str) {
        String revStr = "";
        for (int i = 0; i < str.length(); i++) {
            revStr = str.charAt(i) + revStr;
        }
        return revStr;
    }

    //Add commas to a number string
    public static String addCommasToNumberString(String numStr) {
        String result = "";
        int firstCommaPosition = (numStr.length() == 6) ? 3 : numStr.length()%3;
        int numberOfCommas = numStr.length()/3;
        if (numStr.length() > 3 && numStr.length() <= 6 ) {
            return numStr.substring(0,firstCommaPosition) + "," + numStr.substring(firstCommaPosition);
        } else if (numStr.length() > 6 ) {
            result = numStr.substring(0,firstCommaPosition) + ",";
            for (int i = 1; i < numberOfCommas; i++) {
                int commaPosition = firstCommaPosition + i*3;
                result += numStr.substring(commaPosition-3,commaPosition) + ",";
            }
            return result += numStr.substring(numStr.length()-3);
        }

        return numStr;
    }


    public static String sumOfTwoStrings(String str1, String str2) {
        //First reverse both number strings
        String revStr1 = reverseString(str1);
        String revStr2 = reverseString(str2);
        String result = "";

        int count = 0;
        int carry = 0;

        //Calculate the sum of the digits at the same place and store the sum to result
        while (count<revStr1.length() || count<revStr2.length()) {
            int digitInStr1 = (count < revStr1.length()) ? revStr1.charAt(count) - '0' : 0;
            int digitInStr2 = (count < revStr2.length()) ? revStr2.charAt(count) - '0' : 0;
            int sumOfDigit =  digitInStr1 + digitInStr2 + carry;

            carry = sumOfDigit/10;
            sumOfDigit %= 10;
            result += Integer.toString(sumOfDigit);
            count++;
        }

        //reverse and return the result
        return reverseString(result);
    }

    public static boolean checkIfAllCharactersAreDigit(String str) {
        for (char character: str.toCharArray()) {
            if (!Character.isDigit(character)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        String str1, str2, result = "";

        System.out.println("This program computes the sum of two positive integers up to 40 digits");
        Scanner input = new Scanner(System.in);
        System.out.print("Numbers 1: ");
        str1 = input.nextLine();
        System.out.print("Numbers 2: ");
        str2 = input.nextLine();

        if (!(checkIfAllCharactersAreDigit(str1) && checkIfAllCharactersAreDigit(str2))) {
            System.out.println("Error: Invalid Input!");
            return;
        }

        result = sumOfTwoStrings(str1, str2);
        System.out.println("Sum of the two numbers: " + addCommasToNumberString(result));

    }
}

//
//    If inputs are:
//        Number1: 236598745632 Number2: 2453254365546764765
