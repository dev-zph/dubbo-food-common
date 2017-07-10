package dubbo.out.food.common.Util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * ���ܹ���
 *
 * @author zhangph
 * @version 2017-07-07 9:34
 **/
public class EncryptMD5 {
    /**
     * ���ı�����md5 32λСд����
     *
     * @param text
     * @return
     * @throws
     */
    public static String getMD5(String text) {
        String result = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(text.getBytes());
            result = new BigInteger(1, md.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * �������ַ���MD5���ܺ���洢��MD5�Ա�
     *
     * @param source
     * @param md5
     * @return
     */
    public static boolean equalsMd5(String source, String md5) {
        String sourceMd5 = getMD5(source);
        return md5.equals(sourceMd5);
    }
}
