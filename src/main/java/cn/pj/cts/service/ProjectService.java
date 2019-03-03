package cn.pj.cts.service;

import cn.pj.cts.model.ProjectModel;
import cn.pj.cts.common.Response;
import org.springframework.data.domain.Example;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author:Pengjie WU
 * @Description:TODO
 * @Date: Create in 12:33 2019/2/16
 * @Modify By:
 **/
public interface ProjectService {

    ProjectModel addProject(ProjectModel projectModel);

    List<ProjectModel> addBacthProjects(List<ProjectModel> projectModels);

    int updateProject(ProjectModel projectModel);

    int updateBacthProjects(List<ProjectModel> projectModels);

    void deleteProjectById(String projectId);

    void deleteBacthProjects(List<ProjectModel> projectModels);

    boolean existsById(String projectId);

    ProjectModel findProjectById(String projectId);

    Response findByProjectLoginAccount(ProjectModel projectModel);

    List<ProjectModel> findProjectsByExample(Example projectModel);

    List<ProjectModel> findProjectsByCreator(String creator);
}
