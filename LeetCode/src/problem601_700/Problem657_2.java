package problem601_700;

public class Problem657_2 {

    public boolean judgeCircle(String moves) {
        // U和D的个数相同，L和R的个数相同
        int[] count = new int['U' - 'D' + 1];
        int len = moves.length();

        for (int i = 0; i < len; i++) {
            char c = moves.charAt(i);
            count[c - 'D']++;
        }

        return count['U' - 'D'] == count[0] && count['L' - 'D'] == count['R' - 'D'];
    }

}
