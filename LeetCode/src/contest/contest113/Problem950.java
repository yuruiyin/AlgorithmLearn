package contest.contest113;

import java.util.Arrays;
import java.util.LinkedList;

public class Problem950 {


    public int[] deckRevealedIncreasing(int[] deck) {
        int len = deck.length;
        LinkedList<Integer> indexQueue = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            indexQueue.offer(i);
        }

        int[] ansArr = new int[len];
        Arrays.sort(deck);
        for (int card : deck) {
            ansArr[indexQueue.poll()] = card;
            if (!indexQueue.isEmpty()) {
                indexQueue.offer(indexQueue.poll());
            }
        }

        return ansArr;
    }

    public static void main(String[] args) {
        int[] ansArr = new Problem950().deckRevealedIncreasing(new int[]{17,13,11,2,3,5,7});
    }

}
