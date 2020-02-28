package contest.contest177;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Problem01_1 {

    public int daysBetweenDates(String date1, String date2) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        try {
            long diff = Math.abs(sdf.parse(date1).getTime() - sdf.parse(date2).getTime());
            return (int) (diff / 3600 / 1000 / 24);
        } catch (ParseException e) {
            e.printStackTrace();
            return 0;
        }
    }

}
