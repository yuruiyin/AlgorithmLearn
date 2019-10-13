package problem1201_1300;

import java.util.ArrayList;
import java.util.List;

public class Problem1215 {

    public List<Integer> countSteppingNumbers(int low, int high) {
        List<Integer> ansList = new ArrayList<>();

        List<Integer> lastBitList = new ArrayList<>();
        List<Integer> tmpList = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            if (i == 1) {
                for (int j = 0; j <= 9; j++) {
                    lastBitList.add(j);
                }
                ansList.addAll(lastBitList);
                continue;
            }

            tmpList.clear();
            for (int j = 0; j < lastBitList.size(); j++) {
                int curNum = lastBitList.get(j);
                if (curNum == 0) {
                    continue;
                }

                if (i == 10 && curNum / 1000000000 > 1) {
                    continue;
                }

                int rightDigit = curNum % 10;

                if (rightDigit - 1 >= 0) {
                    int newNum = curNum * 10 + (rightDigit - 1);
                    tmpList.add(newNum);
                    ansList.add(newNum);
                }

                if (rightDigit + 1 < 10) {
                    int newNum = curNum * 10 + (rightDigit + 1);
                    tmpList.add(newNum);
                    ansList.add(newNum);
                }
            }

            lastBitList.clear();
            lastBitList.addAll(tmpList);
        }

//        Collections.sort(ansList);

        int startIndex = 0;
        int endIndex = ansList.size();
        for (int i = 0; i < ansList.size(); i++) {
            if (low <= ansList.get(i)) {
                startIndex = i;
                break;
            }
        }

        for (int i = 0; i < ansList.size(); i++) {
            if (high < ansList.get(i)) {
                endIndex = i;
                break;
            } else if (high == ansList.get(i)) {
                endIndex = i + 1;
                break;
            }
        }

        return ansList.subList(startIndex, endIndex);
    }

    public static void main(String[] args) {

        System.out.println(new Problem1215().countSteppingNumbers(0, 21));

    }
}
