package contest.contest143;

import utils.PrintUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem1104 {

    public List<Integer> pathInZigZagTree(int label) {
        int level = 1;

        while (Math.pow(2, level) <= label) {
            level++;
        }

        List<Integer> ansList = new ArrayList<>();

        while (level >= 1) {
            ansList.add(label);
            int offset = (int) (Math.pow(2, level) - label);
            label = (int) (Math.pow(2, level - 2) + (offset - 1) / 2);
            level--;
        }

        Collections.reverse(ansList);

        return ansList;
    }

//    public List<Integer> pathInZigZagTree(int label) {
//        int level = 1;
//
//        while ((1 << level) <= label) {
//            level++;
//        }
//
//        List<Integer> ansList = new ArrayList<>();
//
//        while (level >= 1) {
//            ansList.add(label);
//            int offset = (1 << level) - label;
//            label = (1 << (level - 2)) + ((offset - 1) >> 1);
//            level--;
//        }
//
//        Collections.reverse(ansList);
//
//        return ansList;
//    }
    
    public static void main(String[] args) {
        List<Integer> ansList = new Problem1104().pathInZigZagTree(14);
        PrintUtil.printIntList(ansList);

        List<Integer> ansList1 = new Problem1104().pathInZigZagTree(26);
        PrintUtil.printIntList(ansList1);

        List<Integer> ansList2 = new Problem1104().pathInZigZagTree(1);
        PrintUtil.printIntList(ansList2);

        List<Integer> ansList3 = new Problem1104().pathInZigZagTree(16);
        PrintUtil.printIntList(ansList3);
    }
    
}
