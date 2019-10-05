package interview_tencent.round01;

public class Problem01 {

    public int reverse(int x) {
        String str = String.valueOf(Math.abs(x));

        StringBuilder reversedStr = new StringBuilder();

        int size = str.length();
        for (int i = 0; i < size; i++) {
            reversedStr.append(str.charAt(size - i - 1));
        }

        String resStr = reversedStr.toString();

        try {
            return x < 0 ? -Integer.parseInt(resStr) : Integer.parseInt(resStr);
        } catch (Exception e) {
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Problem01().reverse(123));
        System.out.println(new Problem01().reverse(-123));
        System.out.println(new Problem01().reverse(120));
        System.out.println(new Problem01().reverse((int) -Math.pow(2, 31)));
    }

}
