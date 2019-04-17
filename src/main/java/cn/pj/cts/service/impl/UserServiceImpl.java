package cn.pj.cts.service.impl;

import cn.pj.cts.common.ErrorCodeAndMsg;
import cn.pj.cts.common.ErrorsException;
import cn.pj.cts.common.Response;
import cn.pj.cts.dao.UserRepository;
import cn.pj.cts.model.UserModel;
import cn.pj.cts.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

/**
 * @Author:Pengjie WU
 * @Description:TODO
 * @Date: Create in 21:28 2019/1/27
 * @Modify By:
 **/
@Service("userService")
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserModel addUser(UserModel userModel) {
        return userRepository.save(userModel);
    }

    @Override
    public List<UserModel> addBacthUsers(List<UserModel> userModels) {
        return userRepository.saveAll(userModels);
    }

    @Override
    public int updateUser(UserModel userModel,HttpSession session) {
        List<UserModel> userModels = this.userRepository.findByUserLoginAccount(userModel.getUserLoginAccount());
        if(CollectionUtils.isEmpty(userModels)){
            userModel.setUserName("测试");
            userRepository.save(userModel);
            session.setAttribute("userModel",userModel);
        }else{
            userModels.get(0).setUserPassword(userModel.getUserPassword());

            session.setAttribute("userModel",userModels.get(0));
            return userRepository.update(userModels.get(0));
        }
        return 1;
    }

    @Override
    public int updateBacthUsers(List<UserModel> userModels) {
        int count = 0;
        if(!CollectionUtils.isEmpty(userModels)){
            for(UserModel userModel:userModels){
                //this.updateUser(userModel);
                count++;
            }
        }
        return count;
    }

    @Override
    public void deleteUserById(String userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public void deleteBacthUsers(List<UserModel> userModels) {
        userRepository.deleteAll(userModels);
    }

    @Override
    public boolean existsById(String userId) {
        return userRepository.existsById(userId);
    }

    @Override
    public UserModel findUserById(String userId) {
        return userRepository.getOne(userId);
    }

    @Override
    public List<UserModel> findUsersByExample(Example userModel) {
        return userRepository.findAll(userModel);
    }

    @Override
    public UserModel findByUserLoginAccount(UserModel userModel) {
        List<UserModel> userModels = userRepository.findByUserLoginAccount(userModel.getUserLoginAccount());
        Response response = new Response();
        if(CollectionUtils.isEmpty(userModels)){
            throw new ErrorsException(ErrorCodeAndMsg.Login_Condition_Error);
        }else{
            UserModel model = userModels.get(0);
            if(!model.getUserPassword().equals(userModel.getUserPassword())){
                throw new ErrorsException(ErrorCodeAndMsg.Login_Condition_Error);
            }else{
                return model;
            }
        }
    }

    @Override
    public UserModel findLoginUserModel(HttpSession session) {
         UserModel userModel = (UserModel)session.getAttribute("userModel");
        if(userModel == null){
            throw new ErrorsException(ErrorCodeAndMsg.Login_Account_Error);
        }else{
            return userModel;
        }
    }

    @Override
    public boolean judgeUserLoginAccoutLegal(String userLoginAccout) {
        List<UserModel> userModels = userRepository.findByUserLoginAccount(userLoginAccout);
        Response response = new Response();
        if(CollectionUtils.isEmpty(userModels)){
           return true;
        }else{
           return false;
        }
    }
}
