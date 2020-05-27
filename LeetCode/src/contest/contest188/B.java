package contest.contest188;

/**
 * A
 *
 * @author: yry
 * @date: 2020/5/10
 */
public class B {

    public int countTriplets(int[] arr) {
        int len = arr.length;
        int[] preArr = new int[len];
        preArr[0] = arr[0];
        for (int i = 1; i < len; i++) {
            preArr[i] = preArr[i - 1] ^ arr[i];
        }

        int ans = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                for (int k = j; k < len; k++) {
                    int a = i == 0 ? preArr[j-1] : preArr[j - 1] ^ preArr[i - 1];
                    int b = preArr[k] ^ preArr[j - 1];
                    if (a == b) {
                        ans++;
                    }
                }
            }
        }

        return ans;
    }

}
