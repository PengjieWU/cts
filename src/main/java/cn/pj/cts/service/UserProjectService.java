package cn.pj.cts.service;

import cn.pj.cts.model.UserProjectModel;
import cn.pj.cts.common.Response;
import org.springframework.data.domain.Example;
import java.util.List;

/**
 * @Author:Pengjie WU
 * @Description:TODO
 * @Date: Create in 12:38 2019/2/16
 * @Modify By:
 **/
public interface UserProjectService {

    UserProjectModel addUserProject(UserProjectModel userProjectModel);

    List<UserProjectModel> addBacthUserProjects(List<UserProjectModel> userProjectModels);

    int updateUserProject(UserProjectModel userProjectModel);

    int updateBacthUserProjects(List<UserProjectModel> userProjectModels);

    void deleteUserProjectById(String userProjectId);

    void deleteBacthUserProjects(List<UserProjectModel> userProjectModels);

    boolean existsById(String userProjectId);

    UserProjectModel findUserProjectById(String userProjectId);

    UserProjectModel findByUserProjectLoginAccount(UserProjectModel userProjectModel);

    List<UserProjectModel> findUserProjectsByExample(Example userProjectModel);
}
