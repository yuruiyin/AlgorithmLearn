package practice057;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class D {

    private static BufferedReader br;
    private static StringTokenizer tokenizer;


    // 中心扩散法，遍历每个索引，从这个索引向两边扩散，看最多能匹配多少字符。
    public static int[] longestPalindrome(char[] arr, int start, int end) {
        int maxLen = 1;
        int maxStart = start;

        int maxIndex = end - (maxLen+1) / 2;

        for (int mid = start; mid < maxIndex; mid++) {
            // 中心扩散法
            // 先寻找从mid开始连续相同的字符，当成回文串的中间部分字符
            int left = mid;
            int right = mid;
            while (right < end - 1 && arr[right + 1] == arr[left]) {
                right++;
            }

            mid = right; // 下次直接跳过当前连续的字符
            int len = right - left + 1;
            while ((--left) >= start && (++right) < end) {
                if (arr[left] != arr[right]) {
                    break;
                }
                len += 2;
            }

            if (len > maxLen) {
                maxStart = left;
                maxLen = len;
                maxIndex = end - (maxLen+1) / 2;
            }
        }

        return new int[]{maxLen, maxStart};
    }

    private static int findLastSmaller(List<Integer> numList, int target) {
        int low = 0;
        int size = numList.size();
        int high = size - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = numList.get(mid);

            if (midVal <= target) {
                if (mid == size - 1 || target < numList.get(mid + 1)) {
                    // 找到最后一个比他小的
                    return mid;
                }

                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    private static void solve() throws IOException {
        String s = next();
        char[] arr = s.toCharArray();
        int len = arr.length;
        long ansMax = 0;

        List<Integer>[] indexListArr = new ArrayList[26];
        for (int i = 0; i < len; i++) {
            char c = arr[i];
            if (indexListArr[c - 'a'] == null) {
                indexListArr[c - 'a'] = new ArrayList<>();
            }
            indexListArr[c - 'a'].add(i);
        }

        int leftMaxLen = longestPalindrome(arr, 0, 1)[0];
        int[] rightMaxRes = longestPalindrome(arr, 1, len);
        int rightMaxLen = rightMaxRes[0];
        int rightMaxStart = rightMaxRes[1];
        ansMax = leftMaxLen + rightMaxLen;

        for (int i = 1; i < len - 1; i++) {
            char c = arr[i];
            List<Integer> indexList = indexListArr[c - 'a'];
            int lastSmallerIndex = findLastSmaller(indexList, i - leftMaxLen);
            if (lastSmallerIndex == -1) {
                continue;
            }

            int curLen = -1;
            for (int j = 0; j <= lastSmallerIndex; j++) {
                int left = indexList.get(j);
                int right = i;
                boolean isFound = true;
                while (left <= right) {
                    if (arr[left] != arr[right]) {
                        isFound = false;
                        break;
                    }
                    left++;
                    right--;
                }

                if (isFound) {
                    curLen = Math.max(curLen, i - indexList.get(j) + 1);
                }
            }

            if (curLen <= leftMaxLen) {
                continue;
            }

            leftMaxLen = curLen;
            if (rightMaxStart == i) {
                rightMaxRes = longestPalindrome(arr, i + 1, len);
                rightMaxLen = rightMaxRes[0];
                rightMaxStart = rightMaxRes[1];
            }
            ansMax = Math.max(ansMax, leftMaxLen + rightMaxLen);
        }

        System.out.println(ansMax);
    }


    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        solve();
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
