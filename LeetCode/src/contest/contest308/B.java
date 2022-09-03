package contest.contest308;

public class B {

    public String removeStars(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length;
        StringBuilder sb = new StringBuilder();
        int rightStarCount = arr[len - 1] == '*' ? 1 : 0;
        if (arr[len - 1] != '*') {
            sb.append(arr[len - 1]);
        }
        for (int i = len - 2; i >= 0; i--) {
            if (arr[i] == '*') {
                rightStarCount++;
            } else {
                if (rightStarCount == 0) {
                    sb.append(arr[i]);
                } else {
                    rightStarCount--;
                }
            }
        }
        return sb.reverse().toString();
    }

}
