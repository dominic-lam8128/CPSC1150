public class Quiz8 {
    public static int reverse(int n) {
        int result = 0;

        while (n > 0) {
            result *= 10;
            result += n%10;
            n /= 10;
        }

        return result;
    }


//    [10] A cipher is a method of sending secret messages by replacing each letter of
//    the original text with a secret key. Write a java method called encipher that
//    accepts a String of characters; it then enciphers and returns the String in another
//    form based on the following substitution cipher key:
//            ABCDEFGHIJKLMNOPQRSTUVWXYZ
//            VJMQDSBGKYAZPWETXCNLHORFUI
//    Each letter character in the text is to be replaced by the corresponding letter in
//    the cipher alphabet. For example if the give String is the following text:
//          Attack at noon.
//    The function will encipher and returns the following String:
//          VLLVMA VL WEEW.

    public static String encipher(String msg) {
        String result = "";
        String key = "VJMQDSBGKYAZPWETXCNLHORFUI";
        msg = msg.toUpperCase();
        for (Character ch : msg.toCharArray()) {
            if (Character.isLetter(ch))
                result += key.charAt(ch - 'A');
            else
                result += ch;
        }
        return result;
    }

    public static void checkOutput() {

    }


    public static void main(String[] args) {
        System.out.println(reverse(1234));
        System.out.println();
        System.out.println(encipher("Attack at noon."));
        System.out.println();
        checkOutput();
    }



}
