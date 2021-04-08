package doubleContest.round48;

import java.util.HashMap;
import java.util.Map;

/**
 * A
 *
 * @author: yry
 * @date: 2021/3/20
 */
public class B {

    class AuthenticationManager {

        private Map<String, Integer> map;
        private int timeToLive;

        public AuthenticationManager(int timeToLive) {
            map = new HashMap<>();
            this.timeToLive = timeToLive;
        }

        public void generate(String tokenId, int currentTime) {
            map.put(tokenId, currentTime + timeToLive);
        }

        public void renew(String tokenId, int currentTime) {
            if (!map.containsKey(tokenId)) {
                return;
            }

            if (map.get(tokenId) <= currentTime) {
                return;
            }

            map.put(tokenId, currentTime + timeToLive);
        }

        public int countUnexpiredTokens(int currentTime) {
            int count = 0;
            for (String token : map.keySet()) {
                int time = map.get(token);
                if (time > currentTime) {
                    count++;
                }
            }

            return count;
        }
    }

}
