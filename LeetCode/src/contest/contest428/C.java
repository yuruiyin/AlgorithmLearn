package contest.contest428;

public class C {

    static class StrHash {

        private static final long P = 805306457;
        private static final long MOD = (int) (1e9+7);
        private long[] hash;
        private long[] power;
        private char[] arr;

        public StrHash(char[] arr) {
            this.arr = arr;
            int len = arr.length;
            hash = new long[len];
            power = new long[len];
            calcHashAndPower();
        }

        private void calcHashAndPower() {
            hash[0] = arr[0];
            power[0] = 1;
            for (int i = 1; i < arr.length; i++) {
                hash[i] = (hash[i-1] * P + arr[i]) % MOD;
                power[i] = (power[i-1] * P) % MOD;
            }
        }

        private long getSubStrHash(int l, int r) {
            if (l == 0) {
                return hash[r];
            }
            return ((hash[r] - power[r-l+1] * hash[l-1]) % MOD + MOD) % MOD;
        }

    }

    private int getLen(int s, int e) {
        return e - s + 1;
    }

    public int beautifulSplits(int[] nums) {
        int len = nums.length;
        if (len < 3) {
            return 0;
        }

        StringBuilder sb = new StringBuilder();
        int[] idxMap = new int[len + 1];
        for (int i = 0; i < len; i++) {
            idxMap[i] = sb.length();
            sb.append(nums[i]).append(",");
        }
        idxMap[len] = sb.length();
        char[] arr = sb.toString().toCharArray();
        StrHash strHash = new StrHash(arr);

        int ans = 0;

        for (int start2 = 1; start2 < len - 1; start2++) {
            int len1 = getLen(0, start2 - 1);
            boolean isArr1AndArr2Compared = false;
            for (int start3 = start2 + 1; start3 < len; start3++) {
                // [0, start2 - 1] [start2, start3 - 1] [start3, len - 1]
                int len2 = getLen(start2, start3 - 1);
                if (len2 >= len1 && !isArr1AndArr2Compared) {
                    long hash1 = strHash.getSubStrHash(0, idxMap[start2] - 1);
                    long preHash2 = strHash.getSubStrHash(idxMap[start2], idxMap[start2 + len1] - 1);
                    if (hash1 == preHash2) {
                        ans += len - start3;
                        break;
                    }
                    isArr1AndArr2Compared = true;
                }

                int len3 = getLen(start3, len - 1);
                if (len3 >= len2) {
                    long hash2 = strHash.getSubStrHash(idxMap[start2], idxMap[start3] - 1);
                    long preHash3 = strHash.getSubStrHash(idxMap[start3], idxMap[start3 + len2] - 1);
                    if (hash2 == preHash3) {
                        ans++;
                    }
                } else if (isArr1AndArr2Compared) {
                    break;
                }
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        System.out.println(new C().beautifulSplits(new int[]{1,1,2,1}));
    }


}
