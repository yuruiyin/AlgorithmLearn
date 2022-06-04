package problem401_500;

import java.util.*;

public class Problem423 {

    public String originalDigits(String s) {
        Map<String, Integer> map = new HashMap<>();
        map.put("zero", 0);
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);
        map.put("seven", 7);
        map.put("eight", 8);
        map.put("nine", 9);
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int[] countArr = new int[26];
        for (char c : s.toCharArray()) {
            countArr[c - 'a']++;
        }
        while (!map.keySet().isEmpty()) {
            boolean isAllZero = true;
            for (int i = 0; i < 26; i++) {
                if (countArr[i] != 0) {
                    isAllZero = false;
                    break;
                }
            }
            if (isAllZero) {
                break;
            }
            int[] tmpCountArr = new int[26];
            for (String word: map.keySet()) {
                Set<Character> charSet = new HashSet<>();
                for (char c : word.toCharArray()) {
                    charSet.add(c);
                }
                for (char c: charSet) {
                    tmpCountArr[c - 'a']++;
                }
            }

            for (int i = 0; i < 26; i++) {
                char c = (char)(i + 'a');
                if (tmpCountArr[i] == 1) {
                    Iterator<String> iterator = map.keySet().iterator();
                    while (iterator.hasNext()) {
                        String word = iterator.next();
                        if (word.indexOf(c) != -1) {
                            while (countArr[i] != 0) {
                                heap.add(map.get(word));
                                for (char tmpC: word.toCharArray()) {
                                    countArr[tmpC - 'a']--;
                                }
                            }
                            iterator.remove();
                            break;
                        }
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!heap.isEmpty()) {
            sb.append(heap.poll());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
//        System.out.println(new Problem423().originalDigits("owoztneoer"));
        System.out.println(new Problem423().originalDigits("zerozero"));
    }

}
