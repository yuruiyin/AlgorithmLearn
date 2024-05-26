package hmac;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class TestHMAC {

    private static final String HMAC_SHA1_ALGORITHM = "HmacSHA1";

    /**
     * 签名
     * @author qian xi
     * @date 16:55 2023/2/24
     * @param data 数据
     * @param key 密钥
     * @return java.lang.String
     */
    private static String getHMAC(String data, String key) throws Exception {
        SecretKeySpec signinKey = new SecretKeySpec(key.getBytes(), HMAC_SHA1_ALGORITHM);
        Mac mac = Mac.getInstance(HMAC_SHA1_ALGORITHM);
        mac.init(signinKey);
        byte[] rawHmac = mac.doFinal(data.getBytes());
        return new String(Base64.getEncoder().encode(rawHmac));
    }

    public static void main(String[] args) {
        // data: GET@/api/sync@last_clock=243819limit=100set_type=0@1693491015, key: 950422DACE1A690579EE92209A586660
        String data = "GET@/api/sync@last_clock=243819limit=100set_type=0@1693491015";
        String key = "950422DACE1A690579EE92209A586660";
        try {
            System.out.println(getHMAC(data, key));
        } catch (Exception e) {

        }
    }

}
