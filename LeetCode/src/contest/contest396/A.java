package contest.contest396;

public class A {

    public boolean isValid(String word) {
        if (word.length() < 3) {
            return false;
        }

        boolean hasY = false;
        boolean hasF = false;
        for (char c : word.toCharArray()) {
            if (!(Character.isLetter(c)) && !Character.isDigit(c)) {
                return false;
            }

            if (Character.isLetter(c)) {
                c = Character.toLowerCase(c);
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                    hasY = true;
                } else {
                    hasF = true;
                }
            }
        }

        return hasY && hasF;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
