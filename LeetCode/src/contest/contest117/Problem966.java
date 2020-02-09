package contest.contest117;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Problem966 {

    private long hash(String word) {
        long ans = 0;
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');

        for (char c : word.toCharArray()) {
            ans *= 26;
            if (set.contains(c)) {
                ans += 0;
            } else {
                ans += c - 'a';
            }
        }

        return ans;
    }

    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> set = new HashSet<>();
        Map<String, Integer> ignoreCaseMap = new HashMap<>();
        int wordLen = wordlist.length;
        Map<Long, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < wordLen; i++) {
            set.add(wordlist[i]);
            String ignoreCaseWord = wordlist[i].toLowerCase();
            long hash = hash(ignoreCaseWord);
            if (!hashMap.containsKey(hash)) {
                hashMap.put(hash, i);
            }
            if (!ignoreCaseMap.containsKey(ignoreCaseWord)) {
                ignoreCaseMap.put(ignoreCaseWord, i);
            }
        }

        int queryLen = queries.length;
        String[] ansArr = new String[queryLen];
        for (int i = 0; i < queryLen; i++) {
            String query = queries[i];
            if (set.contains(query)) {
                ansArr[i] = query;
                continue;
            }

            String ignoreCaseWord = query.toLowerCase();
            if (ignoreCaseMap.containsKey(ignoreCaseWord)) {
                ansArr[i] = wordlist[ignoreCaseMap.get(ignoreCaseWord)];
                continue;
            }

            long hash = hash(ignoreCaseWord);
            if (hashMap.containsKey(hash)) {
                ansArr[i] = wordlist[hashMap.get(hash)];
            } else {
                ansArr[i] = "";
            }
        }

        return ansArr;

    }

}
