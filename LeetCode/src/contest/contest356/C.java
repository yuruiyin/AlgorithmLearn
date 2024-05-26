package contest.contest356;

public class C {

    private String[] arr;
    private String ans;

    private int maxLen;

    private boolean isOk(StringBuilder sb) {
        String str = sb.toString();
        return str.contains(arr[0]) && str.contains(arr[1]) && str.contains(arr[2]);
    }

    private void dfs(StringBuilder tmpSb) {
        if (tmpSb.length() > maxLen) {
            return;
        }

        if (isOk(tmpSb)) {
            if (ans == null) {
                ans = tmpSb.toString();
            } else {
                if (tmpSb.length() > ans.length()) {
                    return;
                } else if (tmpSb.length() == ans.length()) {
                    if (tmpSb.toString().compareTo(ans) < 0) {
                        ans = tmpSb.toString();
                    }
                } else {
                    ans = tmpSb.toString();
                }
            }
            return;
        }

        for (int i = 0; i < 3; i++) {
            if (tmpSb.toString().contains(arr[i])) {
                continue;
            }
            String targetStr = arr[i];
            for (int j = 1; j < tmpSb.length(); j++) {
                String endStr = tmpSb.substring(j);
                if (arr[i].startsWith(endStr)) {
                    targetStr = arr[i].substring(endStr.length());
                    break;
                }
            }
            tmpSb.append(targetStr);
            dfs(tmpSb);
            tmpSb.delete(tmpSb.length() - targetStr.length(), tmpSb.length());
        }
    }

    public String minimumString(String a, String b, String c) {
        arr = new String[]{a, b, c};
        maxLen = a.length() + b.length() + c.length();
        dfs(new StringBuilder());
        return ans;
    }

}
