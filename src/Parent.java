public class Parent {

    public int age;

    public String name;

    static class Child extends Parent {
        public String school;
    }

    public static void main(String[] args) {
        Child child = new Child();
        child.age = 10;
        child.name = "hh";
        child.school = "清华";
        Parent parent = ((Parent) child);
        if (parent instanceof Child) {
            System.out.println(((Child) parent).school);
        }
    }
}
