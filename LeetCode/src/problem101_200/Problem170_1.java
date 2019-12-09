package problem101_200;

import java.util.ArrayList;
import java.util.List;

public class Problem170_1 {

    class TwoSum {

        private List<Integer> numList;

        /** Initialize your data structure here. */
        public TwoSum() {
            numList = new ArrayList<>();
        }

        /** Add the number to an internal data structure.. */
        public void add(int number) {
            // 保证list是有序的
            int low = 0;
            int high = numList.size() - 1;
            int addedIndex = low;

            while (low <= high) {
                int mid = (low + high) >>> 1;
                int midVal = numList.get(mid);

                if (number == midVal) {
                    addedIndex = mid;
                    break;
                } else if (number < midVal) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            if (low > high) {
                addedIndex = low;
            }

            numList.add(addedIndex, number);
        }

        /** Find if there exists any pair of numbers which sum is equal to the value. */
        public boolean find(int value) {
            // 因为列表是有序的，因此可以使用双指针
            int left = 0;
            int right = numList.size() - 1;

            while (left < right) {
                int sum = numList.get(left) + numList.get(right);
                if (sum == value) {
                    return true;
                } else if (sum > value) {
                    // 太大
                    right--;
                } else {
                    left++;
                }
            }

            return false;
        }
    }


}
