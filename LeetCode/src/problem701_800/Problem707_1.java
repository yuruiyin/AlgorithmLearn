package problem701_800;

public class Problem707_1 {

    static class MyLinkedList {

        static class Node {
            Node next;
            int val;
            Node(int val) {
                this.val = val;
            }
        }

        private Node head;
        private int size;
        private Node tail;

        public MyLinkedList() {
            head = null;
            tail = null;
        }

        public int get(int index) {
            if (head == null) {
                return -1;
            }

            if (index < 0 || index >= size) {
                return -1;
            }
            Node cur = head;
            int curIdx = 0;
            while (cur != null && curIdx < index) {
                cur = cur.next;
                curIdx++;
            }
            return cur == null ? -1 : cur.val;
        }

        public void addAtHead(int val) {
            Node node = new Node(val);
            if (head == null) {
                head = node;
                tail = head;
            } else {
                node.next = head;
                head = node;
            }
            size++;
        }

        public void addAtTail(int val) {
            Node node = new Node(val);
            if (tail == null) {
                head = node;
                tail = head;
            } else {
                tail.next = node;
                tail = node;
            }
            size++;
        }

        public void addAtIndex(int index, int val) {
            if (index > size) {
                return;
            }

            Node node = new Node(val);
            if (head == null) {
                head = node;
                tail = head;
            } else {
                if (index < 0) {
                    index = 0;
                }
                Node pre = null;
                Node cur = head;
                int curIdx = 0;
                while (cur != null && curIdx < index) {
                    pre = cur;
                    cur = cur.next;
                    curIdx++;
                }

                if (pre == null) {
                    // 添加到头部
                    node.next = head;
                    head = node;
                } else {
                    pre.next = node;
                    node.next = cur;
                    if (cur == null) {
                        // 添加到尾部
                        tail = node;
                    }
                }
            }
            size++;
        }

        public void deleteAtIndex(int index) {
            if (index < 0 || index >= size || head == null) {
                return;
            }

            Node cur = head;
            Node pre = null;
            int curIdx = 0;
            while (cur != null && curIdx < index) {
                pre = cur;
                cur = cur.next;
                curIdx++;
            }

            if (pre == null) {
                // 删除第一个元素
                Node oldHead = head;
                head = head.next;
                oldHead.next = null;
            } else if (cur != null) {
                pre.next = cur.next;
                if (cur.next == null) {
                    // 删除最后一个元素
                    tail = pre;
                }
                cur.next = null;
            } else if (cur == null) {
                return;
            }
            size--;
        }

    }

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
        linkedList.get(1);            //返回2
        linkedList.deleteAtIndex(1);  //现在链表是1-> 3
        linkedList.get(1);            //返回3
    }

}
