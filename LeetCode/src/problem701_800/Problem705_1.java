package problem701_800;

import java.util.Iterator;
import java.util.LinkedList;

public class Problem705_1 {

    class MyHashSet {

        private static final int BASE = 107;

        private final LinkedList<Integer>[] linkedList;

        private int hash(int key) {
            return key % BASE;
        }

        public MyHashSet() {
            linkedList = new LinkedList[BASE];
            for (int i = 0; i < BASE; i++) {
                linkedList[i] = new LinkedList<>();
            }
        }

        public void add(int key) {
            int h = hash(key);
            for (int tmpKey : linkedList[h]) {
                if (tmpKey == key) {
                    return;
                }
            }
            linkedList[h].addLast(key);
        }

        public void remove(int key) {
            int h = hash(key);
            Iterator<Integer> iterator = linkedList[h].iterator();
            while (iterator.hasNext()) {
                int tmpKey = iterator.next();
                if (tmpKey == key) {
                    iterator.remove();
                    return;
                }
            }
        }

        public boolean contains(int key) {
            int h = hash(key);
            Iterator<Integer> iterator = linkedList[h].iterator();
            while (iterator.hasNext()) {
                int tmpKey = iterator.next();
                if (tmpKey == key) {
                    return true;
                }
            }
            return false;
        }
    }

}
