package doubleContest.round073;

public class A {

    public int mostFrequent(int[] nums, int key) {
        int[] countArr = new int[1001];
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            if (nums[i] == key) {
                countArr[nums[i + 1]]++;
            }
        }

        int maxCount = 0;
        int ansMax = -1;
        for (int i = 1; i <= 1000; i++) {
            if (countArr[i] >= maxCount) {
                maxCount = countArr[i];
                ansMax = i;
            }
        }
        return ansMax;
    }

}
