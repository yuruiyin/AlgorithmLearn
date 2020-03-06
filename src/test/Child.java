package test;

public class Child extends AbsParent {

//    private Child() {
//
//    }

    public static void main(String[] args) {
        Child child1 = (Child) Child.getInstance(Child.class.getName());
        System.out.println(child1.toString());

        Child child2 = (Child) Child.getInstance(Child.class.getName());
        System.out.println(child2.toString());
    }
}
