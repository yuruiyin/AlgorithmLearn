package problem501_600;

public class Problem520 {

    public boolean detectCapitalUse(String word) {
        char[] arr = word.toCharArray();
        boolean isFirstUpper = Character.isUpperCase(arr[0]);
        int upperCount = 0;
        int lowerCount = 0;
        for (char c : arr) {
            if (Character.isLowerCase(c)) {
                lowerCount++;
            } else {
                upperCount++;
            }
        }

        return upperCount == 0 || lowerCount == 0 || (isFirstUpper && upperCount == 1);
    }

}
