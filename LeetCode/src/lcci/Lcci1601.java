package lcci;

/**
 * Lcci1601
 *
 * @author: yry
 * @date: 2020/4/10
 */
public class Lcci1601 {

    public int[] swapNumbers(int[] numbers) {
        numbers[0] ^= numbers[1];
        numbers[1] ^= numbers[0];
        numbers[0] ^= numbers[1];
        return numbers;
    }

}
