package cn.pj.cts.controller.impl;

import cn.pj.cts.common.ErrorCodeAndMsg;
import cn.pj.cts.common.ErrorsException;
import cn.pj.cts.common.Response;
import cn.pj.cts.dao.UserRepository;
import cn.pj.cts.model.UserModel;
import cn.pj.cts.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author:Pengjie WU
 * @Description:TODO
 * @Date: Create in 11:32 2019/1/19
 * @Modify By:
 **/
@RestController
@RequestMapping(value="user")
@Slf4j
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/addUser.action")
    public Response addUser(@RequestBody UserModel userModel){
        userService.addUser(userModel);
        return new Response();

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
