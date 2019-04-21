package cn.pj.cts.dao;

import cn.pj.cts.model.ProjectModel;
import cn.pj.cts.model.ProjectStoryInfoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author:Pengjie WU
 * @Description:TODO
 * @Date: Create in 16:50 2019/3/3
 * @Modify By:
 **/
@Repository
public interface ProjectStoryInfoRepository extends JpaRepository<ProjectStoryInfoModel,String> {

    @Modifying
    @Query(value = "update TCS_PROJECT_STORY_INFO tpsi set " +
            " tpsi.PROJECT_STORY_ID = CASE WHEN :#{#projectStoryInfoModel.projectStoryId} IS NULL THEN tpsi.PROJECT_STORY_ID ELSE :#{#projectStoryInfoModel.projectStoryId} END ," +
            " tpsi.STORY_MNEMONIC_CODE = CASE WHEN :#{#projectStoryInfoModel.storyMnemonicCode} IS NULL THEN tpsi.STORY_MNEMONIC_CODE ELSE :#{#projectStoryInfoModel.storyMnemonicCode} END ," +
            " tpsi.PROJECT_ID = CASE WHEN :#{#projectStoryInfoModel.projectId} IS NULL THEN tpsi.PROJECT_ID ELSE :#{#projectStoryInfoModel.projectId} END ," +
            " tpsi.PROJECT_NAME = CASE WHEN :#{#projectStoryInfoModel.projectName} IS NULL THEN tpsi.PROJECT_NAME ELSE :#{#projectStoryInfoModel.projectName} END ," +
            " tpsi.TARGET_USER_ID = CASE WHEN :#{#projectStoryInfoModel.targetUserId} IS NULL THEN tpsi.TARGET_USER_ID ELSE :#{#projectStoryInfoModel.targetUserId} END ," +
            " tpsi.TARGET_USER_NAME = CASE WHEN :#{#projectStoryInfoModel.targetUserName} IS NULL THEN tpsi.TARGET_USER_NAME ELSE :#{#projectStoryInfoModel.targetUserName} END ," +
            " tpsi.PROJECT_STORY_NAME = CASE WHEN :#{#projectStoryInfoModel.projectStoryName} IS NULL THEN tpsi.PROJECT_STORY_NAME ELSE :#{#projectStoryInfoModel.projectStoryName} END ," +
            " tpsi.PROJECT_STORY_PRIORITY_CODE = CASE WHEN :#{#projectStoryInfoModel.projectStoryPriorityCode} IS NULL THEN tpsi.PROJECT_STORY_PRIORITY_CODE ELSE :#{#projectStoryInfoModel.projectStoryPriorityCode} END ," +
            " tpsi.PROJECT_STORY_PRIORITY_SEQ = CASE WHEN :#{#projectStoryInfoModel.projectStoryPrioritySeq} IS NULL THEN tpsi.PROJECT_STORY_PRIORITY_SEQ ELSE :#{#projectStoryInfoModel.projectStoryPrioritySeq} END ," +
            " tpsi.PROJECT_PARENT_STORY_ID = CASE WHEN :#{#projectStoryInfoModel.projectParentStoryId} IS NULL THEN tpsi.PROJECT_PARENT_STORY_ID ELSE :#{#projectStoryInfoModel.projectParentStoryId} END ," +
            " tpsi.PROJECT_STORY_DESCRIPTION = CASE WHEN :#{#projectStoryInfoModel.projectStoryDescription} IS NULL THEN tpsi.PROJECT_STORY_DESCRIPTION ELSE :#{#projectStoryInfoModel.projectStoryDescription} END ," +
            " tpsi.PROJECT_STORY_TYPE_CODE = CASE WHEN :#{#projectStoryInfoModel.projectStoryTypeCode} IS NULL THEN tpsi.PROJECT_STORY_TYPE_CODE ELSE :#{#projectStoryInfoModel.projectStoryTypeCode} END ," +
            " tpsi.PROJECT_STORY_PROGRESS = CASE WHEN :#{#projectStoryInfoModel.projectStoryProgress} IS NULL THEN tpsi.PROJECT_STORY_PROGRESS ELSE :#{#projectStoryInfoModel.projectStoryProgress} END ," +
            " tpsi.PROJECT_STORY_SEQ = CASE WHEN :#{#projectStoryInfoModel.projectStorySeq} IS NULL THEN tpsi.PROJECT_STORY_SEQ ELSE :#{#projectStoryInfoModel.projectStorySeq} END ," +
            " tpsi.PROJECT_STORY_DURATION_TIME = CASE WHEN :#{#projectStoryInfoModel.projectStoryDurationTime} IS NULL THEN tpsi.PROJECT_STORY_DURATION_TIME ELSE :#{#projectStoryInfoModel.projectStoryDurationTime} END ," +
            " tpsi.STATUS = CASE WHEN :#{#projectStoryInfoModel.status} IS NULL THEN tpsi.STATUS ELSE :#{#projectStoryInfoModel.status} END ," +
            " tpsi.CONTROL_WORD = CASE WHEN :#{#projectStoryInfoModel.controlWord} IS NULL THEN tpsi.CONTROL_WORD ELSE :#{#projectStoryInfoModel.controlWord} END ," +
            " tpsi.REMARK = CASE WHEN :#{#projectStoryInfoModel.remark} IS NULL THEN tpsi.REMARK ELSE :#{#projectStoryInfoModel.remark} END ," +
            " tpsi.CREATOR = CASE WHEN :#{#projectStoryInfoModel.creator} IS NULL THEN tpsi.CREATOR ELSE :#{#projectStoryInfoModel.creator} END ," +
            " tpsi.MODIFIER = CASE WHEN :#{#projectStoryInfoModel.modifier} IS NULL THEN tpsi.MODIFIER ELSE :#{#projectStoryInfoModel.modifier} END ," +
            " tpsi.REC_VER =  tpsi.REC_VER + 1 " +
            " where tpsi.PROJECT_STORY_ID = :#{#projectStoryInfoModel.projectStoryId}",nativeQuery = true)
    int update(@Param("projectStoryInfoModel") ProjectStoryInfoModel projectStoryInfoModel);

    List<ProjectStoryInfoModel> findByProjectStoryNameLike(String projectStoryName);
}
