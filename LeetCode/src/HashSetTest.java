import java.util.HashSet;
import java.util.Set;

public class HashSetTest {

    public static void main(String[] args) {
        Set<Long> oldSet = new HashSet<>();
        oldSet.add(1L);
        Set<Long> newSet = new HashSet<>(oldSet);
        oldSet.clear();
        System.out.println(newSet.size());
    }

}
