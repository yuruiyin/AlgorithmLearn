package problem401_500;

import java.util.ArrayList;
import java.util.List;

public class Problem402 {

    private String removePrefixZero(String str) {
        StringBuilder sb = new StringBuilder();
        boolean hasNotZero = false;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c != '0') {
                hasNotZero = true;
            }

            if (hasNotZero) {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    public String removeKdigits(String num, int k) {
        // 判断每个数字前面有多少个数比自己大，达到k则移除这k个比他大的数字即可，
        int n = num.length();

        if (n == 0) {
            return "0";
        }

        List<Integer> willRemoveIndexList = new ArrayList<>();

        for (int i = 1; i < n; i++) {
            char cur = num.charAt(i);
            char prev = num.charAt(i-1);

            if (prev > cur) {
                willRemoveIndexList.add(i-1);
                if (willRemoveIndexList.size() == k) {
                    break;
                }

                //往前找
                for (int j = i - 2; j >= 0; j--) {
                    if (willRemoveIndexList.contains(j)) {
                        continue;
                    }

                    char old = num.charAt(j);
                    if (old <= cur) {
                        break;
                    }

                    willRemoveIndexList.add(j);
                    if (willRemoveIndexList.size() == k) {
                        break;
                    }
                }

                if (willRemoveIndexList.size() == k) {
                    break;
                }
            }
        }

        int willRemoveIndexListSize = willRemoveIndexList.size();
        if (willRemoveIndexListSize < k) {
            int leftCount = k - willRemoveIndexListSize;

            for (int i = n - leftCount; i < n; i++) {
                willRemoveIndexList.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (willRemoveIndexList.contains(i)) {
                continue;
            }
            char c = num.charAt(i);
            sb.append(c);
        }

        String ansStr = removePrefixZero(sb.toString());

        return ansStr.length() == 0 ? "0" : ansStr;
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem402().removeKdigits("1432219", 3));
        System.out.println(new Problem402().removeKdigits("0", 1));
        System.out.println(new Problem402().removeKdigits("0", 0));
        System.out.println(new Problem402().removeKdigits("10200", 1));
        System.out.println(new Problem402().removeKdigits("10", 2));
        System.out.println(new Problem402().removeKdigits("1234567890", 9));
        System.out.println(new Problem402().removeKdigits("1234567890", 10));
        System.out.println(new Problem402().removeKdigits("123456789", 8));


    }

}
