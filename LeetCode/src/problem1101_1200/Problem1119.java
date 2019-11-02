package problem1101_1200;

public class Problem1119 {

    public String removeVowels(String s) {
        StringBuilder sb = new StringBuilder();
        boolean[] arr = new boolean[26];
        arr['a' - 'a'] = true;
        arr['e' - 'a'] = true;
        arr['i' - 'a'] = true;
        arr['o' - 'a'] = true;
        arr['u' - 'a'] = true;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!arr[c - 'a']) {
                sb.append(c);
            }
        }

        return sb.toString();
    }
    
    public static void main(String[] args) {
        
    }
    
}
