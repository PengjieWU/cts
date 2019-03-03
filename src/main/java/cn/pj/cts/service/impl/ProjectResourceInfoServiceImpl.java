package cn.pj.cts.service.impl;

import cn.pj.cts.dao.ProjectResourceInfoRepository;
import cn.pj.cts.model.ProjectResourceInfoModel;
import cn.pj.cts.service.ProjectResourceInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @Author:Pengjie WU
 * @Description:TODO
 * @Date: Create in 16:42 2019/3/3
 * @Modify By:
 **/
@Service("projectResourceInfoService")
@Slf4j
public class ProjectResourceInfoServiceImpl implements ProjectResourceInfoService {
    @Autowired
    private ProjectResourceInfoRepository projectResourceInfoRepository;
    @Override
    public ProjectResourceInfoModel addProjectResourceInfo(ProjectResourceInfoModel projectResourceInfoModel) {
        return projectResourceInfoRepository.save(projectResourceInfoModel);
    }

    @Override
    public List<ProjectResourceInfoModel> addBacthProjectResourceInfos(List<ProjectResourceInfoModel> projectResourceInfoModels) {
        return null;
    }

    @Override
    public int updateProjectResourceInfo(ProjectResourceInfoModel projectResourceInfoModel) {
        return 0;
    }

    @Override
    public int updateBacthProjectResourceInfos(List<ProjectResourceInfoModel> projectResourceInfoModels) {
        return 0;
    }

    @Override
    public void deleteProjectResourceInfoById(String projectResourceInfoId) {

    }

    @Override
    public void deleteBacthProjectResourceInfos(List<ProjectResourceInfoModel> projectResourceInfoModels) {

    }

    @Override
    public boolean existsById(String projectResourceInfoId) {
        return false;
    }

    @Override
    public ProjectResourceInfoModel findProjectResourceInfoById(String projectResourceInfoId) {
        return null;
    }

    @Override
    public ProjectResourceInfoModel findByProjectResourceInfoLoginAccount(ProjectResourceInfoModel projectResourceInfoModel) {
        return null;
    }

    @Override
    public List<ProjectResourceInfoModel> findProjectResourceInfosByExample(Example projectResourceInfoModel) {
        return null;
    }
}
