package cn.pj.cts.service.impl;

import cn.pj.cts.common.ErrorCodeAndMsg;
import cn.pj.cts.common.ErrorsException;
import cn.pj.cts.dao.ProjectMenuReposity;
import cn.pj.cts.dao.SystemMenuRepository;
import cn.pj.cts.dao.UserRepository;
import cn.pj.cts.entity.ProjectMenuEntity;
import cn.pj.cts.model.ProjectMenuModel;
import cn.pj.cts.model.SystemMenuModel;
import cn.pj.cts.model.UserModel;
import cn.pj.cts.service.ProjectMenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @Author:Pengjie WU
 * @Description:TODO
 * @Date: Create in 20:44 2019/4/14
 * @Modify By:
 **/
@Service("projectMenuService")
@Slf4j
public class ProjectMenuServiceImpl implements ProjectMenuService {

    @Autowired
    private ProjectMenuReposity projectMenuReposity;
    @Autowired
    private SystemMenuRepository systemMenuRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public ProjectMenuModel addProjectMenu(ProjectMenuModel projectMenuModel) {
        ProjectMenuModel model = new ProjectMenuModel();
        projectMenuModel.setProjectId(projectMenuModel.getProjectId());
        projectMenuModel.setMenuId(projectMenuModel.getMenuId());
        projectMenuModel.setReceiveId(projectMenuModel.getReceiveId());
        Example projectMenuModelExample = Example.of(projectMenuModel);
        List<ProjectMenuModel> projectMenuModels = projectMenuReposity.findAll(projectMenuModelExample);
        if(!CollectionUtils.isEmpty(projectMenuModels)){
            throw new ErrorsException(ErrorCodeAndMsg.Grantor_Authority_Error);
        }
        return projectMenuReposity.save(projectMenuModel);
    }

    @Override
    public List<ProjectMenuModel> addBacthProjectMenus(List<ProjectMenuModel> projectMenuModels) {
        return null;
    }

    @Override
    public int updateProjectMenu(ProjectMenuModel projectMenuModel, HttpSession session) {
        return 0;
    }

    @Override
    public int updateBacthProjectMenus(List<ProjectMenuModel> projectMenuModels) {
        return 0;
    }

    @Override
    public void deleteProjectMenuById(String projectMenuId) {
        projectMenuReposity.deleteById(projectMenuId);
    }

    @Override
    public void deleteBacthProjectMenus(List<ProjectMenuModel> projectMenuModels) {

    }

    @Override
    public boolean existsById(String projectMenuId) {
        return false;
    }

    @Override
    public ProjectMenuModel findProjectMenuById(String projectMenuId) {
        return null;
    }

    @Override
    public ProjectMenuModel findByProjectMenuLoginAccount(ProjectMenuModel projectMenuModel) {
        return null;
    }

    @Override
    public List<ProjectMenuModel> findProjectMenusByExample(Example projectMenuModel) {
        return null;
    }

    @Override
    public List<ProjectMenuEntity> findProjectMenuByLoginUser(String projectId, String userId) {
        List<ProjectMenuEntity> projectMenuEntities = new ArrayList<>(3);
        ProjectMenuModel projectMenuModel = new ProjectMenuModel();
        projectMenuModel.setProjectId(projectId);
        projectMenuModel.setReceiveId(userId);
        Example<ProjectMenuModel> projectMenuModelExample = Example.of(projectMenuModel);
        List<ProjectMenuModel> projectMenuModels = projectMenuReposity.findAll(projectMenuModelExample);
        if(!CollectionUtils.isEmpty(projectMenuModels)){
            for(ProjectMenuModel model:projectMenuModels){
                SystemMenuModel systemMenuModel = systemMenuRepository.getOne(model.getMenuId());
                ProjectMenuEntity projectMenuEntity = new ProjectMenuEntity();
                BeanUtils.copyProperties(model,projectMenuEntity);
                projectMenuEntity.setMenuName(systemMenuModel.getMenuName());
                projectMenuEntity.setMenuUrl(systemMenuModel.getMenuUrl());
                projectMenuEntities.add(projectMenuEntity);
            }
        }
        return projectMenuEntities;
    }

    @Override
    public List<ProjectMenuEntity> getProjectUserMenuList(String projectId) {
        ProjectMenuModel projectMenuModel = new ProjectMenuModel();
        projectMenuModel.setProjectId(projectId);
        Example projectMenuModelExample = Example.of(projectMenuModel);
        List<ProjectMenuModel> projectMenuModels = projectMenuReposity.findAll(projectMenuModelExample);
        List<ProjectMenuEntity> projectMenuEntities = new ArrayList<>(8);
        if(!CollectionUtils.isEmpty(projectMenuModels)){
            for(ProjectMenuModel model:projectMenuModels){
                ProjectMenuEntity projectMenuEntity = new ProjectMenuEntity();
                BeanUtils.copyProperties(model,projectMenuEntity);
                SystemMenuModel systemMenuModel = systemMenuRepository.getOne(model.getMenuId());
                projectMenuEntity.setMenuName(systemMenuModel.getMenuName());
                UserModel grantorUserModel = userRepository.getOne(model.getGrantorId());
                projectMenuEntity.setGrantorName(grantorUserModel.getUserName());
                UserModel receiveUserModel = userRepository.getOne(model.getReceiveId());
                projectMenuEntity.setReceiveName(receiveUserModel.getUserName());
                projectMenuEntities.add(projectMenuEntity);
            }
        }
        return projectMenuEntities;
    }
}
