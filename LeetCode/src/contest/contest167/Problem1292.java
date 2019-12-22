package contest.contest167;

public class Problem1292 {

    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length;
        int n = mat[0].length;

        // 每行各个元素的前缀和
        int[][] rowPrevSumArr = new int[m][n+1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rowPrevSumArr[i][j+1] = rowPrevSumArr[i][j] + mat[i][j];
            }
        }

        // 每列各个元素的前缀和
        int[][] colPrevSumArr = new int[m+1][n];
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                colPrevSumArr[i+1][j] = colPrevSumArr[i][j] + mat[i][j];
            }
        }

        int ansMax = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int sum = 0;
                int len = 0;
                // 从当前顶点向右下角扩展出新的正方形。
                for (int k = 0; i + k < m && j + k < n; k++) {
                    int newI = i + k;
                    int newJ = j + k;
                    int rowSum = rowPrevSumArr[newI][newJ + 1] - rowPrevSumArr[newI][j];
                    int colSum = colPrevSumArr[newI+1][newJ] - colPrevSumArr[i][newJ];
                    sum += rowSum + colSum - mat[newI][newJ];
                    if (sum > threshold) {
                        break;
                    }
                    len++;
                }

                if (len > ansMax) {
                    ansMax = len;
                }
            }
        }

        return ansMax;
    }
    public static void main(String[] args) {
        
    }
    
}
