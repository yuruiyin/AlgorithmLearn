package doubleContest.round59;

/**
 * A
 *
 * @author: yry
 * @date: 2021/8/21
 */
public class A {

    public int minTimeToType(String word) {
        char[] arr = word.toCharArray();
        int len = arr.length;
        int cur = 0;
        int ans = 0;
        for (int i = 0; i < len; i++) {
            ans += Math.min(Math.abs((arr[i] - 'a') - cur), Math.abs(Math.min(arr[i] - 'a', cur) + 26 - Math.max(arr[i] - 'a', cur)));
            cur = arr[i] - 'a';
            ans++;
        }

        return ans;
    }
    
    public static void main(String[] args) {
        System.out.println(new A().minTimeToType("bza"));
        System.out.println(new A().minTimeToType("zjpc"));
    }

}
