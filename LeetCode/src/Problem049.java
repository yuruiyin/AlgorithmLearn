import java.util.*;

public class Problem049 {

    private String getSortStr(String str) {
        List<Character> characters = new ArrayList<>();
        int strLen = str.length();
        for (int i = 0; i < strLen; i++) {
            characters.add(str.charAt(i));
        }

        Collections.sort(characters);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strLen; i++) {
            sb.append(characters.get(i));
        }

        return sb.toString();
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str: strs) {
            String sortedStr = getSortStr(str);
            if (!map.containsKey(sortedStr)) {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(sortedStr, list);
            } else {
                map.get(sortedStr).add(str);
            }
        }

        return new ArrayList<>(map.values());
    }
    
    public static void main(String[] args) {
        List<List<String>> ansList = new Problem049().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});

        for (List<String> list: ansList) {
            for (String str: list) {
                System.out.print(str + ",");
            }
            System.out.println();
        }
    }
    
}
