package doubleContest.round085;

public class A_1 {

    public int minimumRecolors(String blocks, int k) {
        char[] arr = blocks.toCharArray();
        int len = arr.length;
        int wCount = 0;
        for (int i = 0; i < k; i++) {
            if (arr[i] == 'W') {
                wCount++;
            }
        }
        int ansMin = wCount;
        for (int end = k; end < len; end++) {
            if (arr[end - k] == 'W') {
                wCount--;
            }
            if (arr[end] == 'W') {
                wCount++;
            }
            ansMin = Math.min(ansMin, wCount);
        }
        return ansMin;
    }

    public static void main(String[] args) {
        System.out.println("hell");
    }

}
