package doubleContest.round08;

public class Problem01 {

    public int countLetters(String s) {
        int len = s.length();
        int ans = 0;
        for (int i = 0; i < len; i++) {
            int count = 1;
            for (int j = i + 1; j < len; j++) {
                if (s.charAt(j) == s.charAt(j-1)) {
                    count++;
                } else {
                    break;
                }
            }
            ans += count;
        }

        return ans;
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem01().countLetters("aaaba"));
        System.out.println(new Problem01().countLetters("aaaaaaaaaa"));
    }
}

//输入： "aaaba"
//        输出： 8
//        解释：
//        只含单一字母的子串分别是 "aaa"， "aa"， "a"， "b"。
//        "aaa" 出现 1 次。
//        "aa" 出现 2 次。
//        "a" 出现 4 次。
//        "b" 出现 1 次。
//        所以答案是 1 + 2 + 4 + 1 = 8。
//        示例 2:
//
//        输入： "aaaaaaaaaa"
//        输出： 55