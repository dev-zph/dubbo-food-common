package dubbo.out.food.common.Util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 加密工具
 *
 * @author zhangph
 * @version 2017-07-07 9:34
 **/
public class EncryptMD5 {
    /**
     * 对文本进行md5 32位小写加密
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
     * 把明文字符串MD5加密后与存储的MD5对比
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
