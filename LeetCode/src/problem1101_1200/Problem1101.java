package problem1101_1200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Problem1101 {

    public int earliestAcq(int[][] logs, int n) {
        Arrays.sort(logs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        ArrayList<Integer>[] setList = new ArrayList[n];

        for (int[] log: logs) {
            int first = log[1];
            int second = log[2];
            if (setList[first] != null && setList[second] != null) {
                if (setList[first] == setList[second]) {
                    continue;
                }

                // 合并
                if (setList[first].size() > setList[second].size()) {
                    setList[first].addAll(setList[second]);
                    for (Integer num: setList[second]) {
                        setList[num] = setList[first];
                    }
                } else {
                    setList[second].addAll(setList[first]);
                    for (Integer num: setList[first]) {
                        setList[num] = setList[second];
                    }
                }
            } else if (setList[first] != null && setList[second] == null) {
                setList[first].add(second);
                setList[second] = setList[first];
            } else if (setList[first] == null && setList[second] != null) {
                setList[second].add(first);
                setList[first] = setList[second];
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(first);
                list.add(second);
                setList[first] = list;
                setList[second] = list;
            }

            if (setList[0] != null && setList[0].size() == n) {
                return log[0];
            }
        }

        return -1;
    }
    
    public static void main(String[] args) {
        
    }
    
}
