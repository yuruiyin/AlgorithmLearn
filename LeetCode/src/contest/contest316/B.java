package contest.contest316;

import java.util.ArrayList;
import java.util.List;

public class B {

    private int gcd(int m, int n) {
        return m % n == 0 ? n : gcd(n, m % n);
    }

    public int subarrayGCD(int[] nums, int k) {
        int gcd = nums[0];
        int ans = 0;
        if (gcd == k) {
            ans++;
        }
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            int tmpGcd = nums[i];
            if (tmpGcd == k) {
                ans++;
            }
            for (int j = i - 1; j >= 0; j--) {
                tmpGcd = gcd(tmpGcd, nums[j]);
                if (tmpGcd == k) {
                    ans++;
                } else if (tmpGcd < k) {
                    break;
                }
            }
        }
        return ans;
    }

    private List<Integer> getAllFactors(int num) {
        List<Integer> list = new ArrayList<>();
        int end = (int) Math.sqrt(num);
        for (int i = 1; i <= end; i++) {
            if (num % i == 0) {
                list.add(i);
                if (num / i != i) {
                    list.add(num / i);
                }
            }
        }

        return list;
    }

    public static void main(String[] args) {
//        System.out.println(getAllFactors((int) 1e9).size());
    }

}
