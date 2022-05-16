package round791_div2;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class C {

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

        private int totalCount = 0;

        public SegmentTree(int min, int max) {
            root = build(min, max);
        }

        public int getTotalCount() {
            return totalCount;
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
            totalCount++;
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
            totalCount--;
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

        public int findBiggerOrEqualCount(int target) {
            Node cur = root;
            if (target <= cur.start) {
                return cur.count;
            }

            if (target > cur.end) {
                return 0;
            }

            int ansCount = 0;
            while (cur != null) {
                int mid = (cur.start + cur.end) >>> 1L;
                if (target <= mid + 1) {
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

        public int findSmallerOrEqualCount(int target) {
            Node cur = root;
            if (target >= cur.end) {
                return cur.count;
            }

            if (target < cur.start) {
                return 0;
            }

            int ansCount = 0;
            while (cur != null) {
                int mid = (cur.start + cur.end) >>> 1L;
                if (target < mid) {
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

    // 注意不要用Arrays.sort()
    // 注意Math.pow可能导致精度问题
    // 注意int溢出问题
    static class Task {

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int q = in.nextInt();
            Map<Integer, Integer> xCountMap = new HashMap<>();
            Map<Integer, Integer> yCountMap = new HashMap<>();
            SegmentTree xSegmentTree = new SegmentTree(1, n);
            SegmentTree ySegmentTree = new SegmentTree(1, n);
            while ((q--) > 0) {
                int t = in.nextInt();
                if (t == 1) {
                    int addPosX = in.nextInt();
                    int addPosY = in.nextInt();
                    xCountMap.put(addPosX, xCountMap.getOrDefault(addPosX, 0) + 1);
                    yCountMap.put(addPosY, yCountMap.getOrDefault(addPosY, 0) + 1);
                    if (xCountMap.get(addPosX) == 1) {
                        xSegmentTree.insert(addPosX);
                    }
                    if (yCountMap.get(addPosY) == 1) {
                        ySegmentTree.insert(addPosY);
                    }
                } else if (t == 2) {
                    int removePosX = in.nextInt();
                    int removePosY = in.nextInt();
                    int oldXCount = xCountMap.getOrDefault(removePosX, 0);
                    if (oldXCount > 0) {
                        xCountMap.put(removePosX, oldXCount - 1);
                        if (oldXCount == 1) {
                            xSegmentTree.remove(removePosX);
                        }
                    }
                    int oldYCount = yCountMap.getOrDefault(removePosY, 0);
                    if (oldYCount > 0) {
                        yCountMap.put(removePosY, oldYCount - 1);
                        if (oldYCount == 1) {
                            ySegmentTree.remove(removePosY);
                        }
                    }
                } else {
                    // 输入矩形，判断是否被车覆盖
                    int x1 = in.nextInt();
                    int y1 = in.nextInt();
                    int x2 = in.nextInt();
                    int y2 = in.nextInt();
                    int xSmallerCount = xSegmentTree.findSmallerCount(x1);
                    int xBiggerCount = xSegmentTree.findBiggerCount(x2);
                    int xCount = xSegmentTree.getTotalCount() - xSmallerCount - xBiggerCount;
                    if (xCount == x2 - x1 + 1) {
                        out.println("Yes");
                        continue;
                    }
                    int ySmallerCount = ySegmentTree.findSmallerCount(y1);
                    int yBiggerCount = ySegmentTree.findBiggerCount(y2);
                    int yCount = ySegmentTree.getTotalCount() - ySmallerCount - yBiggerCount;
                    out.println(yCount == (y2 - y1 + 1) ? "Yes" : "No");
                }
            }
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
