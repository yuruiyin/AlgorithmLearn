package dsu;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * DSUTest
 *
 * @author: yry
 * @date: 2020/3/24
 */
public class DSUTest {

    // 官方版本
    public static int countComponentsOfficial(int n, int[][] edges) {
        OfficialDSU dsu = new OfficialDSU(n);
        for (int[] edge : edges) {
            dsu.union(edge[0], edge[1]);
        }
        return dsu.count;
    }

    // 我的dsu树的版本（非链表版）
    public static int countComponentsTreeDSU(int n, int[][] edges) {
        TreeDSU dsu = new TreeDSU(n);
        for (int[] edge : edges) {
            dsu.union(edge[0], edge[1]);
        }
        return dsu.size();
    }

    // 我的DSU链表版
    public static int countComponentsLinkDSU(int n, int[][] edges) {
        LinkDSU dsu = new LinkDSU(n);
        for (int[] edge : edges) {
            dsu.union(edge[0], edge[1]);
        }
        return dsu.size();
    }

    // zqc版本
    public static int countComponentsZqc(int n, int[][] edges) {
        ZqcDSU dsu = new ZqcDSU(n);
        for (int[] edge : edges) {
            dsu.union(edge[0], edge[1]);
        }
        return dsu.size();
    }

    public static void testOfficial(int[][] edges) {
        long startTime = System.currentTimeMillis();
        int ans = 0;
        for (int j = 0; j < 10; j++) {
            ans = countComponentsOfficial(N, edges);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Official版本： 执行10次总耗时: " + (endTime - startTime) + "ms;   " + "连通分量个数：" + ans);
    }

    public static void testMineTree(int[][] edges) {
        long startTime = System.currentTimeMillis();
        int ans = 0;
        for (int j = 0; j < 10; j++) {
            ans = countComponentsTreeDSU(N, edges);
        }
        long endTime = System.currentTimeMillis();
        System.out.println(" TreeDSU版本： 执行10次总耗时: " + (endTime - startTime) + "ms;   " + "连通分量个数：" + ans);
    }

    public static void testMineLink(int[][] edges) {
        long startTime = System.currentTimeMillis();
        int ans = 0;
        for (int j = 0; j < 10; j++) {
            ans = countComponentsLinkDSU(N, edges);
        }
        long endTime = System.currentTimeMillis();
        System.out.println(" LinkDSU版本： 执行10次总耗时: " + (endTime - startTime) + "ms;   " + "连通分量个数：" + ans);
    }

    public static void testZqc(int[][] edges) {
        long startTime = System.currentTimeMillis();
        int ans = 0;
        for (int j = 0; j < 10; j++) {
            ans = countComponentsZqc(N, edges);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("     Zqc版本： 执行10次总耗时: " + (endTime - startTime) + "ms;   " + "连通分量个数：" + ans);
    }

    private static final int N = 1000_0000;    // 点的个数
    private static final double MUL = 0.001;  // 点数是边数的多少倍

    public static void createInput() {
        try {
            File file = new File("output.txt");
            file.createNewFile();
            BufferedWriter out = new BufferedWriter(new FileWriter(file));

            Set<Long> set = new HashSet<>();
            Random random = new Random();
            for (int i = 0; i < N * MUL; i++) {
                int node1 = random.nextInt(N);
                int node2 = random.nextInt(N);
                if (node1 == node2) { // 不允许自环
                    i--;
                    continue;
                }

                int min = Math.min(node1, node2);
                int max = Math.max(node1, node2);

                if (set.contains((long)min * N + max)) {
                    i--;
                    continue;
                }

                set.add((long)min * N + max);
                out.write(min + " " + max + "\n");
            }

            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void doTest(int[][] edges) {
        try {
            testOfficial(edges);
            Thread.sleep(500);
            testMineTree(edges);
            Thread.sleep(500);
            testMineLink(edges);
            Thread.sleep(500);
            testZqc(edges);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void run() {
        // 读文件
        File file = new File("output.txt");
        try {
            InputStreamReader reader = new InputStreamReader(new FileInputStream(file));
            BufferedReader br = new BufferedReader(reader);
            int[][] edges = new int[(int) (N * MUL)][2];
            String line = "";
            int i = 0;
            while ((line = br.readLine()) != null) {
                String[] arr = line.split(" ");
                edges[i++] = new int[]{Integer.parseInt(arr[0]), Integer.parseInt(arr[1])} ;
            }

            System.out.println(N + "个节点，" + (int) (N * MUL) + "条边");
            System.out.println("排序前：");
            doTest(edges);

            // 排序或不排序对结果有比较大的影响，特别是当边数比点数多很多的时候，即连通分量很少的时候，我的link版本速度特别快，效率可以达到其他三种算法的三四倍
            Arrays.sort(edges, (o1, o2) -> o1[0] - o2[0]);
            System.out.println();
            System.out.println("排序后：");
            doTest(edges);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        createInput();
        run();
//        System.out.println(countComponents(10, new int[][]{
//                {5,6},{0,2},{1,7},{5,9},{1,8},{3,4},{0,6},{0,7},{0,3},{8,9}
//        }));
    }

}
