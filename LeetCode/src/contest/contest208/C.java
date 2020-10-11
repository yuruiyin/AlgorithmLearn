package contest.contest208;

import java.util.*;

/**
 * A
 *
 * @author: yry
 * @date: 2020/9/27
 */
public class C {

//    Successor(x, curOrder):
//    如果 x 没有孩子或者所有 x 的孩子都在 curOrder 中：
//    如果 x 是国王，那么返回 null
//    否则，返回 Successor(x 的父亲, curOrder)
//    否则，返回 x 不在 curOrder 中最年长的孩子

    class ThroneInheritance {

        private List<String> orderList;
        private Map<String, List<String>> childrenMap;
        private Set<String> deathSet;
        private String kingName;
        private Map<String, String> parentMap;

        private String successor(String x) {
            if (!childrenMap.containsKey(x)) {
                if (x.equals(kingName)) {
                    return null;
                } else {
                    return successor(parentMap.get(x));
                }
            } else {
                List<String> childList = childrenMap.get(x);
                for (String child : childList) {
                    if (!orderList.contains(child)) {
                        return child;
                    }
                }
            }

            return null;
        }

        public ThroneInheritance(String kingName) {
            this.kingName = kingName;
            orderList = new ArrayList<>();
            orderList.add(kingName);
            childrenMap = new HashMap<>();
            deathSet = new HashSet<>();
            parentMap = new HashMap<>();
        }

        private int getOrderIndex(String name) {
            for (int i = 0; i < orderList.size(); i++) {
                if (name.equals(orderList.get(i))) {
                    return i;
                }
            }
            return -1;
        }

        private int getMaxIndex(String x) {
            List<String> childList = childrenMap.get(x);
            if (childList == null) {
                return getOrderIndex(x);
            }

            int max = 0;
            for (String child : childList) {
                max = Math.max(max, getMaxIndex(child));
            }

            return max;
        }

        public void birth(String parentName, String childName) {
            int insertIndex = -1;
            if (!childrenMap.containsKey(parentName)) {
                insertIndex = getOrderIndex(parentName) + 1;
            } else {
                insertIndex = getMaxIndex(parentName) + 1;
            }
            parentMap.put(childName, parentName);
            if (childrenMap.containsKey(parentName)) {
                childrenMap.get(parentName).add(childName);
            } else {
                List<String> childList = new ArrayList<>();
                childList.add(childName);
                childrenMap.put(parentName, childList);
            }

//            String next = successor(parentName);
//            if (next == null) {
//                orderList.add(childName);
//                return;
//            }

//            System.out.println("index: " + insertIndex);
            orderList.add(insertIndex, childName);
        }

        public void death(String name) {
            deathSet.add(name);
        }

        public List<String> getInheritanceOrder() {
            List<String> ansList = new ArrayList<>();
            for (String name : orderList) {
                if (deathSet.contains(name)) {
                    continue;
                }
                ansList.add(name);
            }
            return ansList;
        }
    }

}
