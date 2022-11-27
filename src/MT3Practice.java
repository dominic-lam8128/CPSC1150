public class MT3Practice {

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

    public static void main(String[] args) {
//        System.out.println(factorial(3));
//        System.out.println(nThFibonacciNumber(11));
        System.out.println(isPalindrome("aba"));
        System.out.println(isPalindrome("ab"));
    }
}
