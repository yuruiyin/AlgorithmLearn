package test;

import java.util.Arrays;
import java.util.Comparator;

class Data {
    int x;
    int y;

    public Data(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class CustomCmp implements Comparator<Data> {

    @Override
    public int compare(Data o1, Data o2) {
        if (o1.x != o2.x) {
            return o1.x - o2.x;
        } else {
            return o1.y - o2.y;
        }
    }
}

public class SortTest {

    public static void main(String[] args) {
        Data data1 = new Data(2, 3);
        Data data2 = new Data(2, 2);
        Data data3 = new Data(1, 5);
        Data[] datas = new Data[]{data1, data2, data3};
        Arrays.sort(datas, 0, datas.length, new CustomCmp());

        for (Data data : datas) {
            System.out.println(data.x + ", " + data.y);
        }
    }

}
