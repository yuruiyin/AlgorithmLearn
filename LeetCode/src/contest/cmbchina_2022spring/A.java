package contest.cmbchina_2022spring;

public class A {

    public String deleteText(String article, int index) {
        char[] arr = article.toCharArray();
        int len = arr.length;
        if (arr[index] == ' ') {
            return article;
        }

        String[] strArr = article.split(" ");
        int blankCount = 0;
        for (int i = 0; i <= index; i++) {
            if (arr[i] == ' ') {
                blankCount++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strArr.length; i++) {
            if (i == strArr.length - 1) {
                if (i == blankCount) {
                    if (sb.length() == 0) {
                        return "";
                    }
                    return sb.substring(0, sb.length() - 1);
                }
                sb.append(strArr[i]);
            } else {
                if (i == blankCount) {
                    continue;
                }
                sb.append(strArr[i]).append(" ");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new A().deleteText("Hello", 0));
    }

}
