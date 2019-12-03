package lcp;

public class Problem02 {

    /**
     * 公司推导-通分
     * @return int[0]-分子，int[1]-分母
     */
    private int[] recursive(int[] count, int index) {
        if (index == count.length - 1) {
            return new int[]{count[index], 1};
        }

        int[] nextRes = recursive(count, index+1);
        return new int[]{count[index] * nextRes[0] + nextRes[1], nextRes[0]};
    }

    public int[] fraction(int[] cont) {
        return recursive(cont, 0);
    }

}
