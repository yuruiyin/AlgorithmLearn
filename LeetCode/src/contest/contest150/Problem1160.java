package contest.contest150;

public class Problem1160 {

    private int[] calcCount(String word) {
        int[] countArr = new int[26];
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            countArr[c - 'a']++;
        }
        return countArr;
    }

    public int countCharacters(String[] words, String chars) {
        int[] countArr = calcCount(chars);

        int ans = 0;
        for (String word : words) {
            int[] curCountArr = calcCount(word);
            boolean isMatch = true;
            for (int i = 0; i < 26; i++) {
                if (curCountArr[i] > countArr[i]) {
                    isMatch = false;
                    break;
                }
            }

            if (isMatch) {
                ans += word.length();
            }
        }

        return ans;
    }
    
    public static void main(String[] args) {

    }
}

//示例 1：
//
//        输入：words = ["cat","bt","hat","tree"], chars = "atach"
//        输出：6
//        解释：
//        可以形成字符串 "cat" 和 "hat"，所以答案是 3 + 3 = 6。
//        示例 2：
//
//        输入：words = ["hello","world","leetcode"], chars = "welldonehoneyr"
//        输出：10
//        解释：
//        可以形成字符串 "hello" 和 "world"，所以答案是 5 + 5 = 10。
//
//
//        提示：
//
//        1 <= words.length <= 1000
//        1 <= words[i].length, chars.length <= 100
//        所有字符串中都仅包含小写英文字母
