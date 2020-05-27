package doubleContest.round26;

/**
 * A
 *
 * @author: yry
 * @date: 2020/5/16
 */
public class A {

    public int maxPower(String s) {
        int maxCount = 0;
        char[] arr = s.toCharArray();
        int tmpCount = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i-1]) {
                maxCount = Math.max(maxCount, tmpCount);
                tmpCount = 1;
            } else {
                tmpCount++;
            }
        }

        maxCount = Math.max(maxCount, tmpCount);
        return maxCount;
    }

}
