package cn.pj.cts.service.impl;

import cn.pj.cts.model.ProjectTaskInfoModel;
import cn.pj.cts.service.ProjectTaskInfoService;
import org.springframework.data.domain.Example;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:Pengjie WU
 * @Description:TODO
 * @Date: Create in 16:47 2019/3/3
 * @Modify By:
 **/
@Service("projectTaskInfoService")
@Slf4j
public class ProjectTaskInfoServiceImpl implements ProjectTaskInfoService {
    @Override
    public ProjectTaskInfoModel addProjectTaskInfo(ProjectTaskInfoModel projectTaskInfoModel) {
        return null;
    }

    @Override
    public List<ProjectTaskInfoModel> addBacthProjectTaskInfos(List<ProjectTaskInfoModel> projectTaskInfoModels) {
        return null;
    }

    @Override
    public int updateProjectTaskInfo(ProjectTaskInfoModel projectTaskInfoModel) {
        return 0;
    }

    @Override
    public int updateBacthProjectTaskInfos(List<ProjectTaskInfoModel> projectTaskInfoModels) {
        return 0;
    }

    @Override
    public void deleteProjectTaskInfoById(String projectTaskInfoId) {

    }

    @Override
    public void deleteBacthProjectTaskInfos(List<ProjectTaskInfoModel> projectTaskInfoModels) {

    }

    @Override
    public boolean existsById(String projectTaskInfoId) {
        return false;
    }

    @Override
    public ProjectTaskInfoModel findProjectTaskInfoById(String projectTaskInfoId) {
        return null;
    }

    @Override
    public ProjectTaskInfoModel findByProjectTaskInfoLoginAccount(ProjectTaskInfoModel projectTaskInfoModel) {
        return null;
    }

    @Override
    public List<ProjectTaskInfoModel> findProjectTaskInfosByExample(Example projectTaskInfoModel) {
        return null;
    }
}
