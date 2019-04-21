package cn.pj.cts.controller.impl;

import cn.pj.cts.common.ErrorCodeAndMsg;
import cn.pj.cts.common.ErrorsException;
import cn.pj.cts.common.Response;
import cn.pj.cts.entity.ProjectTaskInfoEntity;
import cn.pj.cts.model.ProjectTaskInfoModel;
import cn.pj.cts.service.ProjectTaskInfoService;
import cn.pj.cts.service.UserService;
import com.sun.deploy.net.HttpResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author:Pengjie WU
 * @Description:TODO
 * @Date: Create in 16:26 2019/3/3
 * @Modify By:
 **/
@RestController
@Slf4j
@RequestMapping("projecttaskinfo")
public class ProjectTaskInfoController {

    @Autowired
    private UserService userService;
    @Autowired
    private ProjectTaskInfoService projectTaskInfoService;

    @GetMapping("findTaskInfoByProjectIdAndMySelf.action")
    public Response findTaskInfoByProjectIdAndMySelf(@RequestParam("projectId") String projectId,HttpSession session){
        ProjectTaskInfoModel projectTaskInfoModel = new ProjectTaskInfoModel();
        String userId = userService.findLoginUserModel(session).getUserId();
        projectTaskInfoModel.setProjectId(projectId);
        projectTaskInfoModel.setCreator(userId);
        return new Response(projectTaskInfoService.findProjectTaskInfoListByCurrentdayAndLoginUser(projectTaskInfoModel));
    }

    @PostMapping("submitTaskInfo.action")
    public Response submitTaskInfo(@RequestBody ProjectTaskInfoModel projectTaskInfoModel, HttpSession session){
        if(StringUtils.isEmpty(projectTaskInfoModel.getProjectTaskScheduleId())){
            return this.addTaskInfo(projectTaskInfoModel,session);
        }else{
            return this.updateTaskInfo(projectTaskInfoModel,session);
        }
    }

    public Response addTaskInfo(ProjectTaskInfoModel projectTaskInfoModel,HttpSession session){
        if(StringUtils.isEmpty(projectTaskInfoModel.getProjectTaskScheduleDoneValue())){
            throw  new ErrorsException(ErrorCodeAndMsg.Save_Condition_Missing);
        }
        if(StringUtils.isEmpty(projectTaskInfoModel.getProjectTaskScheduleTodoValue())){
            throw  new ErrorsException(ErrorCodeAndMsg.Save_Condition_Missing);
        }
        String userId = userService.findLoginUserModel(session).getUserId();
        projectTaskInfoModel.setCreator(userId);
        projectTaskInfoModel.setProjectTaskScheduleCreatorName(userService.findUserById(userId).getUserName());
        projectTaskInfoModel = projectTaskInfoService.addProjectTaskInfo(projectTaskInfoModel);
        return new Response(projectTaskInfoModel);
    }

    public Response updateTaskInfo(ProjectTaskInfoModel projectTaskInfoModel,HttpSession session){
        if(StringUtils.isEmpty(projectTaskInfoModel.getProjectTaskScheduleDoneValue())){
            throw  new ErrorsException(ErrorCodeAndMsg.Save_Condition_Missing);
        }
        if(StringUtils.isEmpty(projectTaskInfoModel.getProjectTaskScheduleTodoValue())){
            throw  new ErrorsException(ErrorCodeAndMsg.Save_Condition_Missing);
        }
        String userId = userService.findLoginUserModel(session).getUserId();
        projectTaskInfoModel.setModifier(userId);
        projectTaskInfoService.updateProjectTaskInfo(projectTaskInfoModel);
        return new Response(projectTaskInfoModel);
    }

    @PostMapping("findTaskInfoByProjectIdAndAllTeam.action")
    public Response findTaskInfoByProjectIdAndAllTeam(@RequestBody ProjectTaskInfoEntity projectTaskInfoEntity){
        if(StringUtils.isEmpty(projectTaskInfoEntity.getProjectId())){
            throw  new ErrorsException(ErrorCodeAndMsg.Query_Condition_Missing);
        }
        if(StringUtils.isEmpty(projectTaskInfoEntity.getSelectDay())){
            throw  new ErrorsException(ErrorCodeAndMsg.Query_Condition_Missing);
        }
        return new Response(projectTaskInfoService.findTaskInfoByProjectIdAndAllTeam(projectTaskInfoEntity));
    }

    @GetMapping("findTaskInfoByProjectIdAndAllTeam.action")
    public Response findTaskInfoByProjectIdAndAllTeamAnCurrentDay(@RequestParam("projectId") String projectId){
        ProjectTaskInfoEntity projectTaskInfoEntity = new ProjectTaskInfoEntity();
        projectTaskInfoEntity.setProjectId(projectId);
        projectTaskInfoEntity.setSelectDay(new Date());

        return new Response(projectTaskInfoService.findTaskInfoByProjectIdAndAllTeam(projectTaskInfoEntity));
    }

    @GetMapping("projectTaskAnalyse.action")
    public void   projectTaskAnalyse(@RequestParam("projectId") String projectId, @RequestParam("selectDay") String selectDay, HttpServletResponse response) throws Exception{
        ProjectTaskInfoEntity projectTaskInfoEntity = new ProjectTaskInfoEntity();
        projectTaskInfoEntity.setProjectId(projectId);
        DateFormat fmt =new SimpleDateFormat("MM/dd/yyyy");
        Date date = fmt.parse(selectDay);
        projectTaskInfoEntity.setSelectDay(date);
        try {
            projectTaskInfoService.projectTaskAnalyse(projectTaskInfoEntity,response);
        }catch (Exception e){

        }

    }



}
