package cn.pj.cts.service;

import cn.pj.cts.entity.ProjectMenuEntity;
import cn.pj.cts.model.ProjectMenuModel;

import org.springframework.data.domain.Example;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author:Pengjie WU
 * @Description:TODO
 * @Date: Create in 20:41 2019/4/14
 * @Modify By:
 **/

public interface ProjectMenuService {

    ProjectMenuModel addProjectMenu(ProjectMenuModel projectMenuModel);

    List<ProjectMenuModel> addBacthProjectMenus(List<ProjectMenuModel> projectMenuModels);

    int updateProjectMenu(ProjectMenuModel projectMenuModel,HttpSession session);

    int updateBacthProjectMenus(List<ProjectMenuModel> projectMenuModels);

    void deleteProjectMenuById(String projectMenuId);

    void deleteBacthProjectMenus(List<ProjectMenuModel> projectMenuModels);

    boolean existsById(String projectMenuId);

    ProjectMenuModel findProjectMenuById(String projectMenuId);

    ProjectMenuModel findByProjectMenuLoginAccount(ProjectMenuModel projectMenuModel);

    List<ProjectMenuModel> findProjectMenusByExample(Example projectMenuModel);

    List<ProjectMenuEntity> findProjectMenuByLoginUser(String projectId, String userId);

    List<ProjectMenuEntity> getProjectUserMenuList(String projectId);
}
