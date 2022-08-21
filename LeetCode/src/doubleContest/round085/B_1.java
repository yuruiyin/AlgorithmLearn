package doubleContest.round085;

public class B_1 {

    public int secondsToRemoveOccurrences(String s) {
        char[] arr = s.toCharArray();
        int ansCount = 0;
        int zeroCount = 0;
        for (char c : arr) {
            if (c == '0') {
                zeroCount++;
            } else if (zeroCount > 0) {
                ansCount = Math.max(ansCount + 1, zeroCount);
            }
        }
        return ansCount;
    }

}
