package holiday_33;

import java.io.*;
import java.util.*;

public class I {
    
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task task = new Task();
        task.solve(1, in, out);
//        task.createInput();
        out.close();
    }

    static class Task {

        private void createInput() {
            int NUM = 500;
            // 创建密码
            char[] arr = new char[54];
            for (int i = 0; i < 26; i++) {
                arr[i] = (char) ('a' + i);
            }

            for (int i = 26; i < 54; i++) {
                arr[i] = '?';
            }

            String pwd = "";
            StringBuilder pwdSb = new StringBuilder();
            Random random = new Random();
            for (int i = 0; i < NUM; i++) {
                int index = random.nextInt(54);
                pwdSb.append(arr[index]);
            }

            pwd = pwdSb.toString();

            System.out.println(pwd);

            // 创建字典
            String[] dict = new String[NUM];
            for (int i = 0; i < NUM; i++) {
                int count = random.nextInt(20) + 1;
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < count; j++) {
                    int index = random.nextInt(26);
                    sb.append((char)(index + 'a'));
                }
                dict[i] = sb.toString();
            }

            for (int i = 0; i < NUM; i++) {
                System.out.println(dict[i]);
            }
        }

        private boolean isMatch(String str, int from, String word) {
            int len = word.length();
            for (int i = 0; i < len; i++) {
                if (i + from >= str.length()) {
                    return false;
                }

                char c = str.charAt(i + from);
                if (c != '?' && c != word.charAt(i)) {
                    return false;
                }
            }
            return true;
        }

        private String pwd;
        private int l;
        private List<String>[] dict;
        private String[] memo;
        private int maxWordLen;

        private String rec(int from) {
            if (from == l) {
                return "";
            }

            if (memo[from] != null) {
                return memo[from];
            }

            List<String> list = new ArrayList<>();
            int end = Math.min(l - from, maxWordLen);
            for (int j = 1; j <= end; j++) {
                if (dict[j] == null) {
                    continue;
                }

                for (String word : dict[j]) {
                    if (isMatch(pwd, from, word)) {
                        String nextMin = rec(from + j);
                        if (nextMin.equals("?")) {
                            // 失败
                            break;
                        }

                        list.add(word + nextMin);
                        break;
                    }
                }
            }

            if (list.isEmpty()) {
                memo[from] = "?";
                return memo[from];
            }

            // 求字典序最小的返回
            String ansMin = list.get(0);
            int size = list.size();
            for (int i = 1; i < size; i++) {
                if (list.get(i).compareTo(ansMin) < 0) {
                    ansMin = list.get(i);
                }
            }

            memo[from] = ansMin;
            return ansMin;
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            this.l = in.nextInt();
            int nw = in.nextInt();
            this.pwd = in.next();
            dict = new ArrayList[21];  // 根据字典中的单词长度进行分裂
            for (int i = 0; i < nw; i++) {
                String word = in.next();
                int len = word.length();
                maxWordLen = Math.max(maxWordLen, len);
                if (dict[len] == null) {
                    dict[len] = new ArrayList<>();
                }
                dict[len].add(word);
            }

            for (int i = 1; i <= maxWordLen; i++) {
                if (dict[i] != null) {
                    Collections.sort(dict[i]);  // 同一长度下的单词进行排序
                }
            }

            memo = new String[l];
            out.println(rec((0)));
        }
    }

    static class InputReader {

        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

    }

}
