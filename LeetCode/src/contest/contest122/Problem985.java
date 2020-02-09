package contest.contest122;

public class Problem985 {

    public int[] sumEvenAfterQueries(int[] arr, int[][] queries) {
        int sum =  0;
        for (int num : arr) {
            if ((num & 1) == 0) {
                sum += num;
            }
        }

        int len = queries.length;

        int[] ans = new int[len];
        int i = 0;
        for (int[] query : queries) {
            int val = query[0];
            int index = query[1];
            int num = arr[index];
            if ((num & 1) == 0) {
                if ((val & 1) == 0) {
                    ans[i] = sum + val;
                } else {
                    ans[i] = sum - num;
                }
            } else {
                if ((val & 1) == 1) {
                    ans[i] = sum + val + num;
                } else {
                    ans[i] = sum;
                }
            }

            sum = ans[i];
            arr[index] += val;
            i++;
        }

        return ans;
    }

}
