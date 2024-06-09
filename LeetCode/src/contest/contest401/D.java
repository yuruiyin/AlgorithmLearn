package contest.contest401;

import java.util.*;

public class D {

    public int maxTotalReward(int[] arr) {
        Arrays.sort(arr);
        int maxNum = 0;
        for (int num : arr) {
            maxNum = Math.max(maxNum, num);
        }
        TreeSet<Integer> set = new TreeSet<>();
        int len = arr.length;
        int[] nextBiggerIdxArr = new int[len];
        int preIdx = 0;
        for (int i = 1; i < len; i++) {
            if (arr[i] > arr[i - 1]) {
                nextBiggerIdxArr[preIdx] = i;
                preIdx = i;
            }
        }
        nextBiggerIdxArr[preIdx] = len;
        int ansMax = 0;
        for (int i = 0; i < len;) {
            int num = arr[i];
            // 选 or 不选
            Integer lower = set.lower(num);
            if (lower != null) {
                TreeSet<Integer> subSet = (TreeSet<Integer>) set.subSet(set.first(), true, lower, true);
                Set<Integer> tmpSet = new HashSet<>();
                for (int tmpNum : subSet) {
                    int newValue = tmpNum + num;
                    if (newValue >= maxNum) {
                        ansMax = Math.max(ansMax, newValue);
                        continue;
                    }
                    tmpSet.add(newValue);
                }
                set.addAll(tmpSet);
            }

            set.add(num);
            i = nextBiggerIdxArr[i];
        }

        return Math.max(ansMax, set.isEmpty() ? 0 : set.last());
    }

    private static int[] createArr() {
        int[] arr = new int[50000];
        Arrays.fill(arr, 1);
        return arr;
    }

    private static int[] createArr1() {
        int[] arr = new int[50000];
        for (int i = 0; i < 50000; i++) {
            arr[i] = i + 1;
        }
        return arr;
    }

    public static void main(String[] args) {
//        System.out.println(new D().maxTotalReward(new int[]{
//                1, 14, 13, 19
//        }));
        System.out.println(new D().maxTotalReward(createArr1()));
    }


}
