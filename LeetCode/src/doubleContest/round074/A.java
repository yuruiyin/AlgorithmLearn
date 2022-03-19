package doubleContest.round074;

/**
 * A
 *
 * @author: yry
 * @date: 2022/3/19
 */
public class A {

    public boolean divideArray(int[] nums) {
        int[] countArr = new int[501];
        for (int num : nums) {
            countArr[num]++;
        }

        for (int i = 1; i<= 500; i++) {
            if (countArr[i] == 0) {
                continue;
            }
            if (countArr[i] % 2 == 1) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
