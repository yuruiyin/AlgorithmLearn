package contest.contest177;

public class Problem01 {

    private boolean isLeap(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }

    public int daysBetweenDates(String date1, String date2) {
        if (date1.equals(date2)) {
            return 0;
        }
        int[] monthDays = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String minDate;
        String maxDate;
        if (date1.compareTo(date2) < 0) {
            minDate = date1;
            maxDate = date2;
        } else {
            minDate = date2;
            maxDate = date1;
        }

        int year1 = Integer.parseInt(minDate.substring(0, 4));
        int year2 = Integer.parseInt(maxDate.substring(0, 4));
        int m1 = Integer.parseInt(minDate.substring(5, 7));
        int m2 = Integer.parseInt(maxDate.substring(5, 7));
        int d1 = Integer.parseInt(minDate.substring(8, 10));
        int d2 = Integer.parseInt(maxDate.substring(8, 10));

        int fromYear = year1;
        int fromM = m1;
        int fromD = d1;

        int i;
        for (i = 0; ; i++) {
            if (fromM == 2) {
                int diff = 0;
                if (isLeap(fromYear)) {
                    diff = 1;
                }

                if (fromD + 1 <= monthDays[fromM - 1] + diff) {
                    fromD++;
                } else {
                    fromM++;
                    fromD = 1;
                }
            } else if (fromM == 12 && fromD == 31) {
                fromYear++;
                fromM = 1;
                fromD = 1;
            } else {
                if (fromD + 1 <= monthDays[fromM - 1]) {
                    fromD++;
                } else {
                    fromM++;
                    fromD = 1;
                }
            }

            if (fromYear == year2 && fromM == m2 && fromD == d2) {
                break;
            }
        }

        return i + 1;
    }

}
