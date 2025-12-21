package contest.contest430;

public class B {

    public String answerString(String word, int numFriends) {
        if (numFriends == 1) {
            return word;
        }
        int len = word.length();
        String ansStr = "a";
        for (int i = 0; i < len; i++) {
            int left = i;
            int right = Math.max(0, numFriends - left - 1);
            int s = i;
            int e = len - right - 1;
            String subStr = word.substring(s, e + 1);
            if (subStr.compareTo(ansStr) > 0) {
                ansStr = subStr;
            }
        }
        return ansStr;
    }

}
