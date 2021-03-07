package contest.contest220;

import java.util.ArrayList;
import java.util.List;

/**
 * A
 *
 * @author: yry
 * @date: 2020/12/20
 */
public class A {

    public String reformatNumber(String number) {
        char[] arr = number.toCharArray();
        int len = arr.length;
        List<Character> list = new ArrayList<>();
        for (char c : arr) {
            if (c == ' ' || c == '-') {
                continue;
            }
            list.add(c);
        }

        int size = list.size();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i+=3) {
            if (size - i > 4) {
                sb.append(list.get(i));
                sb.append(list.get(i + 1));
                sb.append(list.get(i + 2));
                sb.append('-');
            } else if (size - i == 4) {
                sb.append(list.get(i));
                sb.append(list.get(i + 1));
                sb.append('-');
                sb.append(list.get(i + 2));
                sb.append(list.get(i + 3));
                break;
            } else if (size - i == 3) {
                sb.append(list.get(i));
                sb.append(list.get(i + 1));
                sb.append(list.get(i + 2));
                break;
            } else if (size - i == 2) {
                sb.append(list.get(i));
                sb.append(list.get(i + 1));
                break;
            }
        }

        return sb.toString();
    }

}
