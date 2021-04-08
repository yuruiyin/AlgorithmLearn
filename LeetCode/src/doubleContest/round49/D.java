package doubleContest.round49;

/**
 * A
 *
 * @author: yry
 * @date: 2021/4/3
 */
public class D {

    public int maxHappyGroups(int batchSize, int[] groups) {
        int len = groups.length;
        int[] countArr = new int[batchSize];
        for (int num : groups) {
            countArr[num % batchSize]++;
        }

        int ans = countArr[0];
        countArr[0] = 0;

        for (int count = 2; count <= batchSize; count++) {
            for (int i = 1; i < batchSize; i++) {
                if (countArr[i] != 0) {
                    int left = batchSize - i;
                    if (left == i) {
                        ans += countArr[i] / 2;
                        countArr[i] = countArr[i] % 2;
                        continue;
                    }
                    int leftCount = countArr[left];
                    int minCount = Math.min(leftCount, countArr[i]);
                    ans += minCount;
                    countArr[i] -= minCount;
                    countArr[left] -= minCount;
                }
            }
        }

        for (int i = 0; i < batchSize; i++) {
            if (countArr[i] != 0) {
                ans++;
                break;
            }
        }

        return ans;
    }
    
    public static void main(String[] args) {
        System.out.println(new D().maxHappyGroups(3, new int[]{1,2,3,4,5,6}));
        System.out.println(new D().maxHappyGroups(4, new int[]{1,3,2,5,2,2,1,6}));
    }

}
