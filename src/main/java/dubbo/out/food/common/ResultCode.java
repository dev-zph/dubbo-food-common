package dubbo.out.food.common;

import dubbo.out.food.common.MyException.EnumResolveException;

/**
 * @author zhangph
 * @version 2017-07-06 14:58
 **/
public enum ResultCode {

    RESULT_SUCCESS(101, "�ɹ�"), RESULT_FAIL(102, "ʧ��"), RESULT_NEED_RELOGIN(109, "���µ�½");
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
        throw new EnumResolveException("����ķ��ؽ������");
    }

    /**
     * �����Ƿ�ɹ�
     *
     * @param code
     * @return
     */
    public static boolean success(int code) {
        return RESULT_SUCCESS.equals(resolve(code));
    }
}
