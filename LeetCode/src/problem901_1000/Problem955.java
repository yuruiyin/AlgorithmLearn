package problem901_1000;

public class Problem955 {

    public int minDeletionSize(String[] arr) {
        int len = arr.length;
        int wordLen = arr[0].length();

        int ans = 0;
        boolean[] removed = new boolean[wordLen];
        for (int j = 0; j < wordLen; j++) {
            boolean isAsc = true;
            boolean hasEqual = false;
            for (int i = 1; i < len; i++) {
                if (arr[i].charAt(j) < arr[i - 1].charAt(j)) {
                    boolean hasBigger = false;
                    for (int k = 0; k < j; k++) {
                        if (removed[k]) {
                            continue;
                        }

                        if (arr[i].charAt(k) > arr[i-1].charAt(k)) {
                            hasBigger = true;
                            break;
                        }
                    }

                    if (!hasBigger) {
                        isAsc = false;

                    }
                } else if (arr[i].charAt(j) == arr[i-1].charAt(j)) {
                    hasEqual = true;
                }
            }

            if (!isAsc) {
                ans++;
                removed[j] = true;
            } else {
                if (!hasEqual) {
                    return ans;
                }
            }

        }

        return ans;
    }

    public static void main(String[] args) {

    }

}
