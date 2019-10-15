package problem101_200;

import java.util.*;

public class Problem126 {


    private List<List<String>> ansList = new ArrayList<>();

    private Map<String, List<String>> nextListMap = new HashMap<>();

    // 每个单词的层数
    private Map<String, Integer> distanceMap = new HashMap<>();

    private int minDepth = Integer.MAX_VALUE;

    /**
     * 寻找跟某单词只差1个字符的单词列表
     */
    private List<String> findNextList(String word, List<String> wordList) {
        int len = word.length();
        List<String> ansList = new ArrayList<>();
        for (String tmpWord : wordList) {
            int diffCount = 0;
            for (int i = 0; i < len; i++) {
                if (word.charAt(i) != tmpWord.charAt(i)) {
                    diffCount++;
                }

                if (diffCount > 1) {
                    break;
                }
            }

            if (diffCount == 1) {
                ansList.add(tmpWord);
            }
        }

        return ansList;
    }

    private void dfsFind(String beginWord, String endWord, List<String> path) {
        if (path.size() > minDepth) {
            return;
        }

        if (beginWord.equals(endWord)) {
            ansList.add(new ArrayList<>(path));
            return;
        }

        List<String> nextList = nextListMap.get(beginWord);
        for (String nextWord: nextList) {
            if (distanceMap.containsKey(nextWord) && path.size() >= distanceMap.get(nextWord) + 1) {
                continue;
            }

            path.add(nextWord);
            dfsFind(nextWord, endWord, path);
            path.remove(nextWord);
        }
    }

    private void getNextListMap(List<String> wordList) {
        for (String word: wordList) {
            nextListMap.put(word, findNextList(word, wordList));
        }
    }

    private boolean bfsFind(String beginWord, String endWord) {
        LinkedList<String> queue = new LinkedList<>();

        queue.addLast(beginWord);
        distanceMap.put(beginWord, 0);

        int depth = 0;

        while (!queue.isEmpty()) {
            depth++;
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                String word = queue.removeFirst();

                List<String> nextList = nextListMap.get(word);
                for (String nextWord: nextList) {
                    if (distanceMap.containsKey(nextWord)) {
                        continue;
                    }
                    distanceMap.put(nextWord, depth);
                    if (nextWord.equals(endWord)) {
                        minDepth = depth + 1;
                        return true;
                    }
                    queue.addLast(nextWord);
                }
            }
        }

        return false;
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return new ArrayList<>();
        }

        wordList.add(beginWord);

        getNextListMap(wordList);
        boolean isFound = bfsFind(beginWord, endWord);
        if (!isFound) {
            return new ArrayList<>();
        }

        List<String> path = new ArrayList<>();
        path.add(beginWord);
        dfsFind(beginWord, endWord, path);

        return ansList;
    }

    public static void main(String[] args) {
//        List<String> wordList = new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log","cog"));
//        List<List<String>> ansList = new Problem126().findLadders("hit", "cog", wordList);
//
//        List<String> wordList = new ArrayList<>(Arrays.asList("si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"));
//        List<List<String>> ansList = new Problem126().findLadders("qa", "sq", wordList);

        List<String> wordList = new ArrayList<>(Arrays.asList("kid","tag","pup","ail","tun","woo","erg","luz","brr","gay","sip","kay","per","val","mes","ohs","now","boa","cet","pal","bar","die","war","hay","eco","pub","lob","rue","fry","lit","rex","jan","cot","bid","ali","pay","col","gum","ger","row","won","dan","rum","fad","tut","sag","yip","sui","ark","has","zip","fez","own","ump","dis","ads","max","jaw","out","btu","ana","gap","cry","led","abe","box","ore","pig","fie","toy","fat","cal","lie","noh","sew","ono","tam","flu","mgm","ply","awe","pry","tit","tie","yet","too","tax","jim","san","pan","map","ski","ova","wed","non","wac","nut","why","bye","lye","oct","old","fin","feb","chi","sap","owl","log","tod","dot","bow","fob","for","joe","ivy","fan","age","fax","hip","jib","mel","hus","sob","ifs","tab","ara","dab","jag","jar","arm","lot","tom","sax","tex","yum","pei","wen","wry","ire","irk","far","mew","wit","doe","gas","rte","ian","pot","ask","wag","hag","amy","nag","ron","soy","gin","don","tug","fay","vic","boo","nam","ave","buy","sop","but","orb","fen","paw","his","sub","bob","yea","oft","inn","rod","yam","pew","web","hod","hun","gyp","wei","wis","rob","gad","pie","mon","dog","bib","rub","ere","dig","era","cat","fox","bee","mod","day","apr","vie","nev","jam","pam","new","aye","ani","and","ibm","yap","can","pyx","tar","kin","fog","hum","pip","cup","dye","lyx","jog","nun","par","wan","fey","bus","oak","bad","ats","set","qom","vat","eat","pus","rev","axe","ion","six","ila","lao","mom","mas","pro","few","opt","poe","art","ash","oar","cap","lop","may","shy","rid","bat","sum","rim","fee","bmw","sky","maj","hue","thy","ava","rap","den","fla","auk","cox","ibo","hey","saw","vim","sec","ltd","you","its","tat","dew","eva","tog","ram","let","see","zit","maw","nix","ate","gig","rep","owe","ind","hog","eve","sam","zoo","any","dow","cod","bed","vet","ham","sis","hex","via","fir","nod","mao","aug","mum","hoe","bah","hal","keg","hew","zed","tow","gog","ass","dem","who","bet","gos","son","ear","spy","kit","boy","due","sen","oaf","mix","hep","fur","ada","bin","nil","mia","ewe","hit","fix","sad","rib","eye","hop","haw","wax","mid","tad","ken","wad","rye","pap","bog","gut","ito","woe","our","ado","sin","mad","ray","hon","roy","dip","hen","iva","lug","asp","hui","yak","bay","poi","yep","bun","try","lad","elm","nat","wyo","gym","dug","toe","dee","wig","sly","rip","geo","cog","pas","zen","odd","nan","lay","pod","fit","hem","joy","bum","rio","yon","dec","leg","put","sue","dim","pet","yaw","nub","bit","bur","sid","sun","oil","red","doc","moe","caw","eel","dix","cub","end","gem","off","yew","hug","pop","tub","sgt","lid","pun","ton","sol","din","yup","jab","pea","bug","gag","mil","jig","hub","low","did","tin","get","gte","sox","lei","mig","fig","lon","use","ban","flo","nov","jut","bag","mir","sty","lap","two","ins","con","ant","net","tux","ode","stu","mug","cad","nap","gun","fop","tot","sow","sal","sic","ted","wot","del","imp","cob","way","ann","tan","mci","job","wet","ism","err","him","all","pad","hah","hie","aim","ike","jed","ego","mac","baa","min","com","ill","was","cab","ago","ina","big","ilk","gal","tap","duh","ola","ran","lab","top","gob","hot","ora","tia","kip","han","met","hut","she","sac","fed","goo","tee","ell","not","act","gil","rut","ala","ape","rig","cid","god","duo","lin","aid","gel","awl","lag","elf","liz","ref","aha","fib","oho","tho","her","nor","ace","adz","fun","ned","coo","win","tao","coy","van","man","pit","guy","foe","hid","mai","sup","jay","hob","mow","jot","are","pol","arc","lax","aft","alb","len","air","pug","pox","vow","got","meg","zoe","amp","ale","bud","gee","pin","dun","pat","ten","mob"));
        List<List<String>> ansList = new Problem126().findLadders("cet", "ism", wordList);

        for (List<String> list : ansList) {
            for (String word: list) {
                System.out.print(word + ",");
            }
            System.out.println();
        }
    }

}
