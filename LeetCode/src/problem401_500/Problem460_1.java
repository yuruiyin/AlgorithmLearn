package problem401_500;


import utils.DoublyLinkedList;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem460_1
 *
 * @author: yry
 * @date: 2020/4/5
 */
public class Problem460_1 {

    // 思路
    // 二维双向链表。第一维双向链表的节点也是一个双向链表
    // 然后，开辟一个map记录key到第二维链表节点的映射，而且这个第二维的节点里头存放着第一维节点的引用。
    // 最后有一个map记录key->value
    static class LFUCache {

        class SubNode extends DoublyLinkedList.Node {
            int key;
            FreqNode freqNode;
            public SubNode(int key) {
                this.key = key;
            }
        }

        public class FreqNode extends DoublyLinkedList.Node {
            int freq;
            DoublyLinkedList<SubNode> linkedList;

            FreqNode(int freq, DoublyLinkedList<SubNode> linkedList) {
                this.freq = freq;
                this.linkedList = linkedList;
            }

        }

        // 支持以下几种操作
        // 1. 删除最早加入且频率最小的元素
        // 2. 对指定元素的频率加1，也就是说从当前节点的链表中移除，并根据下一个节点的频率决定是直接插入到下一个节点的链表中还是新建一个节点
        // 3. 若执行put操作，除了执行第2步之外，还得将修改指定节点（节点的链表中子节点）的key值

        private Map<Integer, Integer> numMap;
        private DoublyLinkedList<FreqNode> freqLinkList;
        private Map<Integer, SubNode> subNodeMap;
        private int capacity;

        public LFUCache(int capacity) {
            numMap = new HashMap<>();
            freqLinkList = new DoublyLinkedList<>();
            subNodeMap = new HashMap<>();
            this.capacity = capacity;
        }

        public int get(int key) {
            if (!numMap.containsKey(key)) {
                return -1;
            }

            updateFreq(key);
            return numMap.get(key);
        }

        // 更新频率
        private void updateFreq(int key) {
            SubNode subNode = subNodeMap.get(key);
            FreqNode freqNode = subNode.freqNode;
            FreqNode nextFreqNode = (FreqNode) freqNode.next;
            freqNode.linkedList.remove(subNode);
            SubNode newSubNode = new SubNode(key);
            subNodeMap.put(key, newSubNode);

            // 分三种情况，（1）下一个节点为null；（2）下一个节点的频率刚好是当前节点+1，（3）下一个节点频率大于当前节点+1
            // 同时第一种情况和第三种情况可以合并
            if (nextFreqNode == null || nextFreqNode.freq > freqNode.freq + 1) {
                // 在当前节点和下一个节点中间插入
                FreqNode newFreqNode = new FreqNode(freqNode.freq + 1, new DoublyLinkedList<>(newSubNode));
                newSubNode.freqNode = newFreqNode;
                freqLinkList.add(freqNode, newFreqNode);
            } else  {
                nextFreqNode.linkedList.addLast(newSubNode);
                newSubNode.freqNode = nextFreqNode;
            }

            if (freqNode.linkedList.isEmpty()) {
                freqLinkList.remove(freqNode);
            }
        }

        private void createFreqNode(int key) {
            // 若第一个节点的freq是1的话，则直接插入到第一个节点的子节点中，否则新建一个节点
            SubNode subNode = new SubNode(key);
            if (freqLinkList.isEmpty() || freqLinkList.getFirst().freq != 1) {
                FreqNode newFreqNode = new FreqNode(1, new DoublyLinkedList<>(subNode));
                freqLinkList.addFirst(newFreqNode);
                subNode.freqNode = newFreqNode;
            } else {
                freqLinkList.getFirst().linkedList.addLast(subNode);
                subNode.freqNode = freqLinkList.getFirst();
            }
            subNodeMap.put(key, subNode);
        }

        public void put(int key, int value) {
            if (capacity == 0) {
                return;
            }

            if (numMap.containsKey(key)) {
                numMap.put(key, value);
                updateFreq(key);
                return;
            }

            if (numMap.keySet().size() == capacity) {
                // 先移除最不经常用的
                SubNode subNode = freqLinkList.getFirst().linkedList.removeFirst();
                if (freqLinkList.getFirst().linkedList.isEmpty()) {
                    freqLinkList.removeFirst();
                }
                numMap.remove(subNode.key);
                subNodeMap.remove(subNode.key);
            }

            numMap.put(key, value);
            createFreqNode(key);
        }
    }

    public static void main(String[] args) {
        LFUCache cache = new LFUCache(2);

        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // 返回 1
        cache.put(3, 3);    // 去除 key 2
        cache.get(2);       // 返回 -1 (未找到key 2)
        cache.get(3);       // 返回 3
        cache.put(4, 4);    // 去除 key 1
        cache.get(1);       // 返回 -1 (未找到 key 1)
        cache.get(3);       // 返回 3
        cache.get(4);       // 返回 4
    }

}
