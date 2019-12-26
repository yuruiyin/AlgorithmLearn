package problem401_500;

public class Problem476_2 {

    public int findComplement(int num) {
        long tmp = 1;
        // 不断右移, 最后用最低的几位全1去和num异或即可
        while (tmp <= num) {
            tmp <<= 1;
        }

        tmp--;
        return (int) tmp ^ num;
    }

}
