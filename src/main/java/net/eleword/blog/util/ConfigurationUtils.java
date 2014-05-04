package net.eleword.blog.util;

import java.io.IOException;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;
import org.aspectj.apache.bcel.classfile.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

/**
 * @ClassName: ConfigurationUtils
 * @Description: 配置文件读取工具类
 * @author shenmiao@staff.hexun.com
 * @date 2012-10-15 下午04:55:16
 * 
 */
public class ConfigurationUtils implements ApplicationContextAware {
	


	private static Logger logger = LoggerFactory.getLogger(ConfigurationUtils.class);


	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		
//		try {
//			Properties  properties = PropertiesLoaderUtils.loadProperties(new ClassPathResource("hxt.properties"));
//			
//			String logo_path = properties.getProperty("logo.path");
//			if(StringUtils.equals(logo_path.substring(logo_path.length()-1, logo_path.length()),"/")){
//				Constant.LOGO_PATH = logo_path.substring(0, logo_path.length()-1);
//			}else{
//				Constant.LOGO_PATH = logo_path;
//			}
//			String photo_path = properties.getProperty("photo.path");
//			if(StringUtils.equals(photo_path.substring(photo_path.length()-1, photo_path.length()),"/")){
//				Constant.PHOTO_PATH = photo_path.substring(0, photo_path.length()-1);
//			}else{
//				Constant.PHOTO_PATH = photo_path;
//			}
//		} catch (IOException e) {
//			logger.error("Init ConfigurationUtils Error...",e);
//		}
		
		
	}
}
