package com.design.model.combination;

import java.util.ArrayList;

/**
 * @author FYF
 * @date 2022/10/3
 */
public class Client {
	public static void main(String[] args) {
		
		//首先产生了一个根节点
		Branch ceo = new Branch("王大麻子","总经理",100000);
		//产生三个部门经理，也就是树枝节点
		IBranch developDep = new Branch("刘大瘸子","研发部门经理",10000);
		IBranch salesDep = new Branch("马二拐子","销售部门经理",20000);
		IBranch financeDep = new Branch("赵三驼子","财务部经理",30000);
		//再把三个小组长产生出来
		IBranch firstDevGroup = new Branch("杨三乜斜","开发一组组长",5000);
		IBranch secondDevGroup = new Branch("吴大棒槌","开发二组组长",6000);
		//剩下的就是我们这些小兵了,就是路人甲、路人乙
		ILeaf a = new Leaf("a","开发人员",2000);
		ILeaf b = new Leaf("b","开发人员",2000);
		ILeaf c = new Leaf("c","开发人员",2000);
		ILeaf d = new Leaf("d","开发人员",2000);
		ILeaf e = new Leaf("e","开发人员",2000);
		ILeaf f = new Leaf("f","开发人员",2000);
		ILeaf g = new Leaf("g","开发人员",2000);
		ILeaf h = new Leaf("h","销售人员",5000);
		ILeaf i = new Leaf("i","销售人员",4000);
		ILeaf j = new Leaf("j","财务人员",5000);
		ILeaf k = new Leaf("k","CEO秘书",8000);
		ILeaf zhengLaoLiu = new Leaf("郑老六","研发部副总",20000);
		ceo.addSubordinate(developDep);
		ceo.addSubordinate(salesDep);
		ceo.addSubordinate(financeDep);
		developDep.addSubordinate(firstDevGroup);
		developDep.addSubordinate(secondDevGroup);
		developDep.addSubordinate(zhengLaoLiu);
		
		firstDevGroup.addSubordinate(a);
		firstDevGroup.addSubordinate(b);
		firstDevGroup.addSubordinate(c);
		secondDevGroup.addSubordinate(d);
		secondDevGroup.addSubordinate(e);
		secondDevGroup.addSubordinate(f);
		
		salesDep.addSubordinate(h);
		salesDep.addSubordinate(i);
		salesDep.addSubordinate(j);
		
		System.out.println("ceo.getInfo() = " + ceo.getInfo());
		getAllSubordinateInfo(ceo.getSubordinateInfo());
		
	}
	
	private static void getAllSubordinateInfo(ArrayList<Object> subordinateInfo) {
		int length = subordinateInfo.size();
		for (Object o : subordinateInfo) {
			if (o instanceof Leaf) {
				ILeaf employee = (ILeaf) o;
				System.out.println("((Leaf) o).getInfo() = " + ((Leaf) o).getInfo());
			} else {
				IBranch branch = (IBranch) o;
				System.out.println(branch.getInfo());
				//再递归调用
				getAllSubordinateInfo(branch.getSubordinateInfo());
			}
		}
	}
	
}