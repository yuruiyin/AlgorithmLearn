package problem201_300;

public class Problem246 {

    public boolean isStrobogrammatic(String num) {
        char[] map = new char[10];
        map[0] = '0';
        map[1] = '1';
        map[6] = '9';
        map[8] = '8';
        map[9] = '6';
        char[] arr = num.toCharArray();
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            if (map[arr[left] - '0'] != arr[right]) {
                return false;
            }
            left++;
            right--;
        }

        if (left > right) {
            return true;
        }

        char midVal = map[arr[left] - '0'];
        return midVal == '0' || midVal == '1' || midVal == '8';
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem246().isStrobogrammatic("679"));
    }

}
