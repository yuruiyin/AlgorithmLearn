package problem201_300;

import utils.PrintUtil;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem212 {

    class TrieNode {
        private static final int N = 26;
        private TrieNode[] children;
        private boolean end;
        private String word;

        public TrieNode() {
            children = new TrieNode[N];
        }

        public boolean contains(char c) {
            return children[c - 'a'] != null;
        }

        public void putChild(char c) {
            children[c - 'a'] = new TrieNode();
        }

        public TrieNode getChild(char c) {
            return children[c - 'a'];
        }

        public void setEnd(String word) {
            end = true;
            this.word = word;
        }

        public boolean isEnd() {
            return end;
        }
    }

    private void insert(TrieNode root, String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (!node.contains(c)) {
                node.putChild(c);
            }

            node = node.getChild(c);
        }

        node.setEnd(word);
    }

    private char[][] board;
    private int rowCount;
    private int colCount;
    private Set<String> ansSet;

    private void backTrack(int row, int col, boolean[][] visited, TrieNode curTrieNode) {
        if (row < 0 || row >= rowCount || col < 0 || col >= colCount || visited[row][col]) {
            return;
        }

        curTrieNode = curTrieNode.getChild(board[row][col]);
        if (curTrieNode == null) {
            // 当前遍历的字符串不是Trie的某个前缀，说明当前遍历字符串不是单词列表中的某个单词，可以返回了。
            return;
        }

        visited[row][col] = true;
        if (curTrieNode.isEnd()) {
            ansSet.add(curTrieNode.word);
        }

        backTrack(row-1, col, visited, curTrieNode);
        backTrack(row+1, col, visited, curTrieNode);
        backTrack(row, col-1, visited, curTrieNode);
        backTrack(row, col+1, visited, curTrieNode);

        visited[row][col] = false;
    }

    public List<String> findWords(char[][] board, String[] words) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return new ArrayList<>();
        }

        // 构建前缀树
        TrieNode root = new TrieNode();
        for (String word: words) {
            insert(root, word);
        }

        this.board = board;
        this.rowCount = board.length;
        this.colCount = board[0].length;
        ansSet = new HashSet<>();

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                if (!root.contains(board[i][j])) {
                    continue;
                }
                backTrack(i, j, new boolean[rowCount][colCount], root);
            }
        }

        return new ArrayList<>(ansSet);
    }

    public static void main(String[] args) {
        List<String> ansList = new Problem212().findWords(new char[][]{
                {'a', 'b'}, {'c','d'}
        }, new String[]{"cdba"});

        PrintUtil.printStringList(ansList);
    }

}
