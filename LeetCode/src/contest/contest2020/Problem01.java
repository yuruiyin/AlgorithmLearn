package contest.contest2020;

import java.util.List;

public class Problem01 {

    public class Solution
    {
        public String q()
        {
            char q = 34;      // Quotation mark character
            String[] l = {    // Array of source code
                    "public class Solution",
                    "{",
                    "  public String q()",
                    "  {",
                    "    char q = 34;      // Quotation mark character",
                    "    String[] l = {    // Array of source code",
                    "    ",
                    "    };",
                    "    StringBuilder sb = new StringBuilder();",
                    "    for(int i = 0; i < 6; i++)           // Print opening code",
                    "        sb.append(l[i]).append(\"\\n\");",
                    "    for(int i = 0; i < l.length; i++)    // Print string array",
                    "        sb.append(l[6] + q + l[i] + q + ',').append(\"\\n\");",
                    "    for(int i = 7; i < l.length; i++)    // Print this code",
                    "        sb.append(l[i]).append(\"\\n\");",
                    "    return sb.toString();",
                    "  }",
                    "}",
            };
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < 6; i++)           // Print opening code
                sb.append(l[i]).append("\n");
            for(int i = 0; i < l.length; i++)    // Print string array
                sb.append(l[6] + q + l[i] + q + ',').append("\n");
            for(int i = 7; i < l.length; i++)    // Print this code
                sb.append(l[i]).append("\n");
            return sb.toString();
        }
    }


}
