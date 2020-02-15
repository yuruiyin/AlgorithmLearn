package lcof;

public class Lcof048 {

    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int left = 0;
        char[] arr = s.toCharArray();
        int len = arr.length;
        boolean[] visited = new boolean[128];
        visited[arr[0]] = true;
        int ansMax = 1;
        int right;
        for (right = 1; right < len; right++) {
            char curChar = arr[right];
            if (visited[curChar]) {
                ansMax = Math.max(ansMax, right - left);
                while (arr[left] != curChar) {
                    visited[arr[left]] = false;
                    left++;
                }

                left++;
                continue;
            }

            visited[curChar] = true;
        }

        ansMax = Math.max(ansMax, right - left);
        return ansMax;
    }

}
