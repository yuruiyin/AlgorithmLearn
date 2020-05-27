package contest.contest189;

import java.util.Arrays;
import java.util.Comparator;

/**
 * A
 *
 * @author: yry
 * @date: 2020/5/17
 */
public class B {

    public String arrangeWords(String text) {
        String[] arr = text.split(" ");

        Arrays.sort(arr, Comparator.comparingInt(String::length));

        StringBuilder ansSb = new StringBuilder();
        ansSb.append(Character.toUpperCase(arr[0].charAt(0)) + arr[0].substring(1));
        for (int i = 1; i < arr.length; i++) {
            ansSb.append(' ');
            ansSb.append(arr[i].toLowerCase());
        }

        return ansSb.toString();
    }

}
