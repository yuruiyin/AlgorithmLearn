package doubleContest.round63;

/**
 * A
 *
 * @author: yry
 * @date: 2021/10/16
 */
public class B {

    public boolean winnerOfGame(String colors) {
        char[] arr = colors.toCharArray();
        int len = arr.length;
        int countA = arr[0] == 'A' ? 1 : 0;
        int countB = arr[0] == 'B' ? 1 : 0;

        int totalCountA = 0;
        int totalCountB = 0;

        for (int i = 1; i < len; i++) {
            if (arr[i] == arr[i - 1]) {
                if (arr[i] == 'A') {
                    countA++;
                } else {
                    countB++;
                }
            } else {
                if (arr[i] == 'A') {
                    // b
                    if (countB >= 3) {
                        totalCountB += countB - 2;
                    }
                    countB = 0;
                    countA = 1;
                } else {
                    // A
                    if (countA >= 3) {
                        totalCountA += countA - 2;
                    }
                    countA = 0;
                    countB = 1;
                }
            }
        }

        if (countA >= 3) {
            totalCountA += countA - 2;
        }

        if (countB >= 3) {
            totalCountB += countB - 2;
        }

        if (totalCountA > totalCountB) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new B().winnerOfGame("AAAABBBB"));
    }

}
