package contest.contest480;

public class B {

    private boolean isYY(char c) {
        return c == 'a' || c == 'e' || c =='i' || c == 'o' || c == 'u';
    }

    private int calcCount(String str) {
        int count = 0;
        for (char c: str.toCharArray()) {
            if (isYY(c)) {
                count++;
            }
        }
        return count;
    }

    public String reverseWords(String s) {
        String[] strArr = s.split(" ");
        int firstCount = calcCount(strArr[0]);

        StringBuilder ansSb = new StringBuilder(strArr[0]);
        for (int i = 1; i < strArr.length; i++) {
            String str = strArr[i];
            ansSb.append(" ");
            if (calcCount(str) == firstCount) {
                ansSb.append(new StringBuilder(str).reverse());
            } else {
                ansSb.append(str);
            }
        }
        return ansSb.toString();
    }

}
