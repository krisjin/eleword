package net.eleword.blog.util;

import com.mortennobel.imagescaling.AdvancedResizeOp;
import com.mortennobel.imagescaling.ResampleOp;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * TODO 此处填写 class 信息
 *
 * @author krisjin
 */
public class ThumbnailsUtils {

    private ThumbnailsUtils() {
    }

    public static void generateThumbnails(InputStream is, File file, int width, int height) throws IOException {

        BufferedImage src = ImageIO.read(is);

        ResampleOp resampleOp = new ResampleOp(width, height);
        resampleOp.setUnsharpenMask(AdvancedResizeOp.UnsharpenMask.VerySharp);
        BufferedImage rescaled = resampleOp.filter(src, null);

        ImageIO.write(rescaled, "jpg", file);
    }

}

