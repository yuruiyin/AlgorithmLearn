package contest.contest089;

import java.util.Arrays;
import java.util.Random;

public class Problem854 {

    private int len;

    private void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private int backTrack(int from, char[] arr1, char[] arr2) {
        if (from == len) {
            return 0;
        }

        if (arr1[from] == arr2[from]) {
            return backTrack(from + 1, arr1, arr2);
        }

        int min = Integer.MAX_VALUE;
        for (int i = from + 1; i < len; i++) {
            if (arr1[i] == arr2[from] && arr1[i] != arr2[i]) {
                swap(arr1, i, from);
                int res = backTrack(from + 1, arr1, arr2);
                if (res < min) {
                    min = res;
                }
                swap(arr1, i, from);
            }
        }

        return min + 1;
    }

    // 预处理 a..b  b..a的场景，交换一次即可
    private int preProcess(char[] arr1, char[] arr2) {
        int len = arr1.length;
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (arr1[i] == arr2[i]) {
                continue;
            }

            for (int j = i + 1; j < len; j++) {
                if (arr1[j] == arr2[i] && arr1[i] == arr2[j]) {
                    swap(arr1, i, j);
                    count++;
                    break;
                }
            }
        }

        return count;
    }

    public int kSimilarity(String str1, String str2) {
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        len = arr1.length;
        int ansCount = preProcess(arr1, arr2);
        return ansCount + backTrack(0, arr1, arr2);
    }

    private static String createStr() {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < 300; i++) {
            int num = random.nextInt(6);
            sb.append((char) (num + 'a'));
        }

        return sb.toString();
    }
    
    public static void main(String[] args) {
        String str = createStr();
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        String sortedStr = new String(arr);
        
        System.out.println(new Problem854().kSimilarity(str, sortedStr));
    }

}
