package problem401_500;

/**
 * Problem443
 *
 * @author: yry
 * @date: 2020/4/14
 */
public class Problem443 {

    // 获取十进制的位数
    private int getDigitCount(int num) {
        int count = 0;
        while (num > 0) {
            count++;
            num /= 10;
        }
        return count;
    }

    public int compress(char[] chars) {
        int len = chars.length;
        int count = 1;
        int curIdx = 1;
        for (int i = 1; i < len; i++) {
            if (chars[i] != chars[i - 1]) {
                if (count >= 2) {
                    // 可以压缩
                    int digitCount = getDigitCount(count);
                    for (int j = curIdx + digitCount - 1; j >= curIdx; j--) {
                        chars[j] = (char) ((count % 10) + '0');
                        count /= 10;
                    }

                    chars[curIdx + digitCount] = chars[i];
                    curIdx = curIdx + digitCount + 1;
                } else {
                    chars[curIdx] = chars[i];
                    curIdx++;
                }
                count = 1;
            } else {
                count++;
            }
        }

        if (count > 1) {
            int digitCount = getDigitCount(count);
            for (int j = curIdx + digitCount - 1; j >= curIdx; j--) {
                chars[j] = (char) ((count % 10) + '0');
                count /= 10;
            }
            curIdx = curIdx + digitCount;
        }

        return curIdx;
    }

}
