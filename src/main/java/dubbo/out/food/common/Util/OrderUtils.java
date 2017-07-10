package dubbo.out.food.common.Util;

import dubbo.out.food.common.MyException.ApplicationException;
import org.apache.commons.lang.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * ����������
 *
 * @author zhangph
 * @version 2017-07-07 9:39
 **/
public class OrderUtils {

    //֧������ǰ׺
    public static final String PAY_PREFIX = "P";

    // ������ǰ׺
    public static final String ORDER_PREFIX = "D";

    //���ֶ���ǰ׺
    public static final String WITHDRAW_CASH_PREFIX = "TX";

    private static SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");

    /**
     * ֧������������
     *
     * @param userId
     * @return
     */
    public static String generatePayNum(String userId) {
        return PAY_PREFIX + generateNum(userId);
    }

    /**
     * ����������
     *
     * @param userId
     * @return
     */
    public static String generateOrderNum(String userId) {
        return ORDER_PREFIX + generateNum(userId);
    }

    /**
     * ���ֶ����������
     *
     * @param userId
     * @return
     */
    public static String generateWithdrawCashNum(String userId) {
        return WITHDRAW_CASH_PREFIX + generateNum(userId);
    }

    /**
     * ����������ÿ��1000�ʶ������ظ������ÿ�û�1000�ʶ������ظ���
     * ֧��ˮƽ��չ���ۺϴ�������Ϊÿ�� 1000 * N,NΪˮƽ��չ��΢��������
     *
     * @param userId
     * @return
     */
    private static String generateNum(String userId) {
        String dateStr = df.format(new Date()).substring(2);
        if (StringUtils.isBlank(userId)) {
            throw new ApplicationException("������û�����");
        }
        try {
            Thread.sleep(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //�����
        int x = new Random().nextInt(90) + 10;
        return userId + dateStr + x;
    }
}
