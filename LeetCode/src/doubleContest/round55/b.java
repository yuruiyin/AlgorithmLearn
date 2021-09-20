package doubleContest.round55;

/**
 * A
 *
 * @author: yry
 * @date: 2021/6/26
 */
public class b {

    public String removeOccurrences(String s, String part) {
        while (s.contains(part)) {
           int start = s.indexOf(part);
           if (s.equals(part)) {
               return "";
           }

           if (start == 0) {
               s = s.substring(part.length());
           } else {
               int len = s.length();
               String oldS = s;
               s = s.substring(0, start);
               if (start + part.length() < len) {
                   s += oldS.substring(start + part.length());
               }
           }
        }

        return s;
    }

}
