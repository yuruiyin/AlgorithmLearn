package contest.contest176;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Problem03 {

    public int maxEvents(int[][] events) {
        Arrays.sort(events, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0];
            }
        });

        List<int[]>[] list = new ArrayList[100002];

        for (int[] event : events) {
            int start = event[0];
            if (list[start] == null) {
                list[start] = new ArrayList<>();
            }

            list[start].add(event);
        }

        int ans = 0;
        for (int i = 1; i < 100001; i++) {
            List<int[]> eventList = list[i];
            if (eventList == null) {
                continue;
            }

            int minEnd = Integer.MAX_VALUE;
            int minEndIndex = -1;
            for (int j = 0; j < eventList.size(); j++) {
                int[] event = eventList.get(j);
                if (event[1] < minEnd) {
                    minEnd = event[1];
                    minEndIndex = j;
                }
            }

            ans++;
            eventList.remove(minEndIndex);

            List<int[]> newEventList = new ArrayList<>();
            for (int j = 0; j < eventList.size(); j++) {
                int[] event = eventList.get(j);
                if (event[1] != i) {
                    newEventList.add(event);
                }
            }


            if (newEventList.isEmpty()) {
                continue;
            }
            if (list[i + 1] == null) {
                list[i + 1] = new ArrayList<>();
            }
            list[i + 1].addAll(newEventList);
        }

        return ans;
    }

    private static int[][] createArr() {
        int[][] events = new int[100000][2];
        for (int i = 0; i < 100000; i++) {
            events[i] = new int[]{1, 100000};
        }

        return events;
    }
    
    public static void main(String[] args) {
        int[][] events = createArr();
        System.out.println(new Problem03().maxEvents(events));
    }


}
