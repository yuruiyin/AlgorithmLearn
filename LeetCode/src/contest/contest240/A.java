package contest.contest240;

/**
 * A
 *
 * @author: yry
 * @date: 2021/5/9
 */
public class A {

    public int maximumPopulation(int[][] logs) {
        int[] countArr = new int[2051];
        for (int[] log : logs) {
            int s = log[0];
            int e = log[1] - 1;
            for (int i = s; i <= e; i++) {
                countArr[i]++;
            }
        }

        int ansMax = 0;
        int ansMaxYear = -1;
        for (int i = 0; i <= 2050; i++) {
            if (countArr[i] > ansMax) {
                ansMax = countArr[i];
                ansMaxYear = i;
            }
        }

        return ansMaxYear;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
