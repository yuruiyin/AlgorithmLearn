package contest.contest184;

import java.util.HashMap;
import java.util.Map;

/**
 * A
 *
 * @author: yry
 * @date: 2020/4/12
 */
public class C {

    public String entityParser1(String text) {
        Map<String, String> map = new HashMap<>();
        map.put("&quot;", "\"");
        map.put("&apos;", "'");
        map.put("&amp;", "&");
        map.put("&gt;", ">");
        map.put("&lt;", "<");
        map.put("&frasl;", "/");

        String ans = text;

        for (String key : map.keySet()) {
            ans = ans.replaceAll(key, map.get(key));
        }

        return ans;
    }

    public String entityParser(String text) {
        String ans = text;
        ans = ans.replaceAll("&quot;", "\"");
        ans = ans.replaceAll("&apos;", "'");
        ans = ans.replaceAll("&gt;", ">");
        ans = ans.replaceAll("&lt;", "<");
        ans = ans.replaceAll("&frasl;", "/");
        ans = ans.replaceAll("&amp;", "&");
        return ans;
    }
    
    public static void main(String[] args) {
        System.out.println();
    }

}
