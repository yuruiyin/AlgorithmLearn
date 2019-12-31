package contest.contest089;

import java.util.Arrays;
import java.util.Comparator;

public class Problem853 {

    class Data {
        int position;
        int speed;
        Data(int position, int speed) {
            this.position = position;
            this.speed = speed;
        }
    }

    private boolean isMeet(Data data1, Data data2, int target) {
        if (data1.speed <= data2.speed) {
            return false;
        }

        double t = (data2.position - data1.position) * 1.0 / (data1.speed - data2.speed);
        return data1.speed * t + data1.position <= target;
    }

    public int carFleet(int target, int[] position, int[] speed) {
        int len = position.length;
        if (len == 0) {
            return 0;
        }

        Data[] datas = new Data[len];
        for (int i = 0; i < len; i++) {
            datas[i] = new Data(position[i], speed[i]);
        }

        Arrays.sort(datas, Comparator.comparingInt(o -> o.position));

        int ans = 1;
        Data frontCar = datas[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            if (!isMeet(datas[i], frontCar, target)) {
                ans++;
                frontCar = datas[i];
            }
        }

        return ans;
    }

}
