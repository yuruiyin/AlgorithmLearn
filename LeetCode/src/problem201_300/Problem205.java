package problem201_300;

public class Problem205 {

    public boolean isIsomorphic(String s, String t) {
        int[] map = new int[256];
        int len = s.length();
        boolean[] visited = new boolean[256];

        for (int i = 0; i < len; i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            if (map[sChar] == 0) {
                if (visited[tChar]) {
                    return false;
                }

                map[sChar] = tChar;
                visited[tChar] = true;
            } else if (map[sChar] != tChar) {
                return false;
            }
        }

        return true;
    }

}
