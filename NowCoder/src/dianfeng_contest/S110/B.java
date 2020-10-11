package dianfeng_contest.S110;

/**
 * A
 *
 * @author: yry
 * @date: 2020/8/8
 */
public class B {

    /**
     *
     * @param n int整型
     * @param p1 int整型
     * @param q1 int整型
     * @param m1 int整型
     * @param p2 int整型
     * @param q2 int整型
     * @param m2 int整型
     * @return int整型
     */
    public int Highestscore (int n, int p1, int q1, int m1, int p2, int q2, int m2) {
        // write code here
        int ans = 0;

        // 先让p2（牛妹的石头) 弄成 0
        if (p2 > 0) {
            // 牛妹有石头, 牛牛用布吃他
            if (m1 > 0) {
                if (m1 >= p2) {
                    ans += p2;
                    p2 = 0;
                    m1 -= p2;
                } else {
                    ans += m1;
                    m1 = 0;
                    p2 -= m1;
                }
            }

            if (p2 != 0) {
                if (p1 > 0) {
                    if (p1 >= p2) {
                        p2 = 0;
                        p1 -= p2;
                    } else {
                        p1 = 0;
                        p2 -= p1;
                        ans -= p2;
                        q1 -= p2;
                    }
                } else {
                    ans -= p2;
                    q1 -= p2;
                }
            }
        }

        // 让q2（牛妹的剪刀)弄成0
        if (q2 > 0) {
            // 牛妹有剪刀, 牛牛用石头吃他
            if (p1 > 0) {
                if (p1 >= q2) {
                    ans += q2;
                    q2 = 0;
                    p1 -= q2;
                } else {
                    ans += p1;
                    p1 = 0;
                    q2 -= p1;
                }
            }

            if (q2 != 0) {
                if (q1 > 0) {
                    if (q1 >= q2) {
                        q2 = 0;
                        q1 -= q2;
                    } else {
                        q1 = 0;
                        q2 -= q1;
                        ans -= q2;
                        m1 -= q2;
                    }
                } else {
                    ans -= q2;
                    m1 -= q2;
                }
            }
        }

        // 让m2（牛妹的布)弄成0
        if (m2 > 0) {
            // 牛妹有剪刀, 牛牛用剪刀q1吃他
            if (q1 > 0) {
                if (q1 >= m2) {
                    ans += m2;
                    m2 = 0;
                    q1 -= m2;
                } else {
                    ans += q1;
                    q1 = 0;
                    m2 -= q1;
                }
            }

            if (m2 != 0) {
                if (m1 > 0) {
                    if (m1 >= m2) {
                        m2 = 0;
                        m1 -= m2;
                    } else {
                        m1 = 0;
                        m2 -= m1;
                        ans -= m2;
                        m1 -= m2;
                    }
                } else {
                    ans -= m2;
                    m1 -= m2;
                }
            }
        }

        return ans;
    }

}
