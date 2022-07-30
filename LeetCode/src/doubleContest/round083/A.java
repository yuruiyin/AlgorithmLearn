package doubleContest.round083;

import java.util.HashSet;
import java.util.Set;

public class A {

//    "Flush"：同花，五张相同花色的扑克牌。
//            "Three of a Kind"：三条，有 3 张大小相同的扑克牌。
//            "Pair"：对子，两张大小一样的扑克牌。
//            "High Card"：高牌，五张大小互不相同的扑克牌。
    public String bestHand(int[] ranks, char[] suits) {
        Set<Character> set = new HashSet<>();
        int[] rankCountArr = new int[14];
        int[] countArr = new int[4];
        for (int i = 0; i < 5; i++) {
            countArr[suits[i] - 'a']++;
            rankCountArr[ranks[i]]++;
        }

        for (int i = 0; i < 4; i++) {
            if (countArr[i] == 5) {
                return "Flush";
            }
        }

        for (int i = 1; i < 14; i++) {
            if (rankCountArr[i] >= 3) {
                return "Three of a Kind";
            }
        }

        for (int i = 1; i < 14; i++) {
            if (rankCountArr[i] >= 2) {
                return "Pair";
            }
        }

        return "High Card";
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
