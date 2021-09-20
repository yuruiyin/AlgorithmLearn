package contest.contest247;

/**
 * A
 *
 * @author: yry
 * @date: 2021/6/27
 */
public class C {

    public long wonderfulSubstrings(String word) {
        char[] arr = word.toCharArray();
        int len = arr.length;
        int preXor = 1 << (arr[0] - 'a');
        long ans = 1;
        int[] countArr = new int[1 << 10];
        countArr[preXor]++;
        for (int i = 1; i < len; i++) {
            preXor ^= 1 << (arr[i] - 'a');
            ans += countArr[preXor];
            if (preXor == 0) {
                ans++;
            }

            for (int j = 0; j < 10; j++) {
                ans += countArr[preXor ^ (1 << j)];
                if ((1 << j) == preXor) {
                    ans++;
                }
            }

            countArr[preXor]++;
        }
        return ans;
    }
    
    public static void main(String[] args) {
//        System.out.println(new C().wonderfulSubstrings("aba"));
        System.out.println(new C().wonderfulSubstrings("fiabhedce"));
    }

}
