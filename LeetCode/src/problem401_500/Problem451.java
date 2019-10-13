package problem401_500;

import java.util.*;

public class Problem451 {

    class Data {
        int count;
        char c;
        Data(char c, int count) {
            this.count = count;
            this.c = c;
        }
    }

    class CustomCmp implements Comparator<Data> {

        @Override
        public int compare(Data o1, Data o2) {
            return o2.count - o1.count;
        }
    }

    public String frequencySort(String s) {
        Map<Character, Integer> countMap = new HashMap<>();
        int len = s.length();

        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (!countMap.containsKey(c)) {
                countMap.put(c, 1);
            } else {
                countMap.put(c, countMap.get(c) + 1);
            }
        }

        List<Data> list = new ArrayList<>();

        for (Character c : countMap.keySet()) {
            list.add(new Data(c, countMap.get(c)));
        }

        list.sort(new CustomCmp());
        StringBuilder sb = new StringBuilder();
        for (Data data : list) {
            while (data.count-- > 0) {
                sb.append(data.c);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Problem451().frequencySort("tree"));
        System.out.println(new Problem451().frequencySort("cccaaa"));
        System.out.println(new Problem451().frequencySort("Aabb"));

    }

}
