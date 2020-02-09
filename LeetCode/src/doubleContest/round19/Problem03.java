package doubleContest.round19;

public class Problem03 {

    public double angleClock(int hour, int minutes) {
        double p = minutes / 60.0;
        double hourFrom = hour / 12.0;
        double diff = Math.abs(p - hourFrom);
        if (diff == 0) {
            return p * 360 / 12;
        }
        if (hourFrom > p) {
            diff += p / 12;
        } else {
            diff -= p / 12;
        }

        diff = Math.abs(diff);

        if (diff > 0.5) {
            return (1 - diff) * 360;
        }

        return diff * 360;
    }

}
