package contest.contest338;

public class A {

    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        int ans = 0;
        if (k <= numOnes) {
            return k;
        }

        if (k <= numOnes + numZeros) {
            return numOnes;
        }

        return numOnes - (k - numOnes - numZeros);
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
