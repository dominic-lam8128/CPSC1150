import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Midterm2 {

    public static int process(int[] list) {
        int index = 0, temp, range = list.length-1;
        while (list[0]>list[range]) {
            temp = list[0];
            while (index < range) {
                list[index] = list[index+1];
                index++;
                System.out.println(index + ", " + Arrays.toString(list));
            }
            list[range] = temp;
            System.out.println(Arrays.toString(list));
        }
        return list[range];
    }

    public static int rewriteProcess(int[] list) {
        int index = 0, temp, range = list.length-1;
        do {
            temp = list[0];
            for (;index < range;index++) {
                list[index] = list[index+1];
                index++;
            }
            list[range] = temp;
        } while (list[0] > list[range]);
        return list[range];
    }

    public static void question1() {
        int[] list = new int[] {18,22,30,1,5,9,17};
        System.out.println(process(list));
//        list = new int[] {18,22,30,1,5,9,17};
//        System.out.println(rewriteProcess(list));
    }

    //    Question 4
    //    [10] Write a Java program to open an input file named "scores.txt, which
    //    contains the scores of students. The program should calculate the average and
    //    the highest score in the file and display the results on the computer screen.

    public static void readScores() throws IOException {
        Scanner scanner = new Scanner(new File("mt2_scores.txt"));
        double sum = 0, max = 0;
        int count = 0;

        while (scanner.hasNext()) {
            double score = scanner.nextDouble();
            sum += score;
            count++;
            max = (score > max)? score:max;
        }
        scanner.close();
        System.out.println("Average: " + sum/count +"\nHighest Score: " + max);
    }



    public static void question4() throws IOException {
        readScores();
    }
    
    public static int[] mergeArrays(int[] list1, int[] list2) {
        int[] list = new int[list1.length + list2.length];
        int shortlength = 0;
        
        shortlength = Math.min(list1.length, list2.length);
        for (int i = 0; i < shortlength; i++) {
            list[i*2] = list1[i];
            list[i*2+1] = list2[i];
        }
        if (shortlength == list2.length) {
            for (int j = shortlength; j < list1.length; j++) {
                list[shortlength+j] = list1[j];
            }
        } else {
            for (int j = shortlength; j < list2.length; j++) {
                list[shortlength+j] = list2[j];
            }
        }

        return list;
    }

    public static void question5(){
        int[] list1 = new int[] {34,4,5,17,15,30};
        int[] list2 = new int[] {12,6,29,20};
        int[] resultList = mergeArrays(list1, list2);
        System.out.println(Arrays.toString(resultList));
    }

    public static void main(String[] args) throws IOException{
//        question1();
        question4();
//        question5();
    }
}


