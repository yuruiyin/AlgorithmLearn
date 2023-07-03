package contest.contest349;

public class B {

    public String smallestString(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length;
        boolean hasDo = false;
        for (int i = 0; i < len; i++) {
            if (arr[i] != 'a') {
                arr[i]--;
                hasDo = true;
            } else {
                if (hasDo) {
                    break;
                }
            }
        }
        if (!hasDo) {
            arr[len - 1] = 'z';
        }
        return new String(arr);
    }

}
