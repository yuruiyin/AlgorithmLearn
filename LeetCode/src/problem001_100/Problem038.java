package problem001_100;

public class Problem038 {

    public String countAndSay(int n) {
        StringBuilder sb = new StringBuilder("1");
        while ((--n) > 0) {
            StringBuilder tmpSb = new StringBuilder();
            int count = 1;
            int len = sb.length();

            if (len == 1) {
                tmpSb.append("11");
                sb = tmpSb;
                continue;
            }

            for (int i = 1; i < len; i++) {
                char curChar = sb.charAt(i);
                char prevChar = sb.charAt(i-1);
                if (curChar!= prevChar) {
                    tmpSb.append(count);
                    tmpSb.append(prevChar);
                    count = 1;
                } else {
                    count++;
                }
            }

            tmpSb.append(count);
            tmpSb.append(sb.charAt(len - 1));

            sb = tmpSb;
        }

        return sb.toString();
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem038().countAndSay(1));
        System.out.println(new Problem038().countAndSay(2));
        System.out.println(new Problem038().countAndSay(3));
        System.out.println(new Problem038().countAndSay(4));
        System.out.println(new Problem038().countAndSay(5));

    }
    
}
