package com.fyf.ltc.lc_1800;

import java.util.HashMap;
import java.util.Map;

/**
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_1797 {
	
	
	public static void main(String[] args) {
		
	}
	
	class AuthenticationManager {
		int timeToLive;
		Map<String, Integer> map;
		
		public AuthenticationManager(int timeToLive) {
			this.timeToLive = timeToLive;
			this.map = new HashMap<String, Integer>();
		}
		
		public void generate(String tokenId, int currentTime) {
			map.put(tokenId, currentTime + timeToLive);
		}
		
		public void renew(String tokenId, int currentTime) {
			if (map.getOrDefault(tokenId, 0) > currentTime) {
				map.put(tokenId, currentTime + timeToLive);
			}
		}
		
		public int countUnexpiredTokens(int currentTime) {
			int res = 0;
			for (int time : map.values()) {
				if (time > currentTime) {
					res++;
				}
			}
			return res;
		}
	}
	
	

}