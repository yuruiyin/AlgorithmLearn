package doubleContest.round62;

/**
 * A
 *
 * @author: yry
 * @date: 2021/10/2
 */
public class C {

    private int getAns(char c, char[] arr, int k) {
        int len = arr.length;
        int[] preFCountArr = new int[len];
        preFCountArr[0] = arr[0] == c ? 1 : 0;
        for (int i = 1; i < len; i++) {
            preFCountArr[i] = preFCountArr[i - 1] + (arr[i] == c ? 1 : 0);
        }

        int l = 0;
        int r = len - 1;

        for (int i = len - 1; i >= 0; i--) {
            if (preFCountArr[i] <= k) {
                r = i;
                break;
            }
        }

        int ansMax = r - l + 1;
        while (l <= r) {
            l++;
            for (int i = r + 1; i < len; i++) {
                if (preFCountArr[i] -  preFCountArr[l - 1] > k) {
                    break;
                }
                r = i;
            }

            ansMax = Math.max(ansMax, r - l + 1);
            if (r == len - 1) {
                break;
            }
        }

        return ansMax;
    }

    public int maxConsecutiveAnswers(String answerKey, int k) {
        char[] arr = answerKey.toCharArray();
        int ans1 = getAns('T', arr, k);
        int ans2 = getAns('F', arr, k);
        return Math.max(ans1, ans2);
    }

    public static void main(String[] args) {
        
    }

}
