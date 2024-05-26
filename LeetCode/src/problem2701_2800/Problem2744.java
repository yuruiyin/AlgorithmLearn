package problem2701_2800;

public class Problem2744 {

    public int maximumNumberOfStringPairs(String[] words) {
        int len = words.length;
        boolean[][] visited = new boolean[26][26];
        int ans = 0;
        for (String word : words) {
            int c1 = word.charAt(0) - 'a';
            int c2 = word.charAt(1) - 'a';
            if (visited[c2][c1]) {
                ans++;
            } else {
                visited[c1][c2] = true;
            }
        }
        return ans;
    }

}
