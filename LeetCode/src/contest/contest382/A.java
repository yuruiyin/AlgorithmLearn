package contest.contest382;

public class A {

    public int countKeyChanges(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length;
        int ans = 0;
        for (int i = 1; i < len; i++) {
            if (Character.toLowerCase(arr[i]) != Character.toLowerCase(arr[i - 1])) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
