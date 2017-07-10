package dubbo.out.food.common;

import dubbo.out.food.common.MyException.EnumResolveException;

/**
 * @author zhangph
 * @version 2017-07-06 14:58
 **/
public enum ResultCode {

    RESULT_SUCCESS(101, "成功"), RESULT_FAIL(102, "失败"), RESULT_NEED_RELOGIN(109, "重新登陆");
    private int code;
    private String message;

    ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }


    public String getMessage() {
        return message;
    }


    public static ResultCode resolve(int code) {
        for (ResultCode resultCode : ResultCode.values()) {
            if (resultCode.getCode() == code) {
                return resultCode;
            }
        }
        throw new EnumResolveException("错误的返回结果代码");
    }

    /**
     * 返回是否成功
     *
     * @param code
     * @return
     */
    public static boolean success(int code) {
        return RESULT_SUCCESS.equals(resolve(code));
    }
}
