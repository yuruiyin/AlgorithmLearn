package contest.contest305;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class C {

    class Data {
        int startIdx;
        int endIdx;
        Data(int startIdx, int endIdx) {
            this.startIdx = startIdx;
            this.endIdx = endIdx;
        }
    }

    public boolean validPartition(int[] nums) {
        int len = nums.length;
        List<Data> list = new ArrayList<>();
        int startIdx = 0;
        for (int i = 1; i < len; i++) {
           if (nums[i] == nums[i - 1]) {
               continue;
           } else {
               if (i - 1 == startIdx) {
                   startIdx = i;
                   continue;
               }
               list.add(new Data(startIdx, i - 1));
               startIdx = i;
           }
        }

        if (len - 1 > startIdx) {
            list.add(new Data(startIdx, len - 1));
        }

        int size = list.size();
        if (size == 0) {
            if (len % 3 != 0) {
                return false;
            }
            for (int i = 1; i < len; i++) {
                if (nums[i] - nums[i - 1] > 1) {
                    return false;
                }
            }
            return true;
        }

        int l = 0;
        int lCount = -1;
        for (int i = 0; i < size; i++) {
            Data data = list.get(i);
            int s = data.startIdx;
            int e = data.endIdx;
            if (s == l) {
                l = e + 1;
                lCount = e - s + 1;
                continue;
            }
            // l < s
            int count = e - s + 1;
            int leftCount = 1;
            for (int j = l + 1; j < s; j++) {
                if (nums[j] - nums[j - 1] > 1) {
                    return false;
                }
                leftCount++;
            }
            if (lCount == -1) {
                // 第一次
                boolean isOk = getAns(count, leftCount, data);
                if (!isOk) {
                    return false;
                }
                lCount = data.endIdx - data.startIdx + 1;
            } else {
                if (lCount == 2) {
                    // 左侧借不了
                    boolean isOk = getAns(count, leftCount, data);
                    if (!isOk) {
                        return false;
                    }
                    lCount = data.endIdx - data.startIdx + 1;
                } else {
                    if (lCount == 3) {
                        if (leftCount % 3 == 1) {
                            // 左边借一个，右边能借一个即可
                            if (count == 2) {
                                return false;
                            }
                            lCount = data.endIdx - data.startIdx + 1;
                            lCount--;
                        } else {
                            lCount = data.endIdx - data.startIdx + 1;
                        }
                    } else {
                        lCount = data.endIdx - data.startIdx + 1;
                    }
                }
            }
        }

        Data lastData = list.get(size - 1);
        int lastDataEndIdx = lastData.endIdx;
        if (lastDataEndIdx == len - 1) {
            return true;
        }
        int count = 1;
        for (int i = lastDataEndIdx + 2; i < len; i++) {
            if (nums[i] - nums[i - 1] > 1) {
                return false;
            }
            count++;
        }

        if (count % 3 == 0) {
            return true;
        } else if (count % 3 == 1) {
            if (lCount <= 3) {
                return false;
            } else {
                return true;
            }
        } else {
            if (lCount == 2) {
                return false;
            }
            return true;
        }
    }

    private boolean getAns(int count, int leftCount, Data data) {
        if (count == 2) {
            return leftCount % 3 == 0;
        } else if (count == 3) {
            // 只能贡献一个
            if (leftCount % 3 == 0) {
                return true;
            } else if (leftCount % 3 == 1) {
                return false;
            } else {
                data.startIdx++;
                return true;
            }
        } else {
            if (leftCount % 3 == 0) {
                return true;
            } else if (leftCount % 3 == 1) {
                data.startIdx += 2;
                return true;
            } else {
                data.startIdx++;
                return true;
            }
        }
    }

    public static void main(String[] args) {
//        System.out.println(new C().validPartition(new int[]{1, 2, 3}));
        // [923198,923198,701131,701132]
//        System.out.println(new C().validPartition(new int[]{923198,923198,701131,701132}));
        System.out.println(new C().validPartition(new int[]{923198,923198}));
    }

}
