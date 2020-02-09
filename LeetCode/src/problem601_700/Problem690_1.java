package problem601_700;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem690_1 {

    class Employee {
        // It's the unique id of each node;
        // unique id of this employee
        public int id;
        // the importance value of this employee
        public int importance;
        // the id of direct subordinates
        public List<Integer> subordinates;
    }

    private Map<Integer, Integer> importanceMap;
    private Map<Integer, List<Integer>> subListMap;

    private int dfs(int id) {
        int ans = importanceMap.get(id);

        for (Integer next: subListMap.get(id)) {
            ans += dfs(next);
        }

        return ans;
    }

    public int getImportance(List<Employee> employees, int id) {
        importanceMap = new HashMap<>();
        subListMap = new HashMap<>();

        for (Employee employee : employees) {
            importanceMap.put(employee.id, employee.importance);
            subListMap.put(employee.id, employee.subordinates);
        }

        return dfs(id);
    }

}
