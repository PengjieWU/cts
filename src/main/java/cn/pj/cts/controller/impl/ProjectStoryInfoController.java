package cn.pj.cts.controller.impl;

import cn.pj.cts.common.ErrorCodeAndMsg;
import cn.pj.cts.common.ErrorsException;
import cn.pj.cts.common.Response;
import cn.pj.cts.entity.ProjectStoryInfoEntity;
import cn.pj.cts.model.ProjectStoryInfoModel;
import cn.pj.cts.service.ProjectStoryInfoService;
import cn.pj.cts.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
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
}
