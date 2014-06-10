package com.soarsky.octopus.exception;

public class NameException extends Exception {
	
	private static final long serialVersionUID = -5617041297326250904L;

	/**
	 * 构造详细消息为 指定消息 的新异常
	 */
	public NameException() {
		super("温馨提示：不能找到服务器名称");
	}

	public NameException(String message) {
		super(message);
	}
	
	public NameException(String message, Throwable cause) {
		super(message, cause);
	}

	public NameException(Throwable cause) {
		super(cause);
	}

}
