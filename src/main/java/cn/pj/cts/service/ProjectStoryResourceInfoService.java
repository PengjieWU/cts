package cn.pj.cts.service;

import cn.pj.cts.model.ProjectStoryResourceInfoModel;
import org.springframework.data.domain.Example;

import java.util.List;

/**
 * @Author:Pengjie WU
 * @Description:TODO
 * @Date: Create in 16:30 2019/3/3
 * @Modify By:
 **/
public interface ProjectStoryResourceInfoService {
    ProjectStoryResourceInfoModel addProjectStoryResourceInfo(ProjectStoryResourceInfoModel projectStoryResourceInfoModel);

    List<ProjectStoryResourceInfoModel> addBacthProjectStoryResourceInfos(List<ProjectStoryResourceInfoModel> projectStoryResourceInfoModels);

    int updateProjectStoryResourceInfo(ProjectStoryResourceInfoModel projectStoryResourceInfoModel);

    int updateBacthProjectStoryResourceInfos(List<ProjectStoryResourceInfoModel> projectStoryResourceInfoModels);

    void deleteProjectStoryResourceInfoById(String projectStoryResourceInfoId);

    void deleteBacthProjectStoryResourceInfos(List<ProjectStoryResourceInfoModel> projectStoryResourceInfoModels);

    boolean existsById(String projectStoryResourceInfoId);

    ProjectStoryResourceInfoModel findProjectStoryResourceInfoById(String projectStoryResourceInfoId);

    ProjectStoryResourceInfoModel findByProjectStoryResourceInfoLoginAccount(ProjectStoryResourceInfoModel projectStoryResourceInfoModel);

    List<ProjectStoryResourceInfoModel> findProjectStoryResourceInfosByExample(Example projectStoryResourceInfoModel);
}
