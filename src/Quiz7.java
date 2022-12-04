import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Quiz7 {
    /**    Question 1
     *     Write a Java method, which receives a sorted array of integers and a key
     *     (an integer). The array is sorted from the smallest to the largest. The method must
     *     insert the key into the array, in such a way that the numbers in the array will still be
     *     sorted after the insertion.
     *     Notes:
     *     > When the key is inserted, the last element of the array will be removed
     *     > If the key is larger than the last element in the array, the key should
     *     replace the last element
     */

    public static void insertKey(int[] list, int key) {
        //The last element will be removed anyway.
        list[list.length-1] = key;

        //Loop thru the array from the end,
        //for i = n..1, swap list[i-1] and list[i] if list[i-1] > list[i]
        for (int i = list.length-1; i > 0 ; i--) {
            if (list[i-1] > list[i]) {
                int temp = list[i-1];
                list[i-1] = list[i];
                list[i] = temp;
            }
        }
    }


    /**    Question 2
     *     Write a complete java program which asks the user to enter a name and
     *     his/her 10 digits phone number. Your program then adds the name and the
     *     formatted phone number to a file called directory.txt.
     *     Sample run:
     *     Please enter your name: John Smith
     *     Please enter your 10-digit phone number: 6042836377
     *     Your program then should add the following line to the directory.txt
     *     file:
     *             John Smith 604-263-6677
     *     You may assume the input is correct.
     *
     * @throws IOException
     */

    public static void writeDirectory() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter your name: ");
        String name = scanner.nextLine();
        System.out.println("Please enter your 10-digit phone number: ");
        String number = scanner.nextLine();

        PrintWriter pw = new PrintWriter(new File("directory.txt"));
        pw.println(name + " " + number.substring(0,3) + "-" + number.substring(3,6) + "-" + number.substring(6));
        pw.close();
    }


    public static void main(String[] args) throws IOException {
        //Question 1
        int[] list = {1,3,5,7,9};
        System.out.println(Arrays.toString(list));
        insertKey(list, 2);
        System.out.println(Arrays.toString(list));

        //Question 2
        writeDirectory();


    }
}
