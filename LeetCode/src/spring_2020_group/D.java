package spring_2020_group;

import java.util.*;

/**
 * A
 *
 * @author: yry
 * @date: 2020/4/25
 */
public class D {

    private static final int MAXN = (int) (1e6 + 5);

    // 求n以内的所有素数
    private List<Integer> getAllPrimes(int n) {
        boolean[] isNotPrime = new boolean[n + 1];
        for (int i = 2; i * i <= n; i++) {
            if (isNotPrime[i]) {
                continue;
            }

            for (int j = i * i; j <= n; j += i) {
                isNotPrime[j] = true;
            }
        }

        List<Integer> primeList = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (!isNotPrime[i]) {
                primeList.add(i);
            }
        }
        return primeList;
    }


    public int splitArray(int[] nums) {
        List<Integer> list = getAllPrimes(1000);
        System.out.println(list.size());
        return 0;
    }
    
    public static void main(String[] args) {
        int N = 100000;
        int[] nums = new int[N];
        Random random = new Random();
        for (int i = 0; i < N; i++) {
            nums[i] = random.nextInt(1000000) + 2;
        }

        System.out.println(new D().splitArray(nums));
    }

}
