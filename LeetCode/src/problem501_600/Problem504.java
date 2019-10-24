package problem501_600;

public class Problem504 {

    public String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }

        int originNum = num;
        StringBuilder sb = new StringBuilder();

        num = Math.abs(num);
        while (num > 0) {
            sb.append(num % 7);
            num /= 7;
        }

        if (originNum < 0) {
            sb.append('-');
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new Problem504().convertToBase7(100));
        System.out.println(new Problem504().convertToBase7(-7));
    }


}
