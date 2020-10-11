package contest.contest204;

/**
 * A
 *
 * @author: yry
 * @date: 2020/8/30
 */
public class B {

    public int getMaxLen(int[] arr) {
        int len = arr.length;
        int preOddNegativeIdx = len;
        int preEvenNegativeIdx = -1;

        int ansMax = 0;

        int negativeCount = 0;
        int offset = 0;

        for (int i = 0; i < len; i++) {
            if (arr[i] == 0) {
                negativeCount = 0;
                offset = i + 1;
                preOddNegativeIdx = len;
                preEvenNegativeIdx = -1;
            } else {
                if (arr[i] < 0) {
                    negativeCount++;
                }

                int dis = 0;
                if (negativeCount % 2 == 0) {
                    dis = i - preEvenNegativeIdx;
                    ansMax = Math.max(ansMax, dis - offset);
                } else {
                    dis = i - preOddNegativeIdx;
                    ansMax = Math.max(ansMax, dis);
                }

                if (preOddNegativeIdx == len && negativeCount % 2 != 0) {
                    preOddNegativeIdx = i;
                }

            }
        }

        return ansMax;
    }
    
    public static void main(String[] args) {
        //[5,-20,-20,-39,-5,0,0,0,36,-32,0,-7,-10,-7,21,20,-12,-34,26,2]
        System.out.println(new B().getMaxLen(new int[]{5,-20,-20,-39,-5,0,0,0,36,-32,0,-7,-10,-7,21,20,-12,-34,26,2}));
    }

}
