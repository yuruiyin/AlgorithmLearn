package sort;

public class HeapSort {

    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
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

    private static void buildHeap(int[] a) {
        int n = a.length;
        for (int i = (n - 1) / 2; i >= 0; i--) {
            heapify(a, i, n);
        }
    }

    public static void heapSort(int[] a) {
        int n = a.length;

        buildHeap(a);
        int i = n - 1;
        while (i >= 1) {
            swap(a, 0, i);
            i--;
            heapify(a, 0, i + 1);
        }
    }

    private static void printArray(int[] a) {
        for (int item : a) {
            System.out.print(item + " ");
        }
    }

    public static void main(String[] args) {
        int[] a = {3, 2, 1, 7, 4, 5, 10, 8, 9, 6, 12, 11};
        long start = System.currentTimeMillis();
        heapSort(a);
        long end = System.currentTimeMillis();
        System.out.println("堆排序耗时： " + (end - start) + "ms");

        printArray(a);
    }

}
