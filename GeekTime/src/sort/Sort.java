package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
     * 二分查找第一个比目标值大的元素
     */
    private static int binarySearch(List<Integer> datas, int wantInsertedValue) {
        if (datas.isEmpty()) {
            return 0;
        }
        int low = 0;
        int high = datas.size() - 1;
        while (low <= high) {
            int mid = (low + high) >> 1;
            int midValue = datas.get(mid);
            // 要插入的值跟数组中已有的值不会相等
            if (midValue > wantInsertedValue) {
                if (mid == 0 || datas.get(mid - 1) < wantInsertedValue) {
                    return mid;
                }

                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
    private static void insertSortBinary(int[] a) {
        int n = a.length;
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int insertIndex = binarySearch(list, a[i]);
            list.add(insertIndex, a[i]);
        }

        for (int i = 0; i < n; i++) {
            a[i] = list.get(i);
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

    /**
     * 归并排序
     */
    private static void mergeSort(int[] a) {
        int n = a.length;
        int[] tmpArr = new int[n];

        mSort(a, tmpArr, 0, n - 1);
    }

    /**
     * 希尔排序（也是一种插入排序）
     */
    private static void shellInsertSort(int[] a) {
        int n = a.length;

        for (int dk = n / 2; dk > 0; dk /= 2) {
            for (int i = dk; i < n; i++) {
                int x = a[i];
                int j;
                for (j = i - dk; j >= 0 && x < a[j]; j -= dk) {
                    a[j + dk] = a[j];
                }
                a[j + dk] = x;
            }
        }
    }

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
                a[num++] = i;
                bucket[i]--;
            }
        }
    }

    private static void heapify(int[] a, int i, int n) {
        while (true) {
            int maxPos = i;
            if (2*i+1 < n && a[2*i+1] > a[maxPos]) {
                maxPos = 2*i+1;
            }

            if (2*i+2 < n && a[2*i+2] > a[maxPos]) {
                maxPos = 2*i+2;
            }

            if (maxPos == i) {
                break;
            }

            swap(a, i, maxPos);
            i = maxPos;
        }
    }

    /**
     * 建堆，（大顶堆）
     */
    private static void buildHeap(int[] a) {
        int n = a.length;
        for (int i = (n - 1) / 2; i >= 0; i--) {
            heapify(a, i, n);
        }
    }

    /**
     * 堆排序
     */
    private static void heapSort(int[] a) {
        int n = a.length;
        buildHeap(a);
        int i = n - 1;
        while (i >= 1) {
            swap(a, 0, i);
            i--;
            heapify(a, 0, i + 1);
        }
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
//        for (int i = 0; i < NUM; i++) {
//            int randomValue = (int) (1 + Math.random() * NUM);
//            resArr[i] = randomValue;
//        }

        for (int i = 0; i < NUM; i++) {
            resArr[i] = 10;
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

//        long start = System.currentTimeMillis();
//        insertSortBinary(a);
//        long end = System.currentTimeMillis();
//        System.out.println("二分插入排序耗时： " + (end - start) + "ms");


//        long start = System.currentTimeMillis();
//        selectSort(a);
//        long end = System.currentTimeMillis();
//        System.out.println("选择排序耗时： " + (end - start) + "ms");

        long start = System.currentTimeMillis();
        quickSort(a, 0, a.length - 1);
        long end = System.currentTimeMillis();
        System.out.println("快速排序耗时： " + (end - start) + "ms");

//        long start = System.currentTimeMillis();
//        systemSort(a);
//        long end = System.currentTimeMillis();
//        System.out.println("系统排序耗时： " + (end - start) + "ms");

//        long start = System.currentTimeMillis();
//        mergeSort(a);
//        long end = System.currentTimeMillis();
//        System.out.println("归并排序耗时： " + (end - start) + "ms");

//        long start = System.currentTimeMillis();
//        shellInsertSort(a);
//        long end = System.currentTimeMillis();
//        System.out.println("希尔排序耗时： " + (end - start) + "ms");

//        long start = System.currentTimeMillis();
//        countingSort(a);
//        long end = System.currentTimeMillis();
//        System.out.println("计数（桶）排序耗时： " + (end - start) + "ms");

//        long start = System.currentTimeMillis();
//        heapSort(a);
//        long end = System.currentTimeMillis();
//        System.out.println("堆排序耗时： " + (end - start) + "ms");

//        printArray(a);
    }

}
