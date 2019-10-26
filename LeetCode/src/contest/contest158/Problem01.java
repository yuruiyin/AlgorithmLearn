package contest.contest158;

public class Problem01 {

    public int balancedStringSplit(String s) {
        int rSize = 0;
        int lSize = 0;
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'R') {
                rSize++;
            } else {
                lSize++;
            }

            if (rSize == lSize) {
                ans++;
                rSize = 0;
                lSize = 0;
            }
        }

        return ans;
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem01().balancedStringSplit("RLRRLLRLRL"));
        System.out.println(new Problem01().balancedStringSplit("RLLLLRRRLR"));
        System.out.println(new Problem01().balancedStringSplit("LLLLRRRR"));

    }

}
