package contest.contest119;

import java.util.Arrays;

public class Problem976 {

    public int largestPerimeter(int[] arr) {
        Arrays.sort(arr);
        int len = arr.length;

        for (int i = len - 1; i > 1; i--) {
            int diff = arr[i] - arr[i-1];
            if (diff < arr[i-2]) {
                return arr[i] + arr[i-1] + arr[i-2];
            }
        }

        return 0;
    }

}

//  给定由一些正数（代表长度）组成的数组 A，返回由其中三个长度组成的、面积不为零的三角形的最大周长。
//
//        如果不能形成任何面积不为零的三角形，返回 0。
//
//        示例 1：
//
//        输入：[2,1,2]
//        输出：5
//        示例 2：
//
//        输入：[1,2,1]
//        输出：0
//        示例 3：
//
//        输入：[3,2,3,4]
//        输出：10
//        示例 4：
//
//        输入：[3,6,2,3]
//        输出：8
//
//        提示：
//
//        3 <= A.length <= 10000
//        1 <= A[i] <= 10^6
