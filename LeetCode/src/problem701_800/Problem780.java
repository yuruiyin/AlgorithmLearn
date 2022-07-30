package problem701_800;

public class Problem780 {

    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        if (tx == ty) {
            return sx == sy && sx == tx;
        }

        if (tx < sx || ty < sy) {
            return false;
        }

        while (true) {
            if (tx > ty) {
                int diffX = tx - sx;
                int countY = diffX / ty;
                if (countY <= 0) {
                    return false;
                }
                tx -= countY * ty;
            } else {
                int diffY = ty - sy;
                int countX = diffY / tx;
                if (countX <= 0) {
                    return false;
                }
                ty -= countX * tx;
            }

            if (tx == sx && ty == sy) {
                return true;
            }
            if (tx == ty || tx < sx || ty < sy) {
                return false;
            }
        }
    }

}
