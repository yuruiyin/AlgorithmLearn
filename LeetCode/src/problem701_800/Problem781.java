package problem701_800;

public class Problem781 {

    public int numRabbits(int[] answers) {
        if (answers.length == 0) {
           return 0;
        }

        int[] countMap = new int[1000];
        for (int num : answers) {
            countMap[num]++;
        }

        int ans = countMap[0];
        for (int i = 1; i < 1000; i++) {
            if (countMap[i] == 0) {
                continue;
            }
            ans += (i + 1) * ((countMap[i] - 1) / (i + 1)  + 1);
        }

        return ans;
    }

}
