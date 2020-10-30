package contest.contest211;

import java.util.Arrays;
import java.util.Comparator;

/**
 * A
 *
 * @author: yry
 * @date: 2020/10/18
 */
public class C {

    class Data {
        int score;
        int age;
        Data(int score, int age) {
            this.score = score;
            this.age = age;
        }
    }

    public int bestTeamScore(int[] scores, int[] ages) {
        int len = scores.length;
        Data[] datas = new Data[len];
        for (int i = 0; i < len; i++) {
            datas[i] = new Data(scores[i], ages[i]);
        }

        Arrays.sort(datas, (o1, o2) -> {
            if (o1.age == o2.age) {
                return o1.score - o2.score;
            }
            return o1.age - o2.age;
        });

        int[] dp = new int[len]; // 以当前下标为结尾的最大score和
        dp[0] = datas[0].score;

        for (int i = 1; i < len; i++) {
            dp[i] = datas[i].score;
            for (int j = i - 1; j >= 0; j--) {
                if (datas[i].score >= datas[j].score) {
                    dp[i] = Math.max(dp[i], dp[j] + datas[i].score);
                }
            }
        }

        int ansMax = 0;
        for (int i = 0; i < len; i++) {
            ansMax = Math.max(ansMax, dp[i]);
        }

        return ansMax;
    }

}
