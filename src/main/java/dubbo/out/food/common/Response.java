package dubbo.out.food.common;

import java.io.Serializable;

/**
 * Result Object
 *
 * @author zhangph
 * @version 2017-07-06 14:56
 **/
public class Response<T> implements Serializable {

    private static final long serialVersionUID = -5257337099014653525L;

    private int code;
    private String message;

    private T data;

    public Response(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public Response() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Response<T> success() {
        this.code = ResultCode.RESULT_SUCCESS.getCode();
        return this;
    }

    public Response<T> data(T data) {
        this.data = data;
        return this;
    }

    public Response fail() {
        this.code = ResultCode.RESULT_FAIL.getCode();
        return this;
    }

    public Response<T> message(String message) {
        this.message = message;
        return this;
    }

}
