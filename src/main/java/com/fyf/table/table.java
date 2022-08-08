package com.fyf.table;

import org.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Base64;
import java.util.List;
import java.util.Map;

public class table {
	public static void main(String[] args) {
		
		// 官网获取的 API Key 更新为你注册的
		String clientId = "您的ak";
		// 官网获取的 Secret Key 更新为你注册的
		String clientSecret = "您的sk";
		
		String access_token = getAuth(clientId, clientSecret);
		//调用表格文字识别(同步接口)
		String request_url = "https://aip.baidubce.com/rest/2.0/ocr/v1/table";
		String url = request_url + "?access_token=" + access_token;
		String img_str = convertFileToBase64("您的本地图片路径");
		//对base64 utf-8转码
		String imgParam = "";
		try {
			imgParam = URLEncoder.encode(img_str, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		long startTime = System.currentTimeMillis(); //程序开始记录时间
		
		String params = "image=" + imgParam + "&cell_contents=false";
		
		String res = sendPost(url, params);
		
		long endTime = System.currentTimeMillis(); //程序结束记录时间
		long TotalTime = endTime - startTime; //总消耗时间
		System.out.println("time cost:" + TotalTime + "ms");
		System.out.println(res);
		
	}
	
	//post请求方法
	public static String sendPost(String url, String param) {
		StringBuilder result = new StringBuilder();
		try {
			URL httpurl = new URL(url);
			HttpURLConnection httpConn = (HttpURLConnection) httpurl.openConnection();
			httpConn.setDoOutput(true);
			httpConn.setDoInput(true);
			PrintWriter out = new PrintWriter(httpConn.getOutputStream());
			out.print(param);
			out.flush();
			out.close();
			BufferedReader in = new BufferedReader(new InputStreamReader(httpConn.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result.append(line);
			}
			in.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return result.toString();
	}
	
	//图片转base64
	public static String convertFileToBase64(String imgPath) {
		byte[] data = null;
		// 读取图片字节数组
		try {
			InputStream in = new FileInputStream(imgPath);
			//System.out.println("文件大小（字节）="+in.available());
			data = new byte[in.available()];
			in.read(data);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 对字节数组进行Base64编码，得到Base64编码的字符串
		String base64Str = Base64.getEncoder().encodeToString(data);
		return base64Str;
	}
	
	//获取access_token
	public static String getAuth(String ak, String sk) {
		// 获取token地址
		String authHost = "https://aip.baidubce.com/oauth/2.0/token?";
		String getAccessTokenUrl = authHost
				                           // 1. grant_type为固定参数
				                           + "grant_type=client_credentials"
				                           // 2. 官网获取的 API Key
				                           + "&client_id=" + ak
				                           // 3. 官网获取的 Secret Key
				                           + "&client_secret=" + sk;
		try {
			URL realUrl = new URL(getAccessTokenUrl);
			// 打开和URL之间的连接
			HttpURLConnection connection = (HttpURLConnection) realUrl.openConnection();
			connection.setRequestMethod("GET");
			connection.connect();
			// 获取所有响应头字段
			Map<String, List<String>> map = connection.getHeaderFields();
			// 遍历所有的响应头字段
			for (String key : map.keySet()) {
				System.err.println(key + "--->" + map.get(key));
			}
			// 定义 BufferedReader输入流来读取URL的响应
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			StringBuilder result = new StringBuilder();
			String line;
			while ((line = in.readLine()) != null) {
				result.append(line);
			}
			System.err.println("result:" + result);
			JSONObject jsonObject = new JSONObject(result.toString());
			return jsonObject.getString("access_token");
		} catch (Exception e) {
			System.err.print("获取token失败！");
			e.printStackTrace(System.err);
		}
		return null;
	}
	
}
