package problem001_100;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class Problem089 {

    private boolean isOneCharDiff(int num1, int num2) {
        int xor = num1 ^ num2;
        return (xor & (xor - 1)) == 0;
    }

    public List<Integer> grayCode(int n) {
        List<Integer> ansList = new ArrayList<>();
        ansList.add(0);

        int maxNum = (1 << n) - 1;

        BitSet bitSet = new BitSet();
        bitSet.set(0);
        while (ansList.size() < maxNum + 1) {
            int lastNum = ansList.get(ansList.size() - 1);
            for (int i = 0; i < n; i++) {
                int value = 1 << i;

                int addValue = lastNum + value;
                if (addValue <= maxNum && !bitSet.get(addValue) && isOneCharDiff(lastNum, addValue)) {
                    ansList.add(addValue);
                    bitSet.set(addValue);
                    break;
                }

                int minusValue = lastNum - value;
                if (minusValue > 0 && !bitSet.get(minusValue) && isOneCharDiff(lastNum, minusValue)) {
                    ansList.add(minusValue);
                    bitSet.set(minusValue);
                    break;
                }
            }
        }

        return ansList;
    }

    public static void main(String[] args) {
        List<Integer> ansList = new Problem089().grayCode(3);

        for (Integer num : ansList) {
            System.out.print(num + ",");
        }
        System.out.println();
    }
    
}
