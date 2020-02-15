package lcof;

public class Lcof011 {

    public int minArray(int[] numbers) {
        int len = numbers.length;
        for (int i = 0; i < len - 1; i++) {
            if (numbers[i] > numbers[i+1]) {
                return numbers[i+1];
            }
        }

        return numbers[0];
    }

}
