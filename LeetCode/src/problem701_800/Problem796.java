package problem701_800;

public class Problem796 {

    public boolean rotateString(String s, String goal) {
        if (s.equals(goal)) {
            return true;
        }

        int len = s.length();
        for (int i = 1; i < len; i++) {
            if ((s.substring(i) + s.substring(0, i)).equals(goal)) {
                return true;
            }
        }
        return false;
    }

}
