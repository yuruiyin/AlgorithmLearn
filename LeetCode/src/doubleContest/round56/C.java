package doubleContest.round56;

/**
 * A
 *
 * @author: yry
 * @date: 2021/7/10
 */
public class C {

    public boolean sumGame(String num) {
        char[] arr = num.toCharArray();
        int len = arr.length;
        int leftCount = 0;
        int rightCount = 0;
        int leftSum = 0;
        int rightSum = 0;
        for (int i = 0; i < len / 2; i++) {
            if (arr[i] == '?') {
                leftCount++;
            } else {
                leftSum += arr[i] - '0';
            }
        }

        for (int i = len / 2; i < len; i++) {
            if (arr[i] == '?') {
                rightCount++;
            } else {
                rightSum += arr[i] - '0';
            }
        }

        int totalCount = leftCount + rightCount;
        if (totalCount == 0) {
            return leftSum != rightSum;
        }

        if (totalCount % 2 == 1) {
            // 最后一下是alice，那么alice肯定可以让结果不相等，必赢
            return true;
        }

        if (leftSum == rightSum) {
            if (leftCount == rightCount) {
                return false;
            } else {
                return true;
            }
        } else if (leftSum > rightSum) {
            if (rightCount <= leftCount) {
                return true;
            }
            if (leftSum + leftCount * 9 < Math.max(leftCount, rightCount / 2 + rightCount % 2) * 9 + rightSum) {
                return true;
            }
            return false;
        } else {
            if (leftCount <= rightCount) {
                return true;
            }
            if (rightSum + rightCount * 9 < Math.max(rightCount, leftCount / 2 + leftCount % 2) * 9 + leftSum) {
                return true;
            }
            return false;
        }

    }

    public static void main(String[] args) {
        System.out.println(new C().sumGame("54208?183?"));
    }

}
