package contest.contest161;

public class Problem1247 {

    private void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public int minimumSwap(String s1, String s2) {
        int len = s1.length();
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        int ans = 0;

        for (int i = 0; i < len; i++) {
            char c1 = arr1[i];
            char c2 = arr2[i];

            if (c1 == c2) {
                continue;
            }

            boolean hasFound = false;
            for (int j = i+1; j < len; j++) {
                char tmpC1 = arr1[j];
                char tmpC2 = arr2[j];
                if (tmpC1 == tmpC2) {
                    continue;
                }

                if (tmpC2 == c2) {
                    //
                    arr2[j] = c1;
                    hasFound = true;
                    ans++;
                    break;
                }
            }

            if (!hasFound) {
                for (int j = i+1; j < len; j++) {
                    char tmpC1 = arr1[j];
                    char tmpC2 = arr2[j];
                    if (tmpC1 == tmpC2) {
                        continue;
                    }

                    if (tmpC1 == c2) {
                        arr1[j] = c1;
                        ans += 2;
                        hasFound = true;
                        break;
                    }
                }
            }

            if (!hasFound) {
                return -1;
            }
        }

        return ans;
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem1247().minimumSwap("xxyyxyxyxx", "xyyxyxxxyx"));
    }
    
}

//      示例 1：
//
//        输入：s1 = "xx", s2 = "yy"
//        输出：1
//        解释：
//        交换 s1[0] 和 s2[1]，得到 s1 = "yx"，s2 = "yx"。
//        示例 2：
//
//        输入：s1 = "xy", s2 = "yx"
//        输出：2
//        解释：
//        交换 s1[0] 和 s2[0]，得到 s1 = "yy"，s2 = "xx" 。
//        交换 s1[0] 和 s2[1]，得到 s1 = "xy"，s2 = "xy" 。
//        注意，你不能交换 s1[0] 和 s1[1] 使得 s1 变成 "yx"，因为我们只能交换属于两个不同字符串的字符。
//        示例 3：
//
//        输入：s1 = "xx", s2 = "xy"
//        输出：-1
//        示例 4：
//
//        输入：s1 = "xxyyxyxyxx", s2 = "xyyxyxxxyx"
//        输出：4
//
//
//        提示：
//
//        1 <= s1.length, s2.length <= 1000
//        s1, s2 只包含 'x' 或 'y'。
