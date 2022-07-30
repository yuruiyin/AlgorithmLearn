package contest.contest296;

import java.util.List;

public class D {

    static class TextEditor {

        class Node {
            Node pre;
            Node next;
            char c;
            Node(char c) {
                this.c = c;
            }
        }

        private Node head;
        private Node cursorNode;

        public TextEditor() {
            head = new Node('|');
            cursorNode = head;
        }

        public void addText(String text) {
            Node cur = cursorNode;
            Node lastNode = null;
            Node oldLeft = cursorNode.pre;
            for (int i = text.length() - 1; i >= 0; i--) {
                Node node = new Node(text.charAt(i));
                if (i == text.length() - 1) {
                    lastNode = node;
                }
                cur.pre = node;
                node.next = cur;
                cur = node;
            }
            cur.pre = oldLeft;
            cursorNode = lastNode.next;
        }

        public int deleteText(int k) {
            Node cur = cursorNode.pre;
            int count = 0;
            while ((k--) > 0 && cur != null) {
                count++;
                cur.next = null;
                cur = cur.pre;
            }
            cursorNode.pre = cur;
            if (cur != null) {
                cur.next = cursorNode;
            }
            return count;
        }

        private String getLeftStr() {
            int count = 0;
            Node cur = cursorNode.pre;
            StringBuilder sb = new StringBuilder();
            while (cur != null && count < 10) {
                sb.append(cur.c);
                cur = cur.pre;
                count++;
            }
            return sb.reverse().toString();
        }

        public String cursorLeft(int k) {
            Node cur = cursorNode.pre;
            Node right = cursorNode;
            while ((k--) > 0 && cur != null) {
                // 交换
                Node pre = cur.pre;
                Node next = right.next;
                if (pre != null) {
                    pre.next = right;
                }
                right.pre = pre;
                right.next = cur;
                cur.pre = right;
                cur.next = next;
                cur = right.pre;
            }

            return getLeftStr();
        }

        public String cursorRight(int k) {
            Node cur = cursorNode.next;
            Node left = cursorNode;
            while ((k--) > 0 && cur != null) {
                // 交换
                Node next = cur.next;
                Node pre = left.pre;
                if (next != null) {
                    next.pre = left;
                }
                left.next = next;
                left.pre = cur;
                cur.pre = pre;
                cur.next = left;
                cur = left.next;
            }

            return getLeftStr();
        }
    }

    public static void main(String[] args) {
        TextEditor textEditor = new TextEditor(); // 当前 text 为 "|" 。（'|' 字符表示光标）
        textEditor.addText("leetcode"); // 当前文本为 "leetcode|" 。
        textEditor.deleteText(4); // 返回 4
        // 当前文本为 "leet|" 。
        // 删除了 4 个字符。
        textEditor.addText("practice"); // 当前文本为 "leetpractice|" 。
        textEditor.cursorRight(3); // 返回 "etpractice"
        // 当前文本为 "leetpractice|".
        // 光标无法移动到文本以外，所以无法移动。
        // "etpractice" 是光标左边的 10 个字符。
        textEditor.cursorLeft(8); // 返回 "leet"
        // 当前文本为 "leet|practice" 。
        // "leet" 是光标左边的 min(10, 4) = 4 个字符。
        textEditor.deleteText(10); // 返回 4
        // 当前文本为 "|practice" 。
        // 只有 4 个字符被删除了。
        textEditor.cursorLeft(2); // 返回 ""
        // 当前文本为 "|practice" 。
        // 光标无法移动到文本以外，所以无法移动。
        // "" 是光标左边的 min(10, 0) = 0 个字符。
        textEditor.cursorRight(6); // 返回 "practi"
        // 当前文本为 "practi|ce" 。
        // "practi" 是光标左边的 min(10, 6) = 6 个字符。
    }

}
