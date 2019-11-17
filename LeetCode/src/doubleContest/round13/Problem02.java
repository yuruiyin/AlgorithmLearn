package doubleContest.round13;

import java.util.*;

public class Problem02 {

    public String findSmallestRegion(List<List<String>> regions, String region1, String region2) {
        Map<String, String> parentMap = new HashMap<>();
        for (List<String> region: regions) {
            String tmpParent = region.get(0);
            for (int i = 1; i < region.size(); i++) {
                parentMap.put(region.get(i), tmpParent);
            }
        }

        if (parentMap.containsKey(region1) && parentMap.get(region1).equals(region2)) {
            return region2;
        }

        if (parentMap.containsKey(region2) && parentMap.get(region2).equals(region1)) {
            return region1;
        }

        Set<String> set = new HashSet<>();
        String curRegion = region1;
        while (parentMap.containsKey(curRegion)) {
            String tmpParent = parentMap.get(curRegion);
            if (tmpParent.equals(region2)) {
                return region2;
            }
            set.add(tmpParent);
            curRegion = tmpParent;
        }

        curRegion = region2;
        while (parentMap.containsKey(curRegion)) {
            String tmpParent = parentMap.get(curRegion);
            if (tmpParent.equals(region1)) {
                return region1;
            }
            if (set.contains(tmpParent)) {
                return tmpParent;
            }
            curRegion = tmpParent;
        }

        return "";
    }
    
    public static void main(String[] args) {
        
    }
    
}
