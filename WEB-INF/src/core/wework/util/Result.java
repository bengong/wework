package wework.util;

public class Result {
	public String status;
	public String message;
	public Object data;

	public String getStatus() {
		return status;
	}

	public Result setStatus(String status) {
		this.status = status;
		
		return this;
	}

	public String getMessage() {
		return message;
	}

	public Result setMessage(String message) {
		this.message = message;
		
		return this;
	}

	public Object getData() {
		return data;
	}

	public Result setData(Object data) {
		this.data = data;
		
		return this;
	}

	public static Result error(String message) {
		Result result = new Result();
		result.status = "error";
		result.message = message;

		return result;
	}

	public static Result success(String message) {
		Result result = new Result();
		result.status = "success";
		result.message = message;
		return result;
	}
	
	/**
	 * 判斷結果是否正常。
	 * @return
	 */
	public boolean isOK() {
		return ("success").equalsIgnoreCase(status);
	}
}
