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

import java.util.List;

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
            " tpti.PROJECT_TASK_SCHEDULE_DONE_VALUE = CASE WHEN :#{#projectTaskInfoModel.projectTaskScheduleDoneValue} IS NULL THEN tpti.PROJECT_TASK_SCHEDULE_DONE_VALUE ELSE :#{#projectTaskInfoModel.projectTaskScheduleDoneValue} END ," +
            " tpti.PROJECT_TASK_SCHEDULE_PROBLEM_VALUE = CASE WHEN :#{#projectTaskInfoModel.projectTaskScheduleProblemValue} IS NULL THEN tpti.PROJECT_TASK_SCHEDULE_PROBLEM_VALUE ELSE :#{#projectTaskInfoModel.projectTaskScheduleProblemValue} END ," +
            " tpti.PROJECT_TASK_SCHEDULE_TODO_VALUE = CASE WHEN :#{#projectTaskInfoModel.projectTaskScheduleTodoValue} IS NULL THEN tpti.PROJECT_TASK_SCHEDULE_TODO_VALUE ELSE :#{#projectTaskInfoModel.projectTaskScheduleTodoValue} END ," +
            " tpti.PROJECT_TASK_SCHEDULE_CREATOR_NAME = CASE WHEN :#{#projectTaskInfoModel.projectTaskScheduleCreatorName} IS NULL THEN tpti.PROJECT_TASK_SCHEDULE_CREATOR_NAME ELSE :#{#projectTaskInfoModel.projectTaskScheduleCreatorName} END ," +
            " tpti.STATUS = CASE WHEN :#{#projectTaskInfoModel.status} IS NULL THEN tpti.STATUS ELSE :#{#projectTaskInfoModel.status} END ," +
            " tpti.CONTROL_WORD = CASE WHEN :#{#projectTaskInfoModel.controlWord} IS NULL THEN tpti.CONTROL_WORD ELSE :#{#projectTaskInfoModel.controlWord} END ," +
            " tpti.REMARK = CASE WHEN :#{#projectTaskInfoModel.remark} IS NULL THEN tpti.REMARK ELSE :#{#projectTaskInfoModel.remark} END ," +
            " tpti.CREATOR = CASE WHEN :#{#projectTaskInfoModel.creator} IS NULL THEN tpti.CREATOR ELSE :#{#projectTaskInfoModel.creator} END ," +
            " tpti.MODIFIER = CASE WHEN :#{#projectTaskInfoModel.modifier} IS NULL THEN tpti.MODIFIER ELSE :#{#projectTaskInfoModel.modifier} END ," +
            " tpti.REC_VER =  tpti.REC_VER + 1 " +
            " where tpti.PROJECT_TASK_SCHEDULE_ID = :#{#projectTaskInfoModel.projectTaskScheduleId}",nativeQuery = true)
    int update(@Param("projectTaskInfoModel") ProjectTaskInfoModel projectTaskInfoModel);



    @Query(value = " select tpti.* from TCS_PROJECT_TASK_INFO tpti " +
            " where 1 = 1 "  +
            " AND tpti.creator = :creator " +
            " AND tpti.PROJECT_ID = :projectId " +
            " AND DATE_FORMAT(tpti.CREATOR_DATETIME, '%Y%m%d') = :dateStr ",nativeQuery = true)
    ProjectTaskInfoModel findProjectTaskInfosByExample(@Param("projectId")String projectId,@Param("creator") String creator,@Param("dateStr") String dateStr);


    @Query(value = " select tpti.* from TCS_PROJECT_TASK_INFO tpti " +
            " where 1 = 1 "  +
            " AND tpti.PROJECT_ID = :projectId " +
            " AND DATE_FORMAT(tpti.CREATOR_DATETIME, '%Y%m%d') = :dateStr ",nativeQuery = true)
    List<ProjectTaskInfoModel> findTaskInfoByProjectIdAndAllTeam(@Param("projectId") String projectId,@Param("dateStr") String dateStr);
}

