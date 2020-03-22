package problem401_500;

/**
 * Problem408
 *
 * @author: yry
 * @date: 2020/3/20
 */
public class Problem408 {

    public boolean validWordAbbreviation(String word, String abbr) {
        int wordIndex = 0;
        for (int i = 0; i < abbr.length();) {
            if (wordIndex >= word.length()) {
                return false;
            }

            char c = abbr.charAt(i);
            if (Character.isDigit(c)) {
                // 获取数字
                if (c == '0') { // 数字第一位为0是非法的
                    return false;
                }

                int num = 0;
                int j;
                for (j = i; j < abbr.length(); j++) {
                    char tmp = abbr.charAt(j);
                    if (!Character.isDigit(tmp)) {
                        break;
                    }

                    num *= 10;
                    num += tmp - '0';
                }

                if (num == 0 || wordIndex + num > word.length()) {
                    return false;
                }

                wordIndex += num;
                i = j;
            } else {
                if (c != word.charAt(wordIndex)) {
                    return false;
                }
                i++;
                wordIndex++;
            }
        }

        return wordIndex == word.length();
    }

    public static void main(String[] args) {
        System.out.println(new Problem408().validWordAbbreviation("internationalization", "i12iz4n"));
    }

}
