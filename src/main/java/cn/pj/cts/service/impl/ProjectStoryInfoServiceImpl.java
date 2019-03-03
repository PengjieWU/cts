package cn.pj.cts.service.impl;
import cn.pj.cts.dao.ProjectStoryInfoRepository;
import cn.pj.cts.entity.ProjectStoryInfoEntity;
import cn.pj.cts.model.ProjectModel;
import cn.pj.cts.model.ProjectResourceInfoModel;
import cn.pj.cts.model.ProjectStoryInfoModel;
import cn.pj.cts.model.ProjectStoryResourceInfoModel;
import cn.pj.cts.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @Author:Pengjie WU
 * @Description:TODO
 * @Date: Create in 16:44 2019/3/3
 * @Modify By:
 **/
@Service("projectStoryInfoService")
@Slf4j
public class ProjectStoryInfoServiceImpl implements ProjectStoryInfoService {

    @Autowired
    private UserService userService;
    @Autowired
    private ProjectStoryInfoRepository projectStoryInfoRepository;
    @Autowired
    private ProjectService projectService;
    @Autowired
    private ProjectResourceInfoService projectResourceInfoService;
    @Autowired
    private ProjectStoryResourceInfoService projectStoryResourceInfoService;
    @Override
    public ProjectStoryInfoModel addProjectStoryInfo(ProjectStoryInfoModel projectStoryInfoModel) {
        return projectStoryInfoRepository.save(projectStoryInfoModel);
    }

    @Override
    public List<ProjectStoryInfoModel> addBacthProjectStoryInfos(List<ProjectStoryInfoModel> projectStoryInfoModels) {
        return null;
    }

    @Override
    public int updateProjectStoryInfo(ProjectStoryInfoModel projectStoryInfoModel) {
        return 0;
    }

    @Override
    public int updateBacthProjectStoryInfos(List<ProjectStoryInfoModel> projectStoryInfoModels) {
        return 0;
    }

    @Override
    public void deleteProjectStoryInfoById(String projectStoryInfoId) {

    }

    @Override
    public void deleteBacthProjectStoryInfos(List<ProjectStoryInfoModel> projectStoryInfoModels) {

    }

    @Override
    public boolean existsById(String projectStoryInfoId) {
        return false;
    }

    @Override
    public ProjectStoryInfoModel findProjectStoryInfoById(String projectStoryInfoId) {
        return null;
    }

    @Override
    public ProjectStoryInfoModel findByProjectStoryInfoLoginAccount(ProjectStoryInfoModel projectStoryInfoModel) {
        return null;
    }

    @Override
    public List<ProjectStoryInfoModel> findProjectStoryInfosByExample(Example projectStoryInfoModel) {
        return projectStoryInfoRepository.findAll(projectStoryInfoModel);
    }

    @Override
    public ProjectStoryInfoEntity addProjectStoryInfoEntity(ProjectStoryInfoEntity projectStoryInfoEntity) {
        ProjectStoryInfoModel projectStoryInfoModel = new ProjectStoryInfoModel();
        ProjectModel projectModel = projectService.findProjectById(projectStoryInfoEntity.getProjectId());
        projectStoryInfoEntity.setProjectName(projectModel.getProjectName());
        if(!StringUtils.isEmpty(projectStoryInfoEntity.getTargetUserId())){
            projectStoryInfoEntity.setTargetUserName(userService.findUserById(projectStoryInfoEntity.getTargetUserId()).getUserName());
        }
        String storyMnemonicCode = (int) ((Math.random()*9+1)*1000)+"";
        projectStoryInfoEntity.setStoryMnemonicCode(storyMnemonicCode);
        BeanUtils.copyProperties(projectStoryInfoEntity,projectStoryInfoModel);
        projectStoryInfoModel = this.addProjectStoryInfo(projectStoryInfoModel);
        if(!StringUtils.isEmpty(projectStoryInfoEntity.getStoryAttachementFiles())){
                MultipartFile file = projectStoryInfoEntity.getStoryAttachementFiles();
                ProjectResourceInfoModel projectResourceInfoModel = new ProjectResourceInfoModel();
                projectResourceInfoModel.setCreator(projectStoryInfoEntity.getCreator());
                projectResourceInfoModel = projectResourceInfoService.addProjectResourceInfo(projectResourceInfoModel);
                ProjectStoryResourceInfoModel projectStoryResourceInfoModel = new ProjectStoryResourceInfoModel();
                projectStoryResourceInfoModel.setCreator(projectStoryInfoEntity.getCreator());
                projectStoryResourceInfoModel.setProjectStoryId(projectStoryInfoModel.getProjectStoryId());
                projectStoryResourceInfoModel.setProjectResourceId(projectResourceInfoModel.getProjectResourceId());
                projectStoryResourceInfoModel.setProjectStoryResourceName(file.getName());
                projectStoryResourceInfoModel = projectStoryResourceInfoService.addProjectStoryResourceInfo(projectStoryResourceInfoModel);


        }
        BeanUtils.copyProperties(projectStoryInfoModel,projectStoryInfoEntity);
        return projectStoryInfoEntity;
    }
}
