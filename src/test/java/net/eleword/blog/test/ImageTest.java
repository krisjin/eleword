package net.eleword.blog.test;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.mortennobel.imagescaling.AdvancedResizeOp;
import com.mortennobel.imagescaling.ResampleOp;

public class ImageTest {

	public static void main(String[] args) throws IOException {
		File f = new File("d:/photo.jpg");
		BufferedImage src = ImageIO.read(f);

		ResampleOp resampleOp = new ResampleOp(120, 120);
		resampleOp.setUnsharpenMask(AdvancedResizeOp.UnsharpenMask.VerySharp);
		BufferedImage rescaled = resampleOp.filter(src, null);

		ImageIO.write(rescaled, "JPG", new File("d:/uu.jpg"));
	}
}