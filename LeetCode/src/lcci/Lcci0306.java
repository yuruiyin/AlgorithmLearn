package lcci;

import java.util.LinkedList;

public class Lcci0306 {

    class AnimalShelf {

        class Animal {
            int id;
            int enqueueTime;
            Animal(int id, int enqueueTime) {
                this.id = id;
                this.enqueueTime = enqueueTime;
            }
        }

        private LinkedList<Animal> dogQueue;
        private LinkedList<Animal> catQueue;
        private int enqueueTime;

        public AnimalShelf() {
            dogQueue = new LinkedList<>();
            catQueue = new LinkedList<>();
            enqueueTime = 0;
        }

        public void enqueue(int[] animal) {
            int type = animal[1];
            int id = animal[0];

            if (type == 0) {
                catQueue.offer(new Animal(id, enqueueTime));
            } else {
                dogQueue.offer(new Animal(id, enqueueTime));
            }

            enqueueTime++;
        }

        public int[] dequeueAny() {
            if (catQueue.isEmpty() && dogQueue.isEmpty()) {
                return new int[]{-1, -1};
            } else if (dogQueue.isEmpty()) {
                return new int[]{catQueue.poll().id, 0};
            } else if (catQueue.isEmpty()) {
                return new int[]{dogQueue.poll().id, 1};
            } else {
                Animal dog = dogQueue.getFirst();
                Animal cat = catQueue.getFirst();
                if (dog.enqueueTime < cat.enqueueTime) {
                    dogQueue.poll();
                    return new int[]{dog.id, 1};
                } else {
                    catQueue.poll();
                    return new int[]{cat.id, 0};
                }
            }
        }

        public int[] dequeueDog() {
            if (dogQueue.isEmpty()) {
                return new int[]{-1, -1};
            }

            return new int[]{dogQueue.poll().id, 1};
        }

        public int[] dequeueCat() {
            if (catQueue.isEmpty()) {
                return new int[]{-1, -1};
            }

            return new int[]{catQueue.poll().id, 0};
        }
    }

}
