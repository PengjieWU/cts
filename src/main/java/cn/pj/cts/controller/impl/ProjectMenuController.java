package cn.pj.cts.controller.impl;

import cn.pj.cts.common.ErrorCodeAndMsg;
import cn.pj.cts.common.ErrorsException;
import cn.pj.cts.common.Response;
import cn.pj.cts.entity.ProjectMenuEntity;
import cn.pj.cts.model.ProjectMenuModel;
import cn.pj.cts.model.UserModel;
import cn.pj.cts.service.ProjectMenuService;
import cn.pj.cts.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author:Pengjie WU
 * @Description:TODO
 * @Date: Create in 21:53 2019/4/14
 * @Modify By:
 **/
@Component
@RestController
@RequestMapping(value="projectMenuInfo")
@Slf4j
public class ProjectMenuController {

    @Autowired
    private ProjectMenuService projectMenuService;
    @Autowired
    private UserService userService;

    @GetMapping("findProjectMenuByLoginUser.action")
    public Response findProjectMenuByLoginUser(@RequestParam("projectId") String projectId, HttpSession session){
        UserModel userModel = userService.findLoginUserModel(session);
        List<ProjectMenuEntity> projectMenuEntities = projectMenuService.findProjectMenuByLoginUser(projectId,userModel.getUserId());
        return new Response(projectMenuEntities);
    }

    @PostMapping("grantorMenu.action")
    public Response grantorMenu(@RequestBody ProjectMenuModel projectMenuModel,HttpSession session){
        if(StringUtils.isEmpty(projectMenuModel.getProjectId())){
            throw new ErrorsException(ErrorCodeAndMsg.Save_Condition_Missing);
        }
        if(StringUtils.isEmpty(projectMenuModel.getMenuId())){
            throw new ErrorsException(ErrorCodeAndMsg.Save_Condition_Missing);
        }
        if(StringUtils.isEmpty(projectMenuModel.getReceiveId())){
            throw new ErrorsException(ErrorCodeAndMsg.Save_Condition_Missing);
        }
        UserModel userModel = userService.findLoginUserModel(session);
        projectMenuModel.setGrantorId(userModel.getCreator());
        projectMenuModel.setCreator(userModel.getCreator());
        projectMenuModel = projectMenuService.addProjectMenu(projectMenuModel);
        return new Response(projectMenuModel);
    }

    @GetMapping("withDrawMenu.action")
    public Response withDrawMenu(@RequestParam("projectMenuId") String projectMenuId){
        projectMenuService.deleteProjectMenuById(projectMenuId);
        return new Response();
    }

    @GetMapping("getProjectUserMenuList.action")
    public Response getProjectUserMenuList(@RequestParam("projectId") String projectId){
        List<ProjectMenuEntity> projectMenuEntities = projectMenuService.getProjectUserMenuList(projectId);
        return new Response(projectMenuEntities);
    }
}
