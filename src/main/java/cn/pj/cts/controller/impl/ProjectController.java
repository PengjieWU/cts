package cn.pj.cts.controller.impl;

import cn.pj.cts.common.ErrorCodeAndMsg;
import cn.pj.cts.common.ErrorsException;
import cn.pj.cts.common.Response;
import cn.pj.cts.model.ProjectModel;
import cn.pj.cts.service.ProjectService;
import cn.pj.cts.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @Author:Pengjie WU
 * @Description:TODO
 * @Date: Create in 12:06 2019/2/16
 * @Modify By:
 **/
@RestController
@RequestMapping(value="project")
@SessionAttributes("projectModel")
@Slf4j

public class ProjectController {

    @Autowired
    private ProjectService projectService;
    @Autowired
    private UserService userService;

    @PostMapping("/addProject.action")
    public Response addProject(@RequestBody ProjectModel projectModel, HttpSession session){
        if(StringUtils.isEmpty(projectModel.getProjectName())){
            throw new ErrorsException(ErrorCodeAndMsg.Save_Condition_Missing);
        }
        if(StringUtils.isEmpty(projectModel.getProjectDescription())){
            throw new ErrorsException(ErrorCodeAndMsg.Save_Condition_Missing);
        }
        if(StringUtils.isEmpty(projectModel.getProjectSecrecy())){
            throw new ErrorsException(ErrorCodeAndMsg.Save_Condition_Missing);
        }
        if(StringUtils.isEmpty(projectModel.getProjectDurationTime())){
            throw new ErrorsException(ErrorCodeAndMsg.Save_Condition_Missing);
        }
        if(StringUtils.isEmpty(projectModel.getProjectContactName())){
            throw new ErrorsException(ErrorCodeAndMsg.Save_Condition_Missing);
        }
        if(StringUtils.isEmpty(projectModel.getProjectContactEmail())){
            throw new ErrorsException(ErrorCodeAndMsg.Save_Condition_Missing);
        }
        if(StringUtils.isEmpty(projectModel.getProjectContactPhone())){
            throw new ErrorsException(ErrorCodeAndMsg.Save_Condition_Missing);
        }
        projectModel.setCreator(userService.findLoginUserModel(session).getUserId());
        projectModel = projectService.addProject(projectModel);
        return new Response(projectModel);
    }

    @GetMapping("/findProjectByLoginUser.action")
    public Response findProjectByLoginUser(HttpSession session){
        String userId = userService.findLoginUserModel(session).getUserId();
        ProjectModel projectModel = new ProjectModel();
        projectModel.setCreator(userId);
        Example<ProjectModel> projectModelExample = Example.of(projectModel);
        return new Response(Optional.ofNullable(projectService.findProjectsByExample(projectModelExample)).orElse(null));
    }

    @GetMapping("findProjectByProjectId.action")
    public Response findProjectByProjectId(@RequestParam("projectId") String projectId){
        return new Response(projectService.findProjectById(projectId));
    }

    @PostMapping("updateProjectByLoginUser.action")
    public  Response updateProjectByLoginUser(@RequestBody ProjectModel projectModel,HttpSession session){
        String userId = userService.findLoginUserModel(session).getUserId();
        if(StringUtils.isEmpty(userId)){
            throw new ErrorsException(ErrorCodeAndMsg.Save_Condition_Missing);
        }
        if(StringUtils.isEmpty(projectModel.getProjectId())){
            throw new ErrorsException(ErrorCodeAndMsg.Save_Condition_Missing);
        }
        if(StringUtils.isEmpty(projectModel.getProjectName())){
            throw new ErrorsException(ErrorCodeAndMsg.Save_Condition_Missing);
        }
        if(StringUtils.isEmpty(projectModel.getProjectDescription())){
            throw new ErrorsException(ErrorCodeAndMsg.Save_Condition_Missing);
        }
        if(StringUtils.isEmpty(projectModel.getProjectSecrecy())){
            throw new ErrorsException(ErrorCodeAndMsg.Save_Condition_Missing);
        }
        if(StringUtils.isEmpty(projectModel.getProjectDurationTime())){
            throw new ErrorsException(ErrorCodeAndMsg.Save_Condition_Missing);
        }
        if(StringUtils.isEmpty(projectModel.getProjectContactName())){
            throw new ErrorsException(ErrorCodeAndMsg.Save_Condition_Missing);
        }
        if(StringUtils.isEmpty(projectModel.getProjectContactEmail())){
            throw new ErrorsException(ErrorCodeAndMsg.Save_Condition_Missing);
        }
        if(StringUtils.isEmpty(projectModel.getProjectContactPhone())){
            throw new ErrorsException(ErrorCodeAndMsg.Save_Condition_Missing);
        }
        projectModel.setModifier(userId);
        projectService.updateProject(projectModel);
        return new Response(projectModel);
    }
}