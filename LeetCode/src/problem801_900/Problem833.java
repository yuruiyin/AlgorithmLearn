package problem801_900;

import java.util.Arrays;
import java.util.Comparator;

public class Problem833 {

    class Data {
        int index;
        String source;
        String target;
        Data(int index, String source, String target) {
            this.index = index;
            this.source = source;
            this.target = target;
        }
    }

    class CustomCmp implements Comparator<Data> {
        @Override
        public int compare(Data o1, Data o2) {
            return o1.index - o2.index;
        }
    }

    public String findReplaceString(String s, int[] indexes, String[] sources, String[] targets) {
        StringBuilder sb = new StringBuilder();
        int indexLen = indexes.length;
        Data[] datas = new Data[indexLen];
        for (int i = 0; i < indexLen; i++) {
            datas[i] = new Data(indexes[i], sources[i], targets[i]);
        }

        Arrays.sort(datas, new CustomCmp());
        int from = 0;
        for (int i = 0; i < s.length(); i++) {
            if (from < indexLen && i == datas[from].index) {
                if (s.indexOf(datas[from].source, i) == i) {
                    sb.append(datas[from].target);
                    i += datas[from].source.length() - 1;
                } else {
                    sb.append(s.charAt(i));
                }
                from++;
            } else {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }


}
