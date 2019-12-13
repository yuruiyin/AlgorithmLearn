package problem501_600;

public class Problem551 {

    public boolean checkRecord(String s) {
        int countA = 0;
        int continuousLCount = 0;

        for (char c: s.toCharArray()) {
            if (c == 'A') {
                countA++;
                if (countA > 1) {
                    return false;
                }

                continuousLCount = 0;
            } else if (c == 'L') {
                continuousLCount++;
                if (continuousLCount == 3) {
                    return false;
                }
            } else {
                continuousLCount = 0;
            }
        }

        return true;
    }

}
