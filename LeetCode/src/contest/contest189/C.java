package contest.contest189;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * A
 *
 * @author: yry
 * @date: 2020/5/17
 */
public class C {

    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        List<Integer> ansList = new ArrayList<>();
        int size = favoriteCompanies.size();
        for (int i = 0; i < size; i++) {
            List<String> list = favoriteCompanies.get(i);
            boolean gIsSub = false;
            for (int j = 0; j < size; j++) {
                if (i == j) {
                    continue;
                }

                List<String> list1 = favoriteCompanies.get(j);
                Set<String> companySet1 = new HashSet<>(list1);
                boolean isSub = true;
                for (String company : list) {
                    if (!companySet1.contains(company)) {
                        isSub = false;
                        break;
                    }
                }

                if (isSub) {
                    gIsSub = true;
                    break;
                }
            }

            if (!gIsSub) {
                ansList.add(i);
            }
        }

        return ansList;
    }

}
