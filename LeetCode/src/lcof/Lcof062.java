package lcof;

import java.util.ArrayList;
import java.util.List;

public class Lcof062 {

    public int lastRemaining(int n, int m) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }

        int from = 0;

        while (list.size() > 1) {
            int removeIndex = (from + m - 1) % list.size();
            list.remove(removeIndex);
            from = removeIndex % list.size();
        }

        return list.get(0);
    }
    
    public static void main(String[] args) {
        System.out.println(new Lcof062().lastRemaining(5, 3));
    }

}
