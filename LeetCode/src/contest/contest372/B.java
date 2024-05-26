package contest.contest372;

public class B {

    public long minimumSteps(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length;
        int preOneCount = 0;
        long ans = 0;
        for (int i = 0; i < len; i++) {
            if (arr[i] == '1') {
                preOneCount++;
            } else {
                ans += preOneCount;
            }
        }
        return ans;
    }

}
