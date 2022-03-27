package contest.contest286;

public class C {

    public long[] kthPalindrome(int[] queries, int intLength) {
        int len = queries.length;
        long[] ansArr = new long[len];
        for (int i = 0; i < len; i++) {
            int q = queries[i];
            int leftNumCount = intLength / 2 + (intLength % 2);
            int totalCount = (int) (Math.pow(10, leftNumCount) - Math.pow(10, leftNumCount - 1));
            if (totalCount < q) {
                ansArr[i] = -1;
            } else {
                int leftNum = (int) (Math.pow(10, leftNumCount - 1) + q - 1);
                StringBuilder leftSb = new StringBuilder(String.valueOf(leftNum));
                if (intLength % 2 == 0) {
                    ansArr[i] = Long.parseLong(leftSb.append(new StringBuilder(leftSb).reverse()).toString());
                } else {
                    ansArr[i] = Long.parseLong(leftSb.append(new StringBuilder(leftSb.subSequence(0, leftSb.length() - 1)).reverse()).toString());
                }
            }
        }
        return ansArr;
    }

    public static void main(String[] args) {
//        new C().kthPalindrome(new int[]{1,2,3,4,5,90}, 3);
        new C().kthPalindrome(new int[]{2,4,6}, 4);
        System.out.println("hello");
    }
    
}
