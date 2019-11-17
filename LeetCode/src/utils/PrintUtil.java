package utils;

import common.ListNode;

import java.util.List;

public class PrintUtil {
    
    public static void printIntList(List<Integer> list) {
        for (Integer num: list) {
            System.out.print(num + ", ");
        }
        System.out.println();
    }

    public static void printIntListList(List<List<Integer>> listList) {
        for (List<Integer> list: listList) {
            printIntList(list);
        }
    }
    
    public static void printStringList(List<String> list) {
        for (String str: list) {
            System.out.println(str + ", ");
        }
        System.out.println();
    }

    public static void printIntArray(int[] nums) {
        for (int num: nums) {
            System.out.print(num + ", ");
        }
        System.out.println();
    }

    public static void printDoubleArray(double[] nums) {
        for (double num: nums) {
            System.out.print(num + ", ");
        }
        System.out.println();
    }
    
    public static void printStringArray(String[] strs) {
        for (String str: strs) {
            System.out.print(str + ", ");
        }
        System.out.println();
    }

    public static void printListNode(ListNode head) {
        ListNode cursor = head;
        while (cursor != null) {
            System.out.print(cursor.val + "->");
            cursor = cursor.next;
        }
        System.out.println();
    }

}
