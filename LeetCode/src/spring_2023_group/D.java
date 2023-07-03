package spring_2023_group;

import java.util.*;

public class D {

    private List<Integer>[] adj;
    private int n;

    private String rec(int node) {
        List<Integer> nextList = adj[node];
        if (nextList.isEmpty()) {
            // 叶子
            return "";
        }

        List<String> strList = new ArrayList<>();
        for (int next : nextList) {
            strList.add("0" + rec(next));
        }
        Collections.sort(strList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() > o2.length() && o1.startsWith(o2)) {
                    if (o1.charAt(o2.length()) == '0') {
                        return -1;
                    }
                    return o1.substring(o2.length() + 1).compareTo(o2);
                } else if (o2.length() > o1.length() && o2.startsWith(o1)) {
                    if (o2.charAt(o1.length()) == '0') {
                        return 1;
                    }
                    return o2.substring(o1.length() + 1).compareTo(o1);
                }
                return o1.compareTo(o2);
            }
        });
        StringBuilder resSb = new StringBuilder();
        for (String str : strList) {
            resSb.append(str).append("1");
        }
        return resSb.toString();
    }

    public String evolutionaryRecord(int[] parents) {
        // 从最长的路径开始，但是最长的路径可能有多条
        this.n = parents.length;
        adj = new ArrayList[n];
        Arrays.setAll(adj, value -> new ArrayList<>());
        int root = 0;
        for (int i = 0; i < n; i++) {
            int p = parents[i];
            if (p == -1) {
                root = i;
                continue;
            }
            adj[p].add(i);
        }

        String ans = rec(root);
        // 去掉尾部的1
        StringBuilder ansSb = new StringBuilder();
        char[] arr = ans.toCharArray();
        boolean hasZero = false;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == '0') {
                hasZero = true;
            }
            if (hasZero) {
                ansSb.append(arr[i]);
            }
        }
        return ansSb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new D().evolutionaryRecord(new int[]{-1,0,0,2}));
    }

}
