package contest.contest137;

public class Problem1047 {

    public String removeDuplicates(String str) {
        char[] arr = str.toCharArray();

        while (true) {
            StringBuilder sb = new StringBuilder();
            int i;
            boolean hasDuplicates = false;
            for (i = 0; i < arr.length - 1;) {
                if (arr[i] != arr[i+1]) {
                    sb.append(arr[i]);
                    i++;
                } else {
                    hasDuplicates = true;
                    i += 2;
                }
            }

            if (i == arr.length - 1) {
                sb.append(arr[i]);
            }

            if (!hasDuplicates) {
                return sb.toString();
            }

            arr = sb.toString().toCharArray();
        }
    }
    
    public static void main(String[] args) {
        
    }
    
}
