import java.util.Arrays;

public class FinalAPIDemo {

    public static void stringClassAPIDemo() {
        String str = "Hello";
        System.out.println("a".compareTo("b"));
        System.out.println("aa".compareTo("b"));
        System.out.println("Hello".concat("World"));
        System.out.println("Hello"+"World");
        System.out.println(str.indexOf('e'));
        System.out.println(str.lastIndexOf('l'));
        System.out.println(str.indexOf("ll"));
        char[] list = "Hello".toCharArray();
        System.out.println(Arrays.toString(list));
        System.out.println("Hello".substring(0,3)); //hel
    }

    public static void main(String[] args) {
        stringClassAPIDemo();
        System.out.println('A' + "B");


    }
}
