package doubleContest.round36;

import java.util.*;

/**
 * A
 *
 * @author: yry
 * @date: 2020/10/3
 */
public class B {

    private int strToInt(String keyTime) {
        int h = Integer.parseInt(keyTime.substring(0, 2));
        int m = Integer.parseInt(keyTime.substring(3));
        return h * 60 + m;
    }

    class Data {
        String name;
        String time;
        Data(String name, String time) {
            this.name = name;
            this.time = time;
        }
    }

    public List<String> alertNames(String[] keyName, String[] keyTime) {
        List<String> ansList = new ArrayList<>();
        int len = keyName.length;
        Map<String, List<Integer>> map = new HashMap<>();

        Data[] datas = new Data[len];
        for (int i = 0; i < len; i++) {
            datas[i] = new Data(keyName[i], keyTime[i]);
        }

        Arrays.sort(datas, Comparator.comparingInt(o -> strToInt(o.time)));

        for (int i = 0; i < len; i++) {
            Data data = datas[i];
            String name = data.name;
            int time = strToInt(data.time);
            if (map.containsKey(name)) {
                map.get(name).add(time);
            } else {
                List<Integer> timeList = new ArrayList<>();
                timeList.add(time);
                map.put(name, timeList);
            }
        }

        for (String name : map.keySet()) {
            List<Integer> timeList = map.get(name);
            if (timeList.size() < 3) {
                continue;
            }

            for (int i = 2; i < timeList.size(); i++) {
                if (timeList.get(i) - timeList.get(i - 2) <= 60) {
                    ansList.add(name);
                    break;
                }
            }
        }

        Collections.sort(ansList);
        return ansList;
    }

}
