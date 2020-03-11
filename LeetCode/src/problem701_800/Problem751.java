package problem701_800;

import utils.PrintUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem751 {

    private long strToInt(String ip) {
        String[] arr = ip.split("\\.");
        long ans = 0;
        long moveBitCount = 0;
        for (int i = 3; i >= 0; i--) {
            ans += Long.parseLong(arr[i]) << moveBitCount;
            moveBitCount += 8;
        }
        return ans;
    }

    private String intToStr(long ipInt) {
        String[] arr = new String[4];
        long mask = (1 << 8) - 1;
        for (int i = 0; i < 4; i++) {
            arr[i] = String.valueOf(ipInt & mask);
            ipInt >>>= 8;
        }

        return arr[3] + '.' + arr[2] + '.' + arr[1] + '.' + arr[0];
    }

    public List<String> ipToCIDR(String ip, int n) {
        long ipInt = strToInt(ip);
        List<String> ansList = new ArrayList<>();
        while (n > 0) {
            long mask = ipInt & (-ipInt);
            long preCount = 32 - Long.bitCount(mask - 1);
            if (n >= mask) {
                ansList.add(intToStr(ipInt) + "/" + preCount);
                n -= mask;
                ipInt += mask;
            } else {
                // 如n == 5, 101 = 100 + 001
                List<Long> maskList = new ArrayList<>();
                while (n > 0) {
                    long mask1 = n & (-n);
//                    long preCount1 = 32 - Long.bitCount(mask1 - 1);
//                    long curIpInt = preCount1 == 32 ? ipInt : ipInt | mask1;
//                    ansList.add(intToStr(curIpInt) + "/" + preCount1);
                    maskList.add(mask1);
                    n -= mask1;
                }

                Collections.reverse(maskList);
                // 从高位往低位遍历
                long curIpInt = ipInt;
                for (int i = 0; i < maskList.size(); i++) {
                    long mask1 = maskList.get(i);
                    long preCount1 = 32 - Long.bitCount(mask1 - 1);
                    ansList.add(intToStr(curIpInt) + "/" + preCount1);
                    curIpInt += mask1;
                }
            }
        }

        return ansList;
    }
    
    public static void main(String[] args) {
        List<String> ansList = new Problem751().ipToCIDR("255.0.0.7", 10);
        PrintUtil.printStringList(ansList);
    }

}
