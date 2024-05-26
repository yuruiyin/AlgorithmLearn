package contest.contest390;

public class D {

    class Trie {
        private Trie[] children;
        private boolean mIsEnd;
        private int height;

        private int wordIdx;

        private int wordLen;

        public Trie() {
            children = new Trie[26];
        }

        public void addChild(char c, int wordIdx, int wordLen) {
            Trie trie = new Trie();
            trie.wordIdx = wordIdx;
            trie.wordLen = wordLen;
            children[c - 'a'] = trie;
        }

        private int getWordIdx() {
            return wordIdx;
        }

        public void setWordIdx(int wordIdx) {
            this.wordIdx = wordIdx;
        }

        public boolean hasChild(char c) {
            return children[c - 'a'] != null;
        }

        public Trie getChild(char c) {
            return children[c - 'a'];
        }

        public void setEnd() {
            this.mIsEnd = true;
        }

        public boolean isEnd() {
            return mIsEnd;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public int getWordLen() {
            return wordLen;
        }

        public void setWordLen(int wordLen) {
            this.wordLen = wordLen;
        }
    }

    private Trie root;

    private void addWord(String word, int wordIdx) {
        Trie cur = root;
        char[] arr = word.toCharArray();
        for (int i = arr.length - 1; i >= 0; i--) {
            char c = arr[i];
            if (!cur.hasChild(c)) {
                cur.addChild(c, wordIdx, word.length());
            } else {
                Trie child = cur.getChild(c);
                if (word.length() < child.getWordLen()) {
                    child.setWordLen(word.length());
                    child.setWordIdx(wordIdx);
                }
            }
            cur = cur.getChild(c);
        }
        cur.setEnd();
    }

    private void createWordsTrie(String[] words) {
        root = new Trie();
        int len = words.length;
        for (int i = 0; i < len; i++) {
            addWord(words[i], i);
        }
    }

    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        createWordsTrie(wordsContainer);
        int len = wordsQuery.length;
        int[] indexArr = new int[len];

        int minLen = 5001;
        int minIdx = -1;
        for (int i = 0; i < wordsContainer.length; i++) {
            String word = wordsContainer[i];
            if (word.length() < minLen) {
                minLen = word.length();
                minIdx = i;
            }
        }

        for (int i = 0; i < len; i++) {
            String word = wordsQuery[i];
            char[] arr = word.toCharArray();
            Trie cur = root;
            int idx = -1;
            for (int j = arr.length - 1; j >= 0; j--) {
                char c = arr[j];
                if (!cur.hasChild(c)) {
                    break;
                }
                idx = cur.getChild(c).wordIdx;
                cur = cur.getChild(c);
            }
            if (idx == -1) {
                // 没有公共后缀
                indexArr[i] = minIdx;
            } else {
                indexArr[i] = idx;
            }
        }

        return indexArr;
    }

    public static void main(String[] args) {
//        int[] ansArr = new D().stringIndices(new String[]{"abcd", "bcd", "xbcd"}, new String[]{"cd", "bcd", "xyz"});
        int[] ansArr = new D().stringIndices(new String[]{"abcdefgh","poiuygh","ghghgh"}, new String[]{"gh","acbfgh","acbfegh"});
    }


}
