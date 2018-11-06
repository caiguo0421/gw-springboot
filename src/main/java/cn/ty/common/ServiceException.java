package cn.ty.common;

/**
 * 自定义的serveiceException
 *
 * @author caigu
 */
public class ServiceException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = -8351540292976907946L;

    private int code;

    public ServiceException() {
        super();
    }

    public ServiceException(int code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(int code, String message) {
        super(message);
        this.code = code;
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(int code, Throwable cause) {
        super(cause);
        this.code = code;
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
