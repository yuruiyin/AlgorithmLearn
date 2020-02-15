package lcof;

import java.util.Arrays;
import java.util.Comparator;

public class Lcof045 {

    class Data {
        int num;
        String numStr;
        Data(int num, String numStr) {
            this.num = num;
            this.numStr = numStr;
        }
    }

    public String minNumber(int[] nums) {
        // 将每个数字都拼成10位（重复自己）
        int len = nums.length;
        Data[] datas = new Data[len];

        for (int i = 0; i < len; i++) {
            String str = String.valueOf(nums[i]);
            StringBuilder sb = new StringBuilder(str);
            while (sb.length() < 10) {
                int count = 10 - sb.length();
                for (int j = 0; j < Math.min(count, str.length()); j++) {
                    sb.append(str.charAt(j));
                }

                if (count <= str.length()) {
                    break;
                }
            }

            datas[i] = new Data(nums[i], sb.toString());
        }

        Arrays.sort(datas, new Comparator<Data>() {
            @Override
            public int compare(Data o1, Data o2) {
                return o1.numStr.compareTo(o2.numStr);
            }
        });

        StringBuilder ansSb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            ansSb.append(datas[i].num);
        }

        return ansSb.toString();
    }

}
