package contest.contest225;

/**
 * A
 *
 * @author: yry
 * @date: 2021/1/24
 */
public class A {

    public String maximumTime(String time) {
        String hh = time.substring(0, 2);
        String mm = time.substring(3);
        if (hh.charAt(0) == '?') {
            char c = hh.charAt(1);
            if (c == '?') {
                hh = "23";
            } else if (c >= '4') {
                hh = "1" + c;
            } else {
                hh = "2" + c;
            }
        } else if (hh.charAt(0) == '2') {
            char c = hh.charAt(1);
            if (c == '?') {
                hh = "23";
            }
        } else {
            char c = hh.charAt(1);
            if (c == '?') {
                hh = hh.charAt(0) + "9";
            }
        }

        if (mm.charAt(0) == '?') {
            char c = mm.charAt(1);
            if (c == '?') {
                mm = "59";
            } else {
                mm = "5" + c;
            }
        } else {
            char c = mm.charAt(1);
            if (c == '?') {
                mm = mm.charAt(0) + "9";
            }
        }

        return hh + ":" + mm;
    }

}
