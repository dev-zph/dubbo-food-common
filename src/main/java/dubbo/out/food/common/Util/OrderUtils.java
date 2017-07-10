package dubbo.out.food.common.Util;

import dubbo.out.food.common.MyException.ApplicationException;
import org.apache.commons.lang.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * 订单工具类
 *
 * @author zhangph
 * @version 2017-07-07 9:39
 **/
public class OrderUtils {

    //支付订单前缀
    public static final String PAY_PREFIX = "P";

    // 订单号前缀
    public static final String ORDER_PREFIX = "D";

    //提现订单前缀
    public static final String WITHDRAW_CASH_PREFIX = "TX";

    private static SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");

    /**
     * 支付订单号生成
     *
     * @param userId
     * @return
     */
    public static String generatePayNum(String userId) {
        return PAY_PREFIX + generateNum(userId);
    }

    /**
     * 订单号生成
     *
     * @param userId
     * @return
     */
    public static String generateOrderNum(String userId) {
        return ORDER_PREFIX + generateNum(userId);
    }

    /**
     * 提现订单编号生成
     *
     * @param userId
     * @return
     */
    public static String generateWithdrawCashNum(String userId) {
        return WITHDRAW_CASH_PREFIX + generateNum(userId);
    }

    /**
     * 处理能力，每秒1000笔订单不重复，最高每用户1000笔订单不重复，
     * 支持水平扩展，综合处理能力为每秒 1000 * N,N为水平扩展的微服务数量
     *
     * @param userId
     * @return
     */
    private static String generateNum(String userId) {
        String dateStr = df.format(new Date()).substring(2);
        if (StringUtils.isBlank(userId)) {
            throw new ApplicationException("错误的用户编码");
        }
        try {
            Thread.sleep(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //随机码
        int x = new Random().nextInt(90) + 10;
        return userId + dateStr + x;
    }
}
