package problem301_400;

public class Problem326_1 {

    public boolean isPowerOfThree(int n) {
        // 其中1162261467为3的19次方
        return n > 0 && 1162261467 % n == 0;
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem326_1().isPowerOfThree(243));
    }

}
