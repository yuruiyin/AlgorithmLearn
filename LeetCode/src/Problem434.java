public class Problem434 {

    public int countSegments(String s) {
        int len = s.length();

        if (len == 0) {
            return 0;
        }

        int sum = 0;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == ' ' && i > 0 && s.charAt(i - 1) != ' ') {
                sum++;
            }
        }

        if (s.charAt(len - 1) != ' ') {
            sum++;
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Problem434().countSegments("Hello, my name is John"));
        System.out.println(new Problem434().countSegments("Hello "));
        System.out.println(new Problem434().countSegments("Hello"));
        System.out.println(new Problem434().countSegments(" Hello"));
        System.out.println(new Problem434().countSegments(""));
        System.out.println(new Problem434().countSegments(" "));
        System.out.println(new Problem434().countSegments("  "));

    }

}
