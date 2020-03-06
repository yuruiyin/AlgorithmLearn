package lcci;

public class Lcci0805_1 {

    public int multiply(int A, int B) {
        int min = Math.min(A, B);
        int max = Math.max(A, B);

        if (min == 0) {
            return 0;
        }

        int ans = max;
        int addPart = 0;

        while (min > 1) {
            if ((min & (min - 1)) == 0) {
                // 说明是2的n次方
                while (min > 1) {
                    ans <<= 1;
                    min >>>= 1;
                }
            } else {
                addPart += max;
                min--;
            }
        }

        return ans + addPart;
    }


}
