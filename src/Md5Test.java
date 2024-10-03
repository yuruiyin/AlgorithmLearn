import java.security.MessageDigest;

public class Md5Test {

    /**
     * 转换成md5值
     *
     * @param src
     * @return
     */
    public final static String convertMd5(String src) {

        String result = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(src.getBytes());
            byte[] b = md.digest();
            int i;
            StringBuilder sb = new StringBuilder();
            for (byte value : b) {
                i = value;
                if (i < 0)
                    i += 256;
                if (i < 16)
                    sb.append("0");
                sb.append(Integer.toHexString(i));
            }
            result = sb.toString();  //md5 32bit
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(convertMd5("/gdesign/view-meta/prod/assets/utils-BUjs2HBO.js"));
    }

}
