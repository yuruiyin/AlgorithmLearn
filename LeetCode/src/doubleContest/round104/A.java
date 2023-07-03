package doubleContest.round104;

public class A {

    public int countSeniors(String[] details) {
        int ans = 0;
        for (String str : details) {
            int age = Integer.parseInt(str.substring(11, 13));
            if (age > 60) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
