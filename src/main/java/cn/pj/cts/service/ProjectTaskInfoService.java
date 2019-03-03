package cn.pj.cts.service;

import cn.pj.cts.model.ProjectTaskInfoModel;
import org.springframework.data.domain.Example;

import java.util.List;

/**
 * @Author:Pengjie WU
 * @Description:TODO
 * @Date: Create in 16:30 2019/3/3
 * @Modify By:
 **/
public interface ProjectTaskInfoService {
    ProjectTaskInfoModel addProjectTaskInfo(ProjectTaskInfoModel projectTaskInfoModel);

    List<ProjectTaskInfoModel> addBacthProjectTaskInfos(List<ProjectTaskInfoModel> projectTaskInfoModels);

    int updateProjectTaskInfo(ProjectTaskInfoModel projectTaskInfoModel);

    int updateBacthProjectTaskInfos(List<ProjectTaskInfoModel> projectTaskInfoModels);

    void deleteProjectTaskInfoById(String projectTaskInfoId);

    void deleteBacthProjectTaskInfos(List<ProjectTaskInfoModel> projectTaskInfoModels);

    boolean existsById(String projectTaskInfoId);

    ProjectTaskInfoModel findProjectTaskInfoById(String projectTaskInfoId);

    ProjectTaskInfoModel findByProjectTaskInfoLoginAccount(ProjectTaskInfoModel projectTaskInfoModel);

    List<ProjectTaskInfoModel> findProjectTaskInfosByExample(Example projectTaskInfoModel);
}
