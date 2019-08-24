public class Problem007Java {

    public int reverse(int x) {
        boolean isNegative = x < 0;
        String str = String.valueOf(Math.abs(x));
        String reversedStr = new StringBuilder(str).reverse().toString();

        try {
            int reversedResult = Integer.parseInt(reversedStr);
            return isNegative ? -reversedResult : reversedResult;
        } catch (Exception e) {
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Problem007Java().reverse(-123));
    }

}
