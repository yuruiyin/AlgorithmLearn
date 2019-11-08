package contest.contest142;

public class Problem1093 {

    public double[] sampleStats(int[] countArr) {
        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;
        double aver = 0;
        double mid = 0;
        double most = 0;
        int len = countArr.length;

        double sum = 0;
        int totalCount = 0;
        int mostCount = 0;
        for (int i = 0; i < len; i++) {
            sum += i * countArr[i];
            totalCount += countArr[i];
            if (countArr[i] > mostCount) {
                mostCount = countArr[i];
                most = i;
            }
        }

        if (totalCount == 0) {
            return new double[]{0, 0, 0, 0, 0};
        }

        aver = sum / totalCount;

        int tmpCount = 0;
        for (int i = 0; i < len; i++) {
            tmpCount += countArr[i];
            if ((totalCount & 1) == 1) {
                if (tmpCount > totalCount / 2) {
                    mid = i;
                    break;
                }
            } else {
                if (tmpCount == totalCount / 2) {
                    double nextNum = -1;
                    for (int j = i + 1; j < len; j++) {
                        if (countArr[j] > 0) {
                            nextNum = j;
                            break;
                        }
                    }
                    mid = (i + nextNum) / 2;
                    break;
                } else if (tmpCount > totalCount / 2) {
                    mid = i;
                    break;
                }
            }
        }

        for (int i = 0; i < len; i++) {
            if (countArr[i] > 0) {
                min = i;
                break;
            }
        }

        for (int i = len - 1; i >= 0; i--) {
            if (countArr[i] > 0) {
                max = i;
                break;
            }
        }


        return new double[]{min, max, aver, mid, most};

    }
    
    public static void main(String[] args) {

    }
    
}
