package dubbo.out.food.common.exception;

public class ApplicationException extends RuntimeException {
	private static final long serialVersionUID = -1936158479822916234L;

	/**
     * 构�?�一个空的异�?.
     */
    public ApplicationException() {
        super();
    }

    /**
     * 构�?�一个异�?, 指明异常的详细信�?.
     *
     * @param message 详细信息
     */
    public ApplicationException(String message) {
        super(message);
    }

    /**
     * 构�?�一个异�?, 指明引起这个异常的起�?.
     *
     * @param cause 异常的起�?
     */
    public ApplicationException(Throwable cause) {
        super(cause);
    }

    /**
     * 构�?�一个异�?, 指明引起这个异常的起�?.
     *
     * @param message 详细信息
     * @param cause 异常的起�?
     */
    public ApplicationException(String message, Throwable cause) {
        super(message, cause);
    }
}
