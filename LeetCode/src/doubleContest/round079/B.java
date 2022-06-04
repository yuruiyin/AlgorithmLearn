package doubleContest.round079;

import java.util.*;

public class B {

    private int getCount(String str) {
        String[] arr = str.split("\\s+");
        return arr.length;
    }

    class Data {
        String sender;
        int count;
        Data(String sender, int count) {
            this.sender = sender;
            this.count = count;
        }
    }

    public String largestWordCount(String[] messages, String[] senders) {
        int len = messages.length;
        Map<String, Integer> countMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            countMap.put(senders[i], countMap.getOrDefault(senders[i], 0) + getCount(messages[i]));
        }

        List<Data> list = new ArrayList<>();
        for (String key: countMap.keySet()) {
            list.add(new Data(key, countMap.get(key)));
        }

        Collections.sort(list, new Comparator<Data>() {
            @Override
            public int compare(Data o1, Data o2) {
                return o1.count == o2.count ? o2.sender.compareTo(o1.sender) : o2.count - o1.count;
            }
        });

        return list.get(0).sender;
    }

}
