package contest.contest420;

import java.util.ArrayList;
import java.util.List;

public class A {

    private char nextChar(char c) {
        return c == 'z' ? 'a' : (char) (c + 1);
    }

    public List<String> stringSequence(String target) {
        List<String> ansList = new ArrayList<>();
        String pre = "";
        for (char c : target.toCharArray()) {
            for (char tmpC = 'a'; tmpC <= c; ) {
                ansList.add(pre + tmpC);
                if (tmpC == c) {
                    break;
                }
                tmpC = nextChar(tmpC);
            }

            pre = pre + c;

        }

        return ansList;
    }

}
