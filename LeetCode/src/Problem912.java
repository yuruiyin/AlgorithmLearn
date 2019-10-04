public class Problem912 {

    private static final int MIN_VALUE = -50000;

    /**
     * 计数排序（特殊的桶排序，每个桶只存放一个元素）
     */
    private static void countingSort(int[] a) {
        int max = Integer.MIN_VALUE;
        for (int item : a) {
            if (item > max) {
                max = item;
            }
        }
        int[] bucket = new int[max + 1];

        for (int item : a) {
            bucket[item]++;
        }

        int num = 0;
        for (int i = 0; i <= max; i++) {
            while (bucket[i] > 0) {
                a[num++] = i + MIN_VALUE;
                bucket[i]--;
            }
        }
    }

    /**
     * 让数组所有元素变成非负数
     */
    private void nonNegativeArr(int[] a) {
        // 计算最小元素
        int n = a.length;
        for (int i = 0; i < n; i++) {
            a[i] -= MIN_VALUE;
        }
    }

    public int[] sortArray(int[] a) {
        nonNegativeArr(a);
        countingSort(a);
        return a;
    }

    public static void main(String[] args) {
        int[] a = {5,1,1,2,0,0};
        new Problem912().sortArray(a);

        for (int item : a) {
            System.out.print(item + " ");
        }
    }

}
