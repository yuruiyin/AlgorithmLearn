package spring_2022_group;

public class A {

    public int getMinimumTime(int[] time, int[][] fruits, int limit) {
        int ans = 0;
        for (int[] f: fruits) {
            int type = f[0];
            int num = f[1];
            int count = num / limit + (num % limit == 0 ? 0 : 1);
            ans += time[type] * count;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
