package problem401_500;

public class Problem461_1 {

    public int hammingDistance(int x, int y) {
        int xor = x ^ y;
        return Integer.bitCount(xor);
    }

}
