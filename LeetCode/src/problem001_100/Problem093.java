package problem001_100;

import java.util.ArrayList;
import java.util.List;

public class Problem093 {

    private List<String> ansList;

    private void backTrack(String s, int from, List<String> tmpList) {
        int len = s.length();
        if (from == len) {
            if (tmpList.size() == 4) { // ip地址中间三个点
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < 4; i++) {
                    sb.append(tmpList.get(i));
                    if (i < 3) {
                        sb.append('.');
                    }
                }
                ansList.add(sb.toString());
            }
            return;
        }

        if (tmpList.size() == 4) {
            // 已经有4个了，但是后面还有数字没有匹配，说明出错了
            return;
        }

        // 选一位或两位或三位
        for (int i = 1; i <= 3 && from + i <= len; i++) {
            String numStr = s.substring(from, from + i);
            int num = Integer.parseInt(numStr);
            if (i == 3 && num > 255) {
                break;
            }

            if (i >= 2 && numStr.charAt(0) == '0') {
                // 01,00是不合法的
                continue;
            }

            tmpList.add(numStr);
            backTrack(s, from + i, tmpList);
            tmpList.remove(tmpList.size() - 1);
        }

    }

    public List<String> restoreIpAddresses(String s) {
        ansList = new ArrayList<>();
        backTrack(s, 0, new ArrayList<>());
        return ansList;
    }
    
    public static void main(String[] args) {

    }
    
}
