package contest.contest326;

public class C {

    public int minimumPartition(String s, int k) {
        char[] arr = s.toCharArray();
        int len = arr.length;
        long pre = 0;
        int ans = 0;
        for (int i = 0; i < len; i++) {
            char c = arr[i];
            long tmpValue = pre * 10L + (c - '0');
            if (tmpValue > k) {
                ans++;
                pre = (c - '0');
                if (pre > k) {
                    return -1;
                }
            } else {
                pre = tmpValue;
            }
        }
        ans++;
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
