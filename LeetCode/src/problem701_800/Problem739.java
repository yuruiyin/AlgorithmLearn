package problem701_800;

public class Problem739 {

    // 暴力二重循环，O(n*n)
    public int[] dailyTemperatures(int[] t) {
        int len = t.length;
        int[] ansArr = new int[len];

        for (int i = 0; i < len; i++) {
            for (int j = i+1; j < len; j++) {
                if (t[j] > t[i]) {
                    ansArr[i] = j - i;
                    break;
                }
            }
        }

        return ansArr;
    }

}
