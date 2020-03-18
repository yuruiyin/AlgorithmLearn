package interview_2020;

import java.util.ArrayList;
import java.util.List;

/**
 * A
 *
 * @author: yry
 * @date: 2020/3/17
 */
public class B {

    private static final int MAX = 255;
    private List<String> ansList;
    private int len;
    private String s;

    private boolean isLegal(String numStr) {
        int num = Integer.parseInt(numStr);
        if (numStr.length() > 1 && numStr.charAt(0) == '0') {
            return false;
        }
        return num >= 0 && num <= MAX;
    }

    private String listToStr(List<String> list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size - 1; i++) {
            sb.append(list.get(i));
            sb.append('.');
        }
        sb.append(list.get(size - 1));
        return sb.toString();
    }

    private void backTrack(int idx, List<String> tmpList) {
        if (idx == len) {
            if (tmpList.size() == 4) {
                ansList.add(listToStr(tmpList));
            }
            return;
        }

        if (tmpList.size() >= 4) {
            return;
        }

        int end = Math.min(len - 1, idx + 2);
        StringBuilder sb = new StringBuilder();
        for (int i = idx; i <= end; i++) {
            sb.append(s.charAt(i));
            String str = sb.toString();
            if (isLegal(str)) {
                tmpList.add(str);
                backTrack(i + 1, tmpList);
                tmpList.remove(tmpList.size() - 1);
            }
        }
    }

    public List<String> restoreIpAddresses(String s) {
        ansList = new ArrayList<>();
        this.s = s;
        len = s.length();
        backTrack(0, new ArrayList<>());
        return ansList;
    }

}
