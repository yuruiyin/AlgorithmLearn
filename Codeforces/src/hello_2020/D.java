package hello_2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class D {

    private static final int MOD = (int) (1e9 + 7);

    private static BufferedReader br;
    private static StringTokenizer tokenizer;

    static class Data {
        int sa;
        int ea;
        int sb;
        int eb;
        Data(int sa, int ea, int sb, int eb) {
            this.sa = sa;
            this.ea = ea;
            this.sb = sb;
            this.eb = eb;
        }
    }

    static class Start {
        int index;
        int val;
        Start(int index, int val) {
            this.index = index;
            this.val = val;
        }
    }

    static class StartCmp implements Comparator<Start> {
        @Override
        public int compare(Start o1, Start o2) {
            return o1.val - o2.val;
        }
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int n = nextInt();

        Data[] datas = new Data[n];
        Start[] aStartArr = new Start[n];
        Start[] bStartArr = new Start[n];
        for (int i = 0; i < n; i++) {
            int sa = nextInt();
            int ea = nextInt();
            int sb = nextInt();
            int eb = nextInt();
            datas[i] = new Data(sa, ea, sb, eb);
            aStartArr[i] = new Start(i, sa);
            bStartArr[i] = new Start(i, sb);;
        }

        Arrays.sort(aStartArr, new StartCmp());
        Arrays.sort(bStartArr, new StartCmp());

        long[] aSuffixSumArr = new long[n];
        long[] bSuffixSumArr = new long[n];
        int[] aSuffixXorArr = new int[n];
        int[] bSuffixXorArr = new int[n];
        int[] aSuffixAndArr = new int[n];
        int[] bSuffixAndArr = new int[n];
        int[] aSuffixOrArr = new int[n];
        int[] bSuffixOrArr = new int[n];
        long[] aSuffixMultiArr = new long[n];
        long[] bSuffixMultiArr = new long[n];

        aSuffixSumArr[n-1] = aStartArr[n-1].index;
        bSuffixSumArr[n-1] = bStartArr[n-1].index;
        aSuffixXorArr[n-1] = aStartArr[n-1].index;
        bSuffixXorArr[n-1] = bStartArr[n-1].index;
        for (int i = n - 2; i >= 0; i--) {
            aSuffixSumArr[i] = aSuffixSumArr[i+1] + aStartArr[i].index;
            bSuffixSumArr[i] = bSuffixSumArr[i+1] + bStartArr[i].index;
            aSuffixXorArr[i] = aSuffixXorArr[i+1] ^ aStartArr[i].index;
            bSuffixXorArr[i] = bSuffixXorArr[i+1] ^ bStartArr[i].index;
            aSuffixAndArr[i] = aSuffixAndArr[i+1] & aStartArr[i].index;
            bSuffixAndArr[i] = bSuffixAndArr[i+1] & bStartArr[i].index;
            aSuffixOrArr[i] = aSuffixOrArr[i+1] | aStartArr[i].index;
            bSuffixOrArr[i] = bSuffixOrArr[i+1] | bStartArr[i].index;
        }

        for (int i = 0; i < n; i++) {
            int ea = datas[i].ea;
            int eb = datas[i].eb;
            int firstBiggerIndex1 = findBigger(aStartArr, ea);
            int firstBiggerIndex2 = findBigger(bStartArr, eb);
            if (firstBiggerIndex1 != firstBiggerIndex2) {
                System.out.println("NO");
                return;
            }

            int index = firstBiggerIndex1;

            if (index == -1) {
                continue;
            }

            if (aSuffixSumArr[index] != bSuffixSumArr[index]) {
                System.out.println("NO");
                return;
            }

//
//            // 比较大于的list是否一致
//            Set<Integer> indexSet = new HashSet<>();
//            for (int j = index; j < n; j++) {
//                indexSet.add(aStartArr[j].index);
//            }
//
//            for (int j = index; j < n; j++) {
//                if (!indexSet.contains(bStartArr[j].index)) {
//                    System.out.println("NO");
//                    return;
//                }
//            }
        }
        
        System.out.println("YES");
    }

    private static int findBigger(Start[] arr, int target) {
        int size = arr.length;
        int low = 0;
        int high = size - 1;
        while (low <= high) {
            int mid = (low +high) >>> 1;
            int midVal = arr[mid].val;
            if (midVal > target) {
                if (mid == 0 || arr[mid - 1].val <= target) {
                    return mid;
                }

                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    public static String next() throws IOException {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            String line = br.readLine();
            if (line == null)
                throw new IOException();
            tokenizer = new StringTokenizer(line);
        }
        return tokenizer.nextToken();
    }

    public static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    public static long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    public static double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }

}
