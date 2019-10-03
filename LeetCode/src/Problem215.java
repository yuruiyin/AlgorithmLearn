/**
 * 数组中的第k个最大元素
 */
public class Problem215 {

    /**
     * 插入排序
     */
    private void insertSort(int[] a, int start, int end) {
        for (int i = start + 1; i <= end; i++) {
            int value = a[i];

            int j = i - 1;
            for (; j >= start; j--) {
                if (a[j] > value) {
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }

            a[j + 1] = value;
        }
    }

    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    /**
     * 寻找中位数
     */
    private void findMid(int[] a, int n) {
        if (n == 1) {
            return;
        }

        int i;
        for (i = 0; i < n - 5; i += 5) {
            insertSort(a, i, i + 4);
            swap(a, i / 5, i + 2);
        }

        // 处理剩下的元素（最后小于或等于5个的数）
        int leftCount = n - i;
        insertSort(a, i, i + leftCount - 1);
        swap(a, i / 5, i + leftCount / 2);

        // 继续递归求解中位数的中位数
        n = (n % 5 == 0 ? n / 5 : n / 5 + 1);
        findMid(a, n);
    }

    private int partition(int[] a, int start, int end) {
        if (start >= end) {
            return 0;
        }

        // 中位数当做划分的界限
        int pivotValue = a[start];
        int left = start;
        int right = end;

        while (left != right) {
            while (a[right] >= pivotValue && left < right) {
                right--;
            }

            while (a[left] <= pivotValue && left < right) {
                left++;
            }

            if (left < right) {
                swap(a, left, right);
            }
        }

        a[start] = a[left];
        a[left] = pivotValue;

        return left; // 分区完之后中间值的位置
    }

    private int BFPRT(int[] a, int start, int end, int k) {
        if (start >= end) {
            return a[start];
        }
        // 将中位数的中位数移动到第一个位置
        findMid(a, end - start + 1);
        int pivotIndex = partition(a, start, end);

        int leftLen = pivotIndex + 1 - start;
        if (leftLen == k) {
            return a[pivotIndex];
        } else if (leftLen > k) { // 第k小在左边
            return BFPRT(a, start, pivotIndex - 1, k);
        } else {
            return BFPRT(a, pivotIndex + 1, end, k - leftLen);
        }

    }

    public int findKthLargest(int[] nums, int k) {
        return BFPRT(nums, 0, nums.length - 1, nums.length - k + 1);
    }

    public static void main(String[] args) {
        int[] a = {3,2,1,5,6,4};
        int ans = new Problem215().findKthLargest(a, 2);
        System.out.println(ans);
    }

}
