/*
 * @(#)HttpclientException.java
 * 
 * Woniupay.com Inc.
 * 
 * Copyright (c) 2008-2009 All Rights Reserved.
 */
package dubbo.out.food.exception;


/**
 * �?<code>HttpclientUtil</code>的方法被调用时，如果被调用的方法不支持该操作，则抛出该异常�??
 * 
 * <p>
 * 注意，该异常�?<code>RuntimeException</code>派生�?
 * </p>
 *
 * @author shezengyong
 */
public class NetServiceException extends RuntimeException {

	private static final long serialVersionUID = -1936158479822916234L;

	/**
     * 构�?�一个空的异�?.
     */
    public NetServiceException() {
        super();
    }

    /**
     * 构�?�一个异�?, 指明异常的详细信�?.
     *
     * @param message 详细信息
     */
    public NetServiceException(String message) {
        super(message);
    }

    /**
     * 构�?�一个异�?, 指明引起这个异常的起�?.
     *
     * @param cause 异常的起�?
     */
    public NetServiceException(Throwable cause) {
        super(cause);
    }

    /**
     * 构�?�一个异�?, 指明引起这个异常的起�?.
     *
     * @param message 详细信息
     * @param cause 异常的起�?
     */
    public NetServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
