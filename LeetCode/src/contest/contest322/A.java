package contest.contest322;

public class A {

    public boolean isCircularSentence(String sentence) {
        String[] arr = sentence.split(" ");
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            if (arr[i].charAt(arr[i].length() - 1) != arr[i + 1].charAt(0)) {
                return false;
            }
        }
        return arr[len - 1].charAt(arr[len - 1].length() - 1) == arr[0].charAt(0);
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
