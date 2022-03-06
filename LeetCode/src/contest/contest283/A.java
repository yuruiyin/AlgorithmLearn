package contest.contest283;

import java.util.ArrayList;
import java.util.List;

/**
 * A
 *
 * @author: yry
 * @date: 2022/3/6
 */
public class A {

    public List<String> cellsInRange(String s) {
        // "A1:F1"
        char[] arr = s.toCharArray();
        char col1 = arr[0];
        char row1 = arr[1];
        char col2 = arr[3];
        char row2 = arr[4];

        List<String> ansList = new ArrayList<>();

        for (char c = col1; c <= col2; c++) {
            for (char r = row1; r <= row2; r++) {
                ansList.add(c + "" + r);
            }
        }

        return ansList;
    }
    
    public static void main(String[] args) {
        System.out.println("hello world");
    }
    
}
