package net.eleword.blog.util;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.Assert;

public class ServletUtils {

	public static final String TEXT_TYPE = "text/plain";
	public static final String JSON_TYPE = "application/json";
	public static final String XML_TYPE = "text/xml";
	public static final String HTML_TYPE = "text/html";
	public static final String JS_TYPE = "text/javascript";
	public static final String EXCEL_TYPE = "application/vnd.ms-excel";

	public static final String AUTHENTICATION_HEADER = "Authorization";

	public static final long ONE_YEAR_SECONDS = 60 * 60 * 24 * 365;
	
	/**
	 * 
	 * @Title: setExpiresHeader
	 * @Description: 设置客户端缓存过期时间 的Header.
	 * @param response
	 * @param expiresSeconds
	 */
	public static void setExpiresHeader(HttpServletResponse response, long expiresSeconds) {
		//Http 1.0 header
		response.setDateHeader("Expires", System.currentTimeMillis() + expiresSeconds * 1000);
		//Http 1.1 header
		response.setHeader("Cache-Control", "private, max-age=" + expiresSeconds);
	}
	
	/**
	 * 
	 * @Title: setDisableCacheHeader
	 * @Description: 设置禁止客户端缓存的Header.
	 * @param response
	 */
	public static void setDisableCacheHeader(HttpServletResponse response) {
		//Http 1.0 header
		response.setDateHeader("Expires", 1L);
		response.addHeader("Pragma", "no-cache");
		//Http 1.1 header
		response.setHeader("Cache-Control", "no-cache, no-store, max-age=0");
	}
	
	/**
	 * 
	 * @Title: setLastModifiedHeader
	 * @Description: 设置LastModified Header.
	 * @param response
	 * @param lastModifiedDate
	 */
	public static void setLastModifiedHeader(HttpServletResponse response, long lastModifiedDate) {
		response.setDateHeader("Last-Modified", lastModifiedDate);
	}
	
	/**
	 * 
	 * @Title: setEtag
	 * @Description: 设置Etag Header.
	 * @param response
	 * @param etag
	 */
	public static void setEtag(HttpServletResponse response, String etag) {
		response.setHeader("ETag", etag);
	}
	
	/**
	 * 
	 * @Title: checkIfModifiedSince
	 * @Description: 根据浏览器If-Modified-Since Header, 计算文件是否已被修改.
	 * 如果无修改, checkIfModify返回false ,设置304 not modify status.
	 * @param request
	 * @param response
	 * @param lastModified
	 * @return
	 */
	public static boolean checkIfModifiedSince(HttpServletRequest request, HttpServletResponse response,
			long lastModified) {
		long ifModifiedSince = request.getDateHeader("If-Modified-Since");
		if ((ifModifiedSince != -1) && (lastModified < ifModifiedSince + 1000)) {
			response.setStatus(HttpServletResponse.SC_NOT_MODIFIED);
			return false;
		}
		return true;
	}
	
	/**
	 * 
	 * @Title: checkIfNoneMatchEtag
	 * @Description: 根据浏览器 If-None-Match Header, 计算Etag是否已无效.
	 * 如果Etag有效, checkIfNoneMatch返回false, 设置304 not modify status.
	 * @param request
	 * @param response
	 * @param etag
	 * @return
	 */
	public static boolean checkIfNoneMatchEtag(HttpServletRequest request, HttpServletResponse response, String etag) {
		String headerValue = request.getHeader("If-None-Match");
		if (headerValue != null) {
			boolean conditionSatisfied = false;
			if (!"*".equals(headerValue)) {
				StringTokenizer commaTokenizer = new StringTokenizer(headerValue, ",");

				while (!conditionSatisfied && commaTokenizer.hasMoreTokens()) {
					String currentToken = commaTokenizer.nextToken();
					if (currentToken.trim().equals(etag)) {
						conditionSatisfied = true;
					}
				}
			} else {
				conditionSatisfied = true;
			}

			if (conditionSatisfied) {
				response.setStatus(HttpServletResponse.SC_NOT_MODIFIED);
				response.setHeader("ETag", etag);
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 
	 * @Title: setFileDownloadHeader
	 * @Description: 设置让浏览器弹出下载对话框的Header.
	 * @param response
	 * @param fileName
	 */
	public static void setFileDownloadHeader(HttpServletResponse response, String fileName) {
		try {
			//中文文件名支持
			String encodedfileName = new String(fileName.getBytes(), "ISO8859-1");
			response.setHeader("Content-Disposition", "attachment; filename=\"" + encodedfileName + "\"");
		} catch (UnsupportedEncodingException e) {
		}
	}
	
	/**
	 * 
	 * @Title: getParametersStartingWith
	 * @Description: 取得带相同前缀的Request Parameters.返回的结果的Parameter名已去除前缀.
	 * @param request
	 * @param prefix
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, Object> getParametersStartingWith(ServletRequest request, String prefix) {
		Assert.notNull(request, "Request must not be null");
		Enumeration paramNames = request.getParameterNames();
		Map<String, Object> params = new TreeMap<String, Object>();
		if (prefix == null) {
			prefix = "";
		}
		while (paramNames != null && paramNames.hasMoreElements()) {
			String paramName = (String) paramNames.nextElement();
			if ("".equals(prefix) || paramName.startsWith(prefix)) {
				String unprefixed = paramName.substring(prefix.length());
				String[] values = request.getParameterValues(paramName);
				if (values == null || values.length == 0) {
					// Do nothing, no values found at all.
				} else if (values.length > 1) {
					params.put(unprefixed, values);
				} else {
					params.put(unprefixed, values[0]);
				}
			}
		}
		return params;
	}
	
	/**
	 * 
	 * @Title: encodeHttpBasic
	 * @Description: 对Http Basic验证的 Header进行编码.
	 * @param userName
	 * @param password
	 * @return
	 */
	public static String encodeHttpBasic(String userName, String password) {
		String encode = userName + ":" + password;
		return "Basic " + EncodeUtils.base64Encode(encode.getBytes());
	}
	
	/**
	 * 
	 * @Title: sendMsg
	 * @Description: 向客户端写出数据.
	 * @param response
	 * @param msg
	 * @return
	 */
	public static void sendMsg(HttpServletResponse response, String msg) {
		response.setCharacterEncoding("GBK");
		try {
			response.getWriter().write(msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @Title: sendMsg
	 * @Description: 向客户端写出数据.
	 * @param response
	 * @param msg
	 * @return
	 */
	public static void sendMsg(HttpServletResponse response, String msg, String charset) {
		response.setCharacterEncoding(charset);
		try {
			response.getWriter().write(msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
