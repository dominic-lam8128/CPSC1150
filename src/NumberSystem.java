public class NumberSystem {
    /**
     * Conversions between Binary, Octal, Decimal, Hexadecimal
     * @param
     */


    /**
     * Separator Binary <-> Dec
     * <ul>
     *     <li>Decimal to Binary</li>
     *     <li>Binary to Decimal</li>
     * </ul>
     * @param num
     * @return
     */
    public static String decToBin(int num) {
        String result = "";
        while (num > 0) {
            result = num%2 + result;
            num /= 2;
        }
        return result;
    }

    public static int binToDec(String bin) {
        int result = 0;
        for (char ch:bin.toCharArray()) {
            result *= 2;
            result += ch-'0';
        }
        return result;
    }

    public static int binToDecV2(String bin) {
        int result = 0;
        for (int i = 0; i < bin.length(); i++) {
            result += (bin.charAt(i) - '0')*(int)Math.pow(2,bin.length()- 1 - i);
        }
        return result;
    }


    public static void decToBinTest() {
        for (int i = 0; i < 20; i++) {
            int randomNumber = (int)(Math.random()*1001);
            String bin = decToBin(randomNumber);
            System.out.printf("%d: %d in binary %s, %b\n", i+1, randomNumber, bin, randomNumber == binToDecV2(bin));
        }
    }

    /**
     * Separator Oct <-> Dec
     *
     *
     */

    public static String decToOct(int num) {
        String result = "";

        while (num > 0) {
            result = num%8 + result;
            num /= 8;
        }
        return result;
    }

    public static int octToDec(String oct) {
        int result = 0;
        for (char ch:oct.toCharArray()) {
            result *= 8;
            result += ch - '0';
        }
        return result;
    }

    public static int octToDecV2(String oct) {
        int result = 0;

        for (int i = 0; i < oct.length(); i++) {
            result += (oct.charAt(i) - '0')*(int)(Math.pow(8, oct.length()-i-1));
        }

        return result;
    }


    public static void decToOCTTest() {
        for (int i = 0; i < 20; i++) {
            int randomNumber = (int)(Math.random()*1001);
            String oct = decToOct(randomNumber);
            System.out.printf("%d: %d in octal %s, %b\n", i+1, randomNumber, oct, randomNumber == octToDecV2(oct));
        }
    }


    /**
     * Separator Hexa <-> Dec
     *
     *
     */

    public static String getHexaCharacter(int digit) {
        if (digit < 10) {
            return digit +"";
        }
        return (char)(digit - 10 + 'A') + "";
    }

    public static String decToHex(int num) {
        String result = "";

        while (num > 0) {
            result = getHexaCharacter(num%16) + result;
            num/=16;
        }

        return result;
    }

    public static int hexDigitToDec(char hexCh) {
        if (Character.isDigit(hexCh))
            return hexCh - '0';
        else
            return hexCh - 'A' + 10;
    }

    public static int hexToDec(String hex) {
        int result = 0;
        for (int i = 0; i < hex.length(); i++) {
            result += hexDigitToDec(hex.charAt(i)) * (int)(Math.pow(16, hex.length() - 1 -i));
        }
        return result;
    }

    public static void decToHexTest() {
        for (int i = 0; i < 20; i++) {
            int randomNumber = (int)(Math.random()*1001);
            String hex = decToHex(randomNumber);
            System.out.printf("%d: %d in hexadecimal %s, %b\n", i+1, randomNumber, hex, randomNumber == hexToDec(hex));
        }
    }


    public static void main(String[] args) {
//        System.out.println(decToBin(11));
//        decToBinTest();
//        decToOCTTest();
        decToHexTest();
    }
}
