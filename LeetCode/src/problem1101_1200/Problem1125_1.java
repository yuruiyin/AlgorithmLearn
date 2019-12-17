package problem1101_1200;

import utils.PrintUtil;

import java.util.*;

public class Problem1125_1 {

    private Map<String, Integer> skillToIndexMap;
    private int[] peopleSkillSet;
    private long[][] memo;
    private List<Integer> candidatePeopleIndexList;  // 候选成员索引列表（去除那些所掌握技能是别人子集的成员）
    private int candidatePeopleSize;

    /**
     * 建立成员掌握的技能索引列表
     */
    private void createPeopleSkillSet(List<List<String>> people) {
        peopleSkillSet = new int[people.size()];
        for (Integer i: candidatePeopleIndexList) {
            peopleSkillSet[i] = 0;
            for (String skill: people.get(i)) {
                int skillIndex = skillToIndexMap.get(skill);
                peopleSkillSet[i] |= (1 << skillIndex);
            }
        }
    }

    /**
     * 递归+记忆化求解
     * @param needSkillsFlag 当前递归剩余的需要掌握的技能 （二进制位1代表改技能还没人掌握）
     * @return 当前递归需要的人集合（二进制1代表需要这个人）,整个值是-1代表找不到了
     */
    private long backTrack(int needSkillsFlag, int candidatePeopleIndex) {
        if (needSkillsFlag == 0) { // 每一位都变成0，说明所有技能都有人掌握了。
             return 0;
        }

        if (candidatePeopleIndex == candidatePeopleSize) {
            // 人都选完了，但是还有技能没有人掌握
            return -1;
        }

        if (memo[needSkillsFlag][candidatePeopleIndex] != -2) {
            return memo[needSkillsFlag][candidatePeopleIndex];
        }

        int realPeopleIndex = candidatePeopleIndexList.get(candidatePeopleIndex); // 真实的成员索引（成员在给定列表中的索引）
        int curPeopleSkillSet = peopleSkillSet[realPeopleIndex];
        if ((needSkillsFlag & (~curPeopleSkillSet)) == needSkillsFlag) {
            // 当前成员没有掌握剩下的技能（可能为空，可能是掌握的是前面其它成员已经掌握的技能）
            memo[needSkillsFlag][candidatePeopleIndex] = backTrack(needSkillsFlag, candidatePeopleIndex + 1);
            return memo[needSkillsFlag][candidatePeopleIndex];
        }

        long chooseRes = backTrack(needSkillsFlag & (~curPeopleSkillSet), candidatePeopleIndex + 1);
        if (chooseRes != -1) {
            chooseRes |= (1L << realPeopleIndex); // 由于peopleIndex可能大于32位，因此这里需要用1L去左移。（PS：哭，调了大半天）
        }

        long nonChooseRes = backTrack(needSkillsFlag, candidatePeopleIndex + 1);

        if (chooseRes == -1 && nonChooseRes == -1) {
            memo[needSkillsFlag][candidatePeopleIndex] = -1;
        } else if (chooseRes == -1) {
            memo[needSkillsFlag][candidatePeopleIndex] = nonChooseRes;
        } else if (nonChooseRes == -1) {
            memo[needSkillsFlag][candidatePeopleIndex] = chooseRes;
        } else {
            memo[needSkillsFlag][candidatePeopleIndex] = Long.bitCount(chooseRes) <= Long.bitCount(nonChooseRes) ? chooseRes : nonChooseRes;
        }

        return memo[needSkillsFlag][candidatePeopleIndex];
    }

    /**
     * 建立技能到索引的map
     */
    private void createSkillToIndexMap(String[] req_skills) {
        skillToIndexMap = new HashMap<>();
        for (int i = 0; i < req_skills.length; i++) {
            skillToIndexMap.put(req_skills[i], i);
        }
    }

    private boolean isObtain(List<String> list1, List<String> list2) {
        if (list1.size() < list2.size()) {
            return false;
        }

        Set<String> set1 = new HashSet<>(list1);

        for (String skill : list2) {
            if (!set1.contains(skill)) {
                return false;
            }
        }

        // list1 包含list2
        return true;
    }

    /**
     * 生成候选人索引列表
     */
    private void createCandidatePeopleIndexList(List<List<String>> people) {
        candidatePeopleIndexList = new ArrayList<>();
        Set<Integer> removedIndexSet = new HashSet<>();
        for (int i = 0; i < people.size(); i++) {
            for (int j = 0; j < people.size(); j++) {
                if (i == j || removedIndexSet.contains(j)) { // 不跟自己和已删除的人比
                    continue;
                }

                if (isObtain(people.get(j), people.get(i))) {
                    removedIndexSet.add(i);
                    break;
                }
            }
        }

        for (int i = 0; i < people.size(); i++) {
            if (!removedIndexSet.contains(i)) {
                candidatePeopleIndexList.add(i);
            }
        }

        this.candidatePeopleSize = candidatePeopleIndexList.size();
    }

    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        createCandidatePeopleIndexList(people);
        int peopleLen = people.size();
        createSkillToIndexMap(req_skills);
        createPeopleSkillSet(people);

        int needSkillsFlag = (1 << req_skills.length) - 1;
        memo = new long[needSkillsFlag + 1][candidatePeopleSize];
        for (int i = 0; i <= needSkillsFlag; i++) {
            for (int j = 0; j < candidatePeopleSize; j++) {
                memo[i][j] = -2;
            }
        }
        long result = backTrack(needSkillsFlag, 0);
        List<Integer> ansList = new ArrayList<>();

        for (int i = 0; i < peopleLen; i++) {
            long value = result & 1;
            if (value == 1) {
                ansList.add(i);
            }
            result >>>= 1;
        }

        int peopleSize = ansList.size();
        int[] ansArr = new int[peopleSize];
        for (int i = 0; i < peopleSize; i++) {
            ansArr[i] = ansList.get(i);
        }
        return ansArr;
    }
    
    public static void main(String[] args) {
        List<List<String>> people = new ArrayList<>();
        people.add(new ArrayList<>(Arrays.asList("algorithms","math","java")));
        people.add(new ArrayList<>(Arrays.asList("algorithms","math","reactjs")));
        people.add(new ArrayList<>(Arrays.asList("java","csharp","aws")));
        people.add(new ArrayList<>(Arrays.asList("reactjs","csharp")));
        people.add(new ArrayList<>(Arrays.asList("csharp","math")));
        people.add(new ArrayList<>(Arrays.asList("aws","java")));

        int[] ansArr = new Problem1125_1().smallestSufficientTeam(new String[]{"algorithms","math","java","reactjs","csharp","aws"},
                people);

        PrintUtil.printIntArray(ansArr);

//        long x = (1L << 40);
//        System.out.println(x);
    }

}
