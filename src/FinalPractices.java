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

    public static void generateByteEx(int numberOfPractices)  throws IOException {

        PrintWriter pw = new PrintWriter(new File("Number_System_Answers_set2.txt"));
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

    public static void byteToIntTest() {
        int numberOfTest = 1000;
        boolean boo = true;
        for (int i = 0; i < numberOfTest; i++) {
            int randomNumber = (int)(Math.random()*2049-1028);
//            System.out.println(randomNumber);
            if ((byte)randomNumber != intToByte(randomNumber)) {
                boo = false;
                System.out.println(i+1 + ", " + randomNumber + ", " + (byte)randomNumber + ", " + intToByte(randomNumber));
            }
        }

        if (boo)
            System.out.println("It seems correct!");
    }

    public static int intToByte(int n) {
        if (n < -128)
            return intToByte(n+256);
        if (n > 127)
            return intToByte(n-256);
        return n;
    }







    public static void main(String[] args) throws IOException{
//        generateByteEx(10);
        byteToIntTest();
    }

}
