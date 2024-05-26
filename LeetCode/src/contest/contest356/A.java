package contest.contest356;

public class A {

    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        int count = 0;
        for (int h : hours) {
            if (h >= target) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
