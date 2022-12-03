public class Quiz5 {

//    1. [10] Write a java method which accepts a sentence (String object) and prints
//    the words (separated by space) on different lines. For example if the
//    sentence is "Hello, how are you?" the method should display:
//    Hello.
//            how
//            are
//            you?

    public static void printWords(String msg) {
        for (String word:msg.split(" ")) {
            if (!word.equals("")) {
                System.out.println(word);
            }
        }
    }



    public static void main(String[] args) {
        printWords("Hello, how are you?");
    }
}
