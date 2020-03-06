package problem401_500;

import java.util.*;

public class Problem488 {

    private int ansMin = Integer.MAX_VALUE;

    private List<int[]> getIndexList(List<Character> boardList, int needCount) {
        int count = 1;
        int start = 0;
        List<int[]> posList = new ArrayList<>();
        for (int i = 1; i < boardList.size(); i++) {
            if (boardList.get(i) == boardList.get(i-1)) {
                count++;
            } else {
                // 需要考虑1，2，>=3个的情况
                if (needCount < 3) {
                    if (count == needCount) {
                        posList.add(new int[]{start, needCount});
                    }
                } else {
                    if (count >= 3) {
                        posList.add(new int[]{start, count});
                    }
                }

                count = 1;
                start = i;
            }
        }

        if (needCount < 3) {
            if (count == needCount) {
                posList.add(new int[]{start, needCount});
            }
        } else {
            if (count >= 3) {
                posList.add(new int[]{start, count});
            }
        }

        return posList;
    }

    private void rec(List<Character> boardList, int[] handCountMap, int useCount) {
        if (useCount >= ansMin) {
            return;
        }

        if (boardList.isEmpty()) {
            ansMin = Math.min(ansMin, useCount);
            return;
        }

        // 分成先删连续1个字符、连续2个字符，连续3个及以上字符
        // 对单个字符，可能需要填充两个字符, 对连续2个字符，需要填充一个字符。
        for (int i = 1; i <= 2; i++) {
            List<int[]> indexList = getIndexList(boardList, i);
            int needCount = 3 - i; // 需要多少才能凑到3个
            for (int[] pos: indexList) {
                int index = pos[0];
                char c = boardList.get(index);
                int leftCount = handCountMap[c - 'A'];
                if (leftCount >= needCount) {
                    handCountMap[c - 'A'] = leftCount - needCount;
                    List<Character> nextBoardList = new ArrayList<>(boardList);
                    for (int j = 1; j <= i; j++) {
                        nextBoardList.remove(index);
                    }
                    rec(nextBoardList, handCountMap, useCount + needCount);
                    handCountMap[c - 'A'] = leftCount;
                }
            }
        }

        // 可能先删连续三个字符及以上的连续字符
        List<int[]> treePosList = getIndexList(boardList, 3);
        for (int[] pos : treePosList) {
            int index = pos[0];
            int cnt = pos[1];
            List<Character> nextBoardList = new ArrayList<>();
            nextBoardList.addAll(boardList.subList(0, index));
            if (index + cnt < boardList.size()) {
                nextBoardList.addAll(boardList.subList(index + cnt, boardList.size()));
            }
            rec(nextBoardList, handCountMap, useCount);
        }
    }

    public int findMinStep(String board, String hand) {
        List<Character> boardList = new ArrayList<>();
        for (char c : board.toCharArray()) {
            boardList.add(c);
        }

        int[] handCountMap = new int[26];
        for (char c : hand.toCharArray()) {
            handCountMap[c - 'A']++;
        }

        rec(boardList, handCountMap, 0);
        return ansMin == Integer.MAX_VALUE ? -1 : ansMin;
    }
    
    public static void main(String[] args) {
//        System.out.println(new Problem488().findMinStep("WRRBBW", "RB"));
//        System.out.println(new Problem488().findMinStep("WWRRBBWW", "WRBRW"));
//        System.out.println(new Problem488().findMinStep("WWWW", "WRBRW"));
//        System.out.println(new Problem488().findMinStep("G", "GGGGG"));
//        System.out.println(new Problem488().findMinStep("RBYYBBRRB", "YRBGB"));
//        System.out.println(new Problem488().findMinStep("WWGWGW", "GWBWR"));
        System.out.println(new Problem488().findMinStep("RWYWRRWRR", "YRY"));
        System.out.println(new Problem488().findMinStep("RRWWRRRBBR", "WB"));

    }

}
