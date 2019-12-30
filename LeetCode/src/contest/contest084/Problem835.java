package contest.contest084;

public class Problem835 {

    public int largestOverlap(int[][] arr1, int[][] arr2) {
        int len = arr1.length;
        int rightMax = 0;
        for (int rightOffset = 0; rightOffset < len; rightOffset++) {
            // 下移
            int bottomMax = 0;
            for (int bottomOffset = 0; bottomOffset < len; bottomOffset++) {
                int oneCount = 0;
                for (int i = bottomOffset; i < len; i++) {
                    for (int j = rightOffset; j < len; j++) {
                        if (arr1[i - bottomOffset][j - rightOffset] == 1 && arr2[i][j] == 1) {
                            oneCount++;
                        }
                    }
                }

                bottomMax = Math.max(bottomMax, oneCount);
            }

            // 上移
            int topMax = 0;
            for (int topOffset = 0; topOffset < len; topOffset++) {
                int oneCount = 0;
                for (int i = 0; i < len - topOffset; i++) {
                    for (int j = rightOffset; j < len; j++) {
                        if (arr1[i + topOffset][j - rightOffset] == 1 && arr2[i][j] == 1) {
                            oneCount++;
                        }
                    }
                }

                topMax = Math.max(topMax, oneCount);
            }

            rightMax = Math.max(rightMax, Math.max(bottomMax, topMax));
        }

        int leftMax = 0;
        for (int leftOffset = 0; leftOffset < len; leftOffset++) {
            // 下移
            int bottomMax = 0;
            for (int bottomOffset = 0; bottomOffset < len; bottomOffset++) {
                int oneCount = 0;
                for (int i = bottomOffset; i < len; i++) {
                    for (int j = 0; j < len - leftOffset; j++) {
                        if (arr1[i - bottomOffset][j + leftOffset] == 1 && arr2[i][j] == 1) {
                            oneCount++;
                        }
                    }
                }

                bottomMax = Math.max(bottomMax, oneCount);
            }

            // 上移
            int topMax = 0;
            for (int topOffset = 0; topOffset < len; topOffset++) {
                int oneCount = 0;
                for (int i = 0; i < len - topOffset; i++) {
                    for (int j = 0; j < len - leftOffset; j++) {
                        if (arr1[i + topOffset][j + leftOffset] == 1 && arr2[i][j] == 1) {
                            oneCount++;
                        }
                    }
                }

                topMax = Math.max(topMax, oneCount);
            }

            leftMax = Math.max(leftMax, Math.max(bottomMax, topMax));
        }

        return Math.max(leftMax, rightMax);
    }

}
