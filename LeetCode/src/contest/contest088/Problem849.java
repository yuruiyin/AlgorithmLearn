package contest.contest088;

public class Problem849 {

    public int maxDistToClosest(int[] seats) {
        int len = seats.length;

        int maxZeroCount = 0;
        int maxZeroStart = -1;
        int maxZeroEnd = -1;
        int zeroCount = 0;

        int zeroStart = -1;
        int zeroEnd = -1;

        for (int i = 0; i < len; i++) {
            if (seats[i] == 0) {
                if (zeroCount == 0) {
                    zeroStart = i;
                }
                zeroCount++;
            } else {
                if (zeroCount != 0) {
                    zeroEnd = i - 1;
                    if (zeroCount > maxZeroCount) {
                        maxZeroCount = zeroCount;
                        maxZeroStart = zeroStart;
                        maxZeroEnd = zeroEnd;
                    }
                    zeroCount = 0;
                }
            }
        }

        if (zeroCount > maxZeroCount) {
            maxZeroCount = zeroCount;
            maxZeroEnd = len - 1;
        }

        if (maxZeroStart == 0 || maxZeroEnd == len - 1) {
            return maxZeroCount;
        }

        int startZeroCount = 0;
        if (seats[0] == 0) {
            for (int i = 0; i < len; i++) {
                if (seats[i] == 1) {
                    break;
                } else {
                    startZeroCount++;
                }
            }
        }

        int endZeroCount = 0;
        if (seats[len - 1] == 0) {
            for (int i = len - 1; i >= 0; i--) {
                if (seats[i] == 1) {
                    break;
                } else {
                    endZeroCount++;
                }
            }
        }

        return Math.max(Math.max(startZeroCount, endZeroCount), (maxZeroCount + 1) / 2);
    }

}
