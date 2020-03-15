package utils;

import java.util.Iterator;

/**
 * TreeMultiSetTest
 *
 * @author: yry
 * @date: 2020/3/15
 */
public class TreeMultiSetTest {

    private static void testConstructor1() {

    }

    private static void testDiffIterator(TreeMultiSet<Integer> treeMultiSet) {
        System.out.println("testDiffIterator: ");
        Iterator diffIterator = treeMultiSet.diffIterator();
        while (diffIterator.hasNext()) {
            System.out.print(diffIterator.next() + " ");
        }
        System.out.println();
    }

    private static void testDiffDescendingIterator(TreeMultiSet<Integer> treeMultiSet) {
        System.out.println("testDiffDescendingIterator: ");
        Iterator diffDescendingIterator = treeMultiSet.diffDescendingIterator();
        while (diffDescendingIterator.hasNext()) {
            System.out.print(diffDescendingIterator.next() + " ");
        }
        System.out.println();
    }

    private static void testIterator(TreeMultiSet<Integer> treeMultiSet) {
        System.out.println("testIterator: ");
        Iterator iterator = treeMultiSet.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    }

    private static void testDescendingIterator(TreeMultiSet<Integer> treeMultiSet) {
        System.out.println("testDescendingIterator: ");
        Iterator descendingIterator = treeMultiSet.descendingIterator();
        while (descendingIterator.hasNext()) {
            System.out.print(descendingIterator.next() + " ");
        }
        System.out.println();
    }

    // foreach最终也是用到iterator
    private static void testForeach(TreeMultiSet<Integer> treeMultiSet) {
        System.out.println("testForeach: ");
        for (Integer num : treeMultiSet) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        TreeMultiSet<Integer> treeMultiSet = new TreeMultiSet();
        treeMultiSet.add(2);
        treeMultiSet.add(4);
        treeMultiSet.add(1);
        treeMultiSet.add(2);
        treeMultiSet.add(3);
        treeMultiSet.add(2);
        treeMultiSet.add(3);
        treeMultiSet.add(1);

//        int smallest = treeMultiSet.pollFirst(1);
//        System.out.println("smallest: " + smallest);
//
//        int biggest = treeMultiSet.pollLast(1);
//        System.out.println("biggest: " + biggest);
        treeMultiSet.remove(3);
        treeMultiSet.remove(2, 1);
        treeMultiSet.add(2);
        treeMultiSet.add(4, 5);

        System.out.println("size : " + treeMultiSet.size());
        System.out.println("diffElementSize : " + treeMultiSet.diffElementSize());

        testForeach(treeMultiSet);
        testIterator(treeMultiSet);
        testDescendingIterator(treeMultiSet);
        testDiffIterator(treeMultiSet);
        testDiffDescendingIterator(treeMultiSet);


//        for (Integer num : treeMultiSet) {
//            System.out.print(num + " ");
//        }
//        System.out.println();

        TreeMultiSet<Integer> treeMultiSetClone = (TreeMultiSet<Integer>) treeMultiSet.clone();
//        for (Integer num : treeMultiSetClone) {
//            System.out.print(num + " ");
//        }
//        System.out.println();


//        TreeSet<Integer> set = new TreeSet<>();
//        set.add(1);
//        set.add(2);
//        TreeSet<Integer> cloneSet = (TreeSet) set.clone();
//
//        for (Integer num : cloneSet) {
//            System.out.println(num);
//        }

    }

}
