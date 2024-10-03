package doubleContest.round138;

import java.util.Arrays;
import java.util.Comparator;

public class D {

    class Data {
        int dam;
        int hel;
        Data(int dam, int hel) {
            this.dam = dam;
            this.hel = hel;
        }
    }

    public long minDamage(int power, int[] damage, int[] health) {
        int len = damage.length;
        Data[] datas = new Data[len];
        for (int i = 0; i < len; i++) {
            datas[i] = new Data(damage[i], health[i]);
        }

        Arrays.sort(datas, new Comparator<Data>() {
            @Override
            public int compare(Data o1, Data o2) {
                int count1 = o1.hel / power + (o1.hel % power == 0 ? 0 : 1);
                int count2 = o2.hel / power + (o2.hel % power == 0 ? 0 : 1);
                return o2.dam * count1 - o1.dam * count2;
            }
        });

        long damSum = 0;
        for (int dam: damage) {
            damSum += dam;
        }

        long ans = 0;
        for (int i = 0; i < len; i++) {
            int dam = datas[i].dam;
            int hel = datas[i].hel;
            int count = hel / power + (hel % power == 0 ? 0 : 1);
            ans += damSum * count;
            damSum -= dam;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("hello");
    }

}
