package contest.contest407;

public class C {

    public int maxOperations(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length;
        int ans = 0;
        int preOneCount = 0;
        for (int i = 0; i < len - 1; i++) {
            if (arr[i] == '0' && arr[i + 1] == '1') {
                ans += preOneCount;
            }

            if (arr[i] == '1') {
                preOneCount++;
            }
        }

        if (arr[len - 1] == '0') {
            ans += preOneCount;
        }

        return ans;
    }

}
