package contest.contest297;

import java.util.*;

public class D {

    public long distinctNames(String[] ideas) {
        List<String>[] suffixListArr = new ArrayList[26];
        Arrays.setAll(suffixListArr, value -> new ArrayList<>());
        Map<String, List<Character>> map = new HashMap<>();
        char[] countArr = new char[26];
        for (String word : ideas) {
            char firstC = word.charAt(0);
            if (word.length() == 1) {
                countArr[firstC - 'a']++;
            } else {
                String suffix = word.substring(1);
                suffixListArr[firstC - 'a'].add(suffix);
                if (!map.containsKey(suffix)) {
                    map.put(suffix, new ArrayList<>());
                }
                map.get(suffix).add(firstC);
            }
        }

        // 后缀相同
        long count = 0;
        for (String suffix : map.keySet()) {
            List<Character> preCharList = map.get(suffix);
            long n = preCharList.size();
            count += (n - 1) * n;
        }

        // 前缀相同
        for (int i = 0; i < 26; i++) {
            List<String> suffixList = suffixListArr[i];
            if (suffixList.isEmpty()) {
                continue;
            }
            long n = suffixList.size();
            count += (n - 1) * n;
        }

        long len = ideas.length;
        return (len - 1) * len - count;
    }

    public static void main(String[] args) {
        System.out.println(new D().distinctNames(new String[]{"coffee","donuts","time","toffee"}));
    }

}
