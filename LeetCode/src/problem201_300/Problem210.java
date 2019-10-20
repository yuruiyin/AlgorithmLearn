package problem201_300;

import java.util.ArrayList;
import java.util.LinkedList;

public class Problem210 {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] adj = new ArrayList[numCourses];

        for (int i = 0; i < numCourses; i++) {
            adj[i] = new ArrayList<>();
        }

        // 构建邻接表
        for (int[] prerequisite : prerequisites) {
            int cur = prerequisite[0];
            int prev = prerequisite[1];

            adj[prev].add(cur);
        }

        int[] inDegree = new int[numCourses];

        // 计算各个节点的入度
        for (int i = 0; i < numCourses; i++) {
            if (adj[i].isEmpty()) {
                continue;
            }

            int size = adj[i].size();
            for (int j = 0; j < size; j++) {
                int w = adj[i].get(j);
                inDegree[w]++;
            }
        }

        // 将入度为0的加入到入列中
        LinkedList<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.addLast(i);
            }
        }

        // 构建最长排序列表，判断列表长度是否等于课程数
        int[] ansArr = new int[numCourses];
        int count = 0;
        while (!queue.isEmpty()) {
            int course = queue.removeFirst();
            ansArr[count++] = course;

            int size = adj[course].size();
            for (int i = 0; i < size; i++) {
                int w = adj[course].get(i);
                inDegree[w]--;
                if (inDegree[w] == 0) {
                    queue.addLast(w);
                }
            }
        }

        if (count != numCourses) {
            return new int[]{};
        }

        return ansArr;
    }
    
    public static void main(String[] args) {
//        int[] arr = new Problem210().findOrder(2, new int[][]{
//                {1,0}
//        });

//        int[] arr = new Problem210().findOrder(4, new int[][]{
//                {1,0},
//                {2,0},
//                {3,1},
//                {3,2}
//        });

        int[] arr = new Problem210().findOrder(2, new int[][]{
                {1,0},
                {0,1}
        });
        
        for (int course: arr) {
            System.out.print(course + ",");
        }
        System.out.println();


    }
    
}
