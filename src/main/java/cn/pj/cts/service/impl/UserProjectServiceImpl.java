package cn.pj.cts.service.impl;

import cn.pj.cts.common.Response;
import cn.pj.cts.dao.UserProjectRepository;
import cn.pj.cts.entity.AddUserEntity;
import cn.pj.cts.model.UserModel;
import cn.pj.cts.model.UserProjectModel;
import cn.pj.cts.service.UserProjectService;
import cn.pj.cts.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author:Pengjie WU
 * @Description:TODO
 * @Date: Create in 12:43 2019/2/16
 * @Modify By:
 **/
@Service("userProjectService")
@Slf4j
public class UserProjectServiceImpl implements UserProjectService {


    @Autowired
    private UserProjectRepository userProjectRepository;

    @Autowired
    private UserService userService;


    @Override
    public UserProjectModel addUserProject(UserProjectModel userProjectModel) {
        return null;
    }

    @Override
    public List<UserProjectModel> addBacthUserProjects(List<UserProjectModel> userProjectModels) {
        return null;
    }

    @Override
    public int updateUserProject(UserProjectModel userProjectModel) {
        return 0;
    }

    @Override
    public int updateBacthUserProjects(List<UserProjectModel> userProjectModels) {
        return 0;
    }

    @Override
    public void deleteUserProjectById(String userProjectId) {
        userProjectRepository.deleteById(userProjectId);

    }

    @Override
    public void deleteBacthUserProjects(List<UserProjectModel> userProjectModels) {

    }

    @Override
    public boolean existsById(String userProjectId) {
        return false;
    }

    @Override
    public UserProjectModel findUserProjectById(String userProjectId) {
        return null;
    }

    @Override
    public UserProjectModel findByUserProjectLoginAccount(UserProjectModel userProjectModel) {
        return null;
    }

    @Override
    public List<UserProjectModel> findUserProjectsByExample(Example userProjectModel) {
        return userProjectRepository.findAll(userProjectModel);
    }

    @Override
    public void addUserJump(AddUserEntity addUserEntity,HttpSession session) {
        UserModel userModel = new UserModel();
        userModel.setUserLoginAccount(addUserEntity.getTargetEmail());
        Example<UserModel> userModelExample = Example.of(userModel);
        List<UserModel> userModels = userService.findUsersByExample(userModelExample);
        if(CollectionUtils.isEmpty(userModels)){
            userModel.setUserName("Jay");
            userModel.setUserPassword("123456");
            userModel = userService.addUser(userModel);
        }else{
            userModel = userModels.get(0);
        }
        session.setAttribute("userModel",userModel);
        UserProjectModel userProjectModel = new UserProjectModel();
        userProjectModel.setProjectId(addUserEntity.getProjectId());
        userProjectModel.setUserId(userModel.getUserId());
        userProjectModel.setProjectRole(addUserEntity.getRole());
        userProjectRepository.save(userProjectModel);
    }
}
