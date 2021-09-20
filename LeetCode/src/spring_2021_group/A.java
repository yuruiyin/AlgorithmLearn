package spring_2021_group;

/**
 * A
 *
 * @author: yry
 * @date: 2021/4/10
 */
public class A {

    public int storeWater(int[] bucket, int[] vat) {
        int len = bucket.length;

        boolean hasNonZero = false;
        for (int i = 0; i < len; i++) {
            if (vat[i] != 0) {
                hasNonZero = true;
                break;
            }
        }

        if (!hasNonZero) {
            return 0;
        }

        int[] arr = new int[len];
        int ans = 0;
        for (int i = 0; i < len; i++) {
            if (bucket[i] == 0) {
                if (vat[i] == 0) {
                    continue;
                } else {
                    bucket[i] = 1;
                    ans++;
                }
            }
            arr[i] = vat[i] / bucket[i] + (vat[i] % bucket[i] == 0 ? 0 : 1);
        }

        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= 10000; i++) {
            int tmpCount = 0;
            for (int j = 0; j < len; j++) {
                if (arr[j] > i) {
                    tmpCount += (vat[j] / i + (vat[j] % i == 0 ? 0 : 1)) - bucket[j];
                }
            }
            tmpCount += i;
            min = Math.min(min, tmpCount);
        }

        return min + ans;
    }

    public static void main(String[] args) {
        System.out.println(new A().storeWater(new int[]{1,3}, new int[]{6, 8}));
    }

}
