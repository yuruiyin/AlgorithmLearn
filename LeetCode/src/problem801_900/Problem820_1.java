package problem801_900;

/**
 * Problem820_1
 *
 * @author: yry
 * @date: 2020/3/28
 */
public class Problem820_1 {

    class TrieNode {
        private TrieNode[] children;
        private boolean mIsEnd;

        public TrieNode() {
            children = new TrieNode[26];
        }

        public boolean hasChild(char c) {
            return children[c - 'a'] != null;
        }

        public void addChild(char c) {
            children[c - 'a'] = new TrieNode();
        }

        private TrieNode getChild(char c) {
            return children[c - 'a'];
        }

        public void setEnd(boolean isEnd) {
            mIsEnd = isEnd;
        }

        public boolean isEnd() {
            return mIsEnd;
        }
    }

    private TrieNode root;
    private int ansCount = 0;
    private int leafCount = 0;

    private void addWord(String word) {
        TrieNode cur = root;
        int preWordLen = 0;
        boolean hasMeetEnd = false; //是否碰到一个单词为当前要加入的单词的前缀，即被覆盖
        int wordLen = word.length();
        for (int i = wordLen - 1; i >= 0; i--) {
            char c = word.charAt(i);
            if (cur.hasChild(c)) {
                preWordLen++;
                cur = cur.getChild(c);
                continue;
            }

            if (cur.isEnd()) {
                hasMeetEnd = true;
                cur.setEnd(false);
            }

            for (int j = i; j >= 0; j--) {
                char tmpC = word.charAt(j);
                cur.addChild(tmpC);
                cur = cur.getChild(tmpC);
            }
            cur.setEnd(true);
            break;
        }

        if (hasMeetEnd) {
            ansCount += wordLen - preWordLen;
        } else {
            if (preWordLen < wordLen) {
                ansCount += wordLen;
                leafCount++;
            }
        }
    }

    public int minimumLengthEncoding(String[] words) {
        root = new TrieNode();

        for (String word : words) {
            addWord(word);
        }

        return ansCount + leafCount;
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem820_1().minimumLengthEncoding(new String[]{"time", "me", "bell"}));
        System.out.println(new Problem820_1().minimumLengthEncoding(new String[]{"me", "time"}));
        System.out.println(new Problem820_1().minimumLengthEncoding(new String[]{"time", "atime", "btime"}));

    }

}
