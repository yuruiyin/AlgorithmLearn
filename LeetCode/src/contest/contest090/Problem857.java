package contest.contest090;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Problem857 {

    class Person {
        int quality;
        double perQualityWage;
        Person(int quality, double perQualityWage) {
            this.quality = quality;
            this.perQualityWage = perQualityWage;
        }
    }

    public  double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int len = quality.length;
        Person[] persons = new Person[len];

        for (int i = 0; i < len; i++) {
            persons[i] = new Person(quality[i], wage[i] * 1.0 / quality[i]);
        }

        // 按照单位质量期望工资从小到大排序
        Arrays.sort(persons, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return Double.compare(o1.perQualityWage, o2.perQualityWage);
            }
        });
        PriorityQueue<Integer> qualityQueue = new PriorityQueue<>((o1, o2) -> o2 - o1); // 根是quality最大的
        int qualitySum = 0;
        for (int i = 0; i < k; i++) {
            qualityQueue.offer(persons[i].quality);
            qualitySum += persons[i].quality;
        }

        double ansMin = qualitySum * persons[k-1].perQualityWage; // k-1是前k个单位时间期望工资最大的

        // 遍历后面
        for (int i = k; i < len; i++) {
            if (persons[i].quality >= qualityQueue.peek()) {
                continue;
            }

            qualitySum -= qualityQueue.poll();
            qualityQueue.offer(persons[i].quality);
            qualitySum += persons[i].quality;
            ansMin = Math.min(ansMin, qualitySum * persons[i].perQualityWage);
        }

        return ansMin;
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem857().mincostToHireWorkers(new int[]{2,1,5}, new int[]{17,6,4}, 2));
    }

}
