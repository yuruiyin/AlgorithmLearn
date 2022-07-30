package contest.contest303;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class C_1 {

    class FoodRatings {

        private final Map<String, TreeSet<Integer>> map;
        private final Map<String, Integer> indexMap;

        private final String[] foods;
        private final String[] cuisines;
        private final int[] ratings;

        public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
            this.foods = foods;
            this.cuisines = cuisines;
            this.ratings = ratings;
            map = new HashMap<>();
            indexMap = new HashMap<>();
            int n = foods.length;
            for (int i = 0; i < n; i++) {
                indexMap.put(foods[i], i);
                if (!map.containsKey(cuisines[i])) {
                    map.put(cuisines[i], new TreeSet<>(new Comparator<Integer>() {
                        @Override
                        public int compare(Integer o1, Integer o2) {
                            return ratings[o1] == ratings[o2] ? foods[o1].compareTo(foods[o2]) : ratings[o2] - ratings[o1];
                        }
                    }));
                }
                map.get(cuisines[i]).add(i);
            }
        }

        public void changeRating(String food, int newRating) {
            int index = indexMap.get(food);
            String cuisine = cuisines[index];
            map.get(cuisine).remove(index);
            ratings[index] = newRating;
            map.get(cuisine).add(index);
        }

        public String highestRated(String cuisine) {
            return foods[map.get(cuisine).first()];
        }
    }

}
