package contest.contest321;

public class B {

    private int getAns(char[] arr, char[] subArr) {
        int len = arr.length;
        int subLen = subArr.length;
        int j = 0;
        for (int i = 0; i < len && j < subLen; ) {
            if (arr[i] == subArr[j]) {
                i++;
                j++;
            } else {
                i++;
            }
        }

        return subLen - j;
    }

    public int appendCharacters(String s, String t) {
        return getAns(s.toCharArray(), t.toCharArray());
    }

    public static void main(String[] args) {
//        "vrykt"
//        "rkge"
        System.out.println(new B().appendCharacters("vrykt", "rkge"));
    }

}
