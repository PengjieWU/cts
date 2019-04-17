package cn.pj.cts.controller.impl;

import cn.pj.cts.common.ErrorCodeAndMsg;
import cn.pj.cts.common.ErrorsException;
import cn.pj.cts.common.Response;
import cn.pj.cts.entity.UserEntity;
import cn.pj.cts.model.UserModel;
import cn.pj.cts.service.UserService;
import cn.pj.cts.util.SendMail;
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
@Slf4j
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
        session.removeAttribute("userModel");
        session.setAttribute("userModel",userModel);
        return new Response(userModel);
    }


    @PostMapping("/getVerificationCode.action")
    public Response getVerificationCode(@RequestBody UserModel userModel,HttpSession session){
        if(StringUtils.isEmpty(userModel.getUserLoginAccount())) {
            throw  new ErrorsException(ErrorCodeAndMsg.Save_Condition_Missing);
        }
        String verificationCode = (int)((Math.random()*9+1)*1000)+"";
        session.setAttribute("verificationCode","1234");
        try {
            SendMail.testFindPassword(userModel.getUserLoginAccount(),verificationCode);
        }catch (Exception e){
            throw  new ErrorsException(ErrorCodeAndMsg.Save_Condition_Missing);
        }

        return new Response();

    }

    @PostMapping("/checkVerificationCode.action")
    public Response checkVerificationCode(@RequestBody UserEntity userEntity, HttpSession session){
        if(StringUtils.isEmpty(userEntity.getUserLoginAccount())) {
            throw  new ErrorsException(ErrorCodeAndMsg.Save_Condition_Missing);
        }
        if(StringUtils.isEmpty(userEntity.getCode())){
            throw  new ErrorsException(ErrorCodeAndMsg.Save_Condition_Missing);
        }

        String verificationCode = (String) session.getAttribute("verificationCode");
        if(userEntity.getCode().equalsIgnoreCase(verificationCode)){
            return new Response();
        }else {
            throw new ErrorsException(ErrorCodeAndMsg.Save_Condition_Missing);
        }
    }

    @PostMapping("/updateUser.action")
    public Response updateUser(@RequestBody UserModel userModel,HttpSession session){
        if(StringUtils.isEmpty(userModel.getUserLoginAccount())){
            throw new ErrorsException(ErrorCodeAndMsg.Save_Condition_Missing);
        }
        if(StringUtils.isEmpty(userModel.getUserPassword())){
            throw new ErrorsException(ErrorCodeAndMsg.Save_Condition_Missing);
        }

        userService.updateUser(userModel,session);
        return new Response();
    }


    @DeleteMapping(path="deleteUser")
    public void deleteUser(@RequestBody UserModel userModel){

    }

    @GetMapping("judgeUserLoginAccoutLegal.action")
    public Response judgeUserLoginAccoutLegal(@RequestParam("userLoginAccount") String userLoginAccount){

        boolean flag = userService.judgeUserLoginAccoutLegal(userLoginAccount);
        String msg = null;
        if(!flag){
            msg = "该邮箱已经注册，请尝试找回密码";
        }
        return  new Response(msg);
    }

    @GetMapping("findCurrentLoginUser.action")
    public Response findCurrentLoginUser(HttpSession session){
        UserModel userModel = userService.findLoginUserModel(session);
        return new Response(userModel);
    }
}
