package problem801_900;

public class Problem888 {

    public int[] fairCandySwap(int[] arr1, int[] arr2) {
        int sum1 = 0;
        int sum2 = 0;
        for (int num: arr1) {
            sum1 += num;
        }

        boolean[] flag = new boolean[100001];
        for (int num: arr2) {
            sum2 += num;
            flag[num] = true;
        }

        int sum = sum1 + sum2;
        int target = sum / 2;

        for (int num : arr1) {
            int left = sum1 - num;
            if (left >= target) {
                continue;
            }

            int needNum = target - left;
            if (needNum <= 100000 && flag[needNum]) {
                return new int[]{num, needNum};
            }
        }

        return new int[]{-1, -1};
    }

}
