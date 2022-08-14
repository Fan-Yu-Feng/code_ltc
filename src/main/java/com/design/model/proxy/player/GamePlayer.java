package com.design.model.proxy.player;

/**
 * @author FYF
 * @date 2022/8/14
 */
public class GamePlayer implements IGamePlayer {
	
	/**
	 * 用户名
	 */
	private String name;
	
	public GamePlayer(IGamePlayer iGamePlayer,String name) throws Exception {
		if(iGamePlayer == null){
			System.out.println("不能创建真实角色!");
			throw new Exception("不能创建真实角色");
		}
		this.name = name;
	}
	
	
	@Override
	public void login(String user, String password) {
		System.out.println("登录名为"+user+"的用户"+this.name+"登录成功！");
	}
	
	@Override
	public void killBoss() {
		System.out.println(this.name + "在打怪！");
	}
	
	@Override
	public void upgrade() {
		System.out.println(this.name + " 又升了一级！");
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}