package net.eleword.blog.util;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

public class HttpUtils {

	private static  String API_URL = "http://ipapi.sinaapp.com/api.php?f=text&ip=";

	/**
	 * 获取IP地址
	 * 
	 * @param request
	 * @return
	 */
	public static String getIp(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

	/**
	 * 获取根目录
	 * 
	 * @param request
	 * @return
	 */
	public static String getBasePath(HttpServletRequest request) {
		String path = request.getContextPath();
		String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
		return basePath;
	}

	/**
	 * 获取目录
	 * 
	 * @param request
	 * @return
	 */
	public static String getContextPath(HttpServletRequest request) {
		String path = request.getContextPath();
		return path;
	}

	public static String getRealPath() {
		return System.getProperty(ConstantEnum.ApplicationPath.toString());
	}

	public static String getAddressFromIP(String ip) throws ClientProtocolException, IOException {

		CloseableHttpClient instance = null;

		CloseableHttpResponse response = null;

		instance = HttpClientBuilder.create().build();
		response = instance.execute(new HttpGet(API_URL+ip));
		
		
		
		String result=EntityUtils.toString(response.getEntity());
		
		int index=result.lastIndexOf("归属地信息：");
		if(index!=-1){
			result=result.substring(index+6, result.length());
		}else{
			result="没找到此IP";
		}
		return result;
	}
	
}
