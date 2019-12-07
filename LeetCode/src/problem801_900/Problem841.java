package problem801_900;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem841 {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> roomSet = new HashSet<>();
        Set<Integer> keySet = new HashSet<>();

        roomSet.add(0);
        List<Integer> firstRoomKeyList = rooms.get(0);
        keySet.addAll(firstRoomKeyList);

        while (!keySet.isEmpty()) {
            roomSet.addAll(keySet);
            Set<Integer> newKeySet = new HashSet<>();
            for (Integer key: keySet) {
                List<Integer> nextKeyList = rooms.get(key);
                for (Integer nextKey : nextKeyList) {
                    if (!roomSet.contains(nextKey)) {
                        newKeySet.add(nextKey);
                    }
                }
            }

            if (newKeySet.isEmpty()) {
                break;
            }

            keySet = newKeySet;
        }

        return roomSet.size() == rooms.size();
    }

}
