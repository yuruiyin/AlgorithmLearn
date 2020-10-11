package pre03;

/**
 * A
 *
 * @author: yry
 * @date: 2020/9/5
 */
public class D {

    /**
     * @param s: string need to be transformed
     * @param k: minimum char can be transformed in one operation
     * @return: minimum times of transforming all char into '1'
     */
    public int perfectString(String s, int k) {
        // Write your code here.
        char[] arr = s.toCharArray();
        int len = arr.length;
        // 全部变成1

        int ans = 0;

        for (int i = 0; i < len; i++) {
            if (arr[i] == '0') {
                int end = Math.min(len, i + k);
                int j;
                for (j = i; j < end; j++) {
                    if (arr[j] == '1') {
                        break;
                    }
                }

                i = j - 1;
                ans++;
            }
        }

        return ans;
    }
    
    public static void main(String[] args) {
        System.out.println(new D().perfectString("10101", 2));
        System.out.println(new D().perfectString("00000", 3));
        System.out.println(new D().perfectString("100", 1));
        System.out.println(new D().perfectString("01111", 1));
    }

}
