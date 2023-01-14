package contest.contest325;

import java.util.ArrayList;
import java.util.List;

public class A {

    public int closetTarget(String[] words, String target, int startIndex) {
        int len = words.length;
        List<Integer> indexList = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (words[i].equals(target)) {
                indexList.add(i);
            }
        }

        if (indexList.isEmpty()) {
            return -1;
        }

        int ansMin = len;

        for (int i : indexList) {
            ansMin = Math.min(ansMin, Math.abs(startIndex - i));
            ansMin = Math.min(ansMin, Math.abs(i + len - startIndex));
            ansMin = Math.min(ansMin, Math.abs(startIndex + len - i));
        }

        return ansMin;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
