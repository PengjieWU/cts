package cn.pj.cts.controller.impl;

import cn.pj.cts.common.ErrorCodeAndMsg;
import cn.pj.cts.common.ErrorsException;
import cn.pj.cts.common.Response;
import cn.pj.cts.model.UserModel;
import cn.pj.cts.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @Author:Pengjie WU
 * @Description:TODO
 * @Date: Create in 11:32 2019/1/19
 * @Modify By:
 **/
@RestController
@RequestMapping(value="user")
@SessionAttributes("userModel")
@Slf4j
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/addUser.action")
    public Response addUser(@RequestBody UserModel userModel,HttpSession session){
        if(StringUtils.isEmpty(userModel.getUserLoginAccount())) {
            throw new ErrorsException(ErrorCodeAndMsg.Save_Condition_Missing);
        }
        if(StringUtils.isEmpty(userModel.getUserPassword())){
            throw new ErrorsException(ErrorCodeAndMsg.Save_Condition_Missing);
        }
        if(StringUtils.isEmpty(userModel.getUserName())){
            throw new ErrorsException(ErrorCodeAndMsg.Save_Condition_Missing);
        }
        userModel = userService.addUser(userModel);
        session.setAttribute("userModel",userModel);
        return new Response(userModel);

    }

    @PostMapping("/findByUserLoginAccount.action")
    public Response findByUserLoginAccount(@RequestBody UserModel userModel,HttpSession session){
        if(StringUtils.isEmpty(userModel.getUserLoginAccount())){
            throw new ErrorsException(ErrorCodeAndMsg.Query_Condition_Missing);
        }
        if(StringUtils.isEmpty(userModel.getUserPassword())){
            throw  new ErrorsException(ErrorCodeAndMsg.Query_Condition_Missing);
        }

        userModel = userService.findByUserLoginAccount(userModel);
        session.setAttribute("userModel",userModel);
        return new Response(userModel);
    }

    @PostMapping("/updateUser")
    public Response updateUser(@RequestBody UserModel userModel){
        userService.updateUser(userModel);
        return new Response();
    }


    @DeleteMapping(path="deleteUser")
    public void deleteUser(@RequestBody UserModel userModel){

    }






}
