package contest.contest355;

import java.util.ArrayList;
import java.util.List;

public class A {

    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> ansList = new ArrayList<>();
        for (String w: words) {
            String[] arr = w.split("\\" + separator);
            for (String str : arr) {
                if (str.isEmpty()) {
                    continue;
                }
                System.out.println(str);
                ansList.add(str);
            }
        }
        return ansList;
    }

    public static void main(String[] args) {
        char separator = '.';
        String[] arr = "one.two.three".split("\\" + separator);
        for (String str : arr) {
            System.out.println(str);
        }
//        System.out.println("hello world");
    }

}
