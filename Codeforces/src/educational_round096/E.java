package educational_round096;

import java.io.*;
import java.util.*;

public class E {

    // 注意不要用Arrays.sort()
    // 注意Math.pow可能导致精度问题
    // 注意int溢出问题
    static class Task {

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            char[] arr = in.next().toCharArray();
            LinkedList<Integer>[] indexListArr = new LinkedList[26];
            for (int i = 0; i < n; i++) {
                char c = arr[i];
                if (indexListArr[c - 'a'] == null) {
                    indexListArr[c - 'a'] = new LinkedList<>();
                }
                indexListArr[c - 'a'].add(i);
            }

            char[] reverseArr = new char[n];
            for (int i = 0; i < n; i++) {
                reverseArr[i] = arr[n - i - 1];
            }

            int cur = 0;
            SegmentTree segmentTree = new SegmentTree(0, n - 1);
            boolean[] removed = new boolean[n];
            long ans = 0;
            for (int i = 0; i < n; i++) {
                while (removed[cur]) {
                    cur++;
                }
                LinkedList<Integer> indexList = indexListArr[reverseArr[i] - 'a'];
                int index = indexList.poll();
                removed[index] = true;
                segmentTree.insert(index);
                if (reverseArr[i] == arr[cur]) {
                    cur++;
                    continue;
                }

                int smallerCount1 = segmentTree.findSmallerCount(index);
                int smallerCount2 = segmentTree.findSmallerCount(cur);
                ans += (index - cur - smallerCount1 + smallerCount2);
            }

            out.println(ans);
        }
    }

    static class SegmentTree {
        class Node {
            int start;
            int end;
            int count; //当前区间有多少个
            Node left;
            Node right;
            Node(int start, int end) {
                this.start = start;
                this.end = end;
            }
        }

        private Node root;

        public SegmentTree(int min, int max) {
            root = build(min, max);
        }

        private Node build(int min, int max) {
            Node root = new Node(min, max);
            if (min == max) {
                return root;
            }

            int mid = (min + max) >>> 1L;
            root.left = build(min, mid);
            root.right = build(mid + 1, max);
            return root;
        }

        public void insert(int val) {
            Node cur = root;
            while (cur != null) {
                int mid = (cur.start + cur.end) >>> 1;
                cur.count++;
                if (val <= mid) {
                    cur = cur.left;
                } else {
                    cur = cur.right;
                }
            }
        }

        public void remove(int val) {
            Node cur = root;
            while (cur != null) {
                int mid = (cur.start + cur.end) >>> 1;
                cur.count--;
                if (val <= mid) {
                    cur = cur.left;
                } else {
                    cur = cur.right;
                }
            }
        }

        public int findBiggerCount(int target) {
            Node cur = root;
            if (target < cur.start) {
                return cur.count;
            }

            if (target >= cur.end) {
                return 0;
            }

            int ansCount = 0;
            while (cur != null) {
                int mid = (cur.start + cur.end) >>> 1L;
                if (target <= mid) {
                    if (cur.right != null) {
                        ansCount += cur.right.count;
                    }
                    cur = cur.left;
                } else {
                    cur = cur.right;
                }
            }

            return ansCount;
        }

        public int findSmallerCount(int target) {
            Node cur = root;
            if (target > cur.end) {
                return cur.count;
            }

            if (target <= cur.start) {
                return 0;
            }

            int ansCount = 0;
            while (cur != null) {
                int mid = (cur.start + cur.end) >>> 1L;
                if (target <= mid) {
                    cur = cur.left;
                } else {
                    if (cur.left != null) {
                        ansCount += cur.left.count;
                    }
                    cur = cur.right;
                }
            }

            return ansCount;
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
