package problem601_700;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Problem690 {

    class Employee {
        // It's the unique id of each node;
        // unique id of this employee
        public int id;
        // the importance value of this employee
        public int importance;
        // the id of direct subordinates
        public List<Integer> subordinates;
    }

    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Integer> importanceMap = new HashMap<>();
        Map<Integer, List<Integer>> subListMap = new HashMap<>();

        for (Employee employee : employees) {
            importanceMap.put(employee.id, employee.importance);
            subListMap.put(employee.id, employee.subordinates);
        }

        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(id);

        int ans = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                ans += importanceMap.get(cur);

                for (Integer next: subListMap.get(cur)) {
                    queue.add(next);
                }
            }
        }

        return ans;
    }

}
