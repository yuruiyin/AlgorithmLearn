package problem701_800;

public class Problem771_1 {

    public int numJewelsInStones(String J, String S) {
        boolean[] map = new boolean['z' + 1];
        for (char c: J.toCharArray()) {
            map[c] = true;
        }

        int ans = 0;
        for (char c : S.toCharArray()) {
            if (map[c]) {
                ans++;
            }
        }

        return ans;
    }

}
