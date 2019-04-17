package cn.pj.cts.entity;

import cn.pj.cts.model.ProjectStoryInfoModel;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @Author:Pengjie WU
 * @Description:TODO
 * @Date: Create in 18:46 2019/3/3
 * @Modify By:
 **/
public class ProjectStoryInfoEntity extends ProjectStoryInfoModel {

    private MultipartFile file;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
