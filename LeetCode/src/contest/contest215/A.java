package contest.contest215;

import java.util.ArrayList;
import java.util.List;

/**
 * A
 *
 * @author: yry
 * @date: 2020/11/15
 */
public class A {

    class OrderedStream {

        private String[] arr;
        private int ptr;
        private int n;

        public OrderedStream(int n) {
            arr = new String[n + 2];
            this.n = n;
            ptr = 1;
        }

        public List<String> insert(int id, String value) {
            arr[id] = value;
            if (id != ptr) {
                return new ArrayList<>();
            }

            List<String> ansList = new ArrayList<>();
            for (int i = ptr; i <= n; i++) {
                if (arr[i] == null) {
                    break;
                }
                ansList.add(arr[i]);
                ptr = i;
            }

            ptr++;
            return ansList;
        }
    }

}
