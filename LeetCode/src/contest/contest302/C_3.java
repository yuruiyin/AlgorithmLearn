package contest.contest302;

public class C_3 {

    class Data {
        char[] arr;
        int idx;

        Data(char[] arr, int idx) {
            this.arr = arr;
            this.idx = idx;
        }
    }

    private int compareStr(char[] arr1, char[] arr2, int trim) {
        int len = arr1.length;
        for (int i = len - trim; i < len; i++) {
            if (arr1[i] < arr2[i]) {
                return -1;
            } else if (arr1[i] > arr2[i]) {
                return 1;
            }
        }
        return 0;
    }

    private int compareData(Data data1, Data data2, int trim) {
        int compareRes = compareStr(data1.arr, data2.arr, trim);
        return compareRes == 0 ? Integer.compare(data1.idx, data2.idx) : compareRes;
    }

    private void swap(Data[] datas, int i, int j) {
        Data t = datas[i];
        datas[i] = datas[j];
        datas[j] = t;
    }

    private int partition(Data[] datas, int lo, int hi, int trim) {
        if (lo >= hi) {
            return hi;
        }

        Data pivot = datas[lo];
        int left = lo;
        int right = hi;
        while (left < right) {
            // 从右往左找到 < mid的第一个数
            while (left < right && compareData(datas[right], pivot, trim) != -1) {
                right--;
            }

            // 从左往右找到 > mid的第一个数
            while (left < right && compareData(datas[left], pivot, trim) != 1) {
                left++;
            }

            if (left < right) {
                swap(datas, left, right);
            }
        }

        datas[lo] = datas[left];
        datas[left] = pivot;
        return left;
    }

    /**
     * 求第k小元素
     */
    private Data findKthSmallestNum(Data[] datas, int l, int r, int k, int trim) {
        if (l >= r) {
            return datas[l];
        }
        int pivot = partition(datas, l, r, trim);
        int leftLen = pivot - l + 1;
        if (k == leftLen) {
            return datas[pivot];
        } else if (k < leftLen) {
            return findKthSmallestNum(datas, l, pivot - 1, k, trim);
        } else {
            return findKthSmallestNum(datas, pivot + 1, r, k - leftLen, trim);
        }
    }

    /**
     * O(n)（基于快排分治思想）算法求第k小元素
     */
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int qLen = queries.length;
        int[] ansArr = new int[qLen];
        Data[] datas = new Data[nums.length];
        for (int i = 0; i < nums.length; i++) {
            datas[i] = new Data(nums[i].toCharArray(), i);
        }

        for (int i = 0; i < qLen; i++) {
            int[] query = queries[i];
            int k = query[0];
            int trim = query[1];
            Data kthSmallestData = findKthSmallestNum(datas, 0, nums.length - 1, k, trim);
            ansArr[i] = kthSmallestData.idx;
        }
        return ansArr;
    }

    public static void main(String[] args) {
//        System.out.println("0".compareTo("1"));
        //        ["24","37","96","04"]
        //       [[2,1],[2,2]]
        new C_3().smallestTrimmedNumbers(new String[]{"24", "37", "96", "04"}, new int[][]{
                {2, 1}, {2, 2}
        });

        // ["102","473","251","814"], queries = [[1,1],[2,3],[4,2],[1,2]]
        new C_3().smallestTrimmedNumbers(new String[]{"102", "473", "251", "814"}, new int[][]{
                {1, 1,}, {2, 3}, {4, 2}, {1, 2}
        });
    }

}
