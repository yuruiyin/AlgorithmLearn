package problem301_400;

import java.util.*;

public class Problem332 {

    private Map<String, List<String>> map;
    private int ticketCount;
    private List<String> ansList;
    private Map<String, Integer> countMap;

    private boolean backTrack(String from, List<String> tmpList, Map<String, Integer> visited) {
        if (tmpList.size() == ticketCount + 1) {
            ansList = new ArrayList<>(tmpList);
            return true;
        }

        if (!map.containsKey(from)) {
            return false;
        }

        for (String to : map.get(from)) {
            String ticket = from + "," + to;
            if (visited.getOrDefault(ticket, 0) >= countMap.get(ticket)) {
                continue;
            }

            visited.put(ticket, visited.getOrDefault(ticket, 0) + 1);
            tmpList.add(to);
            boolean isFound = backTrack(to, tmpList, visited);
            if (isFound) {
                return true;
            }

            tmpList.remove(tmpList.size() - 1);
            visited.put(ticket, visited.get(ticket) - 1);
        }

        return false;
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        map = new HashMap<>();
        ticketCount = tickets.size();
        countMap = new HashMap<>();

        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            if (!map.containsKey(from)) {
                map.put(from, new ArrayList<>());
            }

            map.get(from).add(to);

            String key = from + ',' + to;
            countMap.put(key, countMap.getOrDefault(key, 0) + 1);
        }

        for (String from : map.keySet()) {
            List<String> toList = map.get(from);
            Collections.sort(toList);
        }


        ansList = new ArrayList<>();
        List<String> tmpList = new ArrayList<>();
        tmpList.add("JFK");
        backTrack("JFK", tmpList, new HashMap<>());
        return ansList;
    }

}
