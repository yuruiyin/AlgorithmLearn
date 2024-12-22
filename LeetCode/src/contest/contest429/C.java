package contest.contest429;

public class C {

    private boolean isOK(char[] arr, int maxLen, int numOps) {
        int count = 1;
        int len = arr.length;
        char preNum = arr[0];
        for (int i = 1; i < len; i++) {
            if (arr[i] == preNum) {
                count++;
                if (count > maxLen) {
                    if (numOps == 0) {
                        return false;
                    }

                    if (i == len - 1) {
                        return true;
                    }
                    if (arr[i] == arr[i + 1]) {
                        preNum = arr[i] == '0' ? '1' : '0';
                    } else {
                        preNum = arr[i];
                    }
                    numOps--;
                    count = 1;
                } else {
                    preNum = arr[i];
                }
            } else {
                count = 1;
                preNum = arr[i];
            }
        }
        return true;
    }

    private boolean isOneLenOk(char[] arr, int numOps) {
        int len = arr.length;
        char preNum = arr[0];
        for (int i = 1; i < len; i++) {
            if (arr[i] == preNum) {
                if (numOps <= 0) {
                    return false;
                }
                numOps--;
                preNum = arr[i] == '0' ? '1' : '0';
            } else {
                preNum = arr[i];
            }
        }
        return true;
    }

    public int minLength(String s, int numOps) {
        char[] arr = s.toCharArray();
        int len = arr.length;
        // 二分
        int l = 2;
        int r = len;
        int ans = -1;
        while (l <= r) {
            int mid = (l + r) >>> 1;
            if (isOK(arr, mid, numOps)) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        if (ans == -1) {
            return 1;
        }

        // 看看 1 可以吗
        // 第一个数字不变
        boolean isOneOk1 = isOneLenOk(arr, numOps);
        if (isOneOk1) {
            return 1;
        }
        // 第一个数字变
        if (numOps == 0) {
            return ans;
        }

        arr[0] = arr[0] == '0' ? '1' : '0';
        boolean isOneOk2 = isOneLenOk(arr, numOps - 1);
        if (isOneOk2) {
            return 1;
        }
        return ans;
    }

    public static void main(String[] args) {
//        System.out.println(new C().minLength("000001", 1));
        System.out.println(new C().minLength("0000", 2));
    }

}
