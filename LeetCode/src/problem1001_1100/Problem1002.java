package problem1001_1100;

import java.util.ArrayList;
import java.util.List;

public class Problem1002 {

    public List<String> commonChars(String[] sArr) {
        int len = sArr.length;
        int[][] countArr = new int[len][26];
        for (int i = 0; i < len; i++) {
            String s = sArr[i];
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                countArr[i][c - 'a']++;
            }
        }

        List<String> ansList = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < len; j++) {
                if (countArr[j][i] < min) {
                    min = countArr[j][i];
                }
            }

            if (min > 0) {
                while ((min--) > 0) {
                    char str = (char) (i + 'a');
                    ansList.add(str + "");
                }
            }
        }

        return ansList;
    }
    
    public static void main(String[] args) {
    }
    
}
