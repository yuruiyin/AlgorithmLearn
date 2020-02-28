package contest.contest177;

public class Problem03 {

    private int[] getAns(int num) {
        int[] arr = new int[]{1, num};
        int end = (int) Math.sqrt(num);
        for (int i = 2; i <= end; i++) {
            if (num % i == 0) {
                arr[0] = i;
                arr[1] = num / i;
            }
        }
        return arr;
    }

    public int[] closestDivisors(int num) {
        int add1 = num + 1;
        int add2 = num + 2;

        int[] arr1 = getAns(add1);
        int[] arr2 = getAns(add2);

        if (Math.abs(arr1[0] - arr1[1]) < Math.abs(arr2[0] - arr2[1])) {
            return arr1;
        }

        return arr2;
    }

}
