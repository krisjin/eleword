package net.eleword.blog.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * TODO 此处填写 class 信息
 *
 * @author krisjin
 * @date 2014-5-4下午4:06:00
 */
@Controller
public class FileManage {
    String relativelyPath = "/docs";

    @RequestMapping(value = "/admin/files.htm", method = RequestMethod.GET)
    public String list() {

        return "admin/fileManage.htm";
    }

    @RequestMapping(value = "/admin/file/add.htm", method = RequestMethod.GET)
    public String add() {
        return "admin/addFile.htm";
    }

    @RequestMapping(value = "/admin/file/save.htm", method = RequestMethod.POST)
    public String saveAvatar(HttpServletRequest request, @RequestParam(value = "file") CommonsMultipartFile file) {
        if (file != null) {
            try {
                @SuppressWarnings("deprecation")
                String avatarFolder = request.getRealPath("/") + relativelyPath + "/";
                File tmpFile = new File(avatarFolder);
                if (!tmpFile.exists()) {
                    tmpFile.mkdirs();
                }

                File newFile = new File(avatarFolder, file.getOriginalFilename());
                file.transferTo(newFile);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return "redirect:/admin/files.htm";
    }
}
