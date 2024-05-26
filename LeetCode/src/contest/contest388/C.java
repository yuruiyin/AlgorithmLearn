package contest.contest388;

import java.util.Arrays;
import java.util.List;

public class C {

    public String[] shortestSubstrings(String[] arr) {
        int len = arr.length;
        String[] ans = new String[len];
        Arrays.fill(ans, "");
        for (int i = 0; i < len; i++) {
            String word = arr[i];
            int wordLen = word.length();
            for (int j = 1; j <= wordLen; j++) {
                String minStr = "z".repeat(j);
                boolean isGFound = false;
                for (int k = 0; k < wordLen - j + 1; k++) {
                    String sub = word.substring(k, k + j);
                    boolean isFound = true;
                    for (int l = 0; l < len; l++) {
                        if (i == l) {
                            continue;
                        }
                        if (arr[l].contains(sub)) {
                            isFound = false;
                            break;
                        }
                    }
                    if (isFound) {
                        isGFound = true;
                        if (sub.compareTo(minStr) <= 0) {
                            minStr = sub;
                        }
                    }
                }
                if (isGFound) {
                    ans[i] = minStr;
                    break;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }

}
