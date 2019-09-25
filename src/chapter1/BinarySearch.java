package chapter1;

public class BinarySearch {

    private static final int COUNT = 80000000;

    /**
     * 二分查找-while循环版本
     * @param a 数组
     * @param fromIndex 起始位置
     * @param toIndex 终止位置
     * @param key 要查找的关键字
     * @return 查找到的关键字在数组中的索引
     */
    public static int binarySearch(int[] a, int fromIndex, int toIndex, int key) {
        int low = fromIndex;
        int high = toIndex;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = a[mid];

            if (key < midVal) {
                high = mid - 1;
            } else if (key > midVal) {
                low = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

    /**
     * 二分查找-递归版本
     */
    public static int binarySearchRecursive(int[] a, int fromIndex, int toIndex, int key) {
        if (fromIndex > toIndex) {
            return -1;
        }

        if (fromIndex == toIndex) {
            return a[fromIndex] == key ? fromIndex : -1;
        }

        int mid = (fromIndex + toIndex) >>> 1;
        int midVal = a[mid];

        if (key < midVal) {
            return binarySearchRecursive(a, fromIndex, mid - 1, key);
        } else if (key > midVal) {
            return binarySearchRecursive(a, mid + 1, toIndex, key);
        } else {
            return mid;
        }
    }

    private static void createArr(int[] a) {
        a[0] = 1;
        for (int i = 1; i < COUNT; i++) {
            a[i] = a[i - 1] + 2;
        }
    }

    public static void main(String[] args) {
        int[] a = new int[COUNT];

        createArr(a);

        long startTime = System.currentTimeMillis();
        int resIndex = binarySearch(a, 0, a.length - 1, 4);
        long endTime = System.currentTimeMillis();
        System.out.println("while循环版本： key=4, resIndex: " + resIndex);
        System.out.println("while循环版本：数组长度为800万，耗时: " + (endTime - startTime) + "ms");

        resIndex = binarySearch(a, 0, a.length - 1, 5);
        System.out.println("while循环版本：key=5, resIndex: " + resIndex);

        startTime = System.currentTimeMillis();
        resIndex = binarySearchRecursive(a, 0, a.length - 1, 4);
        endTime = System.currentTimeMillis();
        System.out.println("递归版本：key=5, resIndex: " + resIndex);
        System.out.println("递归版本：数组长度为800万，耗时: " + (endTime - startTime) + "ms");
        resIndex = binarySearchRecursive(a, 0, a.length - 1, 5);
        System.out.println("递归版本：key=5, resIndex: " + resIndex);
    }

}

/**
 * 以上在mac上的耗时都是0ms，主要是因为二分查找是logn的算法，所以即便是递归，依然很快。
 */
