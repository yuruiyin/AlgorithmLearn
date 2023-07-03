package doubleContest.round106;

public class B {

    public int longestSemiRepetitiveSubstring(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length;
        int ansMax = 1;
        for (int i = 1; i < len; i++) {
            int sameCount = 0;
            int r = i;
            int l = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] == arr[j + 1]) {
                    if (sameCount == 1) {
                        l = j + 1;
                        break;
                    } else {
                        sameCount++;
                    }
                }
            }
            ansMax = Math.max(ansMax, r - l + 1);
        }
        return ansMax;
    }

}
