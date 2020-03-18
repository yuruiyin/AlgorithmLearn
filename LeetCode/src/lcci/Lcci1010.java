package lcci;

import utils.SegmentTree;

/**
 * Lcci1010
 *
 * @author: yry
 * @date: 2020/3/17
 */
public class Lcci1010 {

    class StreamRank {

        private static final int MAX = 50000;

        private SegmentTree segmentTree;

        public StreamRank() {
            segmentTree = new SegmentTree(0, MAX);
        }

        public void track(int x) {
            segmentTree.insert(x);
        }

        public int getRankOfNumber(int x) {
            return segmentTree.findSmallerOrEqualCount(x);
        }
    }

}
