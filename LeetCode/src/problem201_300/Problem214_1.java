package problem201_300;

public class Problem214_1 {

    public String shortestPalindrome(String s) {
        int i = 0;
        for(int j = s.length() - 1; j >= 0; j--){
            if(s.charAt(j) == s.charAt(i)){
                i++;
            }
        }
        if(i == s.length()){
            return s;
        }
        return reverse(s.substring(i)) + shortestPalindrome(s.substring(0, i)) + s.substring(i);
    }
    private String reverse(String s){
        StringBuilder stringBuilder = new StringBuilder(s);
        return stringBuilder.reverse().toString();
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem214_1().shortestPalindrome("abcbaba"));
    }

}
