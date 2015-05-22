package net.eleword.blog.util;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;

public class HttpUtils {

    private static String API_URL = "http://ipapi.sinaapp.com/api.php?f=text&ip=";

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

    public static String getAddressFromIP(String ip) {

        CloseableHttpClient instance = null;
        CloseableHttpResponse response = null;
        instance = HttpClientBuilder.create().build();
        String result = "";

        try {
            response = instance.execute(new HttpGet(API_URL + ip));
            result = EntityUtils.toString(response.getEntity());
            int index = result.lastIndexOf("归属地信息：");
            if (index != -1) {
                result = result.substring(index + 6, result.length());
            } else {
                result = "没找到此IP";
            }
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            closeClient(response);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    private static void closeClient(CloseableHttpResponse response) throws IllegalStateException, IOException {

        if (response == null) {
            return;
        }
        try {
            final HttpEntity entity = response.getEntity();
            if (entity != null) {
                final InputStream instream = entity.getContent();
                instream.close();
            }
        } finally {
            try {
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
