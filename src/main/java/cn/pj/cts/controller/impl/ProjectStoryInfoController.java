package cn.pj.cts.controller.impl;

import cn.pj.cts.common.ErrorCodeAndMsg;
import cn.pj.cts.common.ErrorsException;
import cn.pj.cts.common.Response;
import cn.pj.cts.entity.ProjectStoryInfoEntity;
import cn.pj.cts.model.ProjectStoryInfoModel;
import cn.pj.cts.model.UserModel;
import cn.pj.cts.service.ProjectStoryInfoService;
import cn.pj.cts.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * @Author:Pengjie WU
 * @Description:TODO
 * @Date: Create in 16:23 2019/3/3
 * @Modify By:
 **/
@RestController
@Slf4j
@RequestMapping("projectstoryinfo")
public class ProjectStoryInfoController {
    @Autowired
    private ProjectStoryInfoService projectStoryInfoService;
    @Autowired
    private UserService userService;

    @PostMapping("addProjectStoryInfo.action")
    public Response addProjectStoryInfo(@RequestBody ProjectStoryInfoEntity projectStoryInfoEntity, HttpSession session){
        if(StringUtils.isEmpty(projectStoryInfoEntity.getProjectId())){
            throw new ErrorsException(ErrorCodeAndMsg.Save_Condition_Missing);
        }
        if(StringUtils.isEmpty(projectStoryInfoEntity.getProjectStoryName())){
            throw new ErrorsException(ErrorCodeAndMsg.Save_Condition_Missing);
        }
        if(StringUtils.isEmpty(projectStoryInfoEntity.getProjectStoryDescription())){
            throw new ErrorsException(ErrorCodeAndMsg.Save_Condition_Missing);
        }
        if(StringUtils.isEmpty(projectStoryInfoEntity.getProjectStoryDurationTime())){
            throw new ErrorsException(ErrorCodeAndMsg.Save_Condition_Missing);
        }
        if(StringUtils.isEmpty(projectStoryInfoEntity.getProjectStoryProgress())){
            throw new ErrorsException(ErrorCodeAndMsg.Save_Condition_Missing);
        }
        if(StringUtils.isEmpty(projectStoryInfoEntity.getProjectStoryTypeCode())){
            throw new ErrorsException(ErrorCodeAndMsg.Save_Condition_Missing);
        }

        projectStoryInfoEntity.setCreator(userService.findLoginUserModel(session).getUserId());
        projectStoryInfoEntity = projectStoryInfoService.addProjectStoryInfoEntity(projectStoryInfoEntity);
         return new Response(projectStoryInfoEntity);
    }

    @PostMapping("addProjectStoryInfoResource.action")
    public Response addProjectStoryInfoResource(@RequestParam("file")MultipartFile file,@RequestParam("storyId")String storyId){
        return new Response();
    }



    @GetMapping("findStoryInfoByProjectId.action")
    public Response findStoryInfoByProjectId(@RequestParam("projectId") String projectId){
        if(StringUtils.isEmpty(projectId)){
            throw new ErrorsException(ErrorCodeAndMsg.Query_Condition_Missing);
        }
        ProjectStoryInfoModel projectStoryInfoModel = new ProjectStoryInfoModel();
        projectStoryInfoModel.setProjectId(projectId);
        Example<ProjectStoryInfoModel> projectStoryInfoModelExample = Example.of(projectStoryInfoModel);
        return new Response(Optional.ofNullable(projectStoryInfoService.findProjectStoryInfosByExample(projectStoryInfoModelExample)).orElse(null));
    }

    @GetMapping("findStoryInfoByProjectIdAndMine.action")
    public Response findStoryInfoByProjectIdAndMine(@RequestParam("projectId") String projectId,HttpSession session){
        if(StringUtils.isEmpty(projectId)){
            throw new ErrorsException(ErrorCodeAndMsg.Query_Condition_Missing);
        }
        String userId = userService.findLoginUserModel(session).getUserId();
        ProjectStoryInfoModel projectStoryInfoModel = new ProjectStoryInfoModel();
        projectStoryInfoModel.setProjectId(projectId);
        projectStoryInfoModel.setTargetUserId(userId);
        Example<ProjectStoryInfoModel> projectStoryInfoModelExample = Example.of(projectStoryInfoModel);
        return new Response(Optional.ofNullable(projectStoryInfoService.findProjectStoryInfosByExample(projectStoryInfoModelExample)).orElse(null));
    }

    @GetMapping("findStoryInfoByProjectStoryId.action")
    public Response findStoryInfoByProjectStoryId(@RequestParam("projectStoryId") String projectStoryId){
        return new Response(projectStoryInfoService.findProjectStoryInfoById(projectStoryId));
    }

    @GetMapping("findUserByProjectStoryId.action")
    public Response findUserByProjectStoryId(@RequestParam("projectStoryId") String projectStoryId){
        return projectStoryInfoService.findUserByProjectStoryId(projectStoryId);
    }

    @PostMapping("updateProjectStoryInfo.action")
    public Response updateProjectStoryInfo(@RequestBody ProjectStoryInfoEntity projectStoryInfoEntity, HttpSession session){
        if(StringUtils.isEmpty(projectStoryInfoEntity.getProjectStoryTypeCode())){
            throw new ErrorsException(ErrorCodeAndMsg.Save_Condition_Missing);
        }
        if(StringUtils.isEmpty(projectStoryInfoEntity.getProjectStoryId())){
            throw new ErrorsException(ErrorCodeAndMsg.Save_Condition_Missing);
        }
        if(StringUtils.isEmpty(projectStoryInfoEntity.getProjectStoryName())){
            throw new ErrorsException(ErrorCodeAndMsg.Save_Condition_Missing);
        }
        if(StringUtils.isEmpty(projectStoryInfoEntity.getProjectStoryDescription())){
            throw new ErrorsException(ErrorCodeAndMsg.Save_Condition_Missing);
        }
        if(StringUtils.isEmpty(projectStoryInfoEntity.getProjectStoryDurationTime())){
            throw new ErrorsException(ErrorCodeAndMsg.Save_Condition_Missing);
        }
        if(StringUtils.isEmpty(projectStoryInfoEntity.getProjectStoryProgress())){
            throw new ErrorsException(ErrorCodeAndMsg.Save_Condition_Missing);
        }

        UserModel userModel = new UserModel();
        userModel.setUserId(projectStoryInfoEntity.getTargetUserId());
        Example<UserModel> userModelExample = Example.of(userModel);
        List<UserModel> userModels = userService.findUsersByExample(userModelExample);
        if(!CollectionUtils.isEmpty(userModels)){
            projectStoryInfoEntity.setTargetUserName(userModels.get(0).getUserName());
        }
        projectStoryInfoEntity.setModifier(userService.findLoginUserModel(session).getUserId());
        projectStoryInfoService.updateProjectStoryInfo(projectStoryInfoEntity);
        return new Response(projectStoryInfoEntity);
    }
}
