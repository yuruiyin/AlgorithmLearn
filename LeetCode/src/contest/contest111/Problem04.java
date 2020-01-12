package contest.contest111;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Problem04 {

    private String[] arr;
    private int len;
    private int[][] commonLenArr;
    private PriorityQueue<Data>[] maxCommonListArr;

    class Data {
        int index;
        int commonLen;
        Data(int index, int commonLen) {
            this.index = index;
            this.commonLen = commonLen;
        }
    }

    private int getCommonLen(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
//        int minLen = Math.min(len1, len2);

        for (int i = 0; i < len1; i++) {
            if (str1.charAt(i) == str2.charAt(0) && len1 - i <= len2) {
                if (str1.substring(i).equals(str2.substring(0, len1 - i))) {
                    return len1 - i;
                }
            }
        }

        return 0;
    }

    private String backTrack(int from, StringBuilder tmpSb, int size, boolean[] visited) {
        if (size == len) {
            return tmpSb.toString();
        }

        int min = Integer.MAX_VALUE;
        String minLenStr = null;
        visited[from] = true;

        while (!maxCommonListArr[from].isEmpty()) {
            Data nextData = maxCommonListArr[from].poll();
            int next = nextData.index;
            if (visited[nextData.index]) {
                continue;
            }

            int fromIndex = commonLenArr[from][next];
            tmpSb.append(arr[next].substring(fromIndex));
            String resStr = backTrack(next, tmpSb, size + 1, visited);
            int removedLen = arr[next].length() - fromIndex;
            tmpSb.delete(tmpSb.length() - removedLen, tmpSb.length());
            if (resStr.length() < min) {
                min = resStr.length();
                minLenStr = resStr;
            }

            break;
        }

        visited[from] = false;
        return minLenStr;
    }

    public String shortestSuperstring(String[] arr) {
        this.len = arr.length;
        this.arr = arr;
        commonLenArr = new int[len][len];
        maxCommonListArr = new PriorityQueue[len];

        for (int i = 0; i < len; i++) {
            maxCommonListArr[i] = new PriorityQueue<>(new Comparator<Data>() {
                @Override
                public int compare(Data o1, Data o2) {
                    return o2.commonLen - o1.commonLen;
                }
            });
            for (int j = 0; j < len; j++) {
                if (i == j) {
                    continue;
                }

                commonLenArr[i][j] = getCommonLen(arr[i], arr[j]);
                Data data = new Data(j, commonLenArr[i][j]);
                maxCommonListArr[i].offer(data);
            }
        }

        int min = Integer.MAX_VALUE;
        String minLenStr = null;
        PriorityQueue<Data>[] oldPQ = new PriorityQueue[len];
        for (int i = 0; i < len; i++) {
            oldPQ[i] = new PriorityQueue<>(maxCommonListArr[i]);
        }

        for (int i = 0; i < len; i++) {
            maxCommonListArr[i] = oldPQ[i];
            String resStr = backTrack(i, new StringBuilder(arr[i]), 1, new boolean[len]);
            if (resStr.length() < min) {
                min = resStr.length();
                minLenStr = resStr;
            }
        }

        return minLenStr;
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem04().shortestSuperstring(new String[]{"alex","loves","leetcode"}));
    }

}
