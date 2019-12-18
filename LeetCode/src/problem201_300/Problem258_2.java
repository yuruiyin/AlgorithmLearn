package problem201_300;

public class Problem258_2 {

    public int addDigits(int num) {
        // 找规律，比如三位整数 n = 100*a + 10*b + c 各位相加之后变成n = a + b + c
        // 二者之差为99a + 9b，也就是差值可以被9整除。说明每次缩小9的倍数，因此就可以使用num%9来判断了

        if (num <= 9) {
            return num;
        }

        num = num % 9;
        if (num == 0) {
            return 9;
        }

        return num;
    }

}
