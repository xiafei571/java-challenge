package jp.co.axa.apidemo.services.exception;

import java.util.NoSuchElementException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import jp.co.axa.apidemo.services.response.Result;

@ControllerAdvice
@ResponseBody
@SuppressWarnings("rawtypes")
public class ExceptionHandlerClass {

	/**
	 * All unspecified exceptions will be defaulted to SYSTEM_ERROR status
	 * 
	 * @return
	 */
	@ExceptionHandler(Exception.class)
	public Result ExceptionHandler() {
		return new Result<>(ErrorCodeEnum.SYSTEM_ERROR);
	}

	/**
	 * When we searching the entity by Id, If a value is not present, return
	 * RES_NOT_EXIST status
	 * 
	 * @return
	 */
	@ExceptionHandler(NoSuchElementException.class)
	public Result ResNotExistHandler() {
		return new Result<>(ErrorCodeEnum.ID_NOT_EXIST);
	}

}
