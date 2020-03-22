/**
 * LintCode1650
 *
 * @author: yry
 * @date: 2020/3/19
 */
public class LintCode1650 {

    public int count(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        String str = s.trim();
        char[] arr = str.toCharArray();
        int len = arr.length;
        int ans = Character.isLetter(arr[0]) && Character.isLowerCase(arr[0]) ? 1 : 0;
        boolean isFirstLetterInSentence = arr[0] == '.';

        for (int i = 1; i < len; i++) {
            if (!Character.isLetter(arr[i])) {
                if (arr[i] == '.') {
                    isFirstLetterInSentence = true;
                }
                continue;
            }

            if (Character.isLetter(arr[i-1])) {
                if (Character.isUpperCase(arr[i])) {
                    ans++;
                }
            } else {
                if (isFirstLetterInSentence && Character.isLowerCase(arr[i])) {
                    ans++;
                }
            }

            isFirstLetterInSentence = false;
        }

        return ans;
    }

}
