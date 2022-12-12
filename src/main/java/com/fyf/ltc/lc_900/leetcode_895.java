package com.fyf.ltc.lc_900;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

/**
 * @author FYF
 * @date 2022/10/23
 */
public class leetcode_895 {
	
	
	public static void main(String[] args) {
		
		FreqStack freqStack = new FreqStack();
		
		
	}
	
	
}

class FreqStack {
	
	/**
	 * 数字频率 map
	 */
	HashMap<Integer/* num */ , Integer /* freq */> numFreqMap = new HashMap<>();
	/**
	 * 频率数字 map
	 */
	HashMap<Integer/* freq */, Deque<Integer> /* stack */> freqStack = new HashMap<>();
	
	Integer maxFreq = 0;
	
	
	public FreqStack() {
	
	}
	
	public void push(int val) {
		
		// 记录 val 的频率
		int freq = numFreqMap.getOrDefault(val, 0) + 1;
		numFreqMap.put(val, freq);
		
		// 记录最大的频率
		maxFreq = Math.max(maxFreq, freq);
		
		// 记录频率Map
		freqStack.putIfAbsent(freq, new ArrayDeque<>());
		freqStack.get(freq).push(val);
	}
	
	public int pop() {
		
		Deque<Integer> deque = freqStack.get(maxFreq);
		int maxNum = deque.pop();
		
		Integer maxNumFreq = numFreqMap.get(maxNum);
		if(--maxNumFreq == 0){
			numFreqMap.remove(maxNum);
		}
		// 维护num-freq 的map
		numFreqMap.put(maxNum, maxNumFreq);
		
		// 最大频率的栈还有数字 那么 maxFreq 保存原来的数字，否则 -1
		if (deque.size() == 0) {
			--maxFreq;
		}
		return maxNum;
	}
}
