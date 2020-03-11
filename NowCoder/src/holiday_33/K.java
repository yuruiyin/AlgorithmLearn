package holiday_33;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class K {
    
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task task = new Task();
        task.solve(1, in, out);
        out.close();
    }

    static class Task {

        private int[] getStartPos(char[][] grid, int n, int m) {
            int[] pos = new int[2];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (grid[i][j] == '@') {
                        pos[0] = i;
                        pos[1] = j;
                    }
                }
            }
            return pos;
        }

        class Node {
            int r;
            int c;
            int w;
            Node(int r, int c, int w) {
                this.r = r;
                this.c = c;
                this.w = w;
            }
        }


        public List<int[]>[] getSlideListArr(char[][] grid, int n, int m) {
            List<int[]>[] slideListArr = new ArrayList[26];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    char c = grid[i][j];
                    if (Character.isUpperCase(c)) {
                        if (slideListArr[c - 'A'] == null) {
                            slideListArr[c - 'A'] = new ArrayList<>();
                        }
                        slideListArr[c - 'A'].add(new int[]{i, j});
                    }
                }
            }
            return slideListArr;
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int m = in.nextInt();
            char[][] grid = new char[n][m];

            for (int i = 0; i < n; i++) {
                String str = in.next();
                grid[i] = str.toCharArray();
            }

            // bfs
            int[] startPos = getStartPos(grid, n, m);
            int startRow = startPos[0];
            int startCol = startPos[1];
            LinkedList<Node> queue = new LinkedList<>();
            queue.offer(new Node(startRow, startCol, 0));
            Node[][] visited = new Node[n][m];
            visited[startRow][startCol] = new Node(startCol, startRow, 0);
            int[] dx = new int[]{0, 0, -1, 1};
            int[] dy = new int[]{-1, 1, 0, 0};
            int ansMin = Integer.MAX_VALUE;

            List<int[]>[] slideListArr = getSlideListArr(grid, n, m);

            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    Node node = queue.poll();
                    int row = node.r;
                    int col = node.c;
                    int w = node.w;
                    if (grid[row][col] == '=') {
                        ansMin = Math.min(ansMin, w);
                    }

                    if (w >= ansMin) {
                        continue;
                    }

                    for (int j = 0; j < 4; j++) {
                        int nextRow = row + dx[j];
                        int nextCol = col + dy[j];
                        if (nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= m) {
                            continue;
                        }

                        char c = grid[nextRow][nextCol];
                        if (c == '#') {
                            continue;
                        }

                        if (Character.isUpperCase(c)) {
                            List<int[]> slideList = slideListArr[c - 'A'];
                            if (slideList.size() == 2) {
                                int[] first = slideList.get(0);
                                int[] second = slideList.get(1);
                                if (first[0] == nextRow && first[1] == nextCol) {
                                    nextRow = second[0];
                                    nextCol = second[1];
                                } else {
                                    nextRow = first[0];
                                    nextCol = first[1];
                                }
                            }
                        }

                        if (visited[nextRow][nextCol] != null && visited[nextRow][nextCol].w <= w + 1) {
                            continue;
                        }

                        Node nextNode = new Node(nextRow, nextCol, w + 1);
                        visited[nextRow][nextCol] = nextNode;
                        queue.offer(nextNode);
                    }
                }
            }

            out.println(ansMin);
        }
    }

    static class InputReader {

        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

    }

}
