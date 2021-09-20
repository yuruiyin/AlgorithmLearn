package doubleContest.round55;

import java.util.ArrayList;
import java.util.List;

/**
 * A
 *
 * @author: yry
 * @date: 2021/6/26
 */
public class A {

    private boolean isOk(List<Integer> list) {
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) <= list.get(i - 1)) {
                return false;
            }
        }

        return true;
    }

    public boolean canBeIncreasing(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }

        for (int i = 0; i < list.size(); i++) {
            List<Integer> tmpList = new ArrayList<>();
            for (int j = 0; j < list.size(); j++) {
                if (j == i) {
                    continue;
                }
                tmpList.add(list.get(j));
            }

            if (isOk(tmpList)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
