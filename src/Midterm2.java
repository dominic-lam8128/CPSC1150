import java.util.Arrays;

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

    public static void main(String[] args) {
        question1();
    }
}
