package contest.contest262;

import utils.TreeMultiSet;

import java.util.TreeMap;
import java.util.TreeSet;

/**
 * A
 *
 * @author: yry
 * @date: 2021/10/10
 */
public class C {

    class StockPrice {

        private TreeMap<Integer, Integer> time2PriceMap;
        private TreeMultiSet<Integer> priceSet;

        public StockPrice() {
            time2PriceMap = new TreeMap<>();
            priceSet = new TreeMultiSet<>();
        }

        public void update(int timestamp, int price) {
            if (time2PriceMap.containsKey(timestamp)) {
                priceSet.remove(time2PriceMap.get(timestamp));
            }
            priceSet.add(price);
            time2PriceMap.put(timestamp, price);
        }

        public int current() {
            return time2PriceMap.lastEntry().getValue();
        }

        public int maximum() {
            return priceSet.last();
        }

        public int minimum() {
            return priceSet.first();
        }
    }


}
