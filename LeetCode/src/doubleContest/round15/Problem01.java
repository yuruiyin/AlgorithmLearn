package doubleContest.round15;

public class Problem01 {

    public  int findSpecialInteger(int[] arr) {
        int[] count = new int[100001];
        int len = arr.length;
        int value = len / 4;

        for (int num : arr) {
            count[num]++;
            if (count[num] > value) {
                return num;
            }
        }

        return -1;
    }
   
    public static void main(String[] args) {

    }
    
}
