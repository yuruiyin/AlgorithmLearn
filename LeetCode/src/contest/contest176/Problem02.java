package contest.contest176;

import java.util.ArrayList;
import java.util.List;

public class Problem02 {

    class ProductOfNumbers {

        private List<Integer> preMultiList;

        public ProductOfNumbers() {
            preMultiList = new ArrayList<>();
            preMultiList.add(1);
        }

        public void add(int num) {
            if (num == 0) {
                preMultiList = new ArrayList<>();
                preMultiList.add(1);
            } else {
                preMultiList.add(preMultiList.get(preMultiList.size() - 1) * num);
            }
        }

        public int getProduct(int k) {
            if (preMultiList.size() <= k) {
                return 0;
            }
            return preMultiList.get(preMultiList.size() - 1) / preMultiList.get(preMultiList.size() - k - 1);
        }
    }

}
