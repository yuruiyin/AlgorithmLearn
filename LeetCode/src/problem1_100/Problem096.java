package problem1_100;

public class Problem096 {


    private int getNum(int n, int[] count) {
        if (n == 0 || n == 1) {
            count[n] = 1;
            return count[n];
        }

        int sum = 0;
        for (int i = 0; i <= n - 1; i++) {
            int leftCount = count[i] != 0 ? count[i] : getNum(i, count);
            int rightCount = count[n - i - 1] != 0 ? count[n - i - 1] : getNum(n - i - 1, count);

            sum += leftCount * rightCount;
        }

        count[n] = sum;
        return sum;
    }

    private int getNumIterator(int n) {
        int[] count = new int[n + 1];
        count[0] = 1;
        count[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                count[i] += count[j - 1] * count[i - j];
            }
        }

        return count[n];
    }

    public int numTrees(int n) {
        if (n == 0) {
            return  0;
        }

//        return getNum(n, new int[n + 1]);
        return getNumIterator(n);
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem096().numTrees(1));
        System.out.println(new Problem096().numTrees(2));
        System.out.println(new Problem096().numTrees(3));
        System.out.println(new Problem096().numTrees(4));
        System.out.println(new Problem096().numTrees(5));
    }
    
}
