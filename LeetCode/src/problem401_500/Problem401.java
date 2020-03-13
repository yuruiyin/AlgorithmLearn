package problem401_500;

import java.util.ArrayList;
import java.util.List;

public class Problem401 {

    public List<String> readBinaryWatch(int num) {
        List<String> ansList = new ArrayList<>();
        for (int i = Math.min(num, 4); i >= 0; i--) {
            // 小时
            List<Integer> hourList = new ArrayList<>();
            for (int j = 15; j >= 0; j--) {
                if (Integer.bitCount(j) == i) {
                    hourList.add(j);
                }
            }

            // 分钟
            List<Integer> minuteList = new ArrayList<>();
            for (int j = 63; j >= 0; j--) {
                if (Integer.bitCount(j) == num - i) {
                    minuteList.add(j);
                }
            }

            for (Integer hour : hourList) {
                if (hour > 11) {
                    continue;
                }
                String hourStr = String.valueOf(hour);
                for (Integer minute: minuteList) {
                    if (minute > 59) {
                        continue;
                    }
                    String minuteStr = String.format("%02d", minute);
                    ansList.add(hourStr + ":" + minuteStr);
                }
            }
        }

        return ansList;
    }

}
