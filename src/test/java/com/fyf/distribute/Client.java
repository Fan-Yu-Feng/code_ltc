package com.fyf.distribute;

import com.distribute.WorkIdUtil;

/**
 * @author FYF
 * @since 2022/12/28 17:46
 */
public class Client {
	public static void main(String[] args) throws InterruptedException {
		Long snowId = WorkIdUtil.getLongInnerOrderNo();
		
		Thread threadA = new Thread(() -> {
			for (int i = 0; i < 2000; i++) {
				Long snowId1 = WorkIdUtil.getLongInnerOrderNo();
				System.out.println("snowIdA = " + snowId1);
			}
		});
		
		Thread threadB = new Thread(() -> {
			
			for (int i = 0; i < 2000; i++) {
				Long snowId1 = WorkIdUtil.getLongInnerOrderNo();
				System.out.println("snowIdB = " + snowId1);
			}
		});
		
		Thread threadC = new Thread(() -> {
			
			for (int i = 0; i < 2000; i++) {
				Long snowId1 = WorkIdUtil.getLongInnerOrderNo();
				System.out.println("threadC = " + snowId1);
			}
		});
		
		Thread threadD = new Thread(() -> {
			
			for (int i = 0; i < 2000; i++) {
				Long snowId1 = WorkIdUtil.getLongInnerOrderNo();
				System.out.println("threadD = " + snowId1);
			}
		});
		
		Thread threadE = new Thread(() -> {
			
			for (int i = 0; i < 2000; i++) {
				Long snowId1 = WorkIdUtil.getLongInnerOrderNo();
				System.out.println("snowIdE = " + snowId1);
			}
		});

		
		threadA.start();
		threadB.start();
		threadC.start();
		threadD.start();
		threadE.start();
		Thread.sleep(1000 * 60);
		
	}
	
}