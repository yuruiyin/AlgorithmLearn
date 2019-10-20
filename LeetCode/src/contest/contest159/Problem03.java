package contest.contest159;

public class Problem03 {

    private boolean isObtain(int[] countArr, int[] baseCountArr) {
        for (int i = 0; i < baseCountArr.length; i++) {
            if (countArr[i] < baseCountArr[i]) {
                return false;
            }
        }

        return true;
    }

    private void clearArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 0;
        }
    }

    public int balancedString(String originStr) {
        int n = originStr.length();
        int count = n / 4;

        // 先修改字符为a,b,c,d
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char c = originStr.charAt(i);
            if (c == 'Q') {
                sb.append('a');
            } else if (c == 'W') {
                sb.append('b');
            } else if (c == 'E') {
                sb.append('c');
            } else {
                sb.append('d');
            }
        }

        String s1= sb.toString();
        int[] countArr = new int[4];

        for (int i = 0; i < n; i++) {
            char c = s1.charAt(i);
            countArr[c - 'a']++;
        }

        int[] baseCountArr = new int[4];
        int minCount = 0;

        for (int i = 0; i < countArr.length; i++) {
            if (countArr[i] > count) {
                int diff = countArr[i] - count;
                baseCountArr[i] = diff;
                minCount += (diff);
            }
        }

        if (minCount == 0) {
            return 0;
        }

        // 双指针
        int left = 0;
        int right = minCount - 1;
        int[] tmpCountArr = new int[4];
        int ansMin = Integer.MAX_VALUE;
        while (left <= right && right < n) {
            String subStr = s1.substring(left, right + 1);
            int len = subStr.length();

            clearArr(tmpCountArr);
            for (int i = 0; i < len; i++) {
                char key = subStr.charAt(i);
                tmpCountArr[key - 'a']++;
            }

            if (isObtain(tmpCountArr, baseCountArr)) {
                if (len < ansMin) {
                    ansMin = len;
                }

                if (ansMin == minCount) {
                    break;
                }

                left++;
            } else {
                right++;
            }
        }

        return ansMin;
    }

    private String makeStr() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 1000000; i++) {
            sb.append('Q');
        }

        return sb.toString();
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem03().balancedString("QWER"));
        System.out.println(new Problem03().balancedString("QQWE"));
        System.out.println(new Problem03().balancedString("QQQW"));
        System.out.println(new Problem03().balancedString("QQQQ"));
        System.out.println(new Problem03().balancedString("QQQQWWWE"));
        System.out.println(new Problem03().balancedString("WWEQERQWQWWRWWERQWEQ"));
        System.out.println(new Problem03().balancedString(new Problem03().makeStr()));

    }
    
}
