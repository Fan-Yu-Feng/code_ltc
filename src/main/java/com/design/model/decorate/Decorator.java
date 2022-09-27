package com.design.model.decorate;

import com.design.model.decorate.report.SchoolReport;

/**
 * @author FYF
 * @date 2022/9/27
 * @see SchoolReport 装饰的类
 * <p>
 * 专门进行装饰的类，避免类继承层次多维护成本高
 * <p>
 * 封装 {@link com.design.model.decorate.report.SchoolReport} 这个类
 */
public abstract class Decorator extends SchoolReport {
	
	/**
	 * 首先我要知道是哪个成绩单
	 * 装饰类的作用相当于一个特殊的代理类，真是的执行者还是被代理的角色
	 */
	private final SchoolReport sr;
	
	/**
	 * 构造函数，传递成绩单过来
	 *
	 * @param sr 学校成绩单
	 */
	public Decorator(SchoolReport sr) {
		this.sr = sr;
	}
	
	/**
	 * 成绩单还是要被看到的
	 */
	@Override
	public void report() {
		this.sr.report();
	}
	
	/**
	 * 看完还是要签名的
	 *
	 * @param name 名字
	 */
	@Override
	public void sign(String name) {
		this.sr.sign(name);
	}
	
	
}