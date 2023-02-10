package com.fyf.ltc.lc_1700;

import java.util.*;

/**
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_1603 {
	
	
	public static void main(String[] args) {
		
	}
	
	
	public List<String> alertNames(String[] keyName, String[] keyTime) {
		int length = keyName.length;
		Map<String, List<Integer>> map = new HashMap<>();
		List<String> ans = new ArrayList<>();
		
		for (int i = 0; i < length; i++) {
			// 处理一下数据  将时间转为 Integer
			String name = keyName[i];
			String[] time = keyTime[i].split(":");
			String hour = time[0], minute = time[1];
			map.putIfAbsent(name, new ArrayList<>());
			Integer timeInteger = Integer.parseInt(hour) * 60 + Integer.parseInt(minute);
			map.get(name).add(timeInteger);
		}
		
		Set<String> keySet = map.keySet();
		
		for (String key : keySet) {
			List<Integer> list = map.get(key);
			Collections.sort(list);
			if(list.size() < 3 ){
				continue;
			}
			Integer pre = list.get(0);
			
			for (int i = 2; i < list.size(); i++) {
				Integer x = list.get(i);
				int diff = x - pre;
				if(diff <= 60 ){
					ans.add(key);
					break;
				}
				pre = list.get(i -1 );
			}
			Collections.sort(ans);
		}
		return ans;
	}
	
}