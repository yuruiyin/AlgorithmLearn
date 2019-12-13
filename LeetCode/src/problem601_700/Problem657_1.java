package problem601_700;

public class Problem657_1 {

    public boolean judgeCircle(String moves) {
        // U和D的个数相同，L和R的个数相同
        int uCount = 0;
        int dCount = 0;
        int lCount = 0;
        int rCount = 0;
        int len = moves.length();

        for (int i = 0; i < len; i++) {
            char c = moves.charAt(i);
            switch (c) {
                case 'U':
                    uCount++;
                    break;
                case 'D':
                    dCount++;
                    break;
                case 'L':
                    lCount++;
                    break;
                case 'R':
                    rCount++;
                    break;
            }
        }

        return uCount == dCount && lCount == rCount;
    }

}
