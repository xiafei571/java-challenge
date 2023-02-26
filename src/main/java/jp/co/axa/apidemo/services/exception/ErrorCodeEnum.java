package jp.co.axa.apidemo.services.exception;

public enum ErrorCodeEnum {

	RES_NOT_EXIST(1001, "Resource ID does not exist."), 
	DUPLICATION_RES(1002, "Resource already exists."),
	SYSTEM_ERROR(9999, "System error.");

	private int status;

	private String msg;

	private ErrorCodeEnum(int status, String msg) {
		this.status = status;
		this.msg = msg;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
