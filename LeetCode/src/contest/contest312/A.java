package contest.contest312;

import java.util.Arrays;
import java.util.Comparator;

public class A {

    class Data {
        String name;
        int height;
        Data(String name, int height) {
            this.name = name;
            this.height = height;
        }
    }

    public String[] sortPeople(String[] names, int[] heights) {
        int len = names.length;
        Data[] datas = new Data[len];
        for (int i = 0; i < len; i++) {
            datas[i] = new Data(names[i], heights[i]);
        }

        Arrays.sort(datas, new Comparator<Data>() {
            @Override
            public int compare(Data o1, Data o2) {
                return o2.height - o1.height;
            }
        });

        String[] arr = new String[len];
        for (int i = 0; i < len; i++) {
            arr[i] = datas[i].name;
        }

        return arr;
    }

    public static void main(String[] args) {
        System.out.println("hello");
    }

}
