package doubleContest.round109;

import java.util.*;

public class B {

    public String sortVowels(String s) {
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');

        char[] arr = s.toCharArray();
        int len = arr.length;
        char[] ansArr = new char[len];
        List<Character> list = new ArrayList<>();
        Arrays.fill(ansArr, '0');
        for (int i = 0; i < len; i++) {
            if (!set.contains(arr[i])) {
                ansArr[i] = arr[i];
            } else {
                list.add(arr[i]);
            }
        }
        Collections.sort(list);
        int idx = 0;
        for (int i = 0; i < len; i++) {
            if (ansArr[i] == '0') {
                ansArr[i] = list.get(idx++);
            }
        }
        return new String(ansArr);
    }

}
