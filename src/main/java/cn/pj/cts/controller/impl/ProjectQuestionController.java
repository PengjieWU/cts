package cn.pj.cts.controller.impl;

import cn.pj.cts.common.ErrorCodeAndMsg;
import cn.pj.cts.common.ErrorsException;
import cn.pj.cts.common.Response;
import cn.pj.cts.model.ProjectModel;
import cn.pj.cts.model.ProjectQuestionModel;
import cn.pj.cts.model.UserModel;
import cn.pj.cts.service.ProjectQuestionService;
import cn.pj.cts.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Optional;

/**
 * @Author:Pengjie WU
 * @Description:TODO
 * @Date: Create in 20:00 2019/4/6
 * @Modify By:
 **/
@RestController
@RequestMapping(value="question")
@Slf4j
public class ProjectQuestionController {

    @Autowired
    private ProjectQuestionService projectQuestionService;
    @Autowired
    private UserService userService;

    @PostMapping("addQuestion.action")
    public Response addQuestion(@RequestBody ProjectQuestionModel projectQuestionModel, HttpSession session){
        if(StringUtils.isEmpty(projectQuestionModel.getProjectId())){
            throw new ErrorsException(ErrorCodeAndMsg.Save_Condition_Missing);
        }
        if(StringUtils.isEmpty(projectQuestionModel.getProjectQuestionKeyword())){
            throw new ErrorsException(ErrorCodeAndMsg.Save_Condition_Missing);
        }
        if(StringUtils.isEmpty(projectQuestionModel.getProjectQuestionDescription())){
            throw new ErrorsException(ErrorCodeAndMsg.Save_Condition_Missing);
        }
        UserModel userModel =(UserModel) userService.findLoginUserModel(session);
        projectQuestionModel.setProjectCreatorName(userModel.getUserName());
        projectQuestionModel.setCreator(userModel.getUserId());
        projectQuestionModel = projectQuestionService.addProjectQuestion(projectQuestionModel);
        return new Response(projectQuestionModel);
    }

    @GetMapping("findQuestionByProjectId.action")
    public Response findQuestionByProjectId(@RequestParam("projectId") String projectId){
        ProjectQuestionModel projectQuestionModel = new ProjectQuestionModel();
        projectQuestionModel.setProjectId(projectId);
        Example<ProjectQuestionModel> projectQuestionModelExample = Example.of(projectQuestionModel);
        return new Response(Optional.ofNullable(projectQuestionService.findProjectQuestionsByExample(projectQuestionModelExample)).orElse(null));
    }

    @GetMapping("findQuestionByProjectQuestionId.action")
    public Response findQuestionByProjectQuestionId(@RequestParam("projectQuestionId") String projectQuestionId){

        ProjectQuestionModel projectQuestionModel = new ProjectQuestionModel();
        projectQuestionModel.setProjectQuestionId(projectQuestionId);
        Example<ProjectQuestionModel> projectQuestionModelExample = Example.of(projectQuestionModel);
        return new Response(Optional.ofNullable(projectQuestionService.findProjectQuestionsByExample(projectQuestionModelExample).get(0)).orElse(null));
    }

    @GetMapping("findQuestionByBelongId.action")
    public Response findQuestionByBelongId(@RequestParam("projectQuestionId") String projectQuestionId){
        ProjectQuestionModel projectQuestionModel = new ProjectQuestionModel();
        projectQuestionModel.setProjectQuestionBelong(projectQuestionId);
        Example<ProjectQuestionModel> projectQuestionModelExample = Example.of(projectQuestionModel);
        return new Response(Optional.ofNullable(projectQuestionService.findProjectQuestionsByExample(projectQuestionModelExample)).orElse(null));
    }

    @PostMapping("addNewCommment.action")
    public Response addNewCommment(@RequestBody ProjectQuestionModel projectQuestionModel,HttpSession session){
        if(StringUtils.isEmpty(projectQuestionModel.getProjectQuestionAnswer())){
            throw new ErrorsException(ErrorCodeAndMsg.Save_Condition_Missing);
        }
        if(StringUtils.isEmpty(projectQuestionModel.getProjectQuestionBelong())){
            throw new ErrorsException(ErrorCodeAndMsg.Save_Condition_Missing);
        }
        UserModel userModel =(UserModel) userService.findLoginUserModel(session);
        projectQuestionModel.setProjectCreatorName(userModel.getUserName());
        projectQuestionModel.setCreator(userModel.getUserId());
        projectQuestionModel = projectQuestionService.addProjectQuestion(projectQuestionModel);
        return new Response(projectQuestionModel);
    }

}
