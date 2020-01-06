package contest.contest104;

public class Problem04 {

    private int[][] graph;
    private boolean[][][] visited;

    private int backTrack(int mousePos, int catPos, boolean isMouseTurn) {

        if (visited[mousePos][catPos][isMouseTurn ? 1 : 0]) {
            return -1;
        }

        visited[mousePos][catPos][isMouseTurn ? 1 : 0] = true;

        if (isMouseTurn) {
            boolean isAllCatWin = true;
            for (int next: graph[mousePos]) {
                if (next == 0) {
                    return 1; //老鼠进洞了
                }

                if (next == catPos) {
                    continue;
                }

                int res = backTrack(next, catPos, false);
                if (res == 1) {
                    return 1;
                }

                if (res != 2) {
                    isAllCatWin = false;
                }
            }

            // 所有的方案，老鼠都无法赢
            return isAllCatWin ? 2 : 0;
        }

        for (int next : graph[catPos]) {
            if (next == 0) {
                continue;
            }

            if (next == mousePos) {
                return 2;
            }

            int res = backTrack(mousePos, next, true);
            if (res != 1 && res != -1) {
                // 猫存在一个方案，老鼠赢不了
                return res;
            }
        }

        return 1;
    }

    public int catMouseGame(int[][] graph) {
        // 猫只要存在一个行走方案，让老鼠怎么走都会重复出现，则平局，让老鼠怎么走猫都会到达老鼠的地点，则猫赢
        // 否则，老鼠赢。
        this.graph = graph;
        int len = graph.length;
        visited = new boolean[len+1][len+1][2];
        return backTrack(1, 2, true);
    }

    public static void main(String[] args) {
        System.out.println(new Problem04().catMouseGame(new int[][]{
                {6},{4},{9},{5},{1,5},{3,4,6},{0,5,10},{8,9,10},{7},{2,7},{6,7}
        }));
    }

}
