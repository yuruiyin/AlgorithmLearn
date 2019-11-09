package contest.contest139;

public class Problem1071 {

    private boolean canGcd(String str, String subStr) {
        int len = str.length();
        int subLen = subStr.length();

        if (len % subLen != 0) {
            return false;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len / subLen; i++) {
            sb.append(subStr);
        }

        return sb.toString().equals(str);
    }

    public String gcdOfStrings(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        int minLen = Math.min(len1, len2);
        String ansStr = "";
        for (int i = 0; i < minLen; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return "";
            }

            String subStr = str1.substring(0, i + 1);
            if (canGcd(str1, subStr) && canGcd(str2, subStr)) {
                ansStr = subStr;
            }
        }

        return ansStr;
    }
    
    public static void main(String[] args) {

    }
    
}
