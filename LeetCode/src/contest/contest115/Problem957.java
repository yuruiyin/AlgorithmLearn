package contest.contest115;

import utils.PrintUtil;

import java.util.*;

public class Problem957 {

    public int[] prisonAfterNDays(int[] cells, int N) {
        int len = cells.length;

        StringBuilder firstDaySb = new StringBuilder("0");
        for (int i = 1; i < len - 1; i++) {
            int num = (cells[i - 1] ^ cells[i + 1]) == 0 ? 1 : 0;
            firstDaySb.append(num);
        }
        firstDaySb.append('0');

        String lastDay = firstDaySb.toString();
        Set<String> set = new HashSet<>();
        List<String> list = new ArrayList<>();
        list.add(lastDay);
        set.add(lastDay);

        int count = 1;

        while (true) {
            StringBuilder sb = new StringBuilder("0");
            for (int i = 1; i < len - 1; i++) {
                char prevChar = lastDay.charAt(i-1);
                char nextChar = lastDay.charAt(i+1);
                int num = ((prevChar - '0') ^ (nextChar - '0')) == 0 ? 1 : 0;
                sb.append(num);
            }

            sb.append('0');

            String str = sb.toString();
            if (set.contains(str)) {
                break;
            }

            lastDay = str;
            set.add(str);
            list.add(str);
            count++;
        }

        int resIndex = (N - 1) % count;
        String resStr = list.get(resIndex);
        int[] ansArr = new int[len];

        for (int i = 0; i < len; i++) {
            ansArr[i] = resStr.charAt(i) - '0';
        }

        return ansArr;
     }
    
    public static void main(String[] args) {
        int[] ansArr = new Problem957().prisonAfterNDays(new int[]{1,0,0,1,0,0,1,0}, 1000000000);

        PrintUtil.printIntArray(ansArr);
    }
    
}
