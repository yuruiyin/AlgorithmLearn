package contest.contest480;

public class D {

    public int[] minDeletions(String s, int[][] queries) {
        char[] arr = s.toCharArray();
        int len = arr.length;
        int[] leftLetterCountArr = new int[len];
        int[] rightLetterCountArr = new int[len];
        leftLetterCountArr[0] = 1;
        rightLetterCountArr[len - 1] = 1;
        for (int i = 1; i < len; i++) {
            if (arr[i] == arr[i - 1]) {
                leftLetterCountArr[i] = leftLetterCountArr[i - 1] + 1;
            } else {
                leftLetterCountArr[i] = 1;
            }
        }

        for (int i = len - 2; i >= 0; i--) {
            if (arr[i] == arr[i + 1]) {
                rightLetterCountArr[i] = rightLetterCountArr[i + 1] + 1;
            } else {
                rightLetterCountArr[i] = 1;
            }
        }

        for (int[] q : queries) {
            if (q[0] == 1) {
                // 修改
                int j = q[1];

                if (arr[j] == 'A') {
                    arr[j] = 'B';
                } else {
                    arr[j] = 'A';
                }


            } else {

            }
        }

        return null;
    }

}
