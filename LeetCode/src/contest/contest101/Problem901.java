package contest.contest101;

import java.util.ArrayList;
import java.util.List;

public class Problem901 {

    class StockSpanner {

        private List<Integer> list;
        private List<Integer> dp;

        public StockSpanner() {
            list = new ArrayList<>();
            dp = new ArrayList<>();
        }

        public int next(int price) {
            int size = list.size();
            if (size == 0) {
                list.add(price);
                dp.add(1);
                return 1;
            }

            int ans = 1;
            int prevIndex = size - 1;
            while (prevIndex >= 0 && price >= list.get(prevIndex)) {
                int prevCount = dp.get(prevIndex);
                ans += prevCount;
                prevIndex -= prevCount;
            }

            dp.add(ans);
            list.add(price);
            return ans;
        }
    }

}
