package cn.pj.cts.service;

import cn.pj.cts.common.Response;
import cn.pj.cts.entity.ProjectTaskInfoEntity;
import cn.pj.cts.model.ProjectTaskInfoModel;
import com.sun.deploy.net.HttpResponse;
import org.springframework.data.domain.Example;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Author:Pengjie WU
 * @Description:TODO
 * @Date: Create in 16:30 2019/3/3
 * @Modify By:
 **/
public interface ProjectTaskInfoService {
    ProjectTaskInfoModel addProjectTaskInfo(ProjectTaskInfoModel projectTaskInfoModel);

    List<ProjectTaskInfoModel> addBacthProjectTaskInfos(List<ProjectTaskInfoModel> projectTaskInfoModels);

    int updateProjectTaskInfo(ProjectTaskInfoModel projectTaskInfoModel);

    int updateBacthProjectTaskInfos(List<ProjectTaskInfoModel> projectTaskInfoModels);

    void deleteProjectTaskInfoById(String projectTaskInfoId);

    void deleteBacthProjectTaskInfos(List<ProjectTaskInfoModel> projectTaskInfoModels);

    boolean existsById(String projectTaskInfoId);

    ProjectTaskInfoModel findProjectTaskInfoById(String projectTaskInfoId);

    ProjectTaskInfoModel findByProjectTaskInfoLoginAccount(ProjectTaskInfoModel projectTaskInfoModel);

    List<ProjectTaskInfoModel> findProjectTaskInfosByExample(Example projectTaskInfoModel);

    ProjectTaskInfoModel findProjectTaskInfoListByCurrentdayAndLoginUser(ProjectTaskInfoModel projectTaskInfoModel);

    List<ProjectTaskInfoModel> findTaskInfoByProjectIdAndAllTeam(ProjectTaskInfoEntity projectTaskInfoEntity);

    void projectTaskAnalyse(ProjectTaskInfoEntity projectTaskInfoEntity,HttpServletResponse response) throws Exception;

    void wordAnalyse() throws Exception;
}
