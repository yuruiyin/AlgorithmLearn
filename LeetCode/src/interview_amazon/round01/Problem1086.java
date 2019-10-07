package interview_amazon.round01;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Problem1086 {

    class Student {
        int id;
        int score;
        Student(int id, int score) {
            this.id = id;
            this.score = score;
        }
    }

    class CustomCmp implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            if (o1.id != o2.id) {
                return o1.id - o2.id;
            }
            return o2.score - o1.score;
        }
    }

    public int[][] highFive(int[][] items) {
        List<Student> students = new ArrayList<>();
        int size = items.length;

        for (int[] item : items) {
            students.add(new Student(item[0], item[1]));
        }

        students.sort(new CustomCmp());

        int count = 0;
        List<Student> ansList = new ArrayList<>();
        int sum = 0;
        int lastId = 0;
        for (int i = 0; i < size; i++) {
            Student curStu = students.get(i);
            if (curStu.id == lastId) {
                continue;
            }
            count++;
            if (count <= 5) {
                sum += curStu.score;
                if (count == 5) {
                    Student student = new Student(curStu.id, sum / 5);
                    ansList.add(student);
                    sum = 0;
                    count = 0;
                    lastId = curStu.id;
                }
            }
        }

        int[][] ansArr = new int[ansList.size()][2];
        int num = 0;
        for (Student stu : ansList) {
            int[] item = new int[]{stu.id, stu.score};
            ansArr[num++] = item;
        }

        return ansArr;
    }

    public static void main(String[] args) {

    }

}
