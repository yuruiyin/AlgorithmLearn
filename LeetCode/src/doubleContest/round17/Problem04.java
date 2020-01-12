package doubleContest.round17;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem04 {

    public int distinctEchoSubstrings(String text) {
        Set<String> set = new HashSet<>();
        char[] arr = text.toCharArray();
        int len = arr.length;

        for (int i = 0; i < len - 1; i++) {
            int count = 1;
            while (i + 2 * count - 1 < len) {
                boolean isEqual = true;
                for (int j = 0; j < count; j++) {
                    if (arr[i+j] != arr[i+count+j]) {
                        isEqual = false;
                        break;
                    }
                }

                if (isEqual) {
                    set.add(text.substring(i, i + count));
                }

                count++;
            }
        }
        
        return set.size();
    }

    public static String getStr() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 2000; i++) {
            sb.append('a');
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
//        System.out.println(new Problem04().distinctEchoSubstrings(getStr()));
        System.out.println(new Problem04().distinctEchoSubstrings("aaaaaaaaaa"));
        long end = System.currentTimeMillis();
        
        System.out.println("耗时：" + (end - start) + "ms");
    }

}

//    给你一个字符串 text ，请你返回满足下述条件的 不同 非空子字符串的数目：这些子字符串可以写成某个字符串与其自身的串联。
//
//
//
//        示例 1：
//
//        输入：text = "abcabcabc"
//        输出：3
//        解释：3 个子字符串分别为 "abcabc" ， "bcabca" 和 "cabcab" 。
//        示例 2：
//
//        输入：text = "leetcodeleetcode"
//        输出：2
//        解释：2 个子字符串为 "ee" 和 "leetcodeleetcode" 。
//
//
//        提示：
//
//        1 <= text.length <= 2000
//        text 只包含小写英文字母。
