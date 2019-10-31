package problem1101_1200;

import java.util.ArrayList;

public class Problem1153 {

    public boolean canConvert(String str1, String str2) {
        //  两个相等的字符要变成两个不等的字符，不成立
        //  如果str1和str2不相等的前提下，str2包含了所有的26个英文小写字母，那么str1就无法变成str2.

        int len = str1.length();

        if (str1.equals(str2)) {
            return true;
        }

        ArrayList<Integer>[] indexArr1 = new ArrayList[26];
        ArrayList<Integer>[] indexArr2 = new ArrayList[26];

        for (int i = 0; i < 26; i++) {
            indexArr1[i] = new ArrayList<>();
            indexArr2[i] = new ArrayList<>();
        }

        for (int i = 0; i < len; i++) {
            indexArr1[str1.charAt(i) - 'a'].add(i);
            indexArr2[str2.charAt(i) - 'a'].add(i);
        }

        boolean hasAllLetter = true;
        for (int i = 0; i < 26; i++) {
            if (indexArr2[i].isEmpty()) {
                hasAllLetter = false;
                break;
            }
        }

        if (hasAllLetter) {
            return false;
        }

        for (int i = 0; i < 26; i++) {
            ArrayList<Integer> curCharIndexList = indexArr1[i];
            if (curCharIndexList.isEmpty()) {
                continue;
            }

            char c2 = str2.charAt(curCharIndexList.get(0));

            for (int j = 1; j < curCharIndexList.size(); j++) {
                if (str2.charAt(curCharIndexList.get(j)) != c2) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Problem1153().canConvert("abcdefghijklmnopqrstuvwxyz", "bcdefghijklmnopqrstuvwxyza"));
    }

}

//"abcdefghijklmnopqrstuvwxyz"
//        "bcdefghijklmnopqrstuvwxyza"












