package cn.pj.cts.service.impl;

import cn.pj.cts.common.Response;
import cn.pj.cts.dao.UserProjectRepository;
import cn.pj.cts.model.UserProjectModel;
import cn.pj.cts.service.UserProjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

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
}
