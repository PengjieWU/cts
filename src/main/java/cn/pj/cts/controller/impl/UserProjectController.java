package cn.pj.cts.controller.impl;

import cn.pj.cts.common.ErrorCodeAndMsg;
import cn.pj.cts.common.ErrorsException;
import cn.pj.cts.common.Response;
import cn.pj.cts.entity.UserProjectEntity;
import cn.pj.cts.model.ProjectModel;
import cn.pj.cts.model.UserModel;
import cn.pj.cts.model.UserProjectModel;
import cn.pj.cts.service.ProjectService;
import cn.pj.cts.service.UserProjectService;
import cn.pj.cts.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author:Pengjie WU
 * @Description:TODO
 * @Date: Create in 12:06 2019/2/16
 * @Modify By:
 **/
@RestController
@RequestMapping(value="userproject")
@Slf4j
public class UserProjectController {

    @Autowired
    private UserProjectService userProjectService;
    @Autowired
    private UserService userService;
    @Autowired
    private ProjectService projectService;

    @GetMapping("/findProjectByLoginUserJoin.action")
    public Response findProjectByLoginUserJoin(HttpSession session){
        String userId = userService.findLoginUserModel(session).getUserId();
        UserProjectModel userProjectModel = new UserProjectModel();
        userProjectModel.setUserId(userId);
        Example<UserProjectModel> userProjectModelExample = Example.of(userProjectModel);
        List<UserProjectModel> userProjectModels = userProjectService.findUserProjectsByExample(userProjectModelExample);
        if(!CollectionUtils.isEmpty(userProjectModels)){
            List<ProjectModel> projectModels = new ArrayList<ProjectModel>(8);
            for(UserProjectModel model:userProjectModels){
                ProjectModel projectModel = new ProjectModel();
                projectModel = projectService.findProjectById(model.getProjectId());
                projectModels.add(projectModel);
            }
            return new Response(projectModels);
        }
        return new Response(null);
    }

    @GetMapping("findUserByProjectId.action")
    public Response findUserByProjectId(@RequestParam("projectId") String projectId){
        if(StringUtils.isEmpty(projectId)){
            throw new ErrorsException(ErrorCodeAndMsg.Query_Condition_Missing);
        }
        UserProjectModel userProjectModel = new UserProjectModel();
        userProjectModel.setProjectId(projectId);
        Example<UserProjectModel> userProjectModelExample = Example.of(userProjectModel);
        List<UserProjectModel> userProjectModels = userProjectService.findUserProjectsByExample(userProjectModelExample);
        if(!CollectionUtils.isEmpty(userProjectModels)){
            List<UserProjectEntity> userProjectEntities = new ArrayList<UserProjectEntity>(8);
            for(UserProjectModel model:userProjectModels){
                UserProjectEntity userProjectEntity = new UserProjectEntity();
                UserModel userModel = new UserModel();
                userModel = userService.findUserById(model.getUserId());
                BeanUtils.copyProperties(userModel,userProjectEntity);
                BeanUtils.copyProperties(model,userProjectEntity);
                userProjectEntities.add(userProjectEntity);
            }
            return new Response(userProjectEntities);
        }
        return new Response();
    }

    @GetMapping("deleteUserFromProject.action")
    public Response deleteUserFormProject(@RequestParam("userProjectId") String userProjectId){
        if(StringUtils.isEmpty(userProjectId)){
            throw new ErrorsException(ErrorCodeAndMsg.Delete_Condition_Missing);
        }
        userProjectService.deleteUserProjectById(userProjectId);
        return new Response();
    }



}
