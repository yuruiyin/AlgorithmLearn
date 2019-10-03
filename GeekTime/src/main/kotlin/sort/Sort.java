package sort;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Sort {

    private static final int NUM = 100000;

    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    /**
     * 冒泡排序（记录上一轮交换的位置）
     */
    private static void bubbleSort(int[] a) {
        int n = a.length;

        int newLastJ = n - 1;
        for (int i = 0; i < n; i++) {
            int lastJ = newLastJ;
            newLastJ = -1;
            for (int j = 0; j < lastJ; j++) {
                if (a[j + 1] < a[j]) {
                    swap(a, j, j + 1);
                    newLastJ = j;
                }
            }

            if (newLastJ == -1) {
                break;
            }
        }
    }

    /**
     * 冒泡排序（如果有一轮没有交换代表已经有序）
     */
    private static void bubbleSort2(int[] a) {
        int n = a.length;

        for (int i = 0; i < n; i++) {
            int lastJ = n - i - 1;
            boolean isSwap = false;
            for (int j = 0; j < lastJ; j++) {
                if (a[j + 1] < a[j]) {
                    swap(a, j, j + 1);
                    isSwap = true;
                }
            }

            if (!isSwap) {
                break;
            }
        }
    }

    /**
     * 插入排序
     */
    private static void insertSort(int[] a, int start, int end) {
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

    /**
     * 插入排序
     *
     * @param a
     */
    private static void insertSort(int[] a) {
        int n = a.length;

        for (int i = 1; i < n; i++) {
            int value = a[i];

            int j = i - 1;
            for (; j >= 0; j--) {
                if (a[j] > value) {
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }

            a[j + 1] = value;
        }
    }

    /**
     * 简单选择排序
     */
    private static void selectSort(int[] a) {
        int n = a.length;

        for (int i = 0; i < n; i++) {
            // 求无序区的最小值
            int minIndex = i;
            for (int j = i; j < n; j++) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                swap(a, i, minIndex);
            }
        }
    }

    /**
     * 寻找中位数
     */
    private static void findMid(int[] a, int start, int end) {
        int n = end - start + 1;
        if (n == 1 || n == 2) {
            return;
        }

        int i;
        for (i = start; i < end - 4; i += 5) {
            insertSort(a, i, i + 4);
            swap(a, (i - start) / 5 + start, i + 2);
        }

        // 处理剩下的元素（最后小于或等于5个的数）
        int leftCount = end - i + 1;
        insertSort(a, i, i + leftCount - 1);
        swap(a, (i - start) / 5 + start, i + leftCount / 2);

        // 继续递归求解中位数的中位数
        n = (n % 5 == 0 ? n / 5 : n / 5 + 1);
        findMid(a, start, start + n - 1);
    }

    /**
     * 快排
     * 思路：每次都确定一个阈值pivot，目的是让pivot左边的值都小于他，右边的值都大于它，不断递归下去就会有序。
     * 其中，如果进行分区操作呢，主要是让右边比阈值小的数与左边比阈值大的数进行交换。这里要注意，若定第一个元素为阈值，则应该从右往左，再从左往右。
     */
    private static void quickSort(int[] a, int start, int end) {
        // 区间比较小的时候可以使用插入排序
//        if (end - start <= 80) {
//            insertSort(a, start, end);
//            return;
//        }

        if (start >= end) {
            return;
        }

        findMid(a, start, end);
        int pivot = a[start];
        int left = start;
        int right = end;

        while (left != right) {
            while (a[right] >= pivot && left < right) {
                right--;
            }

            while (a[left] <= pivot && left < right) {
                left++;
            }

            if (left < right) {
                swap(a, left, right);
            }
        }

        a[start] = a[left];
        a[left] = pivot;

        quickSort(a, start, left - 1);
        quickSort(a, left + 1, end);
    }

    private static void merge(int[] a, int[] tmpArr, int start, int mid, int end) {
        if (end - start <= 0) {
            return;
        }

        int i, j, k;
        int num = 0;
        for (i = start, j = mid; i < mid && j <= end; ) {
            if (a[i] <= a[j]) {
                tmpArr[num++] = a[i];
                i++;
            } else {
                tmpArr[num++] = a[j];
                j++;
            }
        }

        // 此时，可能存在两种情况：
        // (1) 第一个区域没遍历完；
        // (2) 第二个区域没遍历完。
        if (i != mid) {
            for (k = i; k < mid; k++) {
                tmpArr[num++] = a[k];
            }
        } else if (j != end + 1) {
            for (k = j; k <= end; k++) {
                tmpArr[num++] = a[k];
            }
        }

        // 将tmp数组赋值给a数组
        for (k = 0; k < num; k++) {
            a[start + k] = tmpArr[k];
        }
    }

    private static void mSort(int[] a, int[] tmpArr, int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = (start + end + 1) >>> 1;
        mSort(a, tmpArr, start, mid - 1);
        mSort(a, tmpArr, mid, end);
        merge(a, tmpArr, start, mid, end);
    }

    private static void mergeSort(int[] a) {
        int n = a.length;
        int[] tmpArr = new int[n];

        mSort(a, tmpArr, 0, n - 1);
    }

    private static void systemSort(int[] a) {
        Arrays.sort(a);
    }

    private static void printArray(int[] a) {
        for (int item : a) {
            System.out.print(item + " ");
        }
    }

    private static int[] getArr() {
        int[] resArr = new int[NUM];
        for (int i = 0; i < NUM; i++) {
            int randomValue = (int) (1 + Math.random() * NUM);
            resArr[i] = randomValue;
        }

//        // 从大到小
//        int max = NUM;
//        for (int i = 0; i < NUM; i++) {
//            resArr[i] = max--;
//        }

//        // 从小到大
//        int min = 1;
//        for (int i = 0; i < NUM; i++) {
//            resArr[i] = min++;
//        }

        return resArr;
    }

    public static void main(String[] args) {
        int[] a = getArr();
//        int[] a = {3, 2, 1, 7, 4, 5, 10, 8, 9, 6, 12, 11};

//        long start = System.currentTimeMillis();
//        bubbleSort2(a);
//        long end = System.currentTimeMillis();
//        System.out.println("冒泡排序耗时： " + (end - start) + "ms");

//        long start = System.currentTimeMillis();
//        insertSort(a);
//        long end = System.currentTimeMillis();
//        System.out.println("插入排序耗时： " + (end - start) + "ms");

//        printArray(a);

//        long start = System.currentTimeMillis();
//        selectSort(a);
//        long end = System.currentTimeMillis();
//        System.out.println("选择排序耗时： " + (end - start) + "ms");

//        long start = System.currentTimeMillis();
//        quickSort(a, 0, a.length - 1);
//        long end = System.currentTimeMillis();
//        System.out.println("快速排序耗时： " + (end - start) + "ms");

//        long start = System.currentTimeMillis();
//        systemSort(a);
//        long end = System.currentTimeMillis();
//        System.out.println("系统排序耗时： " + (end - start) + "ms");

        long start = System.currentTimeMillis();
        mergeSort(a);
        long end = System.currentTimeMillis();
        System.out.println("归并排序耗时： " + (end - start) + "ms");

//        printArray(a);
    }

}
