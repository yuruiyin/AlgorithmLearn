package problem101_200;

public class Problem165 {

    public int compareVersion(String version1, String version2) {
        String[] versionArr1 = version1.split("\\.");
        String[] versionArr2 = version2.split("\\.");
        int len1 = versionArr1.length;
        int len2 = versionArr2.length;
        int minLen = Math.min(len1, len2);

        for (int i = 0; i < minLen; i++) {
            int iSubVersion1 = Integer.parseInt(versionArr1[i]);
            int iSubVersion2 = Integer.parseInt(versionArr2[i]);
            if (iSubVersion1 > iSubVersion2) {
                return 1;
            } else if (iSubVersion1 < iSubVersion2) {
                return -1;
            }
        }

        if (len1 == len2) {
            return 0;
        }

        if (len1 > len2) {
            // 判断最后是不是都是0，可能会有多个.0.0.0
            for (int i = minLen; i < len1; i++) {
                int subVersion1 = Integer.parseInt(versionArr1[i]);
                if (subVersion1 != 0) {
                    return 1;
                }
            }
            return 0;
        }

        for (int i = minLen; i < len2; i++) {
            int subVersion2 = Integer.parseInt(versionArr2[i]);
            if (subVersion2 != 0) {
                return -1;
            }
        }
        return 0;
    }
    
    public static void main(String[] args) {
//        System.out.println(new Problem165().compareVersion("0.1", "1.1"));
        System.out.println(new Problem165().compareVersion("1", "1.1"));
    }

}
