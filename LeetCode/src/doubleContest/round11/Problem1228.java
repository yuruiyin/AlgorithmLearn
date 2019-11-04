package doubleContest.round11;

public class Problem1228 {

    public int missingNumber(int[] arr) {
        int absMax = 0;
        int nextIndex = 1;
        for (int i = 1; i < arr.length; i++) {
            int diff = Math.abs(arr[i] - arr[i-1]);

            if (diff > absMax) {
                absMax = diff;
                nextIndex = i;
            }
        }

        return (arr[nextIndex] + arr[nextIndex-1]) / 2;
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem1228().missingNumber(new int[]{5,7,11,13}));
        System.out.println(new Problem1228().missingNumber(new int[]{15,13,12}));
        System.out.println(new Problem1228().missingNumber(new int[]{100,300,400}));
    }
}
