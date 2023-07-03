package contest.contest343;

public class A {

    public int isWinner(int[] player1, int[] player2) {
        int len1 = player1.length;
        int len2 = player2.length;
        int ans1 = 0;
        boolean hasTen1 = false;
        for (int i = 0; i < len1; i++) {
            if (i == 1 && player1[i - 1] == 10) {
                ans1 += 2 * player1[i];
            } else if (i >= 2 && (player1[i - 1] == 10 || player1[i - 2] == 10)) {
                ans1 += 2 * player1[i];
            } else {
                ans1 += player1[i];
            }
//            if (player1[i] == 10) {
//                hasTen1 = true;
//            }
        }
        int ans2 = 0;
        boolean hasTen2 = false;
        for (int i = 0; i < len2; i++) {
            if (i == 1 && player2[i - 1] == 10) {
                ans2 += 2 * player2[i];
            } else if (i >= 2 && (player2[i - 1] == 10 || player2[i - 2] == 10)) {
                ans2 += 2 * player2[i];
            } else {
                ans2 += player2[i];
            }
//            if (player2[i] == 10) {
//                hasTen2 = true;
//            }
        }
        return ans1 == ans2 ? 0 : (ans1 > ans2 ? 1 : 2);
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
