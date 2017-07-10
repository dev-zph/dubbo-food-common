package dubbo.out.food.common.Util;

import java.math.BigDecimal;

/**
 * �������� ������
 *
 * @author zhangph
 * @version 2017-07-07 9:37
 **/
public class FloatUtil {

    //�ϱ���1λС��
    public static final int SCALE = 1;

    /**
     * ��ʽ��floatС��λ���������룩
     *
     * @param number
     * @param scale
     * @return
     */
    public static float formatFloat(float number, int scale) {
        BigDecimal b = new BigDecimal(number);
        return b.setScale(scale, BigDecimal.ROUND_HALF_UP).floatValue();
    }

    /**
     * ��ʽ��floatС��λ���������룩
     *
     * @param number
     * @return
     */
    public static float formatFloat(float number) {
        return formatFloat(number, SCALE);
    }
}
