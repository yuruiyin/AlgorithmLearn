package utils;

public class StringContainsTest {

    public static class StrHash {

        private static final long P = 805306457;
        private static final long MOD = (int) (1e9+7);
        private long[] hash;
        private long[] power;
        private byte[] arr;

        public StrHash(byte[] arr) {
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

    /**
     * 使用系统的contains方法
     */
    private static void testSystemContains(String source, String target) {
        long startTime = System.currentTimeMillis();
        if (source.contains(target)) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
        System.out.println("testSystemContains耗时：" + (System.currentTimeMillis() - startTime) + "ms");
    }

    private static void testStrHashContains(String source, String target) {
        long startTime = System.currentTimeMillis();
        int textLen = source.length();
        int searchLen = target.length();
        StrHash textHash = new StrHash(source.getBytes());
        StrHash searchHash = new StrHash(target.getBytes());
        long searchHashValue = searchHash.getSubStrHash(0, searchLen - 1);
        boolean isFound = false;
        for (int i = 0; i < textLen - searchLen + 1; i++) {
            long subHash = textHash.getSubStrHash(i, i + searchLen - 1);
            if (searchHashValue == subHash) {
                isFound = true;
                System.out.println("yes");
                break;
            }
        }
        if (!isFound) {
            System.out.println("no");
        }
        System.out.println("testStrHashContains耗时：" + (System.currentTimeMillis() - startTime) + "ms");
    }

    private static void testKMPContains(String source, String target) {
        long startTime = System.currentTimeMillis();
        char[] s = source.toCharArray();
        char[] t = target.toCharArray();
        int targetIdx = KMPUtil.kmpSearch(s, t);
        if (targetIdx != -1) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
        System.out.println("testKMPContains耗时：" + (System.currentTimeMillis() - startTime) + "ms");
    }

    public static void main(String[] args) {
        String source = "hel".repeat(200000000);
        String target = "hello".repeat(100);
//        testSystemContains(source, target);
//        testStrHashContains(source, target);
        testKMPContains(source, target);
    }

}
