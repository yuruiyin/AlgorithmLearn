package problem101_200;

import java.util.Arrays;
import java.util.Comparator;

public class Problem179 {

    class Data {
        long longNum;
        int originNum;
        Data(long longNum, int originNum) {
            this.longNum = longNum;
            this.originNum = originNum;
        }
    }

    class CustomCmp implements Comparator<Data> {

        @Override
        public int compare(Data o1, Data o2) {
            // 从大到小
            return -Long.compare(o1.longNum, o2.longNum);
        }
    }

    public String largestNumber(int[] nums) {
        int n = nums.length;
        Data[] longDatas = new Data[n];

        int count = 0;
        boolean isAllZero = true;
        for (int num : nums) {
            if (num == 0) {
                longDatas[count++] = new Data(0, num);
            } else {
                isAllZero = false;
                // 数字重复（比如12，变成1212121212），让数字都变成10位long型
                String str = String.valueOf(num);
                int size = str.length();

                int diff = 10 - size;
                StringBuilder sb = new StringBuilder(str);
                for (int i = 0; i < diff; i++) {
                    sb.append(str.charAt(i % size));
                }

                longDatas[count++] = new Data(Long.parseLong(sb.toString()), num);
            }
        }

        if (isAllZero) {
            return "0";
        }

        Arrays.sort(longDatas, new CustomCmp());

        StringBuilder sb = new StringBuilder();
        for (Data data : longDatas) {
            sb.append(data.originNum);
        }

        return sb.toString();
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem179().largestNumber(new int[]{10,2}));
        System.out.println(new Problem179().largestNumber(new int[]{3,30,34,5,9}));
        System.out.println(new Problem179().largestNumber(new int[]{3}));
        System.out.println(new Problem179().largestNumber(new int[]{0}));
        System.out.println(new Problem179().largestNumber(new int[]{0,0}));
        System.out.println(new Problem179().largestNumber(new int[]{824,938,1399,5607,6973,5703,9609,4398,8247}));
    }
    
}
