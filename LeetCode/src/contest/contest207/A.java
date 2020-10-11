package contest.contest207;

/**
 * A
 *
 * @author: yry
 * @date: 2020/9/20
 */
public class A {

    public String reorderSpaces(String text) {
        char[] arr = text.toCharArray();
        int len = arr.length;
        int sCount = 0;
        for (char c : arr) {
            if (c == ' ') {
                sCount++;
            }
        }

        String[] wordArr = text.trim().split("\\s+");

        int wordCount = wordArr.length;
        if (wordCount == 1) {
            return wordArr[0] + " ".repeat(sCount);
        }

        int eachCount = sCount / (wordCount - 1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < wordCount - 1; i++) {
            sb.append(wordArr[i]);
            sb.append(" ".repeat(eachCount));
        }

        sb.append(wordArr[wordCount - 1]);
        if (sCount % (wordCount - 1) != 0) {
            sb.append(" ".repeat(sCount % (wordCount - 1)));
        }

        return sb.toString();
    }
    
    public static void main(String[] args) {
        System.out.println(new A().reorderSpaces("  this   is  a sentence "));
    }

}
