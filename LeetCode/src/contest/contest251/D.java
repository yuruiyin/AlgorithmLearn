package contest.contest251;

import java.util.*;

/**
 * A
 *
 * @author: yry
 * @date: 2021/7/25
 */
public class D {

    class Node {
        List<Node> children;
        String value;
        Node(String value) {
            this.value = value;
        }
    }

    private Map<String, List<String>> map;
    private Map<String, Integer> childCountMap;

    public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
        Set<String> set = new HashSet<>();
        map = new HashMap<>();
        Map<String, String> parentMap = new HashMap<>();
        for (List<String> path : paths) {
            int size = path.size();
            for (int i = size - 1; i > 0; i--) {
                
            }
            for (int i = 0; i < size - 1; i++) {
                String fileName = path.get(i);
                set.add(fileName);
                if (!map.containsKey(fileName)) {
                    map.put(fileName, new ArrayList<>());
                }
                map.get(fileName).add(path.get(i + 1));
            }
            set.add(path.get(size - 1));
        }


        // 求所有叶子节点
        Set<String> leafSet = new HashSet<>(set);
        for (String key : map.keySet()) {
            leafSet.remove(key);
        }

        return null;
    }

}
