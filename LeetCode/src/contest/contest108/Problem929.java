package contest.contest108;

import java.util.HashSet;
import java.util.Set;

public class Problem929 {

    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();

        for (String e : emails) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < e.length(); i++) {
                char c = e.charAt(i);
                if (c == '@') {
                    sb.append(e.substring(i));
                    break;
                }

                if (c == '.') {
                    continue;
                }

                if (c == '+') {
                    for (int j = i + 1; j < e.length(); j++) {
                        if (e.charAt(j) == '@') {
                            sb.append(e.substring(j));
                            break;
                        }
                    }
                    break;
                }

                sb.append(c);
            }
            set.add(sb.toString());
        }

        return set.size();
    }

}
