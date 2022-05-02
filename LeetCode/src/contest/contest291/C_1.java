package contest.contest291;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class C_1 {

    // 双hash
    static class StrHash {

        private static final long MOD = (int) (1e9 + 7);
        private long[] hash;
        private long[] power;
        private char[] arr;
        private long P;

        public StrHash(char[] arr, long P) {
            this.arr = arr;
            int len = arr.length;
            hash = new long[len];
            power = new long[len];
            this.P = P;
            calcHashAndPower();
        }

        private void calcHashAndPower() {
            hash[0] = arr[0];
            power[0] = 1;
            for (int i = 1; i < arr.length; i++) {
                hash[i] = (hash[i - 1] * P + arr[i]) % MOD;
                power[i] = (power[i - 1] * P) % MOD;
            }
        }

        private long getSubStrHash(int l, int r) {
            if (l == 0) {
                return hash[r];
            }
            return ((hash[r] - power[r - l + 1] * hash[l - 1]) % MOD + MOD) % MOD;
        }

    }

    private int[] arrIndex2StrIndex;

    private char[] numArrToCharArr(int[] arr) {
        arrIndex2StrIndex = new int[arr.length];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            arrIndex2StrIndex[i] = sb.length();
            sb.append(num).append("_");
        }
        return sb.toString().toCharArray();
    }

    public int countDistinct(int[] nums, int k, int p) {
        List<Integer> indexList = new ArrayList<>();
        int len = nums.length;

        char[] charArr = numArrToCharArr(nums);
        StrHash strHash1 = new StrHash(charArr, 805306457);
        StrHash strHash2 = new StrHash(charArr, 2333);

        Set<Long> set = new HashSet<>();
        for (int i = 0; i < len; i++) {
            if (nums[i] % p == 0) {
                indexList.add(i);
            }
            int size = indexList.size();
            int leftIdx = size - k - 1 < 0 ? 0 : indexList.get(size - k - 1) + 1;
            int curCharIdx = arrIndex2StrIndex[i] + String.valueOf(nums[i]).length() - 1;
            for (int j = i; j >= leftIdx; j--) {
                int leftCharIdx = arrIndex2StrIndex[j];
                long hash1 = strHash1.getSubStrHash(leftCharIdx, curCharIdx);
                long hash2 = strHash2.getSubStrHash(leftCharIdx, curCharIdx);
                set.add((hash1 << 32) | hash2);
            }
        }
        return set.size();
    }

    public static void main(String[] args) {
        System.out.println(new C_1().countDistinct(new int[]{2, 3, 3, 2, 2}, 2, 2));
        System.out.println("hello world");
    }

}
