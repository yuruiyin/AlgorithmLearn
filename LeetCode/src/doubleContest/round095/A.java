package doubleContest.round095;

public class A {

    public String categorizeBox(int length, int width, int height, int mass) {
//        如果满足以下条件，那么箱子是 "Bulky" 的：
//        箱子 至少有一个 维度大于等于 104 。
//        或者箱子的 体积 大于等于 109 。
//        如果箱子的质量大于等于 100 ，那么箱子是 "Heavy" 的。
//        如果箱子同时是 "Bulky" 和 "Heavy" ，那么返回类别为 "Both" 。
//        如果箱子既不是 "Bulky" ，也不是 "Heavy" ，那么返回类别为 "Neither" 。
//        如果箱子是 "Bulky" 但不是 "Heavy" ，那么返回类别为 "Bulky" 。
//        如果箱子是 "Heavy" 但不是 "Bulky" ，那么返回类别为 "Heavy" 。

        long tiji = (long)length * width * height;
        boolean isBulky = false;
        if (length >= 10000 || width >= 10000 || height >= 10000 || tiji >= 1e9) {
            isBulky = true;
        }
        boolean isHeavy = false;
        if (mass >= 100) {
            isHeavy = true;
        }

        if (isBulky && isHeavy) {
            return "Both";
        }

        if (!isBulky && !isHeavy) {
            return "Neither";
        }

        if (isBulky) {
            return "Bulky";
        }

        return "Heavy";
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
