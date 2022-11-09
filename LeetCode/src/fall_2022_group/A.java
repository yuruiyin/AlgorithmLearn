package fall_2022_group;

public class A {

    public int minNumBooths(String[] demand) {
        int m = demand.length;
        int ans = 0;
        int[] countArr = new int[26];
        for (int i = 0; i < m; i++) {
            int[] tmpCountArr = new int[26];
            for (int j = 0; j < demand[i].length(); j++) {
                char c = demand[i].charAt(j);
                tmpCountArr[c - 'a']++;
            }
            for (int j = 0; j < 26; j++) {
                countArr[j] = Math.max(countArr[j], tmpCountArr[j]);
            }
        }
        for (int i  = 0; i < 26; i++) {
            ans += countArr[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
