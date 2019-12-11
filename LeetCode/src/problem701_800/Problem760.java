package problem701_800;

public class Problem760 {

    public int[] anagramMappings(int[] arrA, int[] arrB) {
        int len = arrA.length;
        boolean[] visited = new boolean[len];
        int[] ans = new int[len];

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (arrA[i] == arrB[j] && !visited[j]) {
                    ans[i] = j;
                    visited[j] = true;
                    break;
                }
            }
        }

        return ans;
    }

}
