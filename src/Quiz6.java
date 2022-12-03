import java.util.Arrays;

public class Quiz6 {

//    Q2. [5] Write a java method, which accepts a character variable and an array of characters.
//    The method returns the number of times the character appear in the array.

    public static int countCharacterAppearance(char[] list, char key) {
        int sum = 0;
        for (char ch: list)
            sum += (ch == key) ? 1 : 0;
        return sum;
    }

//    Q3. [5] Write a java method, which reverses an integer array. The method reverses
//    an integer array, which is passed as a formal parameter.

    public static void reverseArray(int[] list) {
        for (int i = 0; i < list.length / 2; i++) {
            int temp = list[list.length - i - 1];
            list[list.length-i-1] = list[i];
            list[i] = temp;
        }
    }

    public static int[] generateRandomArray(int length) {
//        int length = (int)(Math.random()*11); //Generates a random number from 0 to 10
        int[] list = new int[length];
        for (int i = 0; i < list.length; i++) {
            list[i] = (int)(Math.random()*101); //Generates a random number from 0 to 100
        }
        return list;
    }


    public static void main(String[] args) {
//        Q1 Demo
        System.out.println(countCharacterAppearance("apple".toCharArray(), 'p'));

//        Q2 Demo
        int[] list = generateRandomArray(10);
        System.out.println(Arrays.toString(list));
        reverseArray(list);
        System.out.println(Arrays.toString(list));

    }
}
