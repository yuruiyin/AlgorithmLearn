package problem801_900;

public class Problem809 {

    public int expressiveWords(String s, String[] words) {
        char[] arr = s.toCharArray();
        int sLen = arr.length;
        int ans = 0;

        int[] countArr = new int[sLen];
        int count = 1;
        int start = 0;
        for (int i = 1; i < sLen; i++) {
            if (arr[i] == arr[i-1]) {
                count++;
            } else {
                countArr[start] = count;
                count = 1;
                start = i;
            }
        }

        countArr[start] = count;

        for (String word: words) {
            char[] wordArr = word.toCharArray();
            int wordLen = wordArr.length;
            boolean isOk = true;
            int i, j;
            for (i = 0, j = 0; i < sLen && j < wordLen;) {
                if (arr[i] != wordArr[j]) {
                    isOk = false;
                    break;
                }

                // 判断s是否
                int continuousCount = countArr[i];
                int wordContinuousCount = 1;
                for (int k = j + 1; k < wordLen; k++) {
                    if (wordArr[k] != wordArr[j]) {
                        break;
                    }

                    wordContinuousCount++;
                }

                if (wordContinuousCount > continuousCount) {
                    isOk = false;
                    break;
                }

                if (continuousCount < 3 && wordContinuousCount != continuousCount) {
                    isOk = false;
                    break;
                }

                i += continuousCount;
                j += wordContinuousCount;
            }

            if (i < sLen || j < wordLen) {
                isOk = false;
            }

            if (isOk) {
                ans++;
            }
        }

        return ans;
    }

}
