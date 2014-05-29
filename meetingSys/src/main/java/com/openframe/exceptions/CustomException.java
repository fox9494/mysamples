package com.openframe.exceptions;

/**
 * 自定义异常消息
 * @author chenll
 *
 */
public class CustomException extends RuntimeException {
	
	private static final long serialVersionUID = -5617041297326250904L;

	/**
	 * 构造详细消息为 指定消息 的新异常
	 */
	public CustomException() {
		super("温馨提示：这是自定义异常");
	}

	public CustomException(String message) {
		super(message);
	}
	
	public CustomException(String message, Throwable cause) {
		super(message, cause);
	}

	public CustomException(Throwable cause) {
		super(cause);
	}

}
