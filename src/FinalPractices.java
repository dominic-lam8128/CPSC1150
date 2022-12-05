import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FinalPractices {

    public static void convertIntToByteManually(int numberOfPractices)  throws IOException {

        PrintWriter pw = new PrintWriter(new File("Number_System_Answers.txt"));
        System.out.println("What will the value of the following integer(s) being casted to byte?");
        pw.println("Answers");
        pw.println( "i      int     byte");

        for (int i = 0; i < numberOfPractices; i++) {
            int randomNumber = (int)(Math.random()*513);
            System.out.println(i+1 + ", " + randomNumber);
            pw.println(i+1 + "\t\t" + randomNumber + "\t\t" + (byte)randomNumber);
        }

        pw.close();


    }

    public static void main(String[] args) throws IOException{
        convertIntToByteManually(10);
    }

}
