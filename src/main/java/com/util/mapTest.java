package com.util;

import cn.hutool.json.JSONUtil;

import java.util.HashMap;

/**
 * @author FYF @Description
 * @date 2022/5/24
 */
public class mapTest {

  public static void main(String[] args) {

    HashMap<String, String> map = new HashMap<>();
    String path = "path_";
    for (int i = 0; i < 10; i++) {
      map.put(String.valueOf(i), path + i);
    }
    System.out.println(map.toString());
    HashMap<String, Object> data = new HashMap<>();
    data.put("aliyun", map);
    System.out.println(JSONUtil.parse(data));
  }
}
