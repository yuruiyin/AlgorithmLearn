package contest.contest336;

public class A {

    public int vowelStrings(String[] words, int left, int right) {
        int ans = 0;
        for (int i = left; i <= right; i++) {
            String str = words[i];
            if ((str.charAt(0) == 'a' ||
                    str.charAt(0) == 'e' ||
                    str.charAt(0) == 'i' ||
                    str.charAt(0) == 'o' ||
                    str.charAt(0) == 'u') &&
                    (str.charAt(str.length() - 1) == 'a' ||
                            str.charAt(str.length() - 1) == 'e' ||
                            str.charAt(str.length() - 1) == 'i' ||
                            str.charAt(str.length() - 1) == 'o' ||
                            str.charAt(str.length() - 1) == 'u')) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
