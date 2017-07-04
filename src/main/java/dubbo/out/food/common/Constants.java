package dubbo.out.food.common;

import dubbo.out.food.utils.ConfigurableConstants;

public class Constants extends ConfigurableConstants {

	static {
		// init("ftp.properties");
		init("common.properties");
	}


	// 订单数量取小数位数
	public static final int ITEM_COUNT_SCAL = 2;
	// 定金折算率
	public static final String EARNEST_MONEY = getValue("EARNEST_MONEY");

	// 定金上限
	public static final String LIMT_UP_MONEY = getValue("LIMT_UP_MONEY");

	// 定金下限
	public static final String LIMT_LOW_MONEY = getValue("LIMT_LOW_MONEY");

	// 是否订金
	public static final String IS_EARNEST_MONEY = getValue("IS_EARNEST_MONEY");

	// 普通会员价
	public static final String MEMBER_MONEY = getValue("MEMBER_MONEY");
	
	public final static String DATE_STATUS_ZEOR = "0";
	// 订单号前缀
	public static final String ORDER_PREFIX = "PO";

}
