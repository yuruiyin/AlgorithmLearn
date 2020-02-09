package contest.contest173;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Problem1333 {

    class  Data {
        int id;
        int rating;
        Data(int id, int rating) {
            this.id = id;
            this.rating = rating;
        }
    }

    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        List<Data> list = new ArrayList<>();

        for (int[] re : restaurants) {
            int id = re[0];
            int rating = re[1];
            int vegan = re[2];
            int price = re[3];
            int dis = re[4];
            if (vegan < veganFriendly || price > maxPrice || dis > maxDistance) {
                continue;
            }

            list.add(new Data(id, rating));
        }

        list.sort(new Comparator<Data>() {
            @Override
            public int compare(Data o1, Data o2) {
                if (o2.rating == o1.rating) {
                    return o2.id - o1.id;
                }
                return o2.rating - o1.rating;
            }
        });

        List<Integer> ansList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            ansList.add(list.get(i).id);
        }

        return ansList;
    }

}

//    给你一个餐馆信息数组 restaurants，其中  restaurants[i] = [idi, ratingi, veganFriendlyi, pricei, distancei]。
//    你必须使用以下三个过滤器来过滤这些餐馆信息。
//
//        其中素食者友好过滤器 veganFriendly 的值可以为 true 或者 false，如果为 true 就意味着你应该只包括 veganFriendlyi 为 true 的餐馆，
//        为 false 则意味着可以包括任何餐馆。此外，我们还有最大价格 maxPrice 和最大距离 maxDistance 两个过滤器，它们分别考虑餐厅的价格因素和距离因素的最大值。
//
//        过滤后返回餐馆的 id，按照 rating 从高到低排序。简单起见， veganFriendlyi 和 veganFriendly 为 true 时取值为 1，为 false 时，取值为 0 。
