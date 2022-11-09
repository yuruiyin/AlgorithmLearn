package contest.contest316;

public class A {

    public boolean haveConflict(String[] event1, String[] event2) {
        long start1 = Integer.parseInt(event1[0].substring(0, 2)) * 60L + Integer.parseInt(event1[0].substring(3, 5));
        long end1 = Integer.parseInt(event1[1].substring(0, 2)) * 60L + Integer.parseInt(event1[1].substring(3, 5));
        long start2 = Integer.parseInt(event2[0].substring(0, 2)) * 60L + Integer.parseInt(event2[0].substring(3, 5));
        long end2 = Integer.parseInt(event2[1].substring(0, 2)) * 60L + Integer.parseInt(event2[1].substring(3, 5));
        for (int i = 0; i <= 1440; i++) {
            if (i >= start1 && i <= end1 && i >= start2 && i <= end2) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new A().haveConflict(new String[]{"01:15","02:00"}, new String[]{"02:00","03:00"}));
        System.out.println("hello world");
    }

}
