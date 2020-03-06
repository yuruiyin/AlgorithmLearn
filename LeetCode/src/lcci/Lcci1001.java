package lcci;

public class Lcci1001 {

    public void merge(int[] A, int m, int[] B, int n) {
        // 先将A右移到末尾
        System.arraycopy(A, 0, A, n, m);

        int index = 0;
        int indexA, indexB;
        for (indexA = n, indexB = 0; indexA < m + n && indexB < n;) {
            if (A[indexA] <= B[indexB]) {
                A[index++] = A[indexA++];
            } else {
                A[index++] = B[indexB++];
            }
        }

        while (indexA < m + n) {
            A[index++] = A[indexA++];
        }

        while (indexB < n) {
            A[index++] = B[indexB++];
        }
    }

}
