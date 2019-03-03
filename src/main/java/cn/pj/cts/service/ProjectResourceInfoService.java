package cn.pj.cts.service;

import cn.pj.cts.model.ProjectResourceInfoModel;

import org.springframework.data.domain.Example;

import java.util.List;

/**
 * @Author:Pengjie WU
 * @Description:TODO
 * @Date: Create in 16:28 2019/3/3
 * @Modify By:
 **/
public interface ProjectResourceInfoService {
    ProjectResourceInfoModel addProjectResourceInfo(ProjectResourceInfoModel projectResourceInfoModel);

    List<ProjectResourceInfoModel> addBacthProjectResourceInfos(List<ProjectResourceInfoModel> projectResourceInfoModels);

    int updateProjectResourceInfo(ProjectResourceInfoModel projectResourceInfoModel);

    int updateBacthProjectResourceInfos(List<ProjectResourceInfoModel> projectResourceInfoModels);

    void deleteProjectResourceInfoById(String projectResourceInfoId);

    void deleteBacthProjectResourceInfos(List<ProjectResourceInfoModel> projectResourceInfoModels);

    boolean existsById(String projectResourceInfoId);

    ProjectResourceInfoModel findProjectResourceInfoById(String projectResourceInfoId);

    ProjectResourceInfoModel findByProjectResourceInfoLoginAccount(ProjectResourceInfoModel projectResourceInfoModel);

    List<ProjectResourceInfoModel> findProjectResourceInfosByExample(Example projectResourceInfoModel);
}
