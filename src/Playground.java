public class Playground {



    public static int mySqrt(int x) {
        System.out.println(x);
        long temp = x;
        while (temp*temp > x) {
            temp = temp/2;
        }


        int i = (int)temp;
        while (i*i <= x && i<46341){
            i++;

        }
        return i-1;
    }

    public static void main(String[] args) {
//        int x = (byte)-400;
//        System.out.println(x);
//
//        x = (byte)400;
//        System.out.println(x);

        System.out.println(mySqrt(2147395600));
//        System.out.println(46340*46340 + ", " + 46341*46341);
    }
}
