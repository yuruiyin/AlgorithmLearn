package contest.contest186;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * A
 *
 * @author: yry
 * @date: 2020/4/26
 */
public class C {

    class Data {
        int num;
        int i;
        int j;
        Data(int num, int i, int j) {
            this.num = num;
            this.i = i;
            this.j = j;
        }
    }

    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        List<Data> dataList = new ArrayList<>();
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.get(i).size(); j++) {
                dataList.add(new Data(nums.get(i).get(j), i, j));
            }
        }

        dataList.sort(new Comparator<Data>() {
            @Override
            public int compare(Data data1, Data data2) {
                if (data1.i + data1.j == data2.i + data2.j) {
                    return data2.i - data1.i;
                }

                return data1.i + data1.j - (data2.i + data2.j);
            }
        });

        List<Integer> ansList = new ArrayList<>();
        for (Data data : dataList) {
            ansList.add(data.num);
        }

        int[] ansArr = new int[ansList.size()];
        for (int i = 0; i < ansList.size(); i++) {
            ansArr[i] = ansList.get(i);
        }

        return ansArr;
    }

}
