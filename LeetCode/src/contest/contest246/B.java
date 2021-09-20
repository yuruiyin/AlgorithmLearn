package contest.contest246;

/**
 * A
 *
 * @author: yry
 * @date: 2021/6/20
 */
public class B {

    private int getHour(String time) {
        return Integer.parseInt(time.substring(0, 2));
    }

    private int getMinute(String time) {
        return Integer.parseInt(time.substring(3, 5));
    }

    public int numberOfRounds(String startTime, String finishTime) {
        int startHour = getHour(startTime);
        int startMinute = startHour * 60 + getMinute(startTime);
        int endHour = getHour(finishTime);
        int endMinute = endHour * 60 + getMinute(finishTime);

        int ans = 0;

        if (startMinute > endMinute) {
            // 玩了通宵
            ans += (24 * 60 - startMinute) / 15;
            ans += endMinute / 15;
        } else {
            ans += endMinute / 15 - startMinute / 15 - (startMinute % 15 == 0 ? 0 : 1);
        }

        return Math.max(0, ans);

    }

    public static void main(String[] args) {
        System.out.println("hello");
    }

}
