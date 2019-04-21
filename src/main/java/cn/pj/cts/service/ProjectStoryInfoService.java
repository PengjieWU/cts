package cn.pj.cts.service;

import cn.pj.cts.common.Response;
import cn.pj.cts.entity.ProjectStoryInfoEntity;
import cn.pj.cts.model.ProjectStoryInfoModel;
import cn.pj.cts.model.UserModel;
import org.springframework.data.domain.Example;

import java.util.List;

/**
 * @Author:Pengjie WU
 * @Description:TODO
 * @Date: Create in 16:29 2019/3/3
 * @Modify By:
 **/
public interface ProjectStoryInfoService {
    ProjectStoryInfoModel addProjectStoryInfo(ProjectStoryInfoModel projectStoryInfoModel);

    List<ProjectStoryInfoModel> addBacthProjectStoryInfos(List<ProjectStoryInfoModel> projectStoryInfoModels);

    int updateProjectStoryInfo(ProjectStoryInfoModel projectStoryInfoModel);

    int updateBacthProjectStoryInfos(List<ProjectStoryInfoModel> projectStoryInfoModels);

    void deleteProjectStoryInfoById(String projectStoryInfoId);

    void deleteBacthProjectStoryInfos(List<ProjectStoryInfoModel> projectStoryInfoModels);

    boolean existsById(String projectStoryInfoId);

    ProjectStoryInfoModel findProjectStoryInfoById(String projectStoryInfoId);

    ProjectStoryInfoModel findByProjectStoryInfoLoginAccount(ProjectStoryInfoModel projectStoryInfoModel);

    List<ProjectStoryInfoModel> findProjectStoryInfosByExample(Example projectStoryInfoModel);

    ProjectStoryInfoEntity addProjectStoryInfoEntity(ProjectStoryInfoEntity projectStoryInfoEntity);

    Response findUserByProjectStoryId(String projectStoryId);

    List<ProjectStoryInfoModel> findAllStoryByStoryNameExample(ProjectStoryInfoModel projectStoryInfoModel);
}
