package doubleContest.round094;

import java.util.*;

public class B {

    class Data {
        long score;
        int id;
        Data(long score, int id) {
            this.score = score;
            this.id = id;
        }
    }

    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        Set<String> positiveSet = new HashSet<>(Arrays.asList(positive_feedback));
        Set<String> negativeSet = new HashSet<>(Arrays.asList(negative_feedback));

        int n = report.length;
        PriorityQueue<Data> heap = new PriorityQueue<>(new Comparator<Data>() {
            @Override
            public int compare(Data o1, Data o2) {
                return o1.score == o2.score ? o2.id - o1.id : Long.compare(o1.score, o2.score);
            }
        });
        for (int i = 0; i < n; i++) {
            String[] feedBack = report[i].split(" ");
            long score = 0;
            for (String str : feedBack) {
                if (positiveSet.contains(str)) {
                    score += 3;
                } else if (negativeSet.contains(str)) {
                    score -= 1;
                }
            }
            heap.add(new Data(score, student_id[i]));
            if (heap.size() >  k) {
                heap.poll();
            }
        }

        List<Integer> ansList = new ArrayList<>();
        while (!heap.isEmpty()) {
            ansList.add(heap.poll().id);
        }
        Collections.reverse(ansList);
        return ansList;
    }

}
