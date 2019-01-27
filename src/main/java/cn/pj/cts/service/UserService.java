package cn.pj.cts.service;

import cn.pj.cts.common.Response;
import cn.pj.cts.model.UserModel;

/**
 * @Author:Pengjie WU
 * @Description:TODO
 * @Date: Create in 21:40 2019/1/27
 * @Modify By:
 **/
public interface UserService {

    Response addUser(UserModel userModel);

}
