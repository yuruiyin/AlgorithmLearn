package doubleContest.round07;

public class Problem1165 {

    public int calculateTime(String keyboard, String word) {
        int[] indexArr = new int[26];
        for (int i = 0; i < keyboard.length(); i++) {
            indexArr[keyboard.charAt(i) - 'a'] = i;
        }

        int lastIndex = 0;
        int sum = 0;
        for (int i = 0; i < word.length(); i++) {
            int curIndex = indexArr[word.charAt(i) - 'a'];
            sum += Math.abs(lastIndex - curIndex);
            lastIndex = curIndex;
        }

        return sum;

    }
    
    public static void main(String[] args) {

    }
    
}
