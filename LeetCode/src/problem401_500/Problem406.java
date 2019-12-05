package problem401_500;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem406 {

    public int[][] reconstructQueue(int[][] peoples) {
        // 先按身高降序，若身高相等按k升序，即高个子先站好
        Arrays.sort(peoples, (o1, o2) -> o1[0] != o2[0] ? o2[0] - o1[0] : o1[1] - o2[1]);

        List<int[]> ansList = new ArrayList<>();
        for (int[] people: peoples) {
            ansList.add(people[1], people);
        }

        return ansList.toArray(peoples);
    }

}



//  假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，
//  k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来重建这个队列。
//
//        注意：
//        总人数少于1100人。
//
//        示例
//
//        输入:
//        [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
//
//        输出:
//        [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]

