public class Problem135 {

    public int candy(int[] ratings) {
        int len = ratings.length;
        int[] count = new int[len];

        for (int i = 0; i < len; i++) {
            count[i] = 1;
        }

        boolean flag = true;
        while (flag) {
            flag = false;
            for (int i = 0; i < len; i++) {
                if (i > 0 && ratings[i] > ratings[i - 1] && count[i] <= count[i - 1]) {
                    count[i] = count[i - 1] + 1;
                    flag = true;
                }

                if (i < len - 1 && ratings[i] > ratings[i + 1] && count[i] <= count[i + 1]) {
                    count[i] = count[i + 1] + 1;
                    flag = true;
                }
            }
        }

        int ans = 0;
        for (int item : count) {
            ans += item;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Problem135().candy(new int[]{1,0,2}));
        System.out.println(new Problem135().candy(new int[]{1,2,2}));
        System.out.println(new Problem135().candy(new int[]{1,2,3,4}));
    }

}
