/*
 * create by 2021年7月1日 下午2:48:10
 */
package com.demo.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.BlockExceptionHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.authority.AuthorityException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowException;
import com.alibaba.csp.sentinel.slots.system.SystemBlockException;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author fangang
 */
@Component
public class UrlBlockHandler implements BlockExceptionHandler {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response, 
			BlockException e) throws Exception {
		String msg = "";
		if(e instanceof FlowException) {
			msg = "接口被限流";
		} else if(e instanceof DegradeException) {
			msg = "接口被熔断，请稍后重试";
		} else if(e instanceof ParamFlowException) {
			msg = "热点参数限流";
		} else if(e instanceof SystemBlockException) {
			msg = "系统规则限流";
		} else if(e instanceof AuthorityException) {
			msg = "没有合法权限";
		}
		response.setStatus(500);
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json;charset=utf-8");
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		mapper.writeValue(response.getWriter(), 
				new ResponseObject(e.getClass().getSimpleName(), msg));
	}
}

class ResponseObject {
	private String exception;
	private String message;
	ResponseObject(String exception, String message) {
		this.exception = exception;
		this.message = message;
	}
	public String getException() {
		return exception;
	}
	public void setException(String exception) {
		this.exception = exception;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
