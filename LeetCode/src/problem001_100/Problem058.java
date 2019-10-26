package problem001_100;

public class Problem058 {

    public int lengthOfLastWord(String s) {
        int len = s.length();
        if (len == 0) {
            return 0;
        }

        int count = 0;
        for (int i = len - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c != ' ') {
                count++;
            } else {
                if (count != 0) {
                    return count;
                }
            }
        }

        return count;
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem058().lengthOfLastWord("Hello world"));
        System.out.println(new Problem058().lengthOfLastWord("Hello world   "));
        System.out.println(new Problem058().lengthOfLastWord(""));
        System.out.println(new Problem058().lengthOfLastWord("        "));
        System.out.println(new Problem058().lengthOfLastWord("hei jjjd"));


    }
    
}
