package contest.contest230;

import utils.TreeMultiSet;

/**
 * A
 *
 * @author: yry
 * @date: 2021/2/28
 */
public class C {

    public int minOperations(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        if (len1 > len2 * 6 || len2 > len1 * 6) {
            return -1;
        }

        int sum1 = 0;
        for (int num : nums1) {
            sum1 += num;
        }

        int sum2 = 0;
        for (int num : nums2) {
            sum2 += num;
        }

        int[] countArr1 = new int[7];
        for (int num : nums1) {
            countArr1[num]++;
        }

        int[] countArr2 = new int[7];
        for (int num : nums2) {
            countArr2[num]++;
        }

        int ans = 0;
        while (sum1 != sum2) {
            if (sum1 < sum2) {
                int[] tmpArr = countArr1;
                countArr1 = countArr2;
                countArr2 = tmpArr;
                int tmp = sum2;
                sum2 = sum1;
                sum1 = tmp;
            }

            int diff = sum1 - sum2;
            // arr1的最大值和arr2的最小值
            int max1 = 1;
            int min2 = 6;
            for (int i = 6; i >= 1; i--) {
                if (countArr1[i] > 0) {
                    max1 = i;
                    break;
                }
            }

            for (int i = 1; i <= 6; i++) {
                if (countArr2[i] > 0) {
                    min2 = i;
                    break;
                }
            }

            int diffMax1 = max1 - 1;
            int diffMax2 = 6 - min2;
            if (diffMax1 >= diffMax2) {
                if (diffMax1 <= diff) {
                    countArr1[max1]--;
                    countArr1[1]++;
                    sum1 -= diffMax1;
                } else {
                    countArr1[max1]--;
                    countArr1[max1 - diff]++;
                    sum1 -= diff;
                }
            } else {
                if (diffMax2 <= diff) {
                    countArr2[min2]--;
                    countArr2[6]++;
                    sum2 += diffMax2;
                } else {
                    countArr2[min2]--;
                    countArr2[min2 + diff]++;
                    sum2 += diff;
                }
            }

            ans++;
        }

        return ans;
    }

}
