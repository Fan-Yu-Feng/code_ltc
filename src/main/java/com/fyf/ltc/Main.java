package com.fyf.ltc;

/**
 * @author FYF @Description
 * @date 2022/1/17
 */
public class Main {

  public static void main(String[] args) {
	
  	
	  int var = ((19-13) + 2 )<< 8;
	
	  System.out.println("var = " + var);
	  double pow = 4<<8;
	  System.out.println("pow = " + pow);
	
	  // int abcdefga = lengthOfLongestSubstring("abcdefga");
    // System.out.println(abcdefga);
  }

  public static int lengthOfLongestSubstring(String s) {
    int[] last = new int[128];
    int n = s.length();
    int start = 0;
    int res = 0;
	  for (int value : last) {
		  System.out.println(value);
	  }

    for (int i = 0; i < n; i++) {
      // 记录字符下标位置
      int index = s.charAt(i);
      // 当出现两个相同字符，start 间隔的左指针：上一个出现该字符的位置
      start = Math.max(start, last[index]);
      res = Math.max(res, i - start + 1);
      // 记录字符的值 i+1
      last[index] = i + 1;
    }

    return res;
  }
}
