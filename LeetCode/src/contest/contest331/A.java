package contest.contest331;

public class A {

    public long pickGifts(int[] gifts, int k) {
        int len = gifts.length;
        while ((k--) > 0) {
            int max = 0;
            int maxIdx = -1;
            for (int i = 0; i < len; i++) {
                if (gifts[i] > max) {
                    max = gifts[i];
                    maxIdx = i;
                }
            }

            gifts[maxIdx] = (int) Math.sqrt(gifts[maxIdx]);
        }

        long sum = 0;
        for (int num : gifts) {
            sum += num;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println("hello");
    }

}
