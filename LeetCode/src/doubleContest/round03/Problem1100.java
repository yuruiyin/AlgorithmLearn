package doubleContest.round03;

public class Problem1100 {

    public int numKLenSubstrNoRepeats(String s, int k) {
        char[] arr = s.toCharArray();
        int len = arr.length;

        if (len < k || k > 26) {
            return 0;
        }

        int ans = 0;
        for (int i = 0; i < len - k + 1; i++) {
            boolean isMatch = true;
            int[] countArr = new int[26];
            for (int j = i; j < i + k; j++) {
                if (countArr[arr[j] - 'a'] > 0) {
                    isMatch = false;
                    break;
                } else {
                    countArr[arr[j] - 'a']++;
                }
            }
            if (isMatch) {
                ans++;
            }
        }

        return ans;
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem1100().numKLenSubstrNoRepeats("havefunonleetcode", 5));
    }
    
}
