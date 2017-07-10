package dubbo.out.food.common.MyException;

/**
 * Œ¥µ«»Î¥ÌŒÛ
 *
 * @author zhangph
 * @version 2017-07-07 9:21
 **/
public class UnAuthorizationException extends RuntimeException{

    public UnAuthorizationException() {
        super();
    }
    public UnAuthorizationException(String errMessage) {
        super(errMessage);
    }
}
