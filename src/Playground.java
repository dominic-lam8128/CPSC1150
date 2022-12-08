import java.lang.reflect.Array;
import java.util.Arrays;

public class Playground {



    public static int mySqrt(int x) {
        System.out.println(x);
        long temp = x;
        while (temp*temp > x) {
            temp = temp/2;
        }


        int i = (int)temp;
        while (i*i <= x && i<46341){
            i++;

        }
        return i-1;
    }

    public static boolean comesBefore(String s1, String s2) {
        return (s1.compareTo(s2) < 0);
    }

    public static int process(int num, int digit) {
        int result = 0, count = 0;
        while (num > 0){
            if (digit == num%10) {
                result += digit*(int)Math.pow(10,count);
            }
            count ++;
            num /= 10;
        }
        return result;
    }

    public static boolean process2(int num1, int num2) {
        int quotient = 1, temp = num2;
        while (temp > 0) {
            temp /= 10;
            quotient *= 10;
        }

        while (num1 > 0) {
            if ((num1%quotient) == num2)
                return true;
            num1 /= 10;
        }

        return false;
    }
    


    public static boolean duplicated(char[] list, char key) {
        for (char ch: list){
            if (ch == key) {
                return true;
            }
        }
        return false;
    }
    public static char[][] genCombinations(char[] list) {
        char[][] result = new char[list.length+1][];
        return result;
    }


    public static void main(String[] args) {


//        int x = (byte)-400;
//        System.out.println(x);
//
//        x = (byte)400;
//        System.out.println(x);

//        System.out.println(mySqrt(2147395600));
////        System.out.println(46340*46340 + ", " + 46341*46341);
//
//        boolean even = false;
//        if (even = true) {
//            System.out.println("it's even");
//        }
//
//        int x = 3; int y = 4;
//        switch (x + 3) {
//            case 6: y = 0;
//            case 7: y = 1;
//            default: y += 1;
//        }
//
//        System.out.println(y);
//
//        System.out.printf("%10s", 123456);
//        System.out.println();
//
//        int[] list = {1,2,3,4,5};
//        System.out.println(Arrays.toString(list));
//        int[] list1 = new int[]{1,2,3,4,5};
//        System.out.println(Arrays.toString(list1));
//        int[] list2 = new int[5];
//
//        System.out.println("aba".compareTo("abc"));
//
//        int startValue = 2;
//        while (startValue > 0) {
//            startValue *= 2;
//            System.out.println(startValue);
////            sum = 0;
//        }
//        System.out.println("Done!");
//
//        System.out.println(process(24574, 4));
//        System.out.println(process(24574, 8));
//
//        System.out.println(process2(3241234, 12));
//        System.out.println(process2(3241234, 42));
//
//        System.out.printf("Hello%10d",1);
//        System.out.println();
//        char[] empty = new char[0];
//        System.out.println(Arrays.toString(empty));

//        System.out.println(factorial(5));
//        System.out.println(nCr(4,2));

//        genCombinationList(new char[] {'a','b','c'},2);
    }
}
