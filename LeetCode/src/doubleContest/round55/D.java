package doubleContest.round55;

import kotlin.Pair;

import java.util.*;

/**
 * A
 *
 * @author: yry
 * @date: 2021/6/26
 */
public class D {

//    所有电影用二维整数数组 entries 表示，其中 entries[i] = [shopi, moviei, pricei]
//    表示商店 shopi 有一份电影 moviei 的拷贝，租借价格为 pricei 。每个商店有 至多一份 编号为 moviei 的电影拷贝。
    class MovieRentingSystem {

        private static final long SHOT_MAX = 300001L;

        class Data {
            int shop;
            int price;
            int movie;
            Data(int shop, int price, int movie) {
                this.shop = shop;
                this.price = price;
                this.movie = movie;
            }
        }

        private TreeSet<Data>[] movieDatas = new TreeSet[10001];

        private Map<Long, Data> shopMap = new HashMap<>();

        private TreeSet<Data> rentedMovies = new TreeSet<>(new Comparator<Data>() {
            @Override
            public int compare(Data o1, Data o2) {
                return o1.price == o2.price ? (o1.shop == o2.shop ? o1.movie - o2.movie : o1.shop - o2.shop) : o1.price - o2.price;
            }
        });

        public MovieRentingSystem(int n, int[][] entries) {
            for (int[] entry : entries) {
                int shop = entry[0];
                int movie = entry[1];
                int price = entry[2];
                if (movieDatas[movie] == null) {
                    movieDatas[movie] = new TreeSet<>(new Comparator<Data>() {
                        @Override
                        public int compare(Data o1, Data o2) {
                            return o1.price == o2.price ? o1.shop - o2.shop : o1.price - o2.price;
                        }
                    });
                }

                Data data = new Data(shop, price, movie);
                movieDatas[movie].add(data);

                shopMap.put(shop * 10000L + movie, data);
            }
        }

        public List<Integer> search(int movie) {
            TreeSet<Data> treeSet = movieDatas[movie];
            if (treeSet == null) {
                return new ArrayList<>();
            }

            List<Integer> ansList = new ArrayList<>();
            Iterator<Data> iterator = treeSet.iterator();
            int i = 0;
            while (iterator.hasNext() && i < 5) {
                ansList.add(iterator.next().shop);
                i++;
            }
            return ansList;
        }

        public void rent(int shop, int movie) {
            Data data = shopMap.get(shop * 10000L + movie);
            movieDatas[movie].remove(data);
            rentedMovies.add(data);
        }

        public void drop(int shop, int movie) {
            Data data = shopMap.get(shop * 10000L + movie);
            rentedMovies.remove(data);
            movieDatas[movie].add(data);
        }

        public List<List<Integer>> report() {
            List<List<Integer>> ansList = new ArrayList<>();
            Iterator<Data> iterator = rentedMovies.iterator();
            int i = 0;
            while (iterator.hasNext() && i < 5) {
                List<Integer> list = new ArrayList<>();
                Data data = iterator.next();
                list.add(data.shop);
                list.add(data.movie);
                ansList.add(list);
                i++;
            }
            return ansList;
        }
    }

}
