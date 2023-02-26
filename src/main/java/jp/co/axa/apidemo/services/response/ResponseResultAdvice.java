package jp.co.axa.apidemo.services.response;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import jp.co.axa.apidemo.services.exception.ErrorCodeEnum;

@ControllerAdvice(basePackages = "jp.co.axa.apidemo.controllers")
public class ResponseResultAdvice implements ResponseBodyAdvice<Object>{

	@Override
	public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
		//@ControllerAdvice basePackages: swagger controller will not be transformed.
		return true;
	}

	@Override
	public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
			Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request,
			ServerHttpResponse response) {
		
		if(body == null) {
			return new Result<>(ErrorCodeEnum.RES_NOT_EXIST);
		}
		
        return new Result<>(body);
	}

}
