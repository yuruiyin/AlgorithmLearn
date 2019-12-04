package problem601_700;

import java.util.Arrays;

public class Problem621 {

    public int leastInterval(char[] tasks, int n) {
        int[] countArr = new int[26];
        for (char task : tasks) {
            countArr[task - 'A']++;
        }

        Arrays.sort(countArr);
        int maxCount = countArr[25];
        int ansCount = (maxCount - 1) * (n + 1) + 1; // A->X->X->A->X->X->A (假设n=2，X可以是其它任务或者待命)
        int i = 24;
        while (i >= 0 && countArr[i] == maxCount) { // 只有个数等于最大个数才需要加1，如A->B->X->A->B->X->A->B
            ansCount++;
            i--;
        }

        return Math.max(ansCount, tasks.length);  // 如AAABBBCCCD,n = 2,通过以上计算结果为9，ABCABCABC, 漏可一个D，因此需要补上。
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem621().leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 0));
    }

}
