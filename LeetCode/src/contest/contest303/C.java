package contest.contest303;

import java.util.*;

public class C {

    class FoodRatings {

        private final Map<String, TreeMap<Integer, TreeSet<String>>> map;
        private final Map<String, Integer> ratingMap;
        private final Map<String, String> cuisinesMap;

        public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
            map = new HashMap<>();
            ratingMap = new HashMap<>();
            cuisinesMap = new HashMap<>();
            int n = foods.length;
            for (int i = 0; i < n; i++) {
                ratingMap.put(foods[i], ratings[i]);
                cuisinesMap.put(foods[i], cuisines[i]);
                if (!map.containsKey(cuisines[i])) {
                    map.put(cuisines[i], new TreeMap<>());
                }
                TreeMap<Integer, TreeSet<String>> treeMap = map.get(cuisines[i]);
                if (!treeMap.containsKey(ratings[i])) {
                    treeMap.put(ratings[i], new TreeSet<>());
                }
                treeMap.get(ratings[i]).add(foods[i]);
            }
        }

        public void changeRating(String food, int newRating) {
            int oldRating = ratingMap.get(food);
            ratingMap.put(food, newRating);
            String cuisines = cuisinesMap.get(food);
            TreeMap<Integer, TreeSet<String>> treeMap = map.get(cuisines);
            treeMap.get(oldRating).remove(food);
            if (treeMap.get(oldRating).isEmpty()) {
                treeMap.remove(oldRating);
            }
            if (!treeMap.containsKey(newRating)) {
                treeMap.put(newRating, new TreeSet<>());
            }
            treeMap.get(newRating).add(food);
        }

        public String highestRated(String cuisine) {
            TreeMap<Integer, TreeSet<String>> treeMap = map.get(cuisine);
            return treeMap.get(treeMap.lastKey()).first();
        }
    }

}
