package contest.contest225;

/**
 * A
 *
 * @author: yry
 * @date: 2021/1/24
 */
public class B {

    private void calcCount(int[] countArr, char[] arr) {
        for (char c : arr) {
            countArr[c - 'a']++;
        }
    }

    private int getAns1(char[] arr1, char[] arr2) {
        int[] countArr1 = new int[26];
        calcCount(countArr1, arr1);
        int[] countArr2 = new int[26];
        calcCount(countArr2, arr2);

        int ans = 0;
        for (int i = 0; i < 26; i++) {
            if (countArr1[i] == 0) {
                continue;
            }
            if (i == 0) {
                // a
                ans += countArr2[i];
                countArr2[25] += countArr2[i];
                countArr2[i] = 0;
            } else if (i == 25) {
                ans += countArr1[i];
            } else {
                boolean hasA2 = countArr2[0] > 0;
                if (hasA2) {
                    for (int j = i; j >= 0; j--) {
                        ans += countArr2[j];
                        countArr2[25] += countArr2[j];
                        countArr2[j] = 0;
                    }
                } else {
                    int count2 = 0;
                    for (int j = i; j >= 0; j--) {
                        count2 += countArr2[j];
                    }

                    if (countArr1[i] < count2) {
                        ans += countArr1[i];
                        countArr1[0] += countArr1[i];
                        countArr1[i] = 0;
                    } else {
                        ans += count2;
                        for (int j = i; j >= 0; j--) {
                            countArr2[j] = 0;
                        }
                        countArr2[25] += count2;
                    }
                }

            }
        }

        return ans;
    }

    private int getAns2(char[] arr1, char[] arr2) {
        int[] countArr1 = new int[26];
        calcCount(countArr1, arr1);
        int[] countArr2 = new int[26];
        calcCount(countArr2, arr2);

        int ans = 0;
        for (int i = 25; i >= 0; i--) {
            if (countArr1[i] == 0) {
                continue;
            }
            if (i == 0) {
                // a
                ans += countArr1[i];
                countArr1[25] += countArr1[i];
                countArr1[i] = 0;
            } else if (i == 25) {
                ans += countArr2[i];
                countArr2[0] += countArr2[i];
                countArr2[i] = 0;
            } else {
                boolean hasZ2 = countArr2[25] > 0;
                if (hasZ2) {
                    for (int j = i; j <= 25; j++) {
                        ans += countArr2[j];
                        countArr2[0] += countArr2[j];
                        countArr2[j] = 0;
                    }
                } else {
                    int count2 = 0;
                    for (int j = i; j <= 25; j++) {
                        count2 += countArr2[j];
                    }

                    if (countArr1[i] < count2) {
                        ans += countArr1[i];
                        countArr1[0] += countArr1[i];
                        countArr1[i] = 0;
                    } else {
                        ans += count2;
                        for (int j = i; j <= 25; j++) {
                            countArr2[j] = 0;
                        }
                        countArr2[0] += count2;
                    }
                }

            }
        }

        return ans;
    }

    private int getSameAns(char[] arr1, char[] arr2) {
        int[] countArr = new int[26];
        calcCount(countArr, arr1);
        calcCount(countArr, arr2);

        int maxCount = 0;
        for (int i = 0; i < 26; i++) {
            maxCount = Math.max(maxCount, countArr[i]);
        }

        return arr1.length + arr2.length - maxCount;
    }

    public int minCharacters(String a, String b) {
        int ansMin = Integer.MAX_VALUE;
        char[] arr1 = a.toCharArray();
        char[] arr2 = b.toCharArray();
        ansMin = Math.min(ansMin, getAns1(arr1, arr2));
        ansMin = Math.min(ansMin, getAns1(arr2, arr1));
        ansMin = Math.min(ansMin, getAns2(arr2, arr1));
        ansMin = Math.min(ansMin, getAns2(arr1, arr2));
        ansMin = Math.min(ansMin, getSameAns(arr2, arr1));
        return ansMin;
    }

    public static void main(String[] args) {
        System.out.println(new B().minCharacters("dee", "a"));
        System.out.println(new B().minCharacters("dbc", "daecc"));
    }

}
