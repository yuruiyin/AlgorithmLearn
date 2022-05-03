package doubleContest.round76;

public class A {

    public int findClosestNumber(int[] nums) {
        int minDis = Integer.MAX_VALUE;
        int minNum = Integer.MAX_VALUE;
        for (int num : nums) {
            int abs = Math.abs(num);
            if (abs == minDis) {
                if (minNum != Integer.MAX_VALUE) {
                    minNum = Math.max(minNum, num);
                }
            } else if (abs < minDis) {
                minDis = abs;
                minNum = num;
            }
        }
        return minNum;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
