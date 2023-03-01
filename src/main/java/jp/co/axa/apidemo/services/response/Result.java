package jp.co.axa.apidemo.services.response;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import jp.co.axa.apidemo.services.exception.ErrorCodeEnum;
import jp.co.axa.apidemo.util.Const;

/**
 * All returns to the client should be wrapped in this class. 
 * The implementation is in jp.co.axa.apidemo.services.response.ResponseResultAdvice
 * 
 * @author xiafei
 *
 * @param <T>
 */
public class Result<T> implements java.io.Serializable {
	private static final long serialVersionUID = -8315396977225280215L;

	// Show the status(ErrorCodeEnum), default:0
	private int status = 0;

	// Message context
	private String msg;

	// Response data
	private T res;

	public Result() {
	}

	public Result(T res) {
		this.res = res;
	}

	public Result(@NotNull ErrorCodeEnum errorCodeEnum, String extendMsg) {
		this.status = errorCodeEnum.getStatus();
		this.msg = errorCodeEnum.getMsg() + Const.WELL_NUMBER_SIGN + extendMsg;
	}

	public Result(@NotNull ErrorCodeEnum errorCodeEnum) {
		this.status = errorCodeEnum.getStatus();
		this.msg = errorCodeEnum.getMsg();
	}

	public Result(@NotNull int status, String msg) {
		this.status = status;
		this.msg = msg;
	}

	public Result(@NotNull ErrorCodeEnum errorCodeEnum, T res) {
		this.status = errorCodeEnum.getStatus();
		this.msg = errorCodeEnum.getMsg();
		this.res = res;
	}

	public boolean isSuccess() {
		return status == 0 ? true : false;
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

	public T getRes() {
		return res;
	}

	public void setRes(T res) {
		this.res = res;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
