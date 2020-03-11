package problem601_700;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem648 {

    class Trie {
        private Trie[] children;
        private boolean mIsEnd;
        private String word;

        public Trie() {
            children = new Trie[26];
        }

        public boolean hasChild(char c) {
            return children[c - 'a'] != null;
        }

        public void put(char c) {
            children[c - 'a'] = new Trie();
        }

        public Trie get(char c) {
            return children[c - 'a'];
        }

        public void setEnd(String word) {
            mIsEnd = true;
            this.word = word;
        }

        public boolean isEnd() {
            return mIsEnd;
        }

    }

    private Trie createTrie(List<String> dict) {
        // 建Trie树
        Trie trie = new Trie();
        for (String word : dict) {
            Trie curTrie = trie;
            int len = word.length();
            for (int i = 0; i < len; i++) {
                char c = word.charAt(i);
                if (!curTrie.hasChild(c)) {
                    curTrie.put(c);
                }
                curTrie = curTrie.get(c);
            }

            curTrie.setEnd(word);
        }

        return trie;
    }

    private String convert(String word, Trie trie) {
        Trie curTrie = trie;
        int len = word.length();
        for (int i = 0; i < len; i++) {
            char c = word.charAt(i);
            if (!curTrie.hasChild(c)) {
                return word;
            }

            curTrie = curTrie.get(c);
            if (curTrie.isEnd()) {
                return curTrie.word;
            }
        }

        return word;
    }

    public String replaceWords(List<String> dict, String sentence) {
        // 建Trie树
        Trie trie = createTrie(dict);
        String[] words = sentence.split(" ");
        int wordSize = words.length;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < wordSize; i++) {
            sb.append(convert(words[i], trie));
            if (i != wordSize - 1) {
                sb.append(' ');
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        List<String> dict = new ArrayList<>(Arrays.asList("a", "aa", "aaa", "aaaa"));
        String sentence = "a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa";
        System.out.println(new Problem648().replaceWords(dict, sentence));
    }

}
