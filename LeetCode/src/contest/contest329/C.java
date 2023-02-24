package contest.contest329;

public class C {

    public boolean makeStringsEqual(String s, String target) {
        // 1要变成0，则需要找到另外一个1，执行xor
        // 0要变成1，则需要找到另外一个1，执行or或xor
        char[] arr = s.toCharArray();
        char[] arrTarget = target.toCharArray();
        int len = arr.length;
        int oneCount = 0;
        for (char c: arr) {
            if (c == '1') {
                oneCount++;
            }
        }

        for (int i = 0; i < len; i++) {
            if (arr[i] == arrTarget[i]) {
                continue;
            }

            if (arr[i] == '0') {
                if (oneCount == 0) {
                    return false;
                }
                oneCount++;
                arr[i] = '1';
            }
        }

        for (int i = 0; i < len; i++) {
            if (arr[i] == arrTarget[i]) {
                continue;
            }

            if (arr[i] == '1') {
                if (oneCount <= 1) {
                    return false;
                }
                oneCount--;
                arr[i] = '0';
            }
        }

        return true;
    }

}
