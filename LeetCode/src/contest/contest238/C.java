package contest.contest238;

/**
 * A
 *
 * @author: yry
 * @date: 2021/5/11
 */
public class C {

    private int findIdx(char c) {
        char[] chars = new char[]{'a', 'e', 'i', 'o', 'u'};
        for (int i = 0; i < 5; i++) {
            if (c == chars[i]) {
                return i;
            }
        }
        return -1;
    }

    public int longestBeautifulSubstring(String word) {
        char[] arr = word.toCharArray();
        int len = arr.length;
        // a, e, i, o, u
        int aFrom = -1;
        int preIdx = -1;
        int ansMax = 0;
        for (int i = 0; i < len; ) {
            if (arr[i] == 'a') {
                if (preIdx == 0) {
                    i++;
                    continue;
                }

                aFrom = i;
                preIdx = 0;
                i++;
            } else {
                if (preIdx == -1) {
                    i++;
                    continue;
                }

                int idx = findIdx(arr[i]);
                if (idx < preIdx || idx > preIdx + 1) {
                    aFrom = -1;
                    preIdx = -1;
                    i++;
                    continue;
                }

                if (idx == 4) {
                    int nextI = i + 1;
                    for (int j = i + 1; j < len; j++) {
                        if (arr[j] != 'u') {
                            break;
                        }
                        nextI = j + 1;
                    }

                    ansMax = Math.max(ansMax, nextI - aFrom);
                    aFrom = -1;
                    preIdx = -1;
                    i = nextI;
                    continue;
                }

                
                preIdx = idx;
                i++;
            }
        }

        return ansMax;
    }
    
    public static void main(String[] args) {
        System.out.println(new C().longestBeautifulSubstring("aeiaaioaaaaeiiiiouuuooaauuaeiu"));
    }

}
