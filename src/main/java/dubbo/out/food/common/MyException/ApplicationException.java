package dubbo.out.food.common.MyException;

/**
 * @author zhangph
 * @version 2017-07-06 12:45
 **/
public class ApplicationException extends RuntimeException {
    private static final long serialVersionUID = 1847831191767103612L;

    /**
     * 空的异常
     */
    public ApplicationException(){
        super();
    }

    /**
     * Specify error information
     *
     * @param message
     */
    public ApplicationException(String message) {
        super(message);
    }

    /**
     * Specify an exception type
     *
     * @param cause
     */
    public ApplicationException(Throwable cause) {
        super(cause);
    }

    /**
     * Specify an exception type and the reason
     *
     * @param message
     * @param cause
     */
    public ApplicationException(String message, Throwable cause) {
        super(message, cause);
    }
}
