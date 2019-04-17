package cn.pj.cts.service.impl;

import cn.pj.cts.dao.ProjectTaskInfoRepository;
import cn.pj.cts.entity.ProjectTaskInfoEntity;
import cn.pj.cts.model.ProjectTaskInfoModel;
import cn.pj.cts.service.ProjectTaskInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @Author:Pengjie WU
 * @Description:TODO
 * @Date: Create in 16:47 2019/3/3
 * @Modify By:
 **/
@Service("projectTaskInfoService")
@Slf4j
public class ProjectTaskInfoServiceImpl implements ProjectTaskInfoService {

    @Autowired
    private ProjectTaskInfoRepository projectTaskInfoRepository;
    @Override
    public ProjectTaskInfoModel addProjectTaskInfo(ProjectTaskInfoModel projectTaskInfoModel) {
        return projectTaskInfoRepository.save(projectTaskInfoModel);
    }

    @Override
    public List<ProjectTaskInfoModel> addBacthProjectTaskInfos(List<ProjectTaskInfoModel> projectTaskInfoModels) {
        return null;
    }

    @Override
    public int updateProjectTaskInfo(ProjectTaskInfoModel projectTaskInfoModel) {
        return projectTaskInfoRepository.update(projectTaskInfoModel);
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

    @Override
    public ProjectTaskInfoModel findProjectTaskInfoListByCurrentdayAndLoginUser(ProjectTaskInfoModel projectTaskInfoModel) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        Date date = new Date();
        String dateStr = simpleDateFormat.format(date);
        projectTaskInfoModel = projectTaskInfoRepository.findProjectTaskInfosByExample(projectTaskInfoModel.getProjectId(),projectTaskInfoModel.getCreator(),dateStr);
        return Optional.ofNullable(projectTaskInfoModel).orElse(new ProjectTaskInfoModel());
    }

    @Override
    public List<ProjectTaskInfoModel> findTaskInfoByProjectIdAndAllTeam(ProjectTaskInfoEntity projectTaskInfoEntity) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        String dateStr = simpleDateFormat.format(projectTaskInfoEntity.getSelectDay());
        List<ProjectTaskInfoModel> projectTaskInfoModels = new ArrayList<>(8);
        projectTaskInfoModels = projectTaskInfoRepository.findTaskInfoByProjectIdAndAllTeam(projectTaskInfoEntity.getProjectId(),dateStr);
        return Optional.ofNullable(projectTaskInfoModels).orElse(new ArrayList<ProjectTaskInfoModel>());
    }
}
