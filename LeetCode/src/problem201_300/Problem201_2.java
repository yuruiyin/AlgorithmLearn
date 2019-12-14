package problem201_300;

public class Problem201_2 {

    // m和n一起右移，直到m等于n, 记录右移的次数，然后最终有m左移这个次数既是答案。
    // 原因：m要过渡到n，那么右侧不相等的位一定会经历0，因此只要考虑左侧的相同的1（可能没有1）的次数
    public int rangeBitwiseAnd(int m, int n) {
        int count = 0;
        while (m != n) {
            m >>>= 1;
            n >>>= 1;
            count++;
        }
        return m << count;
    }

}
