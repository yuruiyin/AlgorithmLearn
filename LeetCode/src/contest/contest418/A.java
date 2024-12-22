package contest.contest418;

public class A {

    private int convert(String str) {
        int ans = 0;
        for (int i = 0; i < str.length(); i++) {
            ans <<= 1;
            ans += str.charAt(i) - '0';
        }
        return ans;
    }

    public int maxGoodNumber(int[] nums) {
        int ansMax = 0;
        String[] strings = new String[3];
        for (int i = 0; i < 3; i++) {
            strings[i] = Integer.toBinaryString(nums[i]);
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == j) {
                    continue;
                }
                for (int k = 0; k < 3; k++) {
                    if (k == j || k == i) {
                        continue;
                    }
                    String str = strings[i] + strings[j] + strings[k];
                    ansMax = Math.max(ansMax, convert(str));
                }
            }
        }
        return ansMax;
    }

    public static void main(String[] args) {
        System.out.println(new A().maxGoodNumber(new int[]{1, 2, 3}));
        System.out.println("hello world");
    }

}
