package contest.contest291;

import java.util.*;

public class C {

    class Data {
        int[] arr;
        Data(int[] arr) {
            this.arr = arr;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Data data = (Data) o;
            return Arrays.equals(arr, data.arr);
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(arr);
        }
    }

    public int countDistinct(int[] nums, int k, int p) {
        List<Integer> indexList = new ArrayList<>();
        int len = nums.length;
        Set<Data> set = new HashSet<>();
        for (int i = 0; i < len; i++) {
            if (nums[i] % p == 0) {
                indexList.add(i);
            }
            int size = indexList.size();
            int leftIdx = size - k - 1 < 0 ? 0 : indexList.get(size - k - 1) + 1;
            List<Integer> list = new ArrayList<>();
            for (int j = i; j >= leftIdx; j--) {
                list.add(nums[j]);
                int[] tmpArr = new int[list.size()];
                for (int m = 0; m < list.size(); m++) {
                    tmpArr[m] = list.get(m);
                }
                set.add(new Data(tmpArr));
            }
        }
        return set.size();
    }

    public static void main(String[] args) {
        System.out.println(new C().countDistinct(new int[]{2,3,3,2,2}, 2, 2));
        System.out.println("hello world");
    }

}
