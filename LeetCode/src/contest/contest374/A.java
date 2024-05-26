package contest.contest374;

import java.util.*;

public class A {

    public List<Integer> findPeaks(int[] mountain) {
        int len = mountain.length;
        List<Integer> ansList = new ArrayList<>();
        for (int i = 1; i < len - 1; i++) {
            if (mountain[i] > mountain[i - 1] && mountain[i] > mountain[i + 1]) {
                ansList.add(i);
            }
        }
        return ansList;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
