package contest.contest360;

public class A {

    public int furthestDistanceFromOrigin(String moves) {
        char[] arr = moves.toCharArray();
        int len = arr.length;
        int lCount = 0;
        int rCount = 0;
        for (int i = 0; i < len; i++) {
            if (arr[i] == 'L') {
                lCount++;
            } else if (arr[i] == 'R') {
                rCount++;
            }
        }

        return Math.max(len - lCount - lCount, len - rCount - rCount);
    }

    public static void main(String[] args) {
        System.out.println("hello wolrd");
    }

}
