package contest.contest287;

public class A {

    public int convertTime(String current, String correct) {
        int h1 = Integer.parseInt(current.substring(0, 2));
        int m1 = Integer.parseInt(current.substring(3, 5));
        int h2 = Integer.parseInt(correct.substring(0, 2));
        int m2 = Integer.parseInt(correct.substring(3, 5));

        int totalM1 = h1 * 60 + m1;
        int totalM2 = h2 * 60 + m2;
        int ans = 0;

        while (totalM1 < totalM2) {
            if (totalM1 + 60 <= totalM2) {
                totalM1 += 60;
            } else if (totalM1 + 15 <= totalM2) {
                totalM1 += 15;
            } else if (totalM1 + 5 <= totalM2) {
                totalM1 += 5;
            } else {
                totalM1++;
            }
            ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("hello");
    }

}
