package dubbo.out.food.common;

import java.math.BigDecimal;

public class Status {
	
	
	
	
	/**
	 * 公共状�??
	 */
	public final static String SUCCESS = "101"; // 成功

	public final static String FAIL = "102"; // 失败
	
	/**
	 * 用户状�??
	 */
	public final static String USER_NOT_USER = "201"; // 用户不存�?

	public final static String USER_WRONG_PWD = "202"; // 密码错误

	public final static String CODE_WRONG = "203"; // 短信验证码错�?

	public final static String HAS_USER = "204"; // 用户名已存在

	public final static String NEED_LOGIN = "205"; // �?重新登录
	
	public final static String ERRO_PHONE = "206"; // 手机号类型填写不正确
	
	public final static String UNACCEP_TYPE = "207";//用户账号被禁�?
	
	public final static String CANUSE = "0"; // 正常账号
	
	public final static String NOTUSE = "1";//账号呗冻�?
	
	//user相关的信�?,session.key
	public static final String SYSTEM_SHOP_KEYWORD = "shop";
	public static final String SYSTEM_USER_KEYWORD = "user";
	public static final String USER_CART_ITEM_COUNT = "cartItemCount";
	/**
	 * 店铺管理
	 */
	public static final int SHOP_APPLY_STATUS_YES = 0;// 正常、�?�过审核

	public static final int SHOP_APPLY_STATUS_READ = 1;// �?店申�? - 阅读须知

	public static final int SHOP_APPLY_STATUS_INFO = 2;// �?店申�? - 信息录入 同时表示待审�?

	public static final int SHOP_APPLY_STATUS_CHECK_NO = 3;// 未�?�过审核

	public static final int SHOP_APPLY_STATUS_BLOCKED = 4;// 被冻�?
	/**
	 * 通用
	 */
	public static final String DELETED_NO = "0"; // 正常

	public static final String DELETED_YES = "1"; // 已删�?
	/**
	 * 店铺的状�?
	 */
	public static final Integer ITEM_STORE = 1; // 仓库中的商品

	public static final Integer ITEM_CHECK = 2; // 待审核商�?

	public static final Integer ITEM_SALE = 3; // �?售中的商�?

	public static final Integer ITEM_CHECK_NO = 4; // 审核被拒�?
	
	//�?低起送订单金�?
	
	/**
	 * 错误信息
	 */
	public static final String SHOP_NOT_FOUND = "未查询到您的店铺相关信息";
	
	// ContentType
	public static final String HTML_TYPE = "text/html;charset=utf-8"; // html
	public static final String JSON_TYPE = "application/json;charset=UTF-8"; // Json
}
