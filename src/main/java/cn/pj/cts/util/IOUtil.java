package cn.pj.cts.util;

import java.io.*;

/**
 * @Author:Pengjie WU
 * @Description:TODO
 * @Date: Create in 17:54 2019/4/21
 * @Modify By:
 **/
public class IOUtil {

    public static void  createAndWriteFile(String content){

        byte[] sourceByte = content.getBytes();
        if(null != sourceByte) {
            try {
                //String tempPath =System.getProperty("java.io.tmpdir")+File.separator;
                //tempPath = tempPath+"wordAnalyse.txt";
                String tempPath = "E:\\wordAnalyse.txt";
                File file = new File(tempPath);
                if (!file.exists()) {
                    File dir = new File(file.getParent());
                    dir.mkdirs();
                    file.createNewFile();
                }
                FileOutputStream outStream = new FileOutputStream(file);
                outStream.write(sourceByte);
                outStream.close();    //关闭文件输出流
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }


    public static byte[] readFile(String tempPath) throws Exception{
        FileInputStream fileInputStream = new FileInputStream("E:\\paper\\page\\TeamCollaborationSystem\\img\\wordAnalyse.png");
        BufferedInputStream in = new BufferedInputStream(fileInputStream);
        ByteArrayOutputStream out = new ByteArrayOutputStream(1024);

        System.out.println("Available bytes:" + in.available());

        byte[] temp = new byte[1024];
        int size = 0;
        while ((size = in.read(temp)) != -1) {
            out.write(temp, 0, size);
        }
        in.close();

        byte[] content = out.toByteArray();

        return content;
    }
}
