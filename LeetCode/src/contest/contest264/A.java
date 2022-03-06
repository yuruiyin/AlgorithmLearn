package contest.contest264;

/**
 * A
 *
 * @author: yry
 * @date: 2021/10/24
 */
public class A {

//    句子仅由小写字母（'a' 到 'z'）、数字（'0' 到 '9'）、连字符（'-'）、标点符号（'!'、'.' 和 ','）以及空格（' '）组成。
//    每个句子可以根据空格分解成 一个或者多个 token ，这些 token 之间由一个或者多个空格 ' ' 分隔。
//
//    如果一个 token 同时满足下述条件，则认为这个 token 是一个有效单词：
//
//    仅由小写字母、连字符和/或标点（不含数字）。
//    至多一个 连字符 '-' 。如果存在，连字符两侧应当都存在小写字母（"a-b" 是一个有效单词，但 "-ab" 和 "ab-" 不是有效单词）。
//    至多一个 标点符号。如果存在，标点符号应当位于 token 的 末尾 。

    private boolean isOk(String word) {
        char[] arr = word.toCharArray();
        int lzfCount = 0;
        int bdCount = 0;
        int lzfIdx = -1;
        int bdIdx = -1;

        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if (!(Character.isLowerCase(c) || (c == '-') || c == '!' || c == '.' || c == ',')) {
                return false;
            }
            if (c == '-') {
                lzfCount++;
                lzfIdx = i;
            } else if (c == '!' || c == '.' || c == ',') {
                bdCount++;
                bdIdx = i;
            }
        }

        if (lzfCount > 1 || bdCount > 1) {
            return false;
        }

        if (lzfCount == 1) {
            if (lzfIdx == 0 || lzfIdx == arr.length - 1) {
                return false;
            }
            if (!(Character.isLowerCase(arr[lzfIdx - 1]) && Character.isLowerCase(arr[lzfIdx + 1]))) {
                return false;
            }
        }

        if (bdCount == 1) {
            if (bdIdx != arr.length - 1) {
                return false;
            }
        }

        return true;
    }

    public int countValidWords(String sentence) {
        String[] wordArr = sentence.trim().split("\\s+");
        int ans = 0;
        for (String word : wordArr) {
            ans += isOk(word) ? 1 : 0;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
