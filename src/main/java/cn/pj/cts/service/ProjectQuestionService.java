package cn.pj.cts.service;

import cn.pj.cts.model.ProjectQuestionModel;
import cn.pj.cts.model.ProjectResourceInfoModel;
import org.springframework.data.domain.Example;

import java.util.List;

import java.util.List;

/**
 * @Author:Pengjie WU
 * @Description:TODO
 * @Date: Create in 17:58 2019/4/6
 * @Modify By:
 **/
public interface ProjectQuestionService {

    ProjectQuestionModel addProjectQuestion(ProjectQuestionModel projectQuestionModel);

    List<ProjectQuestionModel> addBacthProjectQuestions(List<ProjectQuestionModel> projectQuestionModels);

    int updateProjectQuestion(ProjectQuestionModel projectQuestionModel);

    int updateBacthProjectQuestions(List<ProjectQuestionModel> projectQuestionModels);

    void deleteProjectQuestionById(String projectResourceInfoId);

    void deleteBacthProjectQuestions(List<ProjectQuestionModel> projectQuestionModels);

    boolean existsById(String projectResourceInfoId);

    ProjectQuestionModel findProjectQuestionById(String projectQuestionId);

    ProjectQuestionModel findByProjectQuestionLoginAccount(ProjectQuestionModel projectQuestionModel);

    List<ProjectQuestionModel> findProjectQuestionsByExample(Example projectQuestionModel);
}
