package problem1101_1200;

public class Problem1130 {

    private int[] arr;
    private int[] rightMaxArr; // 当前值右侧最大的值
    private int len;

    private int backTrack(int from) {
        if (from >= len - 1) {
            return 0;
        }

        int res1 = backTrack(from + 1) + rightMaxArr[from] * arr[from];
        int res2 = backTrack(from + 2) + rightMaxArr[from + 1] * Math.max(arr[from], arr[from + 1]) + arr[from] * arr[from + 1];

        return Math.min(res1, res2);
    }

    public int mctFromLeafValues(int[] arr) {
        this.arr = arr;
        len = arr.length;
        rightMaxArr = new int[len];
        rightMaxArr[len - 2] = arr[len - 1];
        for (int i = len - 3; i >= 0; i--) {
            rightMaxArr[i] = Math.max(arr[i+1], rightMaxArr[i+1]);
        }

        return backTrack(0);
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem1130().mctFromLeafValues(new int[]{15,13,5,3,15}));
    }

}
