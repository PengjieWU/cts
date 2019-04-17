package cn.pj.cts.service.impl;

import cn.pj.cts.dao.ProjectQuestionRepository;
import cn.pj.cts.model.ProjectQuestionModel;
import cn.pj.cts.service.ProjectQuestionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:Pengjie WU
 * @Description:TODO
 * @Date: Create in 18:03 2019/4/6
 * @Modify By:
 **/
@Service("projectQuestionService")
@Slf4j
public class ProjectQuestionServiceImpl implements ProjectQuestionService {

    @Autowired
    private ProjectQuestionRepository projectQuestionRepository;

    @Override
    public ProjectQuestionModel addProjectQuestion(ProjectQuestionModel projectQuestionModel) {
        return projectQuestionRepository.save(projectQuestionModel);
    }

    @Override
    public List<ProjectQuestionModel> addBacthProjectQuestions(List<ProjectQuestionModel> projectQuestionModels) {
        return null;
    }

    @Override
    public int updateProjectQuestion(ProjectQuestionModel projectQuestionModel) {
        return 0;
    }

    @Override
    public int updateBacthProjectQuestions(List<ProjectQuestionModel> projectQuestionModels) {
        return 0;
    }

    @Override
    public void deleteProjectQuestionById(String projectResourceInfoId) {

    }

    @Override
    public void deleteBacthProjectQuestions(List<ProjectQuestionModel> projectQuestionModels) {

    }

    @Override
    public boolean existsById(String projectResourceInfoId) {
        return false;
    }

    @Override
    public ProjectQuestionModel findProjectQuestionById(String projectQuestionId) {
        return projectQuestionRepository.getOne(projectQuestionId);
    }

    @Override
    public ProjectQuestionModel findByProjectQuestionLoginAccount(ProjectQuestionModel projectQuestionModel) {
        return null;
    }

    @Override
    public List<ProjectQuestionModel> findProjectQuestionsByExample(Example projectQuestionModel) {
        return projectQuestionRepository.findAll(projectQuestionModel);
    }
}
