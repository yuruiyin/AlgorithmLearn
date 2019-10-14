package problem601_700;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用treeMap，然后获取ketSet，然后将set转成list，这样会超时。
 * 反而使用插入排序不会超时。
 */
public class Problem638 {

    class Data {
        int flower;
        int day;
        Data(int flower, int day) {
            this.flower = flower;
            this.day = day;
        }
    }

    private int arrayMethod(int[] bulbs, int k) {
        int n = bulbs.length;
        Data[] datas = new Data[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            Data data = new Data(bulbs[i], i + 1);

            int j;
            for (j = count - 1; j >= 0; j--) {
                if (data.flower < datas[j].flower) {
                    datas[j + 1] = datas[j];
                } else {
                    break;
                }
            }

            datas[j + 1] = data;
            count++;

            // 右边
            if (j + 2 < n && datas[j + 2] != null && datas[j + 2].flower == data.flower + k + 1) {
                return data.day;
            }

            // 左边
            if (j + 1 > 0 && datas[j].flower == data.flower - k - 1) {
                return data.day;
            }
        }

        return -1;
    }

    /**
     * 二分查找第一个比他大的
     */
    private int binarySearch(List<Data> datas, int size, int wantInsertedValue) {
        int low = 0;
        int high = size - 1;
        while (low <= high) {
            int mid = (low + high) >> 1;
            int midValue = datas.get(mid).flower;
            // 要插入的值跟数组中已有的值不会相等
            if (midValue > wantInsertedValue) {
                if (mid == 0 || datas.get(mid - 1).flower < wantInsertedValue) {
                    return mid;
                }

                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private int listBinaryMethod(int[] bulbs, int k) {
        int n = bulbs.length;
        List<Data> datas = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            Data data = new Data(bulbs[i], i + 1);
            if (datas.isEmpty()) {
                datas.add(data);
                continue;
            }

            int insertIndex = binarySearch(datas, datas.size(), data.flower);
            datas.add(insertIndex, data);

            // 判断右边
            if (insertIndex + 1 < datas.size() && datas.get(insertIndex + 1).flower == data.flower + k + 1) {
                return data.day;
            }

            // 判断左边
            if (insertIndex > 0 && datas.get(insertIndex - 1).flower == data.flower - k - 1) {
                return data.day;
            }
        }

        return -1;
    }

    public int kEmptySlots(int[] bulbs, int k) {
//        return arrayMethod(bulbs, k);
        return listBinaryMethod(bulbs, k);
    }
    
    public static void main(String[] args) {
//        System.out.println(new Problem638().kEmptySlots(new int[]{1,3,2}, 1));
//        System.out.println(new Problem638().kEmptySlots(new int[]{1,2,3}, 1));
        System.out.println(new Problem638().kEmptySlots(new int[]{6,5,8,9,7,1,10,2,3,4}, 2));
    }
    
}
