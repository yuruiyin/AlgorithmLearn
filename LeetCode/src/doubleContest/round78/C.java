package doubleContest.round78;

import java.util.Arrays;
import java.util.Comparator;

public class C {

    private int findIdx(int[][] tiles, int from, int target) {
        int len = tiles.length;
        int l = from;
        int r = len - 1;
        while (l <= r) {
            int mid = (l + r) >>> 1;
            if (tiles[mid][0] <= target) {
                if (mid == len - 1 || tiles[mid + 1][0] > target) {
                    return mid;
                }
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }

    public int maximumWhiteTiles(int[][] tiles, int carpetLen) {
        Arrays.sort(tiles, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int len = tiles.length;
        int[] preCountArr = new int[len];
        preCountArr[0] = tiles[0][1] - tiles[0][0] + 1;
        for (int i = 1; i < len; i++) {
            preCountArr[i] = preCountArr[i - 1] + (tiles[i][1] - tiles[i][0] + 1);
        }

        int ansMax = 0;
        for (int i = 0; i < len; i++) {
            int[] tile = tiles[i];
            int l = tile[0];
            int r = tile[1];
            int from = l;
            int to = from + carpetLen - 1;
            // 二分找到to对应的区间索引
            int toIdx = findIdx(tiles, i, to);
            if (toIdx == i) {
                ansMax = Math.max(ansMax, Math.min(carpetLen, r - l  + 1));
            } else {
                int value = preCountArr[toIdx - 1] - (i == 0 ? 0 : preCountArr[i - 1]) +
                        (Math.min(to, tiles[toIdx][1]) - tiles[toIdx][0] + 1);
                ansMax = Math.max(ansMax, value);
            }
        }

        return ansMax;
    }

    public static void main(String[] args) {
        System.out.println(new C().maximumWhiteTiles(new int[][]{
                {1,5},{10,11},{12,18},{20,25},{30,32}
        }, 10));
    }

}
