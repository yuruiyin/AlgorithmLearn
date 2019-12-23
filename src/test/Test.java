package test;

import java.util.*;

public class Test {

    static class Data {
        String name;
        Data(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {
        List<Data> list1 = new ArrayList<>();
        List<Data> list2 = new ArrayList<>();

        list1.add(new Data("name1"));
        list1.add(new Data("name2"));
        list1.add(new Data("name3"));

        list2.add(new Data("name1"));
        list2.add(new Data("name2"));
        list2.add(new Data("name3"));

        Set<List<Data>> set = new HashSet<>();

        set.add(list1);
        set.add(list2);
        
        System.out.println(set.size());

        for (List<Data> list : set) {
            for (Data data : list) {
                System.out.print(data.name + " ");
            }
            System.out.println();
        }
    }

}
