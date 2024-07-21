package contest.contest406;

public class A {

    public String getSmallestString(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length;
        String ans = s;
        for (int i = 1; i < len; i++) {
            if ((arr[i] - '0') % 2 == (arr[i - 1] - '0') % 2) {
                String tmpS = s.substring(0, i - 1) + arr[i] + arr[i - 1] + s.substring(i + 1);
                if (tmpS.compareTo(ans) < 0) {
                    ans = tmpS;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new A().getSmallestString("45320"));
    }

}
