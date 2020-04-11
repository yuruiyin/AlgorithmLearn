package problem301_400;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem386
 *
 * @author: yry
 * @date: 2020/4/8
 */
public class Problem386 {

    public List<Integer> lexicalOrder(int n) {
        String[] arr = new String[n];
        for (int i = 1; i <= n; i++) {
            arr[i - 1] = String.valueOf(i);
        }

        Arrays.sort(arr, String::compareTo);
        List<Integer> ansList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ansList.add(Integer.parseInt(arr[i]));
        }
        return ansList;
    }

    public static void main(String[] args) {
        List<Integer> ansList = new Problem386().lexicalOrder(130);
        System.out.println(ansList.toString());
    }

}
