package interview_google.round08;

public class Problem405_1 {

    // 通过不断无符号右移（左侧补0）四位来处理，每次要被移动的低4位与1111进行与的操作来获取后四位的值
    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }

        char[] count = "0123456789abcdef".toCharArray();
        int mark = 15;
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            sb.append(count[num & mark]);
            num >>>= 4;
        }

        return sb.reverse().toString();
    }

}
