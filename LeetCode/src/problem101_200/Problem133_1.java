package problem101_200;

import java.util.*;

public class Problem133_1 {

    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {}

        public Node(int _val,List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    private void dfs(Node node, Map<Node, Node> map, Set<Node> visited) {
        map.put(node, new Node(node.val, null));
        visited.add(node);

        for (Node neighbor: node.neighbors) {
            if (visited.contains(neighbor)) {
                continue;
            }

            dfs(neighbor, map, visited);
        }
    }

    public Node cloneGraph(Node node) {
        // 先dfs先生成各个节点，然后用一个hashMap来保存原有节点到新节点的映射
        // 然后根据上面的HashMap就可以将节点连接起来。
        Map<Node, Node> map = new HashMap<>();
        dfs(node, map, new HashSet<>());

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
