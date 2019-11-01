package contest.contest145;

import utils.PrintUtil;

import java.util.*;

public class Problem1125 {

    private int ansMin = Integer.MAX_VALUE;
    private List<Integer> ansList = new ArrayList<>();

    private List<List<String>> people;

    private void backTrack(String[] req_skills, int from, Map<String, List<Integer>> skillsToPeoplesMap, Set<String> visitedSkillsSet, Set<Integer> peoples) {
        if (visitedSkillsSet.size() == req_skills.length) {
            if (peoples.size() < ansMin) {
                ansMin = peoples.size();
                ansList.clear();
                ansList.addAll(peoples);
            }
            return;
        }

        if (from >= req_skills.length) {
            return;
        }

        String skill = req_skills[from];
        if (visitedSkillsSet.contains(skill)) {
            backTrack(req_skills, from + 1, skillsToPeoplesMap, visitedSkillsSet, peoples);
            return;
        }

        for (Integer p: skillsToPeoplesMap.get(skill)) {
            peoples.add(p);
            visitedSkillsSet.addAll(people.get(p));
            backTrack(req_skills, from + 1, skillsToPeoplesMap, visitedSkillsSet, peoples);
            visitedSkillsSet.removeAll(people.get(p));
            peoples.remove(p);
        }
    }

    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        this.people = people;
        Map<String, List<Integer>> skillsToPeoplesMap = new HashMap<>();

        for (String skill: req_skills) {
            skillsToPeoplesMap.put(skill, new ArrayList<>());
        }

        for (int i = 0; i < people.size(); i++) {
            List<String> skills = people.get(i);
            for (String sk : skills) {
                skillsToPeoplesMap.get(sk).add(i);
            }
        }

        backTrack(req_skills, 0, skillsToPeoplesMap, new HashSet<>(), new HashSet<>());

        int[] ansArr = new int[ansList.size()];
        for (int i = 0; i < ansList.size(); i++) {
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

        int[] ans = new Problem1125().smallestSufficientTeam(new String[]{"algorithms","math","java","reactjs","csharp","aws"},
                people);

        PrintUtil.printIntArray(ans);
    }
    
}
