package lcci;

public class Lcci0807 {

    private char[] arr;
    private int len;
    private int index = 0;

    private void backTrack(String[] ansArr, boolean[] visited, StringBuilder tmpSb) {
        if (tmpSb.length() == len) {
            ansArr[index++] = tmpSb.toString();
            return;
        }

        for (int i = 0; i < len; i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            tmpSb.append(arr[i]);
            backTrack(ansArr, visited, tmpSb);
            tmpSb.deleteCharAt(tmpSb.length() - 1);
            visited[i] = false;
        }
    }

    private int factorial(int n) {
        int ans = 1;
        for (int i = 2; i <= n; i++) {
            ans *= i;
        }
        return ans;
    }

    public String[] permutation(String str) {
        arr = str.toCharArray();
        len = arr.length;
        String[] ansArr = new String[factorial(len)];
        backTrack(ansArr, new boolean[len], new StringBuilder());
        return ansArr;
    }

}
