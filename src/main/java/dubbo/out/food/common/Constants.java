package dubbo.out.food.common;

import dubbo.out.food.utils.ConfigurableConstants;

public class Constants extends ConfigurableConstants {

	static {
		// init("ftp.properties");
		init("common.properties");
	}


	// ��������ȡС��λ��
	public static final int ITEM_COUNT_SCAL = 2;
	// ����������
	public static final String EARNEST_MONEY = getValue("EARNEST_MONEY");

	// ��������
	public static final String LIMT_UP_MONEY = getValue("LIMT_UP_MONEY");

	// ��������
	public static final String LIMT_LOW_MONEY = getValue("LIMT_LOW_MONEY");

	// �Ƿ񶩽�
	public static final String IS_EARNEST_MONEY = getValue("IS_EARNEST_MONEY");

	// ��ͨ��Ա��
	public static final String MEMBER_MONEY = getValue("MEMBER_MONEY");
	
	public final static String DATE_STATUS_ZEOR = "0";
	// ������ǰ׺
	public static final String ORDER_PREFIX = "PO";

}
