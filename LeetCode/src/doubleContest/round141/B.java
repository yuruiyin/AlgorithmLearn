package doubleContest.round141;

import java.util.*;

public class B {

    public int[] minBitwiseArray(List<Integer> nums) {
        int len = nums.size();
        int[] ansArr = new int[len];
        for (int i = 0; i < len; i++) {
            int num = nums.get(i);
            if (num % 2 == 0) {
                ansArr[i] = -1;
            } else {
                if ((num & (num + 1)) == 0) {
                    ansArr[i] = num >> 1;
                } else {
                    // 计算后面有几个1
                    int oldNum = num;
                    int oneBitCount = 0;
                    while (num > 0) {
                        int bit = num % 2;
                        if (bit == 0) {
                            break;
                        }
                        oneBitCount++;
                        num >>= 1;
                    }

                    ansArr[i] = oldNum - (1 << (oneBitCount - 1));
                }
            }
        }
        return ansArr;
    }

}
