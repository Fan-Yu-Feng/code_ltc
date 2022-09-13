package com.design.model.responsibility.Women;

/**
 * 女人类
 *
 * @author FYF
 * @date 2022/9/13
 */
public class Women implements IWomen {
	
	/**
	 * 通过一个int类型的参数来描述妇女的个人状
	 * 1--未出嫁
	 * 2--出嫁
	 * 3--夫死
	 */
	private int type;
	/**
	 * 妇女的请示
	 */
	private String request;
	
	
	@Override
	public int getType() {
		return 0;
	}
	
	@Override
	public String getRequest() {
		return null;
	}
	
	
	public Women(int type, String request) {
		this.type = type;
		this.request = request;
	}
	
	
	public void setType(int type) {
		this.type = type;
	}
	
	public void setRequest(String request) {
		this.request = request;
	}
}