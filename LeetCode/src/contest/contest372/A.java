package contest.contest372;

public class A {

    public int findMinimumOperations(String s1, String s2, String s3) {
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        for (int i = len1 - 1; i >= 0; i--) {
            String str = s1.substring(0, i + 1);
            if (s2.startsWith(str) && s3.startsWith(str)) {
                return len1 + len2 + len3 - str.length() * 3;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
