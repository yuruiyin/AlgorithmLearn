package doubleContest.round131;

public class B {

    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        int[] indexArr = new int[100001];
        int len = nums.length;
        int count = 0;
        for (int i = 0; i< len; i++) {
            if (nums[i] == x) {
                count++;
                indexArr[count] = i;
            }
        }

        int[] ansArr = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int q = queries[i];
            if (q > count) {
                ansArr[i] = -1;
            } else {
                ansArr[i] = indexArr[q];
            }
        }
        return ansArr;
    }

}
