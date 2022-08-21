package doubleContest.round085;

public class B {

    public int secondsToRemoveOccurrences(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length;
        int ansCount = 0;
        while (true) {
            boolean isFound = false;
            for (int i = 0; i < len - 1;) {
                if (arr[i] == '0' && arr[i + 1] == '1') {
                    isFound = true;
                    arr[i] = '1';
                    arr[i + 1] = '0';
                    i += 2;
                } else {
                    i++;
                }
            }
            if (!isFound) {
                return ansCount;
            }
            ansCount++;
        }
    }

}
