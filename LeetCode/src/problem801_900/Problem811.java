package problem801_900;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem811 {

    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> countMap = new HashMap<>();

        for (String cpdomain : cpdomains) {
            String[] arr = cpdomain.split(" ");
            int count = Integer.parseInt(arr[0]);
            String domain = arr[1];
            countMap.put(domain, countMap.getOrDefault(domain, 0) + count);
            int domainLen = domain.length();
            StringBuilder sb = new StringBuilder();
            for (int i = domainLen - 1; i >= 0; i--) {
                char c = domain.charAt(i);
                if (domain.charAt(i) == '.') {
                    String curDomain = sb.reverse().toString();
                    countMap.put(curDomain, countMap.getOrDefault(curDomain, 0) + count);
                    sb.reverse();
                }
                sb.append(c);
            }
        }

        List<String> ansList = new ArrayList<>();
        for (String domain : countMap.keySet()) {
            ansList.add(countMap.get(domain) + " " + domain);
        }
        return ansList;
    }

}
