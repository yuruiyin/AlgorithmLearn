package contest.contest397;

public class A {

    public int findPermutationDifference(String s, String t) {
        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();
        int len = s.length();
        int[] indexArr1 = new int[26];
        int[] indexArr2 = new int[26];
        for (int i = 0; i < len; i++) {
            indexArr1[arr1[i] - 'a'] = i;
            indexArr2[arr2[i] - 'a'] = i;
        }

        int ans = 0;
        for (int i = 0; i < 26; i++) {
            ans += Math.abs(indexArr1[i] - indexArr2[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
