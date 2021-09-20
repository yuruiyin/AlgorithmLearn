package contest.contest250;

import java.util.Set;

/**
 * A
 *
 * @author: yry
 * @date: 2021/7/18
 */
public class A {

    public int canBeTypedWords(String text, String brokenLetters) {
        String[] arr = text.split(" ");
        int ans = 0;
        boolean[] visited = new boolean[26];
        for (char c : brokenLetters.toCharArray()) {
            visited[c - 'a'] = true;
        }

        for (String str : arr) {
            boolean isOk = true;
            for (char c : str.toCharArray()) {
                if (visited[c - 'a']) {
                    isOk = false;
                    break;
                }
            }
            if (isOk) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("hello");
    }

}
