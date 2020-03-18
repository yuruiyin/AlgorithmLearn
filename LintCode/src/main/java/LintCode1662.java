import java.util.Arrays;
import java.util.Comparator;

/**
 * LintCode1662
 *
 * @author: yry
 * @date: 2020/3/17
 */
public class LintCode1662 {

    class Data {
        int val;
        int index;
        Data(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }

    public int getAns(int[] arr) {
        int len = arr.length;
        Data[] datas = new Data[len];
        for (int i = 0; i < len; i++) {
            datas[i] = new Data(arr[i], i);
        }
        Arrays.sort(datas, Comparator.comparingInt(o -> o.val));
        return datas[(len - 1) >>> 1].index;
    }

}
