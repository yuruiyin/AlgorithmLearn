package doubleContest.round71;

public class C {

    private int getAns(int startAt, char[] arr, int moveCost, int pushCost) {
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            if (startAt != (arr[i] - '0')) {
                ans += moveCost;
                startAt = arr[i] - '0';
            }
            ans += pushCost;
        }
        return ans;
    }

    public int minCostSetTime(int startAt, int moveCost, int pushCost, int targetSeconds) {
        int minute = targetSeconds / 60;
        int second = targetSeconds % 60;
        if (second <= 39) {
            if (minute == 0) {
                return getAns(startAt, String.valueOf(second).toCharArray(), moveCost, pushCost);
            }
            // 两种方案
            second += 60;
            minute--;
            StringBuilder sb = new StringBuilder();
            if (minute != 0) {
                sb.append(minute);
                sb.append(String.format("%02d", second));
            } else {
                sb.append(second);
            }
            int ans1 = getAns(startAt, sb.toString().toCharArray(), moveCost, pushCost);
            if (minute == 99) {
                return ans1;
            }
            second -= 60;
            minute++;
            StringBuilder sb1 = new StringBuilder();
            sb1.append(minute);
            sb1.append(String.format("%02d", second));
            int ans2 = getAns(startAt, sb1.toString().toCharArray(), moveCost, pushCost);
            return Math.min(ans1, ans2);
        }

        StringBuilder sb = new StringBuilder();
        if (minute != 0) {
            sb.append(minute);
            sb.append(String.format("%02d", second));
        } else {
            sb.append(second);
        }
        return getAns(startAt, sb.toString().toCharArray(), moveCost, pushCost);
    }

    public static void main(String[] args) {
//        1
//        9403
//        9402
//        6008
//        System.out.println(new C().minCostSetTime(1, 2, 1, 600));
        System.out.println(new C().minCostSetTime(1, 9403, 9402, 6008));
    }

}
