package contest.contest346;

public class A {

    public int minLength(String s) {
        while (true) {
            int len = s.length();
            StringBuilder sb = new StringBuilder();
            boolean[] visited = new boolean[len];
            for (int i = 0; i < len - 1; i++) {
                String sub = s.substring(i, i + 2);
                if (sub.equals("AB") || sub.equals("CD")) {
                    visited[i] = true;
                    visited[i + 1] = true;
                    i++;
                }
            }
            for (int i = 0; i < len; i++) {
                if (visited[i]) {
                    continue;
                }
                sb.append(s.charAt(i));
            }
            s = sb.toString();
            if (s.length() == len) {
                break;
            }
        }
        return s.length();
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
