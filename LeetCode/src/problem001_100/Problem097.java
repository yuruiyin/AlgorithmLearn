package problem001_100;

import java.util.HashMap;
import java.util.Map;

public class Problem097 {

    private char[] s1;
    private char[] s2;
    private char[] s3;
    private int len1;
    private int len2;
    private int len3;

    private Map<Integer, Boolean> memoMap = new HashMap<>();

    private boolean backTrack(int from1, int from2, int from3) {
        if (from3 == len3) {
            return true;
        }

        if (from1 == len1 && from2 == len2) {
            return false;
        }

        int key = from1 * 10000 + from2 * 100 + from3;

        if (memoMap.containsKey(key)) {
            return memoMap.get(key);
        }

        char c3 = s3[from3];
        boolean isFound1 = false;
        if (from1 < len1 && s1[from1] == c3) {
            isFound1 = backTrack(from1+1, from2, from3+1);
        }

        if (isFound1) {
            memoMap.put(key, true);
            return true;
        }

        boolean isFound2 = false;
        if (from2 < len2 && s2[from2] == c3) {
            isFound2 = backTrack(from1, from2+1, from3+1);
        }

        memoMap.put(key, isFound2);
        return isFound2;
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        len1 = s1.length();
        len2 = s2.length();
        len3 = s3.length();

        if (len1 + len2 != len3) {
            return false;
        }

        this.s1 = s1.toCharArray();
        this.s2 = s2.toCharArray();
        this.s3 = s3.toCharArray();

        return backTrack(0, 0, 0);
    }

    public static void main(String[] args) {
//        System.out.println(new Problem097().isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        System.out.println(new Problem097().isInterleave("aabcc", "dbbca", "aadbbbaccc"));
    }
    
}
