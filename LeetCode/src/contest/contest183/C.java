package contest.contest183;

import java.util.Arrays;

/**
 * A
 *
 * @author: yry
 * @date: 2020/4/5
 */
public class C {

    class Data {
        char c;
        int count;
        Data(char c, int count) {
            this.c = c;
            this.count = count;
        }
    }

    public String longestDiverseString(int a, int b, int c) {
        Data[] datas = new Data[3];
        datas[0] = new Data('a', a);
        datas[1] = new Data('b', b);
        datas[2] = new Data('c', c);

        StringBuilder sb = new StringBuilder();

        while (true) {
            Arrays.sort(datas, (o1, o2) -> o2.count - o1.count);
            if (datas[0].count <= 1) {
                for (int i = 0; i < 3; i++) {
                    while ((datas[i].count--) > 0) {
                        sb.append(datas[i].c);
                    }
                }
                return sb.toString();
            }

            sb.append(datas[0].c);
            sb.append(datas[0].c);
            datas[0].count -= 2;

            if (datas[1].count == 0) {
                return sb.toString();
            }

            if (datas[1].count > datas[0].count) {
                if (datas[1].count >= 2) {
                    sb.append(datas[1].c);
                    sb.append(datas[1].c);
                    datas[1].count -= 2;
                } else {
                    // 1个
                    sb.append(datas[1].c);
                    datas[1].count -= 1;
                }
            } else {
                sb.append(datas[1].c);
                datas[1].count -= 1;
            }
        }

    }

    public static void main(String[] args) {
        System.out.println(new C().longestDiverseString(0, 8, 11));
        System.out.println(new C().longestDiverseString(1, 1, 7));
        System.out.println(new C().longestDiverseString(2, 2, 1));
        System.out.println(new C().longestDiverseString(7, 1, 0));
    }

}
