package lcof;

public class Lcof044 {

    public int findNthDigit(int n) {
        if (n < 10) {
            return n;
        }

        long longN = n + 1L;
        long count = 0;
        for (int bit = 1;; bit++) {
            int curBitStrLen = 0;
            if (bit == 1) {
                curBitStrLen = 10;
            } else {
                curBitStrLen = (int) (Math.pow(10, bit - 1) * 9 * bit);
            }

            if (count + curBitStrLen < longN) {
                count += curBitStrLen;
                continue;
            }

            int from = (int) Math.pow(10, bit - 1); // 如10， 100，1000
            int index = (int) (longN - count - 1) / bit;
            int num = from + index;
            int mod = (int) ((longN - count - 1) % bit);
            int right = bit - mod - 1; // 离右侧的距离
            int ans = num % 10;
            while ((right--) > 0) {
                num /= 10;
                ans = num % 10;
            }

            return ans;
        }
    }
    
    public static void main(String[] args) {
//        System.out.println(new Lcof044().findNthDigit(11));
//        System.out.println(new Lcof044().findNthDigit(10));
        System.out.println(new Lcof044().findNthDigit(2147483647));
    }

}
