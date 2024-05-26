package contest.contest389;

public class A {

    public boolean isSubstringPresent(String s) {
        int len = s.length();
        String reverse = (new StringBuilder(s)).reverse().toString();
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                String sub = s.substring(i, j + 1);
                if (reverse.contains(sub)) {
                    return true;
                }
            }
        }
        return false;
    }

}
