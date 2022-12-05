public class SampleFinal {


    public static void programQ1() {
        char[] arr = {'A', 'B', 'C', 'D', 'E'};
//        arr = new char[] {'B', 'C', 'D', 'E'};
        String tmp;
        int i, j;
        for (i = 0; i < arr.length; i++){
            tmp = "";
            for (j = arr.length - i-1; j > 0; j--)
                tmp += '*';
            for (j = arr[arr.length-1]; j > arr[arr.length-i-1]; j--)
                tmp += (char)j;
            System.out.println(tmp);
        }
    }


    public static void main(String[] args) {
        programQ1();
    }
}
