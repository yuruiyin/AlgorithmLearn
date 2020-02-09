package contest.contest121;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem981 {

    class TimeMap {

        class ValueData {
            String value;
            int timestamp;
            ValueData(String value, int timestamp) {
                this.value = value;
                this.timestamp = timestamp;
            }
        }

        private Map<String, List<ValueData>> map;

        /** Initialize your data structure here. */
        public TimeMap() {
            map = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            if (map.containsKey(key)) {
                map.get(key).add(new ValueData(value, timestamp));
                return;
            }

            List<ValueData> list = new ArrayList<>();
            list.add(new ValueData(value, timestamp));

            map.put(key, list);
        }

        private String find(List<ValueData> list, int timestamp) {
            int size = list.size();
            int low = 0;
            int high = size - 1;
            while (low <= high) {
                int mid = (low + high) >>> 1;
                ValueData midData = list.get(mid);
                if (midData.timestamp <= timestamp) {
                    if (mid == size - 1 || list.get(mid + 1).timestamp > timestamp) {
                        return list.get(mid).value;
                    }

                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

            return "";
        }

        public String get(String key, int timestamp) {
            List<ValueData> list = map.getOrDefault(key, null);
            if (list == null) {
                return "";
            }

            return find(list, timestamp);
        }
    }


}

//    创建一个基于时间的键值存储类 TimeMap，它支持下面两个操作：
//
//        1. set(string key, string value, int timestamp)
//
//        存储键 key、值 value，以及给定的时间戳 timestamp。
//        2. get(string key, int timestamp)
//
//        返回先前调用 set(key, value, timestamp_prev) 所存储的值，其中 timestamp_prev <= timestamp。
//        如果有多个这样的值，则返回对应最大的  timestamp_prev 的那个值。
//        如果没有值，则返回空字符串（""）。
