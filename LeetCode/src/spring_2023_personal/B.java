package spring_2023_personal;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class B {

    public int adventureCamp(String[] expeditions) {
        int len = expeditions.length;
        if (len == 1) {
            return -1;
        }
        String init = expeditions[0];
        String[] initArr = init.split("->");
        Set<String> initSet = new HashSet<>(Arrays.asList(initArr));
        int minIdx = -1;
        int maxCount = 0;
        for (int i = 1; i < len; i++) {
            if (expeditions[i].length() == 0) {
                continue;
            }
            String[] arr = expeditions[i].split("->");
            Set<String> set = new HashSet<>(Arrays.asList(arr));
            int count = 0;
            for (String str : set) {
                if (!initSet.contains(str)) {
                    count++;
                }
            }
            initSet.addAll(set);
            if (count > 0 && count > maxCount) {
                maxCount = count;
                minIdx = i;
            }
        }
        return minIdx;
    }

    public static void main(String[] args) {
//        System.out.println(new B().adventureCamp(new String[]{"Alice->Dex","","Dex"}));
        System.out.println(new B().adventureCamp(new String[]{"xO->xO->xO","xO->BKbWDH","xO->BKbWDH","BKbWDH->mWXW","LSAYWW->LSAYWW","oAibBvPdJ","LSAYWW->u","LSAYWW->LSAYWW"}));
    }

}
