package contest.contest411;

public class A {

    public int countKConstraintSubstrings(String s, int k) {
        char[] arr = s.toCharArray();
        int len = arr.length;
        int ans = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                int count0 = 0;
                int count1 = 0;
                for (int kk = i; kk <= j; kk++) {
                    if (arr[kk] == '0') {
                        count0++;
                    } else {
                        count1++;
                    }
                }

                if (count0 <= k || count1 <= k) {
                    ans++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
