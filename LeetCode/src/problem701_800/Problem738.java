package problem701_800;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem738 {

    private int len = 9;
    private List<Integer> numList;

    private void backTrack(int from, int prevNum) {
        numList.add(prevNum);
        if (from == len) {
            return;
        }

        int prevBit = prevNum % 10;
        for (int next = prevBit; next <= 9; next++) {
            backTrack(from + 1, prevNum * 10 + next);
        }
    }

    public int monotoneIncreasingDigits(int n) {
        numList = new ArrayList<>();
        backTrack(0, 0);
        int size = numList.size();
        Collections.sort(numList);
        for (int i = size - 1; i > 0; i--) {
            if (numList.get(i) <= n) {
                return numList.get(i);
            }
        }

        return -1;
    }

}
