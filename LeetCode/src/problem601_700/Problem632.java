package problem601_700;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Problem632 {

    class Data {
        int value;
        int index;
        Data(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    class CustomCmp implements Comparator<Data> {

        @Override
        public int compare(Data o1, Data o2) {
            return o1.value - o2.value;
        }
    }

    public int[] smallestRange(List<List<Integer>> nums) {
        int minLen = Integer.MAX_VALUE;
        int[] resInterval = new int[2];
        int size = nums.size();
        int[] firstIndex = new int[size]; // 记录当前每个列表中正在处理的第一个元素的位置
        List<Data> dataList = new ArrayList<>(); // 记录每个列表正在处理的第一个元素的按值升序集合

        for (int i = 0; i < size; i++) {
            int firstValue = nums.get(i).get(0);
            dataList.add(new Data(firstValue, i));
        }

        dataList.sort(new CustomCmp());

        int leftIndex = 0;

        while (true) {
            int minValue = dataList.get(leftIndex).value;
            int maxValue = dataList.get(dataList.size() - 1).value;

            int len = maxValue - minValue;
            if (len < minLen) {
                minLen = len;
                resInterval[0] = minValue;
                resInterval[1] = maxValue;

                if (minLen == 0) {
                    return resInterval;
                }
            }

            int minIndex = dataList.get(leftIndex).index;
            if (firstIndex[minIndex] == nums.get(minIndex).size() - 1) {
                break;
            }
            firstIndex[minIndex]++;

            // 从最小值的地方右移的一位，此时，更新排序好的数组。
//            dataList.remove(leftIndex);
            leftIndex++;
            int value = nums.get(minIndex).get(firstIndex[minIndex]);
            Data wantInsertData = new Data(value, minIndex);

            // 可以二分插入
            int left = leftIndex;
            int right = dataList.size() - 1;
            while (left <= right) {
                if (left == right) {
                    if (wantInsertData.value <= dataList.get(left).value) {
                        dataList.add(left, wantInsertData);
                    } else {
                        dataList.add(left + 1, wantInsertData);
                    }
                    break;
                }

                if (wantInsertData.value >= dataList.get(right).value) {
                    dataList.add(right + 1, wantInsertData);
                    break;
                }

                if (wantInsertData.value <= dataList.get(left).value) {
                    dataList.add(left, wantInsertData);
                    break;
                }

                int mid = (left + right) >>> 1;
                int midValue = dataList.get(mid).value;
                if (wantInsertData.value < midValue) {
                    // 要往左边插入
                    right = mid - 1;
                } else if (wantInsertData.value > midValue) {
                    left = mid + 1;
                } else {
                    dataList.add(mid, wantInsertData);
                    break;
                }
            }
        }

        return resInterval;
    }

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        list1.add(4);
        list1.add(10);
        list1.add(15);
        list1.add(24);
        list1.add(26);

        List<Integer> list2 = new ArrayList<>();
        list2.add(0);
        list2.add(9);
        list2.add(12);
        list2.add(20);

        List<Integer> list3 = new ArrayList<>();
        list3.add(5);
        list3.add(18);
        list3.add(22);
        list3.add(30);

        List<List<Integer>> list = new ArrayList<>();
        list.add(list1);
        list.add(list2);
        list.add(list3);

        int[] resArr = new Problem632().smallestRange(list);

        for (int item : resArr) {
            System.out.print(item + " ");
        }
    }
}
