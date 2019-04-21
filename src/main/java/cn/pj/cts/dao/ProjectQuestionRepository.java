package cn.pj.cts.dao;

import cn.pj.cts.model.ProjectQuestionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @Author:Pengjie WU
 * @Description:TODO
 * @Date: Create in 18:05 2019/4/6
 * @Modify By:
 **/
@Repository
public interface ProjectQuestionRepository extends JpaRepository<ProjectQuestionModel,String> {

    @Modifying
    @Query(value = "update TCS_PROJECT_QUESTION_INFO tpq set " +
            " tpq.PROJECT_QUESION_ID = CASE WHEN :#{#projectQuestionModel.projectQuestionId} IS NULL THEN tpq.PROJECT_QUESION_ID ELSE :#{#projectQuestionModel.projectQuestionId} END ," +
            " tpq.PROJECT_ID = CASE WHEN :#{#projectQuestionModel.projectId} IS NULL THEN tpq.PROJECT_ID ELSE :#{#projectQuestionModel.projectId} END ," +
            " tpq.PROJECT_QUESTION_KEYWORD = CASE WHEN :#{#projectQuestionModel.projectQuestionKeyword} IS NULL THEN tpq.PROJECT_QUESTION_KEYWORD ELSE :#{#projectQuestionModel.projectQuestionKeyword} END ," +
            " tpq.PROJECT_QUESTION_DESCRIPTION = CASE WHEN :#{#projectQuestionModel.projectQuestionDescription} IS NULL THEN tpq.PROJECT_QUESTION_DESCRIPTION ELSE :#{#projectQuestionModel.projectQuestionDescription} END ," +
            " tpq.PROJECT_STORY_ID = CASE WHEN :#{#projectQuestionModel.projectStoryId} IS NULL THEN tpq.PROJECT_STORY_ID ELSE :#{#projectQuestionModel.projectStoryId} END ," +
            " tpq.PROJECT_STORY_NAME = CASE WHEN :#{#projectQuestionModel.projectStoryName} IS NULL THEN tpq.PROJECT_STORY_NAME ELSE :#{#projectQuestionModel.projectStoryName} END ," +
            " tpq.PROJECT_QUESTION_ANSWER = CASE WHEN :#{#projectQuestionModel.projectQuestionAnswer} IS NULL THEN tpq.PROJECT_QUESTION_ANSWER ELSE :#{#projectQuestionModel.projectQuestionAnswer} END ," +
            " tpq.PROJECT_QUESTION_BELONG = CASE WHEN :#{#projectQuestionModel.projectQuestionBelong} IS NULL THEN tpq.PROJECT_QUESTION_BELONG ELSE :#{#projectQuestionModel.projectQuestionBelong} END ," +
            " tpq.PROJECT_CREATOR_NAME = CASE WHEN :#{#projectQuestionModel.projectCreatorName} IS NULL THEN tpq.PROJECT_CREATOR_NAME ELSE :#{#projectQuestionModel.projectCreatorName} END ," +
            " tpq.STATUS = CASE WHEN :#{#projectQuestionModel.status} IS NULL THEN tpq.STATUS ELSE :#{#projectQuestionModel.status} END ," +
            " tpq.CONTROL_WORD = CASE WHEN :#{#projectQuestionModel.controlWord} IS NULL THEN tpq.CONTROL_WORD ELSE :#{#projectQuestionModel.controlWord} END ," +
            " tpq.REMARK = CASE WHEN :#{#projectQuestionModel.remark} IS NULL THEN tpq.REMARK ELSE :#{#projectQuestionModel.remark} END ," +
            " tpq.CREATOR = CASE WHEN :#{#projectQuestionModel.creator} IS NULL THEN tpq.CREATOR ELSE :#{#projectQuestionModel.creator} END ," +
            " tpq.MODIFIER = CASE WHEN :#{#projectQuestionModel.modifier} IS NULL THEN tpq.MODIFIER ELSE :#{#projectQuestionModel.modifier} END ," +
            " tpq.REC_VER =  tpq.REC_VER + 1 " +
            " where tpq.PROJECT_QUESION_ID = :#{#projectQuestionModel.projectQuestionId}",nativeQuery = true)
    int update(@Param("projectQuestionModel") ProjectQuestionModel projectQuestionModel);
}
