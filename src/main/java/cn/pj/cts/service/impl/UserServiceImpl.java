package cn.pj.cts.service.impl;

import cn.pj.cts.common.ErrorCodeAndMsg;
import cn.pj.cts.common.ErrorsException;
import cn.pj.cts.common.Response;
import cn.pj.cts.dao.UserRepository;
import cn.pj.cts.model.UserModel;
import cn.pj.cts.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Response addUser(UserModel userModel){
        UserModel model = new UserModel();
        BeanUtils.copyProperties(userModel,model);
        log.info("==========第一个保存开始===========");
        userRepository.save(userModel);
        log.info("==========第一个保存结束===========");
        log.info("==========第二个保存开始===========");
        userRepository.save(model);
        throw  new ErrorsException(ErrorCodeAndMsg.Save_Condition_Missing);

    }
}
