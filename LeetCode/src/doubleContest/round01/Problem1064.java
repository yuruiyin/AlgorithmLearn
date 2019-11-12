package doubleContest.round01;

public class Problem1064 {

    public int fixedPoint(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == i) {
                return i;
            }
        }

        return -1;
    }
    
    public static void main(String[] args) {

    }
    
}
