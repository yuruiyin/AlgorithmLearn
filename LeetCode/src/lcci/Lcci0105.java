package lcci;

public class Lcci0105 {

    public boolean oneEditAway(String first, String second) {
        int len1 = first.length();
        int len2 = second.length();
        if (Math.abs(len1 - len2) > 1) {
            return false;
        }

        if (first.equals(second)) {
            return true;
        }

        boolean isLenEqual = len1 == len2;
        for (int i = 0, j = 0; i < len1 && j < len2; ) {
            if (first.charAt(i) == second.charAt(j)) {
                i++;
                j++;
                continue;
            }

            if (isLenEqual) {
                return first.substring(i + 1).equals(second.substring(j + 1));
            }

            if (len1 > len2) {
                // 删除first的当前字符
                return first.substring(i + 1).equals(second.substring(j));
            } else {
                return first.substring(i).equals(second.substring(j+1));
            }
        }

        return true;
    }
    
    public static void main(String[] args) {
        System.out.println(new Lcci0105().oneEditAway("a", "b"));
    }

}
