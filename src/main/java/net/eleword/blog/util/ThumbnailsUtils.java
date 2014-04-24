package net.eleword.blog.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import com.mortennobel.imagescaling.AdvancedResizeOp;
import com.mortennobel.imagescaling.ResampleOp;

/**
 * TODO 此处填写 class 信息
 * @author krisjin (mailto:krisjin86@163.com)
 */
public class ThumbnailsUtils {
	
	private ThumbnailsUtils(){}
	
	public static void generateThumbnails(InputStream is ,File file,int width,int height) throws IOException{
		
		BufferedImage src = ImageIO.read(is);

		ResampleOp resampleOp = new ResampleOp(width, height);
		resampleOp.setUnsharpenMask(AdvancedResizeOp.UnsharpenMask.VerySharp);
		BufferedImage rescaled = resampleOp.filter(src, null);

		ImageIO.write(rescaled, "jpg", file);	
	}

}

