import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Ch7SingleDimensionalArrays {

    /**
     * Separator for Question 7.1
     * ========================================================
     */

    public static void printScoresAndGrades(int[] scoreList, int max) {
        for (int i = 0; i < scoreList.length; i++) {
            int diff = max - scoreList[i] -1 ;
            char grade = (char)(diff/10 + 'A');
            System.out.printf("Student %d score is %d and grade is %s\n",i,scoreList[i],grade);
        }
    }

    public static void question1() {
        System.out.print("Enter the number of students: ");
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();

        System.out.print("Enter "+ length +" scores: ");

        int max = 0;
        int[] scoreList = new int[length];
        for (int i = 0; i < length; i++) {
            int score = scanner.nextInt();
            scoreList[i] = score;
            if (score > max)
                max = score;
        }

        System.out.println(max + ", " + Arrays.toString(scoreList));
    }


    /**
     * Separator for Question 7.2
     * ========================================================
     */
    public static void question2() {
        Scanner s = new Scanner(System.in);
        System.out.print("Please enter 5 integers: ");
        int[] list = new int[5];
        for (int i = 0; i < list.length; i++) {
            list[i] = s.nextInt();

        }

        for (int i = 0; i < list.length; i++)
            System.out.print(list[list.length-i-1] + ", ");
    }


    /**
     * Separator for Question 7.3
     * ========================================================
     */

    public static void question3() {
        Scanner s = new Scanner(System.in);
        int[] list = new int[100];
        System.out.print("Please enter integers from 1 and 100: ");
        while (s.hasNext()) {
            int num = s.nextInt();
            if (num <= 0 || num >100)
                break;
            list[num-1]++;
        }

        for (int i = 0; i < list.length; i++) {
            if (list[i] != 0) {
                String str = (list[i] > 1) ? "s" : "";
                System.out.println(i + 1 + " occurs " + list[i] + " time" + str);
            }
        }

    }


    /**
     * Separator for Question 7.5
     * ========================================================
     */

    public static void question5() {
        Scanner s = new Scanner(System.in);
        int[] list = new int[10];
        int count = 0;
        System.out.print("Please enter 10 integers: ");
        for (int i = 0; i < 10; i++) {
            int input = s.nextInt();
            for (int j = 0; j < list.length; j++) {
                if (list[j] == input)
                    break;
                if (list[j] == 0) {
                    count++;
                    list[j] = input;
                    break;
                }
            }
        }
        System.out.print("The number of distinct number is: " + count);
        System.out.print("The distinct numbers are: ");
        for (int i = 0; i < list.length; i++) {
            if (list[i] == 0)
                break;
            System.out.print(list[i] + " ");
        }
    }

    public static boolean isPrime(int n) {
        if (n <= 1)
            return false;
        for (int i = 2; i <= (int)(Math.sqrt(n)); i++) {
            if (n%i == 0)
                return false;
        }
        return true;
    }

    public static void testPrime(int n) {
        for (int i = 1; i <= n; i++) {
            System.out.println(i + ", is prime?: " + isPrime(i));
        }
    }

    /**
     * Separator for Question 7.17
     * ========================================================
     */

    public static void sortArray(double[] scoreList, String[] nameList) {
        for (int i = 0; i < scoreList.length-1; i++) {
            int max_index = i;
            for (int j = i+1; j < scoreList.length; j++) {
                if (scoreList[max_index] < scoreList[j])
                    max_index = j;
            }
            double tempScore = scoreList[max_index];
            scoreList[max_index] = scoreList[i];
            scoreList[i] = tempScore;

            String tempName = nameList[max_index];
            nameList[max_index] = nameList[i];
            nameList[i] = tempName;
        }
    }

    public static void question17() {
        Scanner s = new Scanner(System.in);
        System.out.print("Please enter the number of student: ");
        int length = s.nextInt();
        String[] nameList = new String[length];
        double[] scoreList = new double[length];

        for (int i = 0; i < length; i++) {
            System.out.printf("Please enter the name of student %d: ", i);
            String name = s.next();
            System.out.printf("Please enter the score of student %s: ", name);
            double score = s.nextDouble();
            scoreList[i] = score;
            nameList[i] = name;
        }

        sortArray(scoreList, nameList);

        for (int i = 0; i < length; i++) {
            System.out.println(nameList[i] + "\t" + scoreList[i]);
        }
    }

    /**
     * Separator for Question 7.19
     * ========================================================
     */

    public static boolean isSorted(int[] list) {
        for (int i = 1; i < list.length; i++) {
            if (list[i] < list[i-1])
                return false;
        }
        return true;
    }

    public static void question19() {
        System.out.print("Enter list: ");
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int[] list = new int[length];
        for (int i = 0; i < length; i++) {
            list[i] = scanner.nextInt();
        }
        String element = (isSorted(list))? "already" : "not";
        System.out.printf("The list is %s sorted\n",element);
    }

    public static String randomPath(int length) {
        String result = "";
        for (int i = 0; i < length; i++) {
            int randomNum = (int)(Math.random()*2);
            result += (randomNum == 0)? "R" : "L";
        }
        return result;
    }

    public static int countR(String path) {
        int count = 0;
        for (char ch:path.toCharArray())
            count += (ch == 'R') ? 1 : 0;
        return count;
    }

    public static void question21() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of balls to drop: ");
        int numBalls = scanner.nextInt();
        System.out.println("Enter the number of slots in the bean machine: ");
        int numSlots = scanner.nextInt();
        int[] slotList = new int[numSlots];

        for (int i = 0; i < numBalls; i++) {
            String path = randomPath(numSlots-1);
            System.out.println(path + ", " + countR(path));
            slotList[countR(path) + 1]++;
        }

        for (int i = numBalls; i > 0 ; i--) {
            for (int j = 0; j < slotList.length; j++) {
                if (i <= slotList[j])
                    System.out.print("0");
                else
                    System.out.print(" ");
            }
            System.out.println();

        }
    }



    public static void main(String[] args) {
//        testPrime(20);

//        question1();
//        question2();
//        question3();
//        question5();
//        question17();
//        question19();

        question21();

    }
}
