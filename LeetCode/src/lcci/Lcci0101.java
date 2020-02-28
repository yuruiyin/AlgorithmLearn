package lcci;

public class Lcci0101 {

    public boolean isUnique(String astr) {
        boolean[] visited = new boolean[128];

        for (char c : astr.toCharArray()) {
            if (visited[c]) {
                return false;
            }
            visited[c] = true;
        }

        return true;
    }

}
