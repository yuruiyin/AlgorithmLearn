package contest.contest182;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A
 *
 * @author: yry
 * @date: 2020/3/29
 */
public class C {

    class UndergroundSystem {

        class Data {
            int id;
            int t;
            Data(int id, int t) {
                this.id = id;
                this.t = t;
            }
        }

        private Map<String, List<Data>> startIdListMap;
        private Map<String, List<Data>> endIdListMap;

        public UndergroundSystem() {
            startIdListMap = new HashMap<>();
            endIdListMap = new HashMap<>();
        }

        public void checkIn(int id, String stationName, int t) {
            if (!startIdListMap.containsKey(stationName)) {
                startIdListMap.put(stationName, new ArrayList<>());
            }

            startIdListMap.get(stationName).add(new Data(id, t));
        }

        public void checkOut(int id, String stationName, int t) {
            if (!endIdListMap.containsKey(stationName)) {
                endIdListMap.put(stationName, new ArrayList<>());
            }

            endIdListMap.get(stationName).add(new Data(id, t));
        }

        public double getAverageTime(String startStation, String endStation) {
            List<Data> startList = startIdListMap.get(startStation);
            List<Data> endList = endIdListMap.get(endStation);

            double ans = 0;
            int count = 0;
            for (Data start : startList) {
                for (Data end : endList) {
                    if (start.id == end.id) {
                        ans += end.t - start.t;
                        count++;
                        break;
                    }
                }
            }

            return ans / count;

        }
    }

}
