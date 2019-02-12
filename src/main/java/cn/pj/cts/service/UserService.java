package cn.pj.cts.service;

import cn.pj.cts.common.Response;
import cn.pj.cts.model.UserModel;
import org.springframework.data.domain.Example;

import java.util.List;

/**
 * @Author:Pengjie WU
 * @Description:TODO
 * @Date: Create in 21:40 2019/1/27
 * @Modify By:
 **/
public interface UserService {

    UserModel addUser(UserModel userModel);

    List<UserModel> addBacthUsers(List<UserModel> userModels);

    int updateUser(UserModel userModel);

    int updateBacthUsers(List<UserModel> userModels);

    void deleteUserById(String userId);

    void deleteBacthUsers(List<UserModel> userModels);

    boolean existsById(String userId);

    UserModel findUserById(String userId);

    List<UserModel> findUsersByExample(Example userModel);

}