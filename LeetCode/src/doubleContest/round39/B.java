package doubleContest.round39;

/**
 * A
 *
 * @author: yry
 * @date: 2020/11/14
 */
public class B {

    public int minimumDeletions(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length;

        int aCount = 0;
        int bCount = 0;
        for (int i = 0; i < len; i++) {
            if (arr[i] == 'a') {
                aCount++;
            } else {
                bCount++;
            }
        }

        int[] preACountArr = new int[len];
        preACountArr[0] = arr[0] == 'a' ? 1 : 0;
        for (int i = 1; i < len; i++) {
            if (arr[i] == 'b') {
                preACountArr[i] = preACountArr[i - 1];
            } else {
                preACountArr[i] = preACountArr[i - 1] + 1;
            }
        }

        int maxCount = Math.max(aCount, bCount);
        for (int i = 0; i < len - 1; i++) {
            maxCount = Math.max(maxCount, preACountArr[i] + (bCount - i - 1 + preACountArr[i]));
        }

        return len - maxCount;
    }
    
    public static void main(String[] args) {
        System.out.println(new B().minimumDeletions("aababbab"));
    }

}
