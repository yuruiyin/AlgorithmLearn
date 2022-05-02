package spring_2022_personal;

import java.util.*;

public class D {

//    选择一个舱室开启屏障，能量消耗为 2
//    选择相邻两个舱室开启联合屏障，能量消耗为 3
//    对于已开启的屏障，多维持一时刻，能量消耗为 1

//    1 <= time.length == position.length <= 500
//            1 <= time[i] <= 5
//            0 <= position[i] <= 100

    class Data1 {
        // 0: 没有屏障，1: 自己独立的屏障，2: 与相邻的联合屏障
        int pz = 0;
        int position;
        Data1(int pz, int position) {
            this.position = position;
            this.pz = pz;
        }
    }

    class Data {
        int time;
        int position;
        Data(int time, int position) {
            this.time = time;
            this.position = position;
        }
    }

    private List<Data1> list;
    private List<Data> dataList;
    private List<Integer>[] time2Positions;
    private Map<String, Integer> memoMap;

    private String convert(int time, int[] pzArr) {
        StringBuilder sb = new StringBuilder();
        long sum = 0;
        for (int i = 0; i < pzArr.length; i+=16) {
            for (int j = 0; j < 16 && i * 16 + j < pzArr.length; j++) {
                int idx = i * 16 + j;
                sum += ((long) pzArr[idx] << (idx << 1L));
            }
            sb.append(sum);
        }
        return sb.toString();
    }

    private int dp(int time, int[] pzArr) {
        if (time == 6) {
            return 0;
        }

        String key = convert(time, pzArr);
        if (memoMap.containsKey(key)) {
            return memoMap.get(key);
        }

        List<Integer> positions = time2Positions[time];
        if (positions == null || positions.isEmpty()) {
            // 继承屏障
            int ansMin = Integer.MAX_VALUE;
            for (int i = 0; i < pzArr.length; i++) {
                if (pzArr[i] == 1) {
                    // 上一次独立屏障
                    ansMin = Math.min(ansMin, dp(time + 1,pzArr ));
                    pzArr[i] = 1;
                } else if (pzArr[i] == 2) {
                    // 上一次联合屏障

                }
            }
            int res = dp(time + 1, pzArr);
            memoMap.put(key, res);
            return res;
        }

        return 0;
    }

    public int defendSpaceCity(int[] times, int[] positions) {
        if (times.length == 1) {
            return 2;
        }

        list = new ArrayList<>();
        Set<Integer> posSet = new TreeSet<>();
        for (int pos : positions) {
            posSet.add(pos);
        }

        for (int pos : posSet) {
            list.add(new Data1(0, pos));
        }

        dataList = new ArrayList<>();
        for (int i = 0; i < times.length; i++) {
            dataList.add(new Data(times[i], positions[i]));
        }

        Collections.sort(dataList, new Comparator<Data>() {
            @Override
            public int compare(Data o1, Data o2) {
                return o1.time == o2.time ? o1.position - o2.position : o1.time - o2.time;
            }
        });

//        输入：time = [1,1,1,2,2,3,5], position = [1,2,3,1,2,1,3]
//        输出：9

        time2Positions = new ArrayList[6];
        for (int i = 0; i < dataList.size(); i++) {
            Data data = dataList.get(i);
            if (time2Positions[data.time] == null) {
                time2Positions[data.time] = new ArrayList<>();
            }
            time2Positions[data.time].add(data.position);
        }

        int[] pzArr = new int[101];
        memoMap = new HashMap<>();
        return dp(1, pzArr);
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
