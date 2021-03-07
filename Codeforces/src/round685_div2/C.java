package round685_div2;

import java.io.*;
import java.util.*;

public class C {

    // 注意不要用Arrays.sort()
    // 注意Math.pow可能导致精度问题
    // 注意int溢出问题
    static class Task {

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int t = in.nextInt();
            while ((t--) > 0) {
                int n = in.nextInt();
                int k = in.nextInt();
                char[] arr1 = in.next().toCharArray();
                char[] arr2 = in.next().toCharArray();

                // 先去除重复的
                int[] countArr1 = new int[26];
                for (int i = 0; i < n; i++) {
                    countArr1[arr1[i] - 'a']++;
                }

                List<Character> list2 = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    if (countArr1[arr2[i] - 'a'] > 0) {
                        countArr1[arr2[i] - 'a']--;
                        continue;
                    }

                    list2.add(arr2[i]);
                }

                Collections.sort(list2);

                List<Character> list1 = new ArrayList<>();
                for (int i = 0; i < 26; i++) {
                    int count = countArr1[i];
                    while ((count--) > 0) {
                        list1.add((char) (i + 'a'));
                    }
                }

                boolean isOk = true;
                int size = list1.size();
                for (int i = 0; i < size; i++) {
                    if (list1.get(i) == list2.get(i)) {
                        continue;
                    }

                    if (list1.get(i) > list2.get(i)) {
                        isOk = false;
                        break;
                    }

                    if (i + k > size) {
                        for (int j = i; j < size; j++) {
                            if (list1.get(j) != list2.get(j)) {
                                isOk = false;
                                break;
                            }
                        }
                        if (!isOk) {
                            break;
                        }
                    }

                    for (int j = i + 1; j < i + k && j < size; j++) {
                        if (list1.get(j) != list1.get(j - 1) || list2.get(j) != list2.get(j - 1)) {
                            isOk = false;
                            break;
                        }
                    }

                    if (!isOk) {
                        break;
                    }

                    i += k - 1;
                }

                out.println(isOk ? "Yes" : "No");
            }
        }
    }

    private static void sort(char[] arr) {
        Character[] objArr = new Character[arr.length];
        for (int i = 0; i < arr.length; i++) {
            objArr[i] = arr[i];
        }
        Arrays.sort(objArr);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = objArr[i];
        }
    }

    private static void sort(double[] arr) {
        Double[] objArr = Arrays.stream(arr).boxed().toArray(Double[]::new);
        Arrays.sort(objArr);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = objArr[i];
        }
    }

    private static void sortDesc(double[] arr) {
        Double[] objArr = Arrays.stream(arr).boxed().toArray(Double[]::new);
        Arrays.sort(objArr);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = objArr[arr.length - i - 1];
        }
    }

    private static void sort(int[] arr) {
        Integer[] objArr = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(objArr);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = objArr[i];
        }
    }

    private static void sortDesc(int[] arr) {
        Integer[] objArr = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(objArr);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = objArr[arr.length - i - 1];
        }
    }

    private static void sort(long[] arr) {
        Long[] objArr = Arrays.stream(arr).boxed().toArray(Long[]::new);
        Arrays.sort(objArr);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = objArr[i];
        }
    }

    private static void sortDesc(long[] arr) {
        Long[] objArr = Arrays.stream(arr).boxed().toArray(Long[]::new);
        Arrays.sort(objArr);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = objArr[arr.length - i - 1];
        }
    }

    private static void solve() {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task task = new Task();
        task.solve(1, in, out);
        out.close();
    }

    public static void main(String[] args) {
        new Thread(null, () -> solve(), "1", 1 << 26).start();
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
