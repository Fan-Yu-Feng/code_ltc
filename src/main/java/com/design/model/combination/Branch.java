package com.design.model.combination;

import java.util.ArrayList;

/**
 * @author FYF
 * @date 2022/10/3
 */
public class Branch implements IBranch {
	
	/**
	 * 存储子节点的信息
	 */
	private final ArrayList<Object> subordinateList = new ArrayList<>();
	/**
	 * 树枝节点的名称
	 */
	private String name;
	/**
	 * 树枝节点的职位
	 */
	private String position;
	/**
	 * 树枝节点的薪水
	 */
	private int salary;
	
	
	public Branch(String name, String position, int salary) {
		this.name = name;
		this.position = position;
		this.salary = salary;
	}
	
	@Override
	public String getInfo() {
		String info;
		info = "名称：" + this.name;
		info = info + "\t职位："+ this.position;
		info = info + "\t薪水："+this.salary;
		return info;
	}
	
	@Override
	public ArrayList<Object> getSubordinateInfo() {
		return this.subordinateList;
	}
	
	@Override
	public void addSubordinate(ICorp corp) {
		this.subordinateList.add(corp);
	}
	
	
	public ArrayList<Object> getSubordinateList() {
		return subordinateList;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPosition() {
		return position;
	}
	
	public void setPosition(String position) {
		this.position = position;
	}
	
	public int getSalary() {
		return salary;
	}
	
	public void setSalary(int salary) {
		this.salary = salary;
	}
}