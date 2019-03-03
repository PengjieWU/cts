package cn.pj.cts.dao;

import cn.pj.cts.model.ProjectModel;
import cn.pj.cts.model.ProjectTaskInfoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
/**
 * @Author:Pengjie WU
 * @Description:TODO
 * @Date: Create in 16:52 2019/3/3
 * @Modify By:
 **/
@Repository
public interface ProjectTaskInfoRepository extends JpaRepository<ProjectTaskInfoModel,String> {
    @Modifying
    @Query(value = "update TCS_PROJECT_TASK_INFO tpti set " +
            " tpti.PROJECT_TASK_SCHEDULE_ID = CASE WHEN :#{#projectTaskInfoModel.projectTaskScheduleId} IS NULL THEN tpti.PROJECT_TASK_SCHEDULE_ID ELSE :#{#projectTaskInfoModel.projectTaskScheduleId} END ," +
            " tpti.PROJECT_ID = CASE WHEN :#{#projectTaskInfoModel.projectId} IS NULL THEN tpti.PROJECT_ID ELSE :#{#projectTaskInfoModel.projectId} END ," +
            " tpti.PROJECT_RESOURCE_ID = CASE WHEN :#{#projectTaskInfoModel.projectResourceId} IS NULL THEN tpti.PROJECT_RESOURCE_ID ELSE :#{#projectTaskInfoModel.projectResourceId} END ," +
            " tpti.PROJECT_TASK_RESOURCE_NAME = CASE WHEN :#{#projectTaskInfoModel.projectTaskResourceName} IS NULL THEN tpti.PROJECT_TASK_RESOURCE_NAME ELSE :#{#projectTaskInfoModel.projectTaskResourceName} END ," +
            " tpti.PROJECT_TASK_RESOURCE_TYPE = CASE WHEN :#{#projectTaskInfoModel.projectTaskResourceType} IS NULL THEN tpti.PROJECT_TASK_RESOURCE_TYPE ELSE :#{#projectTaskInfoModel.projectTaskResourceType} END ," +
            " tpti.PROJECT_TASK_SCHEDULE_TYPE_CODE = CASE WHEN :#{#projectTaskInfoModel.projectTaskScheduleTypeCode} IS NULL THEN tpti.PROJECT_TASK_SCHEDULE_TYPE_CODE ELSE :#{#projectTaskInfoModel.projectTaskScheduleTypeCode} END ," +
            " tpti.PROJECT_TASK_SCHEDULE_VALUE = CASE WHEN :#{#projectTaskInfoModel.projectTaskScheduleValue} IS NULL THEN tpti.PROJECT_TASK_SCHEDULE_VALUE ELSE :#{#projectTaskInfoModel.projectTaskScheduleValue} END ," +
            " tpti.PROJECT_STORY_PRIORITY_SEQ = CASE WHEN :#{#projectTaskInfoModel.projectStoryPrioritySeq} IS NULL THEN tpti.PROJECT_STORY_PRIORITY_SEQ ELSE :#{#projectTaskInfoModel.projectStoryPrioritySeq} END ," +
            " tpti.PROJECT_PARENT_STORY_ID = CASE WHEN :#{#projectTaskInfoModel.projectParentStoryId} IS NULL THEN tpti.PROJECT_PARENT_STORY_ID ELSE :#{#projectTaskInfoModel.projectParentStoryId} END ," +
            " tpti.PROJECT_STORY_DESCRIPTION = CASE WHEN :#{#projectTaskInfoModel.projectStoryDescription} IS NULL THEN tpti.PROJECT_STORY_DESCRIPTION ELSE :#{#projectTaskInfoModel.projectStoryDescription} END ," +
            " tpti.PROJECT_STORY_TYPE_CODE = CASE WHEN :#{#projectTaskInfoModel.projectStoryTypeCode} IS NULL THEN tpti.PROJECT_STORY_TYPE_CODE ELSE :#{#projectTaskInfoModel.projectStoryTypeCode} END ," +
            " tpti.PROJECT_STORY_PROGRESS = CASE WHEN :#{#projectTaskInfoModel.projectStoryProgress} IS NULL THEN tpti.PROJECT_STORY_PROGRESS ELSE :#{#projectTaskInfoModel.projectStoryProgress} END ," +
            " tpti.PROJECT_STORY_SEQ = CASE WHEN :#{#projectTaskInfoModel.projectStorySeq} IS NULL THEN tpti.PROJECT_STORY_SEQ ELSE :#{#projectTaskInfoModel.projectStorySeq} END ," +
            " tpti.PROJECT_STORY_DURATION_TIME = CASE WHEN :#{#projectTaskInfoModel.projectStoryDurationTime} IS NULL THEN tpti.PROJECT_STORY_DURATION_TIME ELSE :#{#projectTaskInfoModel.projectStoryDurationTime} END ," +
            " tpti.STATUS = CASE WHEN :#{#projectTaskInfoModel.status} IS NULL THEN tpti.STATUS ELSE :#{#projectTaskInfoModel.status} END ," +
            " tpti.CONTROL_WORD = CASE WHEN :#{#projectTaskInfoModel.controlWord} IS NULL THEN tpti.CONTROL_WORD ELSE :#{#projectTaskInfoModel.controlWord} END ," +
            " tpti.REMARK = CASE WHEN :#{#projectTaskInfoModel.remark} IS NULL THEN tpti.REMARK ELSE :#{#projectTaskInfoModel.remark} END ," +
            " tpti.CREATOR = CASE WHEN :#{#projectTaskInfoModel.creator} IS NULL THEN tpti.CREATOR ELSE :#{#projectTaskInfoModel.creator} END ," +
            " tpti.MODIFIER = CASE WHEN :#{#projectTaskInfoModel.modifier} IS NULL THEN tpti.MODIFIER ELSE :#{#projectTaskInfoModel.modifier} END ," +
            " tpti.REC_VER =  tpti.REC_VER + 1 " +
            " where tpti.PROJECT_STORY_ID = :#{#projectTaskInfoModel.projectStoryId}",nativeQuery = true)
    int update(@Param("projectTaskInfoModel") ProjectTaskInfoModel projectTaskInfoModel);
}

