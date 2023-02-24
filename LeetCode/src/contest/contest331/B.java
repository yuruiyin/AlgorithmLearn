package contest.contest331;

public class B {

    private boolean isIn(char c) {
        return c == 'a' || c == 'e' ||c == 'i' ||c == 'o' ||c == 'u';
    }

    private boolean isOk(String str) {
        char[] arr = str.toCharArray();
        int len = arr.length;
        return isIn(arr[0]) && isIn(arr[len - 1]);
    }

    public int[] vowelStrings(String[] words, int[][] queries) {
        int len = words.length;
        int[] preCountArr = new int[len];
        preCountArr[0] = isOk(words[0]) ? 1 : 0;
        for (int i = 1; i < len; i++) {
            preCountArr[i] = preCountArr[i - 1] + (isOk(words[i]) ? 1: 0);
        }

        int qLen = queries.length;
        int[] ansArr = new int[queries.length];
        for (int i = 0; i < qLen; i++) {
            int[] q = queries[i];
            int s = q[0];
            int e = q[1];
            ansArr[i] = preCountArr[e] - (s == 0 ? 0: preCountArr[s - 1]);
        }

        return ansArr;
    }

}
