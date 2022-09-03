package contest.contest_ubiquant2022;

public class C {

    private int gcd(int a, int b) {
        return a % b == 0 ? b : gcd(b, a % b);
    }

    private int[] getCount(int num) {
        int count2 = 0;
        while (num > 0 && num % 2 == 0) {
            num /= 2;
            count2++;
        }
        int count3 = 0;
        while (num > 0 && num % 3 == 0) {
            num /= 3;
            count3++;
        }
        return num == 1 ? new int[]{count2, count3} : null;
    }

    public int minOperations(int[] numbers) {
        int len = numbers.length;
        if (len == 1) {
            return 0;
        }
        int gcdNum = numbers[0];
        for (int i = 1; i < len; i++) {
            gcdNum = gcd(gcdNum, numbers[i]);
        }

        int[][] countArr = new int[len][];
        int sum = 0;
        int maxCount2 = 0;
        int maxCount3 = 0;
        for (int i = 0; i < len; i++) {
            int num = numbers[i];
            int left = num / gcdNum;
            int[] count = getCount(left);
            if (count == null) {
                return -1;
            }
            maxCount2 = Math.max(count[0], maxCount2);
            maxCount3 = Math.max(count[1], maxCount3);
            countArr[i] = count;
        }

        int ans = 0;
        for (int i = 0; i < len; i++) {
            int curCount2 = countArr[i][0];
            int curCount3 = countArr[i][1];
            ans += maxCount2 - curCount2 + (maxCount3 - curCount3);
        }

        return ans;
    }

    public static void main(String[] args) {
//        System.out.println(new C().minOperations(new int[]{5}));
//        System.out.println(new C().minOperations(new int[]{1, 1}));
//        System.out.println(new C().minOperations(new int[]{2, 2}));
        System.out.println(new C().minOperations(new int[]{1, 2, 3}));
    }

}
