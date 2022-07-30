package doubleContest.round80;

public class C_1 {

    /**
     * 使用数组优化map
     */
    public boolean matchReplacement(String s, String sub, char[][] mappings) {
        char[] sArr = s.toCharArray();
        int sLen = sArr.length;
        char[] subArr = sub.toCharArray();
        int subLen = subArr.length;
        boolean[][] visited = new boolean['z' + 1]['z' + 1];
        for (char[] mapping : mappings) {
            char from = mapping[0];
            char to = mapping[1];
            visited[from][to] = true;
        }

        for (int i = 0; i < sLen && sLen - i >= subLen; i++) {
            boolean isOk = true;
            for (int j = i; j <= i + subLen - 1; j++) {
                if (sArr[j] != subArr[j - i] && !visited[subArr[j - i]][sArr[j]]) {
                    isOk = false;
                    break;
                }
            }
            if (isOk) {
                return true;
            }
        }
        return false;
    }

}
