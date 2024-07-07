package contest.contest405;

public class A {

    public String getEncryptedString(String s, int k) {
        char[] arr = s.toCharArray();
        int len = arr.length;
        char[] oldArr = new char[len];
        System.arraycopy(arr, 0, oldArr, 0, len);

        for (int i = 0; i < len; i++) {
            arr[i] = oldArr[(i + k) % len];
        }

        return new String(arr);
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
