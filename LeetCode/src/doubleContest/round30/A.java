package doubleContest.round30;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A
 *
 * @author: yry
 * @date: 2020/7/12
 */
public class A {

    public String reformatDate(String date) {
        String[] arr  = date.split(" ");
        String[] months = new String[] {
                "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"
        };

        Map<String, String> monthMap = new HashMap<>();
        for (int i = 0; i < 12; i++) {
            monthMap.put(months[i], String.format("%02d", i + 1));
        }

        int day = Integer.parseInt(arr[0].substring(0, arr[0].length() - 2));
        return arr[2] + "-" + monthMap.get(arr[1]) + "-" + String.format("%02d", day);
    }

    public static void main(String[] args) {
        System.out.println(new A().reformatDate("12th Jan 2018"));
    }

}
