package contest.contest407;

public class B {

    public boolean doesAliceWin(String s) {
        char[] chars = new char[]{'a', 'e', 'i', 'o', 'u'};

        char[] arr = s.toCharArray();
        int yCount = 0;
        for (char c : arr) {
            boolean isY = false;
            for (char tmpC : chars) {
                if (c == tmpC) {
                    // 元音
                    isY = true;
                    break;
                }
            }
            if (isY) {
                yCount++;
            }
        }

        return yCount != 0;
    }

}
