package com.design.model.template;

import com.design.model.template.hummer.HummerH1Model;
import com.design.model.template.hummer.HummerModel;

/**
 * @author FYF
 * @date 2022/8/11
 */
public class Client {
	
	
	public static void main(String[] args) {
		HummerModel h1 = new HummerH1Model();
		
		h1.run();
		
	}
}