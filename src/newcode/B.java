package newcode;

import java.util.*;

public class B {

    static class Data {
        long s;
        long e;

        Data(long s, long e) {
            this.s = s;
            this.e = e;
        }
    }

    private static List<Data> getAns(String[] arr) {
        int len = arr.length;
        Data[] datas = new Data[len];
        for (int i = 0; i < len; i++) {
            // str: (3,6)
            String str = arr[i];
            int dIdx = str.indexOf(',');
            long s = Integer.parseInt(str.substring(1, dIdx));
            long e = Integer.parseInt(str.substring(dIdx + 1, str.length() - 1));
            datas[i] = new Data(s, e);
        }

        Arrays.sort(datas, new Comparator<Data>() {
            @Override
            public int compare(Data o1, Data o2) {
                return o1.e == o2.e ? Long.compare(o2.s, o1.s) : Long.compare(o1.e, o2.e);
            }
        });

        List<Data> ansList = new ArrayList<>();
        ansList.add(datas[0]);
        long preE = datas[0].e;
        for (int i = 1; i < len; i++) {
            Data data = datas[i];
            if (data.e == datas[i - 1].e) {
                continue;
            }
            if (data.s < preE) {
                continue;
            }
            ansList.add(data);
            preE = data.e;
        }

        return ansList;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            // (3,6) (1,5) (6,7)
            String str = in.nextLine();
            String[] arr = str.split(" ");
            List<Data> ansList = getAns(arr);
            int count = ansList.size();
            System.out.println("count:" + count);
            for (int i = 0; i < count; i++) {
                Data data = ansList.get(i);
                System.out.print("(" + data.s + "," + data.e + ")");
                if (i != count - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

}
