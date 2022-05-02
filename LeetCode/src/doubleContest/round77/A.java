package doubleContest.round77;

public class A {

    public int countPrefixes(String[] words, String s) {
        int ans = 0;
        for (String word: words) {
            if (s.startsWith(word)) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
