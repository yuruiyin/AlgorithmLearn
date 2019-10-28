package contest.contest154;

public class Problem01 {

    public int maxNumberOfBalloons(String text) {
        int[] count = new int[26];

        for (int i= 0; i < text.length(); i++) {
            char c = text.charAt(i);
            count[c - 'a']++;
        }

        int bCount = count['b' - 'a'];
        int aCount = count['a' - 'a'];
        int lCount = count['l' - 'a'] / 2;
        int oCount = count['o' - 'a'] / 2;
        int nCount = count['n' - 'a'];

        return Math.min(Math.min(aCount, bCount), Math.min(lCount, Math.min(oCount, nCount)));
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem01().maxNumberOfBalloons("nlaebolko"));
        System.out.println(new Problem01().maxNumberOfBalloons("loonbalxballpoon"));
        System.out.println(new Problem01().maxNumberOfBalloons("leetcodess"));
    }
}
