import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem539 {

    public int findMinDifference(List<String> timePoints) {
        List<Integer> minuteList = new ArrayList<>();

        for (String time: timePoints) {
            int h = Integer.parseInt(time.substring(0, 2));
            int m = Integer.parseInt(time.substring(3, 5));
            minuteList.add(h * 60 + m);
        }

        Collections.sort(minuteList);

        int size = minuteList.size();
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < size; i++) {
            int diff = minuteList.get(i) - minuteList.get(i - 1);
            if (diff < min) {
                min = diff;
            }
        }

        int firstLastDiff = 1440 - minuteList.get(size - 1) + minuteList.get(0);

        return firstLastDiff < min ? firstLastDiff : min;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("05:31");
        list.add("22:08");
        list.add("00:35");
        System.out.println(new Problem539().findMinDifference(list));
    }
    
}
