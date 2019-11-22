package problem101_200;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Problem127 {

    private boolean[] beginVisited;
    private boolean[] endVisited;
    private List<Integer>[] adj;
    private int lenFromBegin = 0;
    private int lenFromEnd = 0;

    private boolean isOneCharDiff(String s1, String s2) {
        int len = s1.length();

        int diffCount = 0;

        for (int i = 0; i < len; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diffCount++;
            }

            if (diffCount > 1) {
                return false;
            }
        }

        return true;
    }

    /**
     * 返回是否相遇
     */
    private boolean doBfs(LinkedList<Integer> queue, boolean isFromBegin) {
        if (isFromBegin) {
            lenFromBegin++;
        } else {
            lenFromEnd++;
        }

        List<Integer> nodeList = new ArrayList<>();
        while (!queue.isEmpty()) {
            nodeList.add(queue.removeFirst());
        }

        for (Integer wordIndex : nodeList) {
            List<Integer> neighborList = adj[wordIndex];
            if (neighborList.isEmpty()) {
                continue;
            }

            for (Integer neighbor: neighborList) {
                if (isFromBegin && beginVisited[neighbor] || !isFromBegin && endVisited[neighbor]) {
                    continue;
                }

                if (isFromBegin && endVisited[neighbor] || !isFromBegin && beginVisited[neighbor]) {
                    return true;
                }

                if (isFromBegin) {
                    beginVisited[neighbor] = true;
                } else {
                    endVisited[neighbor] = true;
                }
                queue.add(neighbor);
            }
        }

        return false;
    }

    private int twoWayBfs(List<Integer>[] adj, List<String> wordList, String endWord) {
        LinkedList<Integer> beginQueue = new LinkedList<>();
        LinkedList<Integer> endQueue = new LinkedList<>();
        int wordSize = wordList.size();
        beginVisited = new boolean[wordSize];
        endVisited = new boolean[wordSize];

        int startWordIndex = wordSize - 1;
        int endWordIndex = wordList.indexOf(endWord);
        beginQueue.add(startWordIndex);
        endQueue.add(endWordIndex);
        beginVisited[wordSize-1] = true;
        endVisited[endWordIndex] = true;

        while (!beginQueue.isEmpty() && !endQueue.isEmpty()) {
            boolean isFoundFromBegin = doBfs(beginQueue, true);
            if (isFoundFromBegin) {
                return lenFromBegin + 1 + lenFromEnd;
            }

            boolean isFoundFromEnd = doBfs(endQueue, false);
            if (isFoundFromEnd) {
                return lenFromBegin + lenFromEnd + 1;
            }
        }

        return 0;
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }

        wordList.add(beginWord);
        int wordSize = wordList.size();
        adj = new ArrayList[wordSize];

        for (int i = 0; i < wordSize; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < wordSize; i++) {
            for (int j = i + 1; j < wordSize; j++) {
                String s1 = wordList.get(i);
                String s2 = wordList.get(j);
                if (isOneCharDiff(s1, s2)) {
                    adj[i].add(j);
                    adj[j].add(i);
                }
            }
        }

        // BFS
        return twoWayBfs(adj, wordList, endWord);
    }
    
    public static void main(String[] args) {

    }
    
}
