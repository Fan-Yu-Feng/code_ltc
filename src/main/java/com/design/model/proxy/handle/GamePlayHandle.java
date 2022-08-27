package com.design.model.proxy.handle;

import com.design.model.proxy.player.GamePlayer;
import com.design.model.proxy.player.IGamePlayer;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 实现 JDK 的动态代理
 *
 * @author FYF
 * @date 2022/8/28
 */
public class GamePlayHandle implements InvocationHandler {
	public GamePlayHandle(Object object) {
		this.object = object;
	}
	
	/**
	 * 被代理者
	 */
	Class<IGamePlayer> aClass = null;
	/**
	 * 被代理的实例
	 */
	Object object;
	
	
	/**
	 * 调用的代理方法
	 *
	 * @param proxy  代理
	 * @param method 方法
	 * @param args   参数
	 *
	 * @return 对象
	 *
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException {
		if("login".equals(method.getName())){
			System.out.println("有人在用我账号登录");
		}
		return method.invoke(proxy, args);
	}
	
	
	public static void main(String[] args) {
		IGamePlayer gamePlayer = new GamePlayer("张三");
		InvocationHandler gamePlayHandle = new GamePlayHandle(gamePlayer);
		System.out.println("开始游戏啦");
		// 获得类的 classLoader
		ClassLoader classLoader = gamePlayer.getClass().getClassLoader();
		// 获取动态代理
		IGamePlayer proxy = (IGamePlayer)Proxy.newProxyInstance(classLoader, new Class[]{IGamePlayer.class}, gamePlayHandle);
		proxy.login("zhangSan", "password");
		proxy.killBoss();
		proxy.upgrade();
	}
	
}