package cn.pj.cts.service.impl;

import cn.pj.cts.dao.ProjectStoryResourceInfoRepository;
import cn.pj.cts.model.ProjectStoryResourceInfoModel;
import cn.pj.cts.service.ProjectStoryResourceInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import java.util.List;

/**
 * @Author:Pengjie WU
 * @Description:TODO
 * @Date: Create in 16:46 2019/3/3
 * @Modify By:
 **/
@Service("projectStoryResourceInfoService")
@Slf4j
public class ProjectStoryResourceInfoServiceImpl implements ProjectStoryResourceInfoService {

    @Autowired
    private ProjectStoryResourceInfoRepository projectStoryResourceInfoRepository;
    @Override
    public ProjectStoryResourceInfoModel addProjectStoryResourceInfo(ProjectStoryResourceInfoModel projectStoryResourceInfoModel) {
        return projectStoryResourceInfoRepository.save(projectStoryResourceInfoModel);
    }

    @Override
    public List<ProjectStoryResourceInfoModel> addBacthProjectStoryResourceInfos(List<ProjectStoryResourceInfoModel> projectStoryResourceInfoModels) {
        return null;
    }

    @Override
    public int updateProjectStoryResourceInfo(ProjectStoryResourceInfoModel projectStoryResourceInfoModel) {
        return 0;
    }

    @Override
    public int updateBacthProjectStoryResourceInfos(List<ProjectStoryResourceInfoModel> projectStoryResourceInfoModels) {
        return 0;
    }

    @Override
    public void deleteProjectStoryResourceInfoById(String projectStoryResourceInfoId) {

    }

    @Override
    public void deleteBacthProjectStoryResourceInfos(List<ProjectStoryResourceInfoModel> projectStoryResourceInfoModels) {

    }

    @Override
    public boolean existsById(String projectStoryResourceInfoId) {
        return false;
    }

    @Override
    public ProjectStoryResourceInfoModel findProjectStoryResourceInfoById(String projectStoryResourceInfoId) {
        return null;
    }

    @Override
    public ProjectStoryResourceInfoModel findByProjectStoryResourceInfoLoginAccount(ProjectStoryResourceInfoModel projectStoryResourceInfoModel) {
        return null;
    }

    @Override
    public List<ProjectStoryResourceInfoModel> findProjectStoryResourceInfosByExample(Example projectStoryResourceInfoModel) {
        return null;
    }
}
