package problem1101_1200;

public class Problem1185 {

    private boolean isRun(int year) {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }

    public String dayOfTheWeek(int day, int month, int year) {
        int today = 1; // 2019-10-28

        String[] week = new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        int[] monthDays = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int todayYear = 2019;
        int todayMonth = 10;
        int todayDay = 28;
        int count = 0;

        boolean isBigger = false;
        if (year > todayYear) {
            isBigger = true;
        } else if (year == todayYear && month > todayMonth) {
            isBigger = true;
        } else if (year == todayYear && month == todayMonth && day > todayDay) {
            isBigger = true;
        }

        while (true) {
            if (todayDay == day && todayMonth == month && todayYear == year) {
                break;
            }

            if (isBigger) {
                int dayCount = monthDays[todayMonth - 1];
                if (todayMonth == 2 && todayDay == 28) {
                    todayDay++;
                } else {
                    if (todayDay == dayCount) {
                        todayDay = 1;
                        todayMonth = todayMonth == 12 ? 1 : todayMonth + 1;
                        todayYear = todayMonth == 12 ? todayYear + 1 : todayYear;
                    } else {
                        todayDay++;
                    }
                }
            } else {
                if (todayDay == 1) {
                    todayYear = todayMonth == 1 ? (todayYear - 1) : todayYear;
                    todayMonth = todayMonth == 1 ? 12 : todayMonth - 1;
                    todayDay = monthDays[todayMonth - 1];
                    if (todayMonth == 2 && isRun(todayYear)) {
                        todayDay++;
                    }
                } else {
                    todayDay--;
                }
            }
            count++;
        }

        if (isBigger) {
            return week[(today + count) % 7];
        } else {
            return week[(today + 7 * 3000 - count) % 7];
        }
    }

    public static void main(String[] args) {
        System.out.println(new Problem1185().dayOfTheWeek(27, 10, 2019));
        System.out.println(new Problem1185().dayOfTheWeek(29, 10, 2019));
        System.out.println(new Problem1185().dayOfTheWeek(31, 8, 2019));
        System.out.println(new Problem1185().dayOfTheWeek(18, 7, 1999));
        System.out.println(new Problem1185().dayOfTheWeek(15, 8, 1993));
    }

}
