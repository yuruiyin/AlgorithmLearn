package contest.contest187;

import java.util.*;

/**
 * A
 *
 * @author: yry
 * @date: 2020/5/3
 */
public class D_1 {

    class Node {
        int x;
        int y;
        int sum;
        Node(int x, int y, int sum) {
            this.x = x;
            this.y = y;
            this.sum = sum;
        }
    }

    class Result {
        int[] arr;
        int size;
        Result(int[] arr, int size) {
            this.arr = arr;
            this.size = size;
        }
    }

    // 求两个有序数组的元素和的前k小（两个元素分别来自数组1和数组2）
    private Result calcTwoSortedArrSumTopK(int[] arr1, int size1, int[] arr2, int size2, int k) {
        boolean[][] visited = new boolean[size1][size2];
        PriorityQueue<Node> heap = new PriorityQueue<>(Comparator.comparingInt(o -> o.sum)); // 小顶堆， 前k小
        heap.add(new Node(0, 0, arr1[0] + arr2[0]));
        visited[0][0] = true;
        int[] ansArr = new int[k];
        int ansSize = 0;
        for (int i = 0; i < k; i++) {
            Node top = heap.poll();
            int x = top.x;
            int y = top.y;
            ansArr[ansSize++] = top.sum;
            if (x == size1 - 1 && y == size2 - 1) {
                break;
            }
            if (x + 1 < size1 && !visited[x + 1][y]) {
                heap.offer(new Node(x + 1, y, arr1[x + 1] + arr2[y]));
                visited[x + 1][y] = true;
            }

            if (y + 1 < size2 && !visited[x][y + 1]) {
                heap.offer(new Node(x, y + 1, arr1[x] + arr2[y + 1]));
                visited[x][y + 1] = true;
            }
        }

//        System.arraycopy(ansArr, 0, arr1, 0, ansSize);
        return new Result(ansArr, ansSize);
    }

    public int kthSmallest(int[][] mat, int k) {
        int[] ansArr = new int[k];
        int n = mat[0].length;
        int curSize = 1;
        for (int[] curRow : mat) {
            // 求两个有序数组相加和的前k小元素
            Result result = calcTwoSortedArrSumTopK(ansArr, curSize, curRow, n, k);
            ansArr = result.arr;
            curSize = result.size;
        }

        return ansArr[k - 1];
    }

    public static void main(String[] args) {
        System.out.println(new D_1().kthSmallest(new int[][]{
                {1, 10, 10}, {1, 4, 5}, {2, 3, 6}
        }, 7)); // 9
    }

}
