package cn.pj.cts.service.impl;

import cn.pj.cts.common.Response;
import cn.pj.cts.dao.ProjectRepository;
import cn.pj.cts.dao.UserProjectRepository;
import cn.pj.cts.model.ProjectModel;
import cn.pj.cts.model.UserModel;
import cn.pj.cts.model.UserProjectModel;
import cn.pj.cts.service.ProjectService;
import cn.pj.cts.service.UserProjectService;
import cn.pj.cts.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

/**
 * @Author:Pengjie WU
 * @Description:TODO
 * @Date: Create in 12:35 2019/2/16
 * @Modify By:
 **/
@Service("projectService")
@Slf4j
public class ProjectServiceImpl implements ProjectService  {

    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private UserProjectRepository userProjectRepository;
    @Autowired
    private UserService userService;

    @Override
    public ProjectModel addProject(ProjectModel projectModel) {

        projectModel =  projectRepository.save(projectModel) ;
        UserProjectModel userProjectModel = new UserProjectModel();
        userProjectModel.setProjectId(projectModel.getProjectId());
        userProjectModel.setUserId(projectModel.getCreator());
        userProjectModel.setCreator(projectModel.getCreator());
        userProjectRepository.save(userProjectModel);
        return projectModel;

    }

    @Override
    public List<ProjectModel> addBacthProjects(List<ProjectModel> projectModels) {
        return null;
    }

    @Override
    public int updateProject(ProjectModel projectModel) {
        return projectRepository.update(projectModel);
    }

    @Override
    public int updateBacthProjects(List<ProjectModel> projectModels) {
        return 0;
    }

    @Override
    public void deleteProjectById(String projectId) {

    }

    @Override
    public void deleteBacthProjects(List<ProjectModel> projectModels) {

    }

    @Override
    public boolean existsById(String projectId) {
        return false;
    }

    @Override
    public ProjectModel findProjectById(String projectId) {

        Optional<ProjectModel> projectModel = projectRepository.findById(projectId);
        return  projectModel.get();
    }

    @Override
    public Response findByProjectLoginAccount(ProjectModel projectModel) {
        return null;
    }

    @Override
    public List<ProjectModel> findProjectsByExample(Example projectModel) {
        return projectRepository.findAll(projectModel);
    }

    @Override
    public List<ProjectModel> findProjectsByCreator(String creator) {
        return projectRepository.findByCreator(creator);
    }
}
