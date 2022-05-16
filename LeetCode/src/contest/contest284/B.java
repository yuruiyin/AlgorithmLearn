package contest.contest284;

public class B {

    public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
        boolean[][] visited = new boolean[n][n];
        for (int[] arr : dig) {
            visited[arr[0]][arr[1]] = true;
        }

        int ans = 0;
        for (int[] art : artifacts) {
            int left = art[0];
            int right = art[2];
            int top = art[1];
            int bottom = art[3];
            boolean isOk = true;
            for (int i = left; i <= right; i++) {
                for (int j = top; j <= bottom; j++) {
                    if (!visited[i][j]) {
                        isOk = false;
                        break;
                    }
                }
                if (!isOk) {
                    break;
                }
            }
            if (isOk) {
                ans++;
            }
        }
        return ans;
    }

}
