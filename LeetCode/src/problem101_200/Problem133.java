package problem101_200;

import java.util.*;

public class Problem133 {

    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {}

        public Node(int _val,List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraph(Node node) {
        // 先bfs先生成各个节点，然后用一个hashMap来保存原有节点到新节点的映射
        // 然后根据上面的HashMap就可以将节点连接起来。
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(node);
        Map<Node, Node> map = new HashMap<>();
        Set<Node> visited = new HashSet<>();
        visited.add(node);

        while (!queue.isEmpty()) {
            List<Node> nodeList = new ArrayList<>();
            while (!queue.isEmpty()) {
                Node frontNode = queue.removeFirst();
                map.put(frontNode, new Node(frontNode.val, null));
                nodeList.add(frontNode);
            }

            for (Node tmpNode: nodeList) {
                for (Node neighbor: tmpNode.neighbors) {
                    if (visited.contains(neighbor)) {
                        continue;
                    }

                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }

        for (Node originNode: map.keySet()) {
            Node cloneNode = map.get(originNode);
            cloneNode.neighbors = new ArrayList<>();
            for (Node neighbor: originNode.neighbors) {
                cloneNode.neighbors.add(map.get(neighbor));
            }
        }

        return map.get(node);
    }

}
