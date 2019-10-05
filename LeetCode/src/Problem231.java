public class Problem231 {

    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        System.out.println(new Problem231().isPowerOfTwo(0));
        System.out.println(new Problem231().isPowerOfTwo(16));
        System.out.println(new Problem231().isPowerOfTwo(218));

    }
}
