package doubleContest.round14;

public class Problem1274 {

    interface Sea {
        boolean hasShips(int[] topRight, int[] bottomLeft);
    }

    private int binarySearchY(Sea sea, int[] topRight, int[] bottomLeft) {
        int bottomY = bottomLeft[1];
        int topY = topRight[1];

        if (bottomY == topY) {
            return 1;
        }

        int mid = (bottomY + topY) >>> 1;

        int x = topRight[0];

        int bottomCount = 0;
        int topCount = 0;

        int[] bottomTopRight = new int[]{x, mid};
        int[] bottomBottomLeft = new int[]{x, bottomY};
        if (sea.hasShips(bottomTopRight, bottomBottomLeft)) {
            bottomCount = binarySearchY(sea, bottomTopRight, bottomBottomLeft);
        }

        int[] topTopRight = new int[]{x, topY};
        int[] topBottomLeft = new int[]{x, mid + 1};
        if (sea.hasShips(topTopRight, topBottomLeft)) {
            topCount = binarySearchY(sea, topTopRight, topBottomLeft);
        }

        return bottomCount + topCount;
    }

    private int binarySearchArea(Sea sea, int[] topRight, int[] bottomLeft) {
        int xLeft = bottomLeft[0];
        int xRight = topRight[0];

        if (xLeft == xRight) {
            // y轴二分
            return binarySearchY(sea, topRight, bottomLeft);
        }

        int xMid = (xLeft + xRight) >>> 1;

        int leftAreaCount = 0;
        int rightAreaCount = 0;

        int[] leftAreaTopRight = new int[]{xMid, topRight[1]};
        int[] leftAreaBottomLeft = bottomLeft;
        if (sea.hasShips(leftAreaTopRight, leftAreaBottomLeft)) {
            leftAreaCount = binarySearchArea(sea, leftAreaTopRight, leftAreaBottomLeft);
        }

        int[] rightAreaTopRight = topRight;
        int[] rightAreaBottomLeft = new int[]{xMid + 1, bottomLeft[1]};
        if (sea.hasShips(rightAreaTopRight, rightAreaBottomLeft)) {
            rightAreaCount = binarySearchArea(sea, rightAreaTopRight, rightAreaBottomLeft);
        }

        return leftAreaCount + rightAreaCount;
    }

    public int countShips(Sea sea, int[] topRight, int[] bottomLeft) {
        return binarySearchArea(sea, topRight, bottomLeft);
    }
    
    public static void main(String[] args) {
        
    }
    
}
