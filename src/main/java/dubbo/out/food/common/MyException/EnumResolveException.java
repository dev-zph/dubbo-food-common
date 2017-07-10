package dubbo.out.food.common.MyException;

/**
 * @author zhangph
 * @version 2017-07-06 14:58
 **/
public class EnumResolveException extends RuntimeException {

    private static final long serialVersionUID = 184415732456470431L;

    public EnumResolveException() {
    }

    public EnumResolveException(String message) {
        super(message);
    }

    public EnumResolveException(String message, Throwable cause) {
        super(message, cause);
    }

    public EnumResolveException(Throwable cause) {
        super(cause);
    }

    public EnumResolveException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
