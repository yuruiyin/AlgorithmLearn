package contest.contest126;

public class Problem1004 {

    public int longestOnes(int[] a, int k) {
        int n = a.length;

        int left = 0;
        int right = 0;
        int ans = 0;
        int zeroCount = a[0] == 0 ? 1 : 0;

        if (k == 0) {
            while (right < n && a[right] == 0) {
                left++;
                right++;
            }

            if (right == n) {
                // 全0
                return 0;
            }

            while (right < n && a[right] == 1) {
                right++;
            }

            if (right == n) {
                if (right - left > ans) {
                    ans = right - left;
                }
            }
        }

        while (right < n) {
            while (zeroCount <= k && right < n - 1) {
                right++;
                if (a[right] == 0) {
                    zeroCount++;
                }
            }

            if (right == n - 1) {
                if (zeroCount > k) {
                    while (left < right && a[left] != 0) {
                        left++;
                    }
                }
                int diff = right - left + 1;
                if (diff > ans) {
                    ans = diff;
                }
                break;
            }

            int diff = right - left;
            if (diff > ans) {
                ans = diff;
            }

            // zeroCount > k
            while (left < right && a[left] != 0) {
                left++;
            }


        }

        return ans;
    }
    
    public static void main(String[] args) {
//        System.out.println(new Problem1004().longestOnes(new int[]{0,0,0,0}, 6));
//        System.out.println(new Problem1004().longestOnes(new int[]{1,1,1,0,0,0,1,1,1,1,0}, 2));
//        System.out.println(new Problem1004().longestOnes(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3));
//        System.out.println(new Problem1004().longestOnes(new int[]{0,0,0,1}, 4));
        System.out.println(new Problem1004().longestOnes(new int[]{0,0,1,1,1,0,0}, 0));
    }
    
}
