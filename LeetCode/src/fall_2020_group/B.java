package fall_2020_group;

import java.util.ArrayList;
import java.util.List;

/**
 * A
 *
 * @author: yry
 * @date: 2020/9/19
 */
public class B {

    private boolean isOk(List<Integer> list, int k, int[] target, int n) {
        List<Integer> targetList = new ArrayList<>();
        while (!list.isEmpty()) {
            List<Integer> tmpList = new ArrayList<>();
            int size = list.size();
            for (int i = 1; i < size; i+=2) {
                tmpList.add(list.get(i));
            }

            for (int i = 0; i < size; i+=2) {
                tmpList.add(list.get(i));
            }

            //取走前k个
            for (int i = 0; i < Math.min(k, size); i++) {
                targetList.add(tmpList.get(i));
            }

            list.clear();
            list.addAll(tmpList.subList(Math.min(k, size), size));
        }

        for (int i = 0; i < n; i++) {
            if (target[i] != targetList.get(i)) {
                return false;
            }
        }

        return true;
    }

    public boolean isMagic(int[] target) {
        int n = target.length;

        if (n == 1) {
            return true;
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        if (target[0] != 2) {
            return false;
        }

        int end = 0;
        for (int i = 1; i < n; i++) {
            if (target[i] - target[i - 1] == 2) {
                end = i;
            } else {
                break;
            }
        }

        int k = end + 1;
        if (k == n / 2) {
            if (target[end + 1] == 1) {
                int newEnd = end + 1;
                for (int i = end + 2; i < n; i++) {
                    if (target[i] - target[i - 1] == 2) {
                        newEnd = i;
                    } else {
                        break;
                    }
                }

                k = newEnd + 1;
            }
        }

        List<Integer> targetList = new ArrayList<>();
        while (!list.isEmpty()) {
            List<Integer> tmpList = new ArrayList<>();
            int size = list.size();
            for (int i = 1; i < size; i+=2) {
                tmpList.add(list.get(i));
            }

            for (int i = 0; i < size; i+=2) {
                tmpList.add(list.get(i));
            }

            //取走前k个
            for (int i = 0; i < Math.min(k, size); i++) {
                targetList.add(tmpList.get(i));
            }

            list.clear();
            list.addAll(tmpList.subList(Math.min(k, size), size));
        }

        for (int i = 0; i < n; i++) {
            if (target[i] != targetList.get(i)) {
                return false;
            }
        }


        return true;
    }

}
