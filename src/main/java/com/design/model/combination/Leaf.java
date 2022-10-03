package com.design.model.combination;

/**
 * 叶子信息
 *
 * @author FYF
 * @date 2022/10/3
 */
public class Leaf implements ILeaf {
	/**
	 * 叶子叫什么名字
	 */
	private String name;
	/**
	 * 叶子的职位
	 */
	private String position;
	/**
	 * 叶子的薪水
	 */
	private int salary;
	
	/**
	 * 通过构造函数传递信息
	 *
	 * @param name     姓名
	 * @param position 职位
	 * @param salary   薪水
	 */
	public Leaf(String name, String position, int salary) {
		this.name = name;
		this.position = position;
		this.salary = salary;
	}
	
	@Override
	public String getInfo() {
		String info;
		info = "名称：" + this.name;
		info = info + "\t职位：" + this.position;
		info = info + "\t薪水：" + this.salary;
		return info;
	}
}