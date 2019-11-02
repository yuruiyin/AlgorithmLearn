package problem1101_1200;

public class Problem1118 {

    private boolean isLeap(int year) {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }

    public int numberOfDays(int year, int month) {
        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if (month != 2) {
            return days[month - 1];
        }

        return isLeap(year) ? 29 : 28;
    }
    
    public static void main(String[] args) {

    }
    
}
