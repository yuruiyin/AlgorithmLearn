package doubleContest.round80;

public class A {

//    它有至少 8 个字符。
//    至少包含 一个小写英文 字母。
//    至少包含 一个大写英文 字母。
//    至少包含 一个数字 。
//    至少包含 一个特殊字符 。特殊字符为："!@#$%^&*()-+" 中的一个。
//    它 不 包含 2 个连续相同的字符（比方说 "aab" 不符合该条件，但是 "aba" 符合该条件）。

    public boolean strongPasswordCheckerII(String password) {
        int len = password.length();
        if (len < 8) {
            return false;
        }

        boolean hasLower = false;
        boolean hasUpper = false;
        boolean hasNumber = false;
        String str = "!@#$%^&*()-+";
        boolean hasInStr = false;
        char[] arr = password.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if (Character.isLowerCase(c)) {
                hasLower = true;
            } else if (Character.isUpperCase(c)) {
                hasUpper = true;
            } else if (c >= '0' && c <= '9') {
                hasNumber = true;
            } else if (str.indexOf(c) != -1) {
                hasInStr = true;
            }
            if (i > 0 && arr[i] == arr[i - 1]) {
                return false;
            }
        }

        return hasLower && hasUpper && hasNumber && hasInStr;
    }

}
