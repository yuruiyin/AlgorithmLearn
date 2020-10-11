package fall_2020_group;

import java.util.ArrayList;
import java.util.List;

/**
 * A
 *
 * @author: yry
 * @date: 2020/9/19
 */
public class A {

    private List<List<Integer>> list = new ArrayList<>();
    private int n;

    private void rec(int cur, List<Integer> tmpList) {
        if (cur == n) {
            list.add(new ArrayList<>(tmpList));
            return;
        }

        tmpList.add(0);
        rec(cur + 1, tmpList);
        tmpList.remove(tmpList.size() - 1);

        tmpList.add(1);
        rec(cur + 1, tmpList);
        tmpList.remove(tmpList.size() - 1);
    }

    public int paintingPlan(int n, int k) {
        this.n = n;

        rec(0, new ArrayList<>());
        int ans = 0;
        for (List<Integer> rowList : list) {
            for (List<Integer> colList : list) {
                int rowCount = 0;
                for (int num : rowList) {
                    if (num == 1) {
                        rowCount++;
                    }
                }

                int colCount = 0;
                for (int num : colList) {
                    if (num == 1) {
                        colCount++;
                    }
                }

                if (rowCount == n && colCount != n || rowCount != n && colCount == n) {
                    continue;
                }

                int count = (rowCount + colCount) * n - colCount * rowCount;
                if (count == k) {
                    ans++;
                }
            }
        }

        return ans;

    }
    
    public static void main(String[] args) {
        System.out.println(new A().paintingPlan(2, 4));
    }

}
