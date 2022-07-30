package contest.contest300;

import java.util.Arrays;

public class A {

    public String decodeMessage(String key, String message) {
        char[] map = new char[26];
        Arrays.fill(map, ' ');
        char cur = 'a';
        for (char c : key.toCharArray()) {
            if (c == ' ') {
                continue;
            }
            if (map[c - 'a'] == ' ') {
                map[c - 'a'] = cur;
                cur++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : message.toCharArray()) {
            if (c == ' ') {
                sb.append(c);
            } else {
                sb.append(map[c - 'a']);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("hello");
    }

}
