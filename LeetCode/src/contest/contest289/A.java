package contest.contest289;

import java.util.ArrayList;
import java.util.List;

public class A {

    public String digitSum(String s, int k) {
        while (s.length() > k) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i += k) {
                String str = s.substring(i, Math.min(i + k, s.length()));
                int sum = 0;
                for (char c : str.toCharArray()) {
                    sum += c - '0';
                }
                sb.append(sum);
            }
            s = sb.toString();
        }
        return s;
    }

    public static void main(String[] args) {
        System.out.println("hello");
    }

}
