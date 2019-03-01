package com.demo.pojo;

import java.io.Serializable;
/**
 * 统一controller返回格式
 * @author Administrator
 * @param <T>
 */
public class ResultBean<T> implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public static final int SUCCESS = 0; //成功为0
	public static final int FAIL = -1; //异常为-1

	private String msg = "SUCCESS"; //定义信息默认值为success
	private int code = SUCCESS; //定义默认代码为0
	private T data; //返回的数据
	
	public ResultBean(){
		super();
	}
	public ResultBean(T data){
		super();
		this.data = data;
	}
	public ResultBean(Throwable e){
		super();
		this.msg = e.getMessage();
		this.code = FAIL;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	
	
}