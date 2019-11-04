package problem1201_1300;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem1239 {

    private int ansMax = 0;

    private boolean isAllCharDiff(String str) {
        boolean[] count = new boolean[26];

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (count[c - 'a']) {
                return false;
            }
            count[c - 'a'] = true;
        }

        return true;
    }

    private void backTrack(int from, List<String> arr, StringBuilder tmpSb) {
        if (tmpSb.length() > ansMax) {
            ansMax = tmpSb.length();
        }

        if (from == arr.size()) {
            // 最后一个字符串
            return;
        }

        int size = arr.size();
        for (int i = from; i < size; i++) {
            String curStr = arr.get(i);
            int start = tmpSb.length();
            tmpSb.append(curStr);
            if (!isAllCharDiff(tmpSb.toString())) {
                tmpSb.delete(start, tmpSb.length());
                continue;
            }

            backTrack(i + 1, arr, tmpSb);
            tmpSb.delete(start, tmpSb.length());
        }
    }

    public int maxLength(List<String> arr) {
        // 去除数组中字符串有出现多个字符的
        List<String> arr1 = new ArrayList<>();
        for (String str: arr) {
            if (isAllCharDiff(str)) {
                arr1.add(str);
            }
        }

        if (arr1.size() == 0) {
            return 0;
        }

        if (arr1.size() == 1) {
            return arr1.get(0).length();
        }

        backTrack(0, arr1, new StringBuilder());
        return ansMax;
    }
    
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("un","iq","ue"));

        System.out.println(new Problem1239().maxLength(list));
        List<String> list1 = new ArrayList<>(Arrays.asList("cha","r","act","ers"));
        System.out.println(new Problem1239().maxLength(list1));

        List<String> list2 = new ArrayList<>(Arrays.asList("abcdefghijklmnopqrstuvwxyz"));
//        List<String> list2 = new ArrayList<>(Arrays.asList("abcdefghijklmnopqrstuvwxy", "z"));
        System.out.println(new Problem1239().maxLength(list2));
    }
    
}
