package doubleContest.round138;

public class B {

    public String stringHash(String s, int k) {
        char[] arr = s.toCharArray();
        int len = arr.length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i += k) {
            int hashSum = 0;
            for (int j = i; j < i + k; j++) {
                hashSum += arr[j] - 'a';
            }
            sb.append((char) (hashSum % 26 + 'a'));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("hello");
    }

}
