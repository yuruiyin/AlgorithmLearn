package doubleContest.round04;

public class Problem1121 {

    public boolean canDivideIntoSubsequences(int[] nums, int k) {
        if (k == 1) {
            return true;
        }

        int maxNum = nums[nums.length - 1];
        int[] countArr = new int[maxNum + 1];

        for (int num: nums) {
            countArr[num]++;
        }

        // 次数的次数数组，后面需要从次数多的开始减
        int[] countcountArr = new int[nums.length + 1];

        for (int count: countArr) {
            countcountArr[count]++;
        }

        for (int i = nums.length; i >= 1; i--) {
            if (countcountArr[i] == 0) {
                continue;
            }

            if (countcountArr[i] >= k) {
                countcountArr[i] -= k;
                countcountArr[i-1] += k;
            } else {
                if (i == 1) {
                    return false;
                }

                if (countcountArr[1] + countcountArr[i] >= k) {
                    if (i == 2) {
                        countcountArr[1] += 2 * countcountArr[i] - k;
                    } else {
                        countcountArr[i-1] += countcountArr[i];
                        countcountArr[1] -= (k - countcountArr[i]);
                        countcountArr[i] = 0;
                    }
                } else {
                    return false;
                }
            }
        }

        return true;
    }
    
    public static void main(String[] args) {
//        System.out.println(new Problem04().canDivideIntoSubsequences(new int[]{1,1,2,3,4,4}, 3));
//        System.out.println(new Problem04().canDivideIntoSubsequences(new int[]{5,6,6,7,8}, 3));
        System.out.println(new Problem1121().canDivideIntoSubsequences(new int[]{1,2,2,2,3,3,4,4}, 2));
    }
    
}
