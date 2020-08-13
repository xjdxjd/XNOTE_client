package com.xnote.client.common.utils.common;

import com.xnote.client.core.constant.ProjectConstant;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * 文件工具类
 */
public class FileUtils
{
    private final static String DOWN_CONTENT_TYPE = "application/force-download";
    private final static String DOWN_HEADER_DISPOSITION = "Content-Disposition";
    private final static String DOWN_HEADER_ATTACHEMENT = "attachement;fileName=";

    /**
     * 获取文件新名称 -- UUID
     * @param oName 原文件文件
     * @return  新文件名
     */
    public static String getFileName(String oName)
    {
        String str = UUIDUtils.getUUID() + oName.substring(oName.lastIndexOf("."));
        return str;
    }

    /**
     * 保存在本地
     * @param file  上传的文件
     * @param path  保存路径
     * @return
     */
    public static Integer saveLocally(MultipartFile file, String path, String fileName)
    {
        try
        {
            if(!ObjectUtils.isEmpty(file))
            {
                File sfile = new File(path, file.getOriginalFilename());

                if(!sfile.getParentFile().exists())
                {
                    sfile.getParentFile().mkdirs();
                }

                File tempFile = new File(path + fileName);
                file.transferTo(tempFile);
            }

            return ProjectConstant.ZERO_CONSTANT.code();
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
            return ProjectConstant.ONE_CONSTANT.code();
        }
    }

    public static void downFile(String resUrl, File file, HttpServletResponse response)
    {
        response.setContentType(DOWN_CONTENT_TYPE);
        response.addHeader(DOWN_HEADER_DISPOSITION, DOWN_HEADER_ATTACHEMENT + resUrl);
        byte[] buffer = new byte[1024];
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        OutputStream os = null;
        try
        {
            fis = new FileInputStream(file);
            bis = new BufferedInputStream(fis);
            os = response.getOutputStream();
            int i = bis.read(buffer);
            while(i != -1)
            {
                os.write(buffer, 0, i);
                i = bis.read(buffer);
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            try {
                os.close();
                bis.close();
                fis.close();

            }catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
