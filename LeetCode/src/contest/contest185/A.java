package contest.contest185;

import java.util.ArrayList;
import java.util.List;

/**
 * A
 *
 * @author: yry
 * @date: 2020/4/19
 */
public class A {

    public String reformat(String s) {
        List<Character> numList = new ArrayList<>();
        List<Character> charList = new ArrayList<>();

        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)) {
                charList.add(c);
            } else {
                numList.add(c);
            }
        }

        if (Math.abs(numList.size() - charList.size()) > 1) {
            return "";
        }

        int min = Math.min(numList.size(), charList.size());
        StringBuilder sb = new StringBuilder();


        if (numList.size() > charList.size()) {
            for (int i = 0; i < min; i++) {
                sb.append(numList.get(i));
                sb.append(charList.get(i));
            }
            sb.append(numList.get(min));
        } else if (numList.size() < charList.size()) {
            for (int i = 0; i < min; i++) {
                sb.append(charList.get(i));
                sb.append(numList.get(i));
            }
            sb.append(charList.get(min));
        } else {
            for (int i = 0; i < min; i++) {
                sb.append(charList.get(i));
                sb.append(numList.get(i));
            }
        }

        return sb.toString();
    }

}
