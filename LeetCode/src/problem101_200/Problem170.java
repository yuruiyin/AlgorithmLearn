package problem101_200;

import java.util.*;

public class Problem170 {

    class TwoSum {

        private List<Integer> numList;

        /** Initialize your data structure here. */
        public TwoSum() {
            numList = new ArrayList<>();
        }

        /** Add the number to an internal data structure.. */
        public void add(int number) {
            numList.add(number);
        }

        /** Find if there exists any pair of numbers which sum is equal to the value. */
        public boolean find(int value) {
            Set<Integer> set = new HashSet<>();
            for (Integer num : numList) {
                if (set.contains(value - num)) {
                    return true;
                }

                set.add(num);
            }

            return false;
        }
    }

}
