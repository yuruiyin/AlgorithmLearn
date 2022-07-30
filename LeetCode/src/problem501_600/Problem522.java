package problem501_600;

import java.util.*;

public class Problem522 {

    private boolean isSubSequence(String str, String subStr) {
        int i, j;
        for (i = 0, j = 0; i < str.length() && j < subStr.length();) {
            if (subStr.charAt(j) == str.charAt(i)) {
                i++;
                j++;
            } else {
                i++;
            }
        }
        return j == subStr.length();
    }

    public int findLUSlength(String[] strs) {
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length() == o1.length() ? o1.compareTo(o2) : o2.length() - o1.length();
            }
        });

        int len = strs.length;
        Set<String> preSet = new HashSet<>();
        for (int i = 0; i < len; i++) {
            String str = strs[i];
            boolean isPreSub = false;
            for (String preStr: preSet) {
                if (isSubSequence(preStr, str)) {
                    isPreSub = true;
                    break;
                }
            }
            if (isPreSub) {
                preSet.add(str);
                continue;
            }
            if (i == len - 1) {
                return str.length();
            }
            if (!str.equals(strs[i + 1])) {
                return str.length();
            }
            preSet.add(str);
        }

        return -1;
    }

    public static void main(String[] args) {
//        System.out.println(new Problem522().findLUSlength(new String[]{"aaa", "acb"}));
//        System.out.println(new Problem522().findLUSlength(new String[]{"aabbcc", "aabbcc","c","e"}));
//        System.out.println(new Problem522().findLUSlength(new String[]{"aabbcc", "aabbcc","bc","bcc","aabbccc"}));
        System.out.println(new Problem522().findLUSlength(new String[]{"a","b","c","d","e","f","a","b","c","d","e","f"}));
//        System.out.println(new Problem522().findLUSlength(new String[]{"aabbcc", "aabbcc","c","e","aabbcd"}));
//        System.out.println(new Problem522().findLUSlength(new String[]{"aaa", "aaa","aa"}));
    }

}
