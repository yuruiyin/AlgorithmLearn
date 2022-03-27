package contest.contest285;

import kotlin.Pair;

import javax.swing.*;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeSet;

public class D {

    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        char[] arr = s.toCharArray();
        int len = arr.length;
        char[] queryArr = queryCharacters.toCharArray();
        // 根据坐标排序
        TreeSet<Pair<Integer, Integer>>[] intervalTreeSetArr = new TreeSet[26];
        // 根据区间长度排序
        TreeSet<Pair<Integer, Integer>>[] intervalTreeSetArr1 = new TreeSet[26];
        for (int i = 0; i < 26; i++) {
            TreeSet<Pair<Integer, Integer>> treeSet = new TreeSet<>(Comparator.comparingInt(Pair<Integer, Integer>::getFirst));
            TreeSet<Pair<Integer, Integer>> treeSet1 = new TreeSet<>((o1, o2) -> o1.getSecond() - o1.getFirst() - (o2.getSecond() - o2.getFirst()));
            intervalTreeSetArr[i] = treeSet;
            intervalTreeSetArr1[i] = treeSet1;
        }

        int l = 0;
        for (int i = 1; i < len; i++) {
            if (arr[i] != arr[i - 1]) {
                Pair<Integer, Integer> interval = new Pair<>(l , i - 1);
                intervalTreeSetArr[arr[i - 1] - 'a'].add(interval);
                intervalTreeSetArr1[arr[i - 1] - 'a'].add(interval);
            }
        }

        int[] ansArr = new int[queryIndices.length];
        for (int i = 0; i < queryIndices.length; i++) {
            int idx = queryIndices[i];
            char newC = queryArr[i];
            char oldC = arr[i];
            if (newC == oldC) {
                int maxLen = 0;
                for (int j = 0; j < 26; j++) {
                    Pair<Integer, Integer> maxLenPair = intervalTreeSetArr1[j].last();
                    if (maxLenPair == null) {
                        continue;
                    }
                    maxLen = Math.max(maxLen, maxLenPair.getSecond() - maxLenPair.getFirst());
                }
                ansArr[i] = maxLen;
                continue;
            }

            TreeSet<Pair<Integer, Integer>> treeSet = intervalTreeSetArr[oldC - 'a'];
            Pair<Integer, Integer> floorPair = treeSet.floor(new Pair<>(idx, idx));
            if (floorPair.getSecond() - floorPair.getFirst() == 0) {
                // 区间长度为1，则替换完，相当于删掉
                intervalTreeSetArr[oldC - 'a'].remove(floorPair);
                intervalTreeSetArr1[oldC - 'a'].remove(floorPair);
                if (idx == 0) {
                    if (idx == len - 1 || arr[idx] != arr[idx + 1]) {
                        // 当前就只有字符
                        Pair<Integer, Integer> newPair = new Pair<>(idx, idx);
                        intervalTreeSetArr[newC - 'a'].add(newPair);
                        intervalTreeSetArr1[newC - 'a'].add(newPair);
                    } else {
                        // arr[idx] != arr[idx + 1]
                        TreeSet<Pair<Integer, Integer>> treeSet1 = intervalTreeSetArr[newC - 'a'];
                        Pair<Integer, Integer> higherPair = treeSet1.higher(new Pair<>(idx, idx));
                        intervalTreeSetArr[newC - 'a'].remove(higherPair);
                        intervalTreeSetArr1[newC - 'a'].remove(higherPair);
                        Pair<Integer, Integer> newPair = treeSet.higher(new Pair<>(idx, higherPair.getSecond()));
                        intervalTreeSetArr[newC - 'a'].add(newPair);
                        intervalTreeSetArr1[newC - 'a'].add(newPair);
                    }
                } else if (idx == len - 1) {
                    if (arr[idx] != arr[idx - 1]) {
                        Pair<Integer, Integer> newPair = new Pair<>(idx, idx);
                        intervalTreeSetArr[newC - 'a'].add(newPair);
                        intervalTreeSetArr1[newC - 'a'].add(newPair);
                    } else {

                    }
                }
            } else if (idx == floorPair.getFirst()) {
                // 当前替换的是区间的最左侧字符，则区间大小减一
                intervalTreeSetArr[oldC - 'a'].remove(floorPair);
                intervalTreeSetArr1[oldC - 'a'].remove(floorPair);
                Pair<Integer, Integer> newPair = new Pair<>(floorPair.getFirst() + 1, floorPair.getSecond());
                intervalTreeSetArr[oldC - 'a'].add(newPair);
                intervalTreeSetArr1[oldC - 'a'].add(newPair);
                TreeSet<Pair<Integer, Integer>> newCTreeSet = intervalTreeSetArr[newC - 'a'];

            } else if (idx == floorPair.getSecond()) {
                // 当前替换的是区间的最右侧字符，则区间大小减一
                intervalTreeSetArr[oldC - 'a'].remove(floorPair);
                intervalTreeSetArr1[oldC - 'a'].remove(floorPair);
                Pair<Integer, Integer> newPair = new Pair<>(floorPair.getFirst(), floorPair.getSecond() - 1);
                intervalTreeSetArr[oldC - 'a'].add(newPair);
                intervalTreeSetArr1[oldC - 'a'].add(newPair);
            } else {
                // 当前替换的是区间中非两端的字符
                intervalTreeSetArr[oldC - 'a'].remove(floorPair);
                intervalTreeSetArr1[oldC - 'a'].remove(floorPair);
                Pair<Integer, Integer> leftPair = new Pair<>(floorPair.getFirst(), idx - 1);
                Pair<Integer, Integer> rightPair = new Pair<>(idx + 1, floorPair.getSecond());
                intervalTreeSetArr[oldC - 'a'].add(leftPair);
                intervalTreeSetArr[oldC - 'a'].add(rightPair);
                intervalTreeSetArr1[oldC - 'a'].add(leftPair);
                intervalTreeSetArr1[oldC - 'a'].add(rightPair);
                intervalTreeSetArr[newC - 'a'].add(new Pair<>(idx, idx));
                intervalTreeSetArr1[newC - 'a'].add(new Pair<>(idx, idx));
            }
        }

        return null;
    }

    public static void main(String[] args) {

    }

}
