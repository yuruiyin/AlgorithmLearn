package interview_huawei;

import java.util.*;

public class Problem01 {

    public int findMinDifference(List<String> timePoints) {
        List<Integer> minuteList = new ArrayList<>();

        for (String time: timePoints) {
            int h = Integer.parseInt(time.substring(0, 2));
            int m = Integer.parseInt(time.substring(3, 5));
            minuteList.add(h * 60 + m);
        }

//        Collections.sort(minuteList);

        int size = minuteList.size();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                int diff = Math.abs(minuteList.get(i) - minuteList.get(j));
                if (diff > 720) {
                    diff = 1440 - diff;
                }
                if (diff < min) {
                    min = diff;
                }
            }
        }

        return min;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("05:31");
        list.add("22:08");
        list.add("00:35");
        System.out.println(new Problem01().findMinDifference(list));
    }

}
