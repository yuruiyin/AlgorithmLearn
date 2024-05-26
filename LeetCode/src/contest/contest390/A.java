package contest.contest390;

public class A {

    private boolean isOk(String str) {
        int[] countArr = new int[26];
        for (char c : str.toCharArray()) {
            countArr[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (countArr[i] > 2) {
                return false;
            }
        }
        return true;
    }

    public int maximumLengthSubstring(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length;
        int max = 2;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                String sub = s.substring(i, j + 1);
                if (isOk(sub)) {
                    max = Math.max(max, sub.length());
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
