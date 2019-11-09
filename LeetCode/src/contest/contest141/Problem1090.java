package contest.contest141;

import java.util.Arrays;
import java.util.Comparator;

public class Problem1090 {

    class Data {
        int value;
        int label;
        Data(int value, int label) {
            this.value = value;
            this.label = label;
        }
    }

    class CustomCmp implements Comparator<Data> {

        @Override
        public int compare(Data o1, Data o2) {
            return o2.value - o1.value;
        }
    }

    public int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {
        int len = values.length;
        Data[] datas = new Data[len];
        for (int i = 0; i < len; i++) {
            datas[i] = new Data(values[i], labels[i]);
        }

        Arrays.sort(datas, new CustomCmp());

        int[] labelCountArr = new int[20001];

        int ans = 0;
        int valueCount = 0;
        for (Data data: datas) {
            if (labelCountArr[data.label] < use_limit) {
                ans += data.value;
                labelCountArr[data.label]++;
                valueCount++;
            }
            if (valueCount == num_wanted) {
                break;
            }
        }

        return ans;
    }
    
    public static void main(String[] args) {
        
    }
    
}
