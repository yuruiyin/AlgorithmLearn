package doubleContest.round78;

public class A {

    public int divisorSubstrings(int num, int k) {
        String str = String.valueOf(num);
        int len = str.length();
        int ans =0;
        for (int i = 0; i < len - k + 1; i++) {
            String subStr = str.substring(i, i + k);
            int subNum = Integer.parseInt(subStr);
            if (subNum == 0) {
                continue;
            }
            if (num % subNum == 0) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
