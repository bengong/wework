package wework.util;

/**
 * 业务异常。
 */
public class BusinessException extends RuntimeException {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -8310159703463860482L;

	public Object data;
	
	public BusinessException() {
		super();
	}

	public BusinessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public BusinessException(String message, Throwable cause) {
		super(message, cause);
	}

	public BusinessException(String message) {
		super(message);
	}
	
	public BusinessException(String message, Object data) {
		super(message);
		
		this.data = data;
	}

	public BusinessException(Throwable cause, Object data) {
		super(cause);
		
		this.data = data;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
    public String toString() {
        String message = getLocalizedMessage()+"\n"+"业务数据: "+data;
        return (message != null) ? ("业务出错: "+message) : "业务出错";
    }
}
