import java.util.Arrays;

public class PowerSet {
    public static int nCr(int n, int r) {
        return factorial(n)/(factorial(n-r)*factorial(r));
    }

    public static int nPr(int n, int r) {
        return factorial(n)/factorial(n-r);
    }

    public static int factorial(int n) {
        if (n <= 1)
            return 1;
        return n*factorial(n-1);
    }

    public static String[] charListToStingList(char[] list) {
        String[] result = new String[list.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = list[i] +"";
        }
        return result;
    }

    public static String[] genPermutationList(char[] list, int selectionCount) {
        if (selectionCount == 1) {
            return charListToStingList(list);
        }

        int length = nPr(list.length, selectionCount);
        String[] permutations = new String[length];
        int count = 0;
        for (String perm : genPermutationList(list, selectionCount-1)) {
            for (char ch : list) {
                if (perm.indexOf(ch) == -1) {
                    permutations[count] = perm + ch;
                    count++;
                }
            }
        }
        return permutations;
    }

    public static String sortString(String str) {
        char[] list = str.toCharArray();
        Arrays.sort(list);
        return new String(list);
    }

    public static String[] genCombinationList(char[] list, int selectionCount) {
        if (selectionCount == 0) {
            return new String[0];
        }

        int length = nCr(list.length, selectionCount);
        String[] combinations = new String[length];

        String[] permutations = genPermutationList(list, selectionCount);
        for (String perm : permutations) {
            perm = sortString(perm);
            for (int i = 0; i < combinations.length; i++) {
                if (combinations[i] == null) {
                    combinations[i] = perm;
                    break;
                } else {
                    if (combinations[i].equals(perm)) {
                        break;
                    }
                }
            }
        }

        return combinations;
    }

    public static String[][] genPowerSetForCharacters(char[] list) {
        String[][] powerSet = new String[list.length+1][];

        for (int i = 0; i < list.length+1; i++) {
            powerSet[i] = genCombinationList(list,i);
        }

        return powerSet;
    }

    public static void displayPowerSet(String[][] powerSet) {
        for (String[] list:powerSet){
            System.out.println(Arrays.toString(list));
        }
    }

    public static void main(String[] args) {
        char[] charList = new char[] {'a','b','c','d','e'};
        String[][] ps = genPowerSetForCharacters(charList);
        displayPowerSet(ps);
    }

}
