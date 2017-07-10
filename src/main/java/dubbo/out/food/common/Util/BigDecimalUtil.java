package dubbo.out.food.common.Util;

import java.math.BigDecimal;

/**
 * @author zhangph
 * @version 2017-07-07 9:38
 **/
public class BigDecimalUtil {
    
    //�ϱ���2λС��
    public static final int SCALE = 2;

    /**
     * ���㵥�۳���������Ĭ�ϱ���2λС��
     *
     * @param args1
     * @param args2
     * @return
     */
    public static BigDecimal multipy(BigDecimal args1, BigDecimal args2) {
        return multipy(args1, args2, SCALE);
    }

    /**
     * ����BigDecimal�������,����scaleλ
     *
     * @param args1
     * @param args2
     * @param scale
     * @return
     */
    public static BigDecimal multipy(BigDecimal args1, BigDecimal args2, int scale) {
        return args1.multiply(args2).setScale(scale, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * �ӷ�,�������뱣��ָ��С��λ��
     *
     * @param args1
     * @param args2
     * @param scale
     * @return
     */
    public static BigDecimal add(BigDecimal args1, BigDecimal args2, int scale) {
        if (args1 == null && args2 != null) {
            return args2.setScale(scale, BigDecimal.ROUND_HALF_UP);
        }

        if (args2 == null && args1 != null) {
            return args1.setScale(scale, BigDecimal.ROUND_HALF_UP);
        }

        if (args1 == null && args2 == null) {
            return new BigDecimal("0.00");
        }

        return args1.add(args2).setScale(scale, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * �ӷ�,�������뱣��2λС��
     *
     * @param args1
     * @param args2
     * @return
     */
    public static BigDecimal add(BigDecimal args1, BigDecimal args2) {
        return add(args1, args2, SCALE);
    }

    /**
     * �Ƚ����������Ƿ�һ���󣬾���ΪС�����2λ����������
     *
     * @param args1
     * @param args2
     * @return
     */
    public static boolean equals(BigDecimal args1, BigDecimal args2) {
        if (args1 == null && args2 == null) {
            return true;
        }
        if ((args1 == null && args2 != null) || (args1 != null && args2 == null)) {
            return false;
        }
        return args1.setScale(2, BigDecimal.ROUND_HALF_UP).equals(args2.setScale(2, BigDecimal.ROUND_HALF_UP));
    }

    /**
     * �����ܼۣ�������λС�����������룩
     *
     * @param price ����
     * @param count ����
     * @return
     */
    public static BigDecimal getTotalPrice(BigDecimal price, BigDecimal count) {
        BigDecimal zero = new BigDecimal("0.00");
        if (zero.compareTo(count) == 0) {
            return zero;
        } else {
            return price.multiply(count).setScale(SCALE, BigDecimal.ROUND_HALF_UP);
        }
    }

    /**
     * ����Integer������õ���λС�����ȵ�����,�����������
     *
     * @param dividend
     * @param divisor
     * @return
     */
    public static BigDecimal divide(Integer dividend, Integer divisor) {
        return new BigDecimal(dividend).divide(new BigDecimal(divisor), SCALE, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * ���� args1 - args2 ����scaleλ
     *
     * @param args1
     * @param args2
     * @param scale
     * @return
     */
    public static BigDecimal subtract(BigDecimal args1, BigDecimal args2, int scale) {
        return args1.subtract(args2).setScale(scale, BigDecimal.ROUND_HALF_UP);
    }

    public static BigDecimal subtract(BigDecimal args1, BigDecimal args2) {
        return args1.subtract(args2).setScale(SCALE, BigDecimal.ROUND_HALF_UP);
    }
}
