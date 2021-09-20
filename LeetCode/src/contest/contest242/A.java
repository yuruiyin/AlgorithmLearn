package contest.contest242;

/**
 * A
 *
 * @author: yry
 * @date: 2021/5/23
 */
public class A {

    public boolean checkZeroOnes(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length;
        int oneCount = arr[0] == '0' ? 0 : 1;
        int zeroCount = arr[0] == '1' ? 0 : 1;
        int maxOneCount = 0;
        int maxZeroCount = 0;
        for (int i = 1; i < len; i++) {
            if (arr[i] == arr[i - 1]) {
                if (arr[i] == '0') {
                    zeroCount++;
                } else {
                    oneCount++;
                }
            } else {
                maxOneCount = Math.max(maxOneCount, oneCount);
                maxZeroCount = Math.max(maxZeroCount, zeroCount);
                oneCount = arr[i] == '0' ? 0 : 1;
                zeroCount = arr[i] == '1' ? 0 : 1;
            }
        }

        maxOneCount = Math.max(maxOneCount, oneCount);
        maxZeroCount = Math.max(maxZeroCount, zeroCount);

        return maxOneCount > maxZeroCount;
    }

}
