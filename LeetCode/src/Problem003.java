import java.util.HashMap;
import java.util.Map;

public class Problem003 {

    private void removeKeys(Map<Character, Integer> map, String s, int startIndex, int endIndex) {
        for (int i = startIndex; i <= endIndex; i++) {
            Character key = s.charAt(i);
            map.remove(key);
        }
    }

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int len = s.length();
        if (len == 0) {
            return 0;
        }
        int maxLen = 1;
        int jStartIndex = 1;
        int clearStartIndex = 0;
        for (int i = 0; i < len; ) {
            Character iChar = s.charAt(i);
            map.put(iChar, i);
            int j;
            for (j = jStartIndex; j < len; j++) {
                Character curChar = s.charAt(j);
                if (map.containsKey(curChar)) {
                    maxLen = Math.max(maxLen, j - i);
                    i = map.get(curChar) + 1;
                    jStartIndex = j + 1;
                    removeKeys(map, s, clearStartIndex, i - 1);
                    map.put(curChar, j);
                    clearStartIndex = i;
                    break;
                }
                map.put(curChar, j);
            }
            if (j == len) {
                // 说明已经找到尾部，无需再找了
                maxLen = Math.max(maxLen, j - i);
                break;
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int len = new Problem003().lengthOfLongestSubstring("abcabcbb");
        System.out.println(len);
    }

}
