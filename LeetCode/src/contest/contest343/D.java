package contest.contest343;

public class D {

    public String smallestBeautifulString(String s, int k) {
        char[] arr = s.toCharArray();
        int len = arr.length;
        if (len == 1) {
            char c = arr[0];
            if (c - 'a' + 1 == k) {
                return "";
            }
            return String.valueOf((char)(c + 1));
        }
        for (int i = len - 1; i >= 0; i--) {
            // 最多+5
            for (char c = (char) (arr[i] + 1); c <= arr[i] + 5 && c < 'a' + k; c++) {
                boolean isOk = true;
                for (int j = Math.max(0, i - 2); j <= i - 1; j++) {
                    if (c == arr[j]) {
                        isOk = false;
                        break;
                    }
                }

                if (isOk) {
                    arr[i] = c;
                    // 修改后缀
                    boolean isOk3 = true;
                    for (int j = i + 1; j < len; j++) {
                        boolean isOk2 = false;
                        for (char c1 = 'a'; c1 < 'a' + k; c1++) {
                            boolean isOk1 = true;
                            for (int jj = Math.max(0, j - 2); jj <= j - 1; jj++) {
                                if (c1 == arr[jj]) {
                                    isOk1 = false;
                                    break;
                                }
                            }
                            if (isOk1) {
                                arr[j] = c1;
                                isOk2 = true;
                                break;
                            }
                        }
                        if (!isOk2) {
                            isOk3 = false;
                            break;
                        }
                    }

                    if (isOk3) {
                        return new String(arr);
                    }
                }
            }
        }
        return "";
    }

}
