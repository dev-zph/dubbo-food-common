package dubbo.out.food.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.apache.commons.lang.StringUtils;

import com.xianguo.platform.common.Constants;
/**
 * @author 陈佳
 * @createTime 2017�?1�?23�? 上午9:31:07
 * 
 */
public class OrderUtil {
	/**
	 *生成订单编号
	 * @param userId
	 * @return
	 */
	public static String generateOrderNum(String userId) {
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		String orderNum;
		if (!StringUtils.isEmpty(userId)) {
			int len = 8 - String.valueOf(userId).length();
			for (int i = 0; i < len; i++) {// �?0
				userId = "0" + userId;
			}
			orderNum = userId + df.format(new Date());
		} else {
			orderNum = "99999999" + df.format(new Date());
		}
		int x = new Random().nextInt(90000) + 10000;
		orderNum = Constants.ORDER_PREFIX + orderNum + x;
		return orderNum;
	}

}
