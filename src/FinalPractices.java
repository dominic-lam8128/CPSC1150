import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FinalPractices {


    public static int f2(int n, int result) {
        if (n == 0)
            return 0;
        else
            return f2(n - 1, n + result);
    }

    public static void tracef2Recursion(){
        System.out.println(f2(2,0));
    }

    public static void convertIntToByteManually(int numberOfPractices)  throws IOException {

        PrintWriter pw = new PrintWriter(new File("Number_System_Answers.txt"));
        System.out.println("Consider the following code");
        System.out.println("\t\tint x = n");
        System.out.println("\t\tbyte y = (byte)x");
        System.out.println("What will the output value of y if n is the following integers?");
        pw.println("Answers");
        pw.println( "i      int     byte");

        for (int i = 0; i < numberOfPractices; i++) {
            int randomNumber = (int)(Math.random()*1025 - 512);
            System.out.println(i+1 + ", " + randomNumber);
            pw.println(i+1 + "\t\t" + randomNumber + "\t\t" + (byte)randomNumber);
        }

        pw.close();


    }

    public static void main(String[] args) throws IOException{
        convertIntToByteManually(10);
    }

}
