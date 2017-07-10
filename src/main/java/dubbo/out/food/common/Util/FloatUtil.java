package dubbo.out.food.common.Util;

import java.math.BigDecimal;

/**
 * 浮点类型 工具类
 *
 * @author zhangph
 * @version 2017-07-07 9:37
 **/
public class FloatUtil {

    //认保留1位小数
    public static final int SCALE = 1;

    /**
     * 格式化float小数位（四舍五入）
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
     * 格式化float小数位（四舍五入）
     *
     * @param number
     * @return
     */
    public static float formatFloat(float number) {
        return formatFloat(number, SCALE);
    }
}
