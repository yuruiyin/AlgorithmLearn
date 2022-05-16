package doubleContest.round073;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class B {

    class Data {
        int num;
        int i;
        Data(int num, int i) {
            this.num = num;
            this.i = i;
        }
    }

    private int convert(int[] mapping, int num) {
        int ansNum = 0;
        int m = 1;
        if (num == 0) {
            return mapping[0];
        }
        while (num > 0) {
            ansNum += m * mapping[num % 10];
            num /= 10;
            m *= 10;
        }
        return ansNum;
    }

    public int[] sortJumbled(int[] mapping, int[] nums) {
        int len = nums.length;
        List<Data> datas = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            Data data = new Data(convert(mapping, nums[i]), i);
            datas.add(data);
        }
        Collections.sort(datas, new Comparator<Data>() {
            @Override
            public int compare(Data o1, Data o2) {
                return o1.num == o2.num ? o1.i - o2.i : o1.num - o2.num;
            }
        });

        int[] ansArr = new int[len];
        for (int i = 0; i < len; i++) {
            ansArr[i] = nums[datas.get(i).i];
        }
        return ansArr;
    }

}
