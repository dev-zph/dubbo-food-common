package dubbo.out.food.utils;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

public class EncryptMD5 {

	/**
	 * 对文本进行md5 32位小写加�?
	 * @param text
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public static String getMD5(String text){
		String result = null;  
		
        char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',  
                'a', 'b', 'c', 'd', 'e', 'f' };		//用来将字节转换成16进制表示的字�?  
        try {  
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");  
            md.update(text.getBytes());  
            byte tmp[] = md.digest();// MD5 的计算结果是�?�? 128 位的长整数， 
            char str[] = new char[16 * 2];// 每个字节�? 16 进制表示的话，使用两个字符， �?以表示成 16，进制需�? 32 个字�?  
            int k = 0;
            for (int i = 0; i < 16; i++) {
                byte byte0 = tmp[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];	//取字节中�? 4 位的数字转换
                // 为�?�辑右移，将符号位一起右�?  
                str[k++] = hexDigits[byte0 & 0xf];
  
            }  
            result = new String(str);
  
        } catch (NoSuchAlgorithmException e) {  
            e.printStackTrace();  
        }  
		
		return result;
	}
	/**
	 * 把明文字符串MD5加密后与存储的MD5对比
	 * @param source
	 * @param md5
	 * @return
	 */
	public static boolean equalsMd5(String source,String md5){
		boolean result;
		String sourceMd5 = getMD5(source);
		result = md5.equals(sourceMd5) ? true : false;
		return result;
	}
	
}
