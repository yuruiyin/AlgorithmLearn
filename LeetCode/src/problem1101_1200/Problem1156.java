package problem1101_1200;

public class Problem1156 {

    public int maxRepOpt1(String text) {
        int len = text.length();
        if (len == 1) {
            return 1;
        }

        char[] arr = text.toCharArray();
        int[] countArr = new int[26];
        for (char c : arr) {
            countArr[c - 'a']++;
        }

        int[] preContinueCountArr = new int[len];
        preContinueCountArr[0] = 1;
        for (int i = 1; i < len; i++) {
            if (arr[i] == arr[i - 1]) {
                preContinueCountArr[i] = preContinueCountArr[i - 1] + 1;
            } else {
                preContinueCountArr[i] = 1;
            }
        }

        int[] sufContinueCountArr = new int[len];
        sufContinueCountArr[len - 1] = 1;
        for (int i = len - 2; i >= 0; i--) {
            if (arr[i] == arr[i + 1]) {
                sufContinueCountArr[i] = sufContinueCountArr[i + 1] + 1;
            } else {
                sufContinueCountArr[i] = 1;
            }
        }

        // 第0个元素被替换，换成第1个元素(不一定有更多的第一个元素)
        int ansMax = arr[0] == arr[1] ? sufContinueCountArr[0] :
                (countArr[arr[1] - 'a'] != sufContinueCountArr[1] ? sufContinueCountArr[1] + 1 : sufContinueCountArr[1]);
        int replaceLastValue = arr[len - 1] == arr[len - 2] ? preContinueCountArr[len - 1] :
                (countArr[arr[len - 2] - 'a'] != preContinueCountArr[len - 2] ? preContinueCountArr[len - 2] + 1 : preContinueCountArr[len - 2]);
        ansMax = Math.max(ansMax, replaceLastValue);
        for (int i = 1; i < len - 1; i++) {
            // 当前元素被交换，只有两种选择，交换成左侧或者右侧的字符
            if (arr[i - 1] == arr[i + 1]) {
                // 左右两侧字符相等，那么一定替换成这个字符
                int leftCount = preContinueCountArr[i - 1];
                int rightCount = sufContinueCountArr[i + 1];
                int value = leftCount + rightCount;
                if (leftCount + rightCount != countArr[arr[i - 1] - 'a']) {
                    value++;
                }
                ansMax = Math.max(ansMax, value);
            } else {
                // 左右两侧字符不相等
                int leftCount = preContinueCountArr[i - 1];
                int replaceLeftValue = leftCount == countArr[arr[i - 1] - 'a'] ? leftCount : leftCount + 1;
                int rightCount = sufContinueCountArr[i + 1];
                int replaceRightValue = rightCount == countArr[arr[i + 1] - 'a'] ? rightCount : rightCount + 1;
                ansMax = Math.max(ansMax, Math.max(replaceRightValue, replaceLeftValue));
            }
        }
        return ansMax;
    }

}
