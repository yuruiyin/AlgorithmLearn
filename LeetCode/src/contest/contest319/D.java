package contest.contest319;

public class D {
    
    private boolean isPalindrome(char[] arr, int left, int right) {
        while (left < right) {
            if (arr[left] != arr[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public int maxPalindromes(String s, int k) {
        char[] arr = s.toCharArray();
        int len = arr.length;
        int ans = 0;
        int l = 0;
        for (int i = k - 1; i < len;) {
            int end = i - k + 1;
            boolean isFound = false;
            for (int left = Math.max(l , i - k); left <= end; left++) {
                if (isPalindrome(arr, left, i)) {
                    ans++;
                    l = i + 1;
                    i += k;
                    isFound = true;
                    break;
                }
            }
            if (!isFound) {
                i++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
//        System.out.println(new D().maxPalindromes("abaccdbbd", 3));
        long start = System.currentTimeMillis();
//        String str = "a".repeat(666) + "bc" + "a".repeat(666) + "de" + "a".repeat(666);
        String str = "a".repeat(665) + "bc" + "a".repeat(665) + "de" + "a".repeat(665);
        System.out.println(str);
        System.out.println(new D().maxPalindromes(str, 1000));
//        System.out.println(new D().maxPalindromes("abcd".repeat(500), 1000));
        System.out.println("time cost: " + (System.currentTimeMillis() - start));

    }

}
