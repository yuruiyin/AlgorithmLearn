package contest.contest178;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Problem02 {

    class Data {
        int team;
        int[] rankCountArr;
        Data(int team, int[] rankCountArr) {
            this.team = team;
            this.rankCountArr = rankCountArr;
        }
    }

    public String rankTeams(String[] votes) {
        int teamCount = votes[0].length();
        Data[] countArr = new Data[26];

        for (String vote : votes) {
            for (int i = 0; i < vote.length(); i++) {
                int team = vote.charAt(i) - 'A';
                if (countArr[team] == null) {
                    countArr[team] = new Data(team, new int[teamCount]);
                }
                countArr[team].rankCountArr[i]++;
            }
        }

        Arrays.sort(countArr, new Comparator<Data>() {
            @Override
            public int compare(Data o1, Data o2) {
                if (o1 == null) {
                    return 1;
                } else if (o2 == null) {
                    return -1;
                }

                int[] rank1 = o1.rankCountArr;
                int[] rank2 = o2.rankCountArr;

                int rankBigger = 0;

                for (int i = 0; i < rank1.length; i++) {
                    if (rank1[i] > rank2[i]) {
                        rankBigger = 1;
                        break;
                    } else if (rank1[i] < rank2[i]) {
                        rankBigger = -1;
                        break;
                    }
                }

                if (rankBigger == 1) {
                    return -1;
                } else if (rankBigger == -1) {
                    return 1;
                }

                return o1.team - o2.team;
            }
        });

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 26; i++) {
            if (countArr[i] == null) {
                continue;
            }

            sb.append((char) (countArr[i].team + 'A'));
        }

        return sb.toString();
    }

}
