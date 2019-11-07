package contest.contest143;

import java.util.HashMap;
import java.util.Map;

public class Problem1105 {

    private Map<Integer, Integer> memo = new HashMap<>();

    private int dfs(int[][] books, int shelf_width, int curIndex, int emptyWidth) {
        int key = curIndex * 1000 + emptyWidth;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int prevIndex = curIndex - 1;
        int i;
        int height = books[prevIndex][1];
        for (i = curIndex; i < books.length; i++) {
            if (books[i][1] <= books[prevIndex][1] && books[i][0] <= emptyWidth) {
                emptyWidth -= books[i][0]; // 跟在后面
            } else if (books[i][1] > books[prevIndex][1] && books[i][0] <= emptyWidth) {
                // 跟在后面
                emptyWidth -= books[i][0];
                int height1 = dfs(books, shelf_width, i + 1, emptyWidth);
                // 另起一行
                emptyWidth = shelf_width - books[i][0];
                int height2 = dfs(books, shelf_width, i + 1, emptyWidth) + books[prevIndex][1];
                height = Math.min(height1, height2);
                break;
            } else {
                // 另起一行
                emptyWidth = shelf_width - books[i][0];
                height = dfs(books, shelf_width, i + 1, emptyWidth) + books[prevIndex][1];
                break;
            }
        }

        memo.put(key, height);

        return height;
    }

    public int minHeightShelves(int[][] books, int shelf_width) {
        return dfs(books, shelf_width, 1, shelf_width - books[0][0]);
    }

    public static void main(String[] args) {
        System.out.println(new Problem1105().minHeightShelves(new int[][]{
                {1,1},{2,3},{2,3},{1,1},{1,1},{1,1},{1,2}
        }, 4));
    }
    
}
