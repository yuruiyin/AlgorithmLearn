package problem201_300;

public class Problem248 {

    private int ansCount = 0;
    private char[] dl = new char[]{'0', '1', '6', '8', '9'};
    private char[] dr = new char[]{'0', '1', '9', '8', '6'};
    private String[] ds = new String[]{"", "0", "1", "8"};
    private String low;
    private String high;
    private int lowSize;
    private int highSize;

    // 从中间不断向两边扩散，即从0个或一个字符不断增加在头尾增加中心扩散数
    private void helper(String cur) {
        int curSize = cur.length();
        if (curSize > highSize || curSize == highSize && cur.compareTo(high) > 0) {
            return;
        }

        if (curSize == lowSize && cur.compareTo(low) >= 0 || curSize > lowSize) {
            // cur的第一个字符是0只可能cur就等于0的情况才是合法的
            if (!(curSize > 1 && cur.charAt(0) == '0')) {
                ansCount++;
            }
        }

        // 往头尾各加入一对中心对称数
        for (int i = 0; i < dl.length; i++) {
            helper(dl[i] + cur + dr[i]);
        }
    }

    public int strobogrammaticInRange(String low, String high) {
        this.low = low;
        this.high = high;
        this.lowSize = low.length();
        this.highSize = high.length();

        for (int i = 0; i < ds.length; i++) {
            helper(ds[i]);
        }

        return ansCount;
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem248().strobogrammaticInRange("50", "100"));
        System.out.println(new Problem248().strobogrammaticInRange("90", "8699"));
    }

}
