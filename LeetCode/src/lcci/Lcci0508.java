package lcci;

public class Lcci0508 {

    public int[] drawLine(int length, int w, int x1, int x2, int y) {
        int[] ansArr = new int[length];

        int offset = w * y / 32;
        int index1 = x1 / 32;
        int mod1 = x1 % 32;
        int index2 = x2 / 32;
        int mod2 = x2 % 32;

        while (index1 != index2) {
            for (int i = mod1; i <= 31; i++) {
                ansArr[index1 + offset] |= 1 << (31 - i);
            }
            index1++;
            mod1 = 0;
        }

        for (int i = mod1; i <= mod2; i++) {
            ansArr[index1 + offset] |= 1 << (31 - i);
        }

        return ansArr;
    }

}
