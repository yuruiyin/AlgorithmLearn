package contest.contest146;

public class Problem1128 {

    public int numEquivDominoPairs(int[][] dominoes) {
        int[] countArr = new int[100];

        for (int i = 0; i < dominoes.length; i++) {
            int min = Math.min(dominoes[i][0], dominoes[i][1]);
            int max = Math.max(dominoes[i][0], dominoes[i][1]);
            int key = min * 10 + max;
            countArr[key]++;
        }

        int ans = 0;
        for (int count: countArr) {
            if (count <= 1) {
                continue;
            }
            ans += count * (count - 1) / 2;
        }

        return ans;
    }
    
    public static void main(String[] args) {

    }
    
}
