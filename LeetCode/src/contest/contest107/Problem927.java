package contest.contest107;

import utils.PrintUtil;

public class Problem927 {

    public int[] threeEqualParts(int[] arr) {
        int len = arr.length;
        int firstOneIndex = -1;
        for (int i = 0; i < len; i++) {
            if (arr[i] == 1) {
                firstOneIndex = i;
                break;
            }
        }

        if (firstOneIndex == -1) {
            // 全0
            return new int[]{0,2};
        }

        int[] rightOneIndexArr = new int[len];
        int nearOneIndex = -1;
        for (int i = len - 1; i >= 0; i--) {
            if (arr[i] == 1) {
                rightOneIndexArr[i] = i;
                nearOneIndex = i;
            } else {
                rightOneIndexArr[i] = nearOneIndex;
            }
        }

        for (int i = firstOneIndex; i <= len - 3; i++) {
            int start1 = firstOneIndex;
            int end1 = i;
            int numBitLen = end1 - start1 + 1;
            int secondNumFromIndex = i + 1;
            int start2 = rightOneIndexArr[secondNumFromIndex];
            if (start2 == -1) {
                continue;
            }
            
            int end2 = start2 + numBitLen - 1;
            if (end2 >= len - 1) {
                continue;
            }

            int start3 = rightOneIndexArr[end2 + 1];
            if (start3 == -1) {
                continue;
            }

            int end3 = start3 + numBitLen - 1;
            if (end3 != len - 1) {
                continue;
            }

            boolean isFound = true;
            for (int j = 0; j < numBitLen; j++) {
                if (arr[start1 + j] == arr[start2 + j] && arr[start2 + j] == arr[start3 + j]) {
                    continue;
                }

                isFound = false;
                break;
            }

            if (isFound) {
                return new int[]{end1, end2 + 1};
            }
        }

        return new int[]{-1, -1};
    }
    
    public static void main(String[] args) {
        int[] arr = new Problem927().threeEqualParts(new int[]{1,0,1,0,1});

        PrintUtil.printIntArray(arr);

//        int[] arr = new Problem03().threeEqualParts(new int[]{1,1,0,1,1});
//
//        PrintUtil.printIntArray(arr);
    }

}

//  给定一个由 0 和 1 组成的数组 A，将数组分成 3 个非空的部分，使得所有这些部分表示相同的二进制值。
//
//        如果可以做到，请返回任何 [i, j]，其中 i+1 < j，这样一来：
//
//        A[0], A[1], ..., A[i] 组成第一部分；
//        A[i+1], A[i+2], ..., A[j-1] 作为第二部分；
//        A[j], A[j+1], ..., A[A.length - 1] 是第三部分。
//        这三个部分所表示的二进制值相等。
//        如果无法做到，就返回 [-1, -1]。
//
//        注意，在考虑每个部分所表示的二进制时，应当将其看作一个整体。例如，[1,1,0] 表示十进制中的 6，而不会是 3。
//        此外，前导零也是被允许的，所以 [0,1,1] 和 [1,1] 表示相同的值。
//
//
//        示例 1：
//
//        输入：[1,0,1,0,1]
//        输出：[0,3]
//        示例 2：
//
//        输出：[1,1,0,1,1]
//        输出：[-1,-1]
//
//
//        提示：
//
//        3 <= A.length <= 30000
//        A[i] == 0 或 A[i] == 1
