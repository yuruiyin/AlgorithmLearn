import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * LintCode228
 *
 * @author: yry
 * @date: 2020/3/17
 */
public class LintCode822 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public List<Integer> reverseStore(ListNode head) {
        List<Integer> ansList = new ArrayList<>();
        while (head != null) {
            ansList.add(head.val);
            head = head.next;
        }
        Collections.reverse(ansList);
        return ansList;
    }

}
