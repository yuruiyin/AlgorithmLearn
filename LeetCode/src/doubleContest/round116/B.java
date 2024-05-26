package doubleContest.round116;

public class B {

    public int minChanges(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length;
        int preCount = 1;
        int ans = 0;
        for (int i = 1; i < len; i++) {
            if (arr[i] != arr[i - 1]) {
                if (preCount % 2 == 1) {
                    arr[i] = arr[i] == '0' ? '1' : '0';
                    preCount++;
                    ans++;
                } else {
                    preCount = 1;
                }
            } else {
                preCount++;
            }
        }
        return ans;
    }

}
