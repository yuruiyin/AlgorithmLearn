package contest.contest350;

public class A {

    public int distanceTraveled(int mainTank, int additionalTank) {
        int ans = 0;
        while (mainTank > 0) {
            if (mainTank < 5) {
                ans += mainTank * 10;
                break;
            } else {
                mainTank -= 5;
                ans += 50;
                if (additionalTank > 0) {
                    additionalTank--;
                    mainTank++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("hello");
    }

}
