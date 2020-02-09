package problem301_400;

import java.util.HashMap;
import java.util.Map;

public class Problem359 {

    class Logger {

        private Map<String, Integer> map;

        /** Initialize your data structure here. */
        public Logger() {
            map = new HashMap<>();
        }

        /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
         If this method returns false, the message will not be printed.
         The timestamp is in seconds granularity. */
        public boolean shouldPrintMessage(int timestamp, String message) {
            if (map.containsKey(message) && map.get(message) + 10 > timestamp) {
                return false;
            }

            map.put(message, timestamp);
            return true;
        }
    }

}
