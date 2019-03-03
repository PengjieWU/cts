package cn.pj.cts.dao;

import cn.pj.cts.model.ProjectModel;

import cn.pj.cts.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author:Pengjie WU
 * @Description:TODO
 * @Date: Create in 12:08 2019/2/16
 * @Modify By:
 **/
@Repository
public interface ProjectRepository extends JpaRepository<ProjectModel,String> {


    @Modifying
    @Query(value = "update TCS_PROJECT_INFO tpi set " +
            " tpi.PROJECT_ID = CASE WHEN :#{#projectModel.projectId} IS NULL THEN tpi.PROJECT_ID ELSE :#{#projectModel.projectId} END ," +
            " tpi.PROJECT_NAME = CASE WHEN :#{#projectModel.projectName} IS NULL THEN tpi.PROJECT_NAME ELSE :#{#projectModel.projectName} END ," +
            " tpi.PROJECT_COMPANY = CASE WHEN :#{#projectModel.projectCompany} IS NULL THEN tpi.PROJECT_COMPANY ELSE :#{#projectModel.projectCompany} END ," +
            " tpi.PROJECT_DESCRIPTION = CASE WHEN :#{#projectModel.projectDescription} IS NULL THEN tpi.PROJECT_DESCRIPTION ELSE :#{#projectModel.projectDescription} END ," +
            " tpi.PROJECT_SECRECY = CASE WHEN :#{#projectModel.projectSecrecy} IS NULL THEN tpi.PROJECT_SECRECY ELSE :#{#projectModel.projectSecrecy} END ," +
            " tpi.PROJECT_DURATION_TIME = CASE WHEN :#{#projectModel.projectDurationTime} IS NULL THEN tpi.PROJECT_DURATION_TIME ELSE :#{#projectModel.projectDurationTime} END ," +
            " tpi.PROJECT_CONTACT_EMAIL = CASE WHEN :#{#projectModel.projectContactEmail} IS NULL THEN tpi.PROJECT_CONTACT_EMAIL ELSE :#{#projectModel.projectContactEmail} END ," +
            " tpi.PORJECT_CONTACT_NAME = CASE WHEN :#{#projectModel.projectContactName} IS NULL THEN tpi.PORJECT_CONTACT_NAME ELSE :#{#projectModel.projectContactName} END ," +
            " tpi.PROJECT_CONTACT_PHONE = CASE WHEN :#{#projectModel.projectContactPhone} IS NULL THEN tpi.PROJECT_CONTACT_PHONE ELSE :#{#projectModel.projectContactPhone} END ," +
            " tpi.STATUS = CASE WHEN :#{#projectModel.status} IS NULL THEN tpi.STATUS ELSE :#{#projectModel.status} END ," +
            " tpi.CONTROL_WORD = CASE WHEN :#{#projectModel.controlWord} IS NULL THEN tpi.CONTROL_WORD ELSE :#{#projectModel.controlWord} END ," +
            " tpi.REMARK = CASE WHEN :#{#projectModel.remark} IS NULL THEN tpi.REMARK ELSE :#{#projectModel.remark} END ," +
            " tpi.CREATOR = CASE WHEN :#{#projectModel.creator} IS NULL THEN tpi.CREATOR ELSE :#{#projectModel.creator} END ," +
            " tpi.MODIFIER = CASE WHEN :#{#projectModel.modifier} IS NULL THEN tpi.MODIFIER ELSE :#{#projectModel.modifier} END ," +
            " tpi.REC_VER =  tpi.REC_VER + 1 " +
            " where tpi.PROJECT_ID = :#{#projectModel.projectId}",nativeQuery = true)
    int update(@Param("projectModel") ProjectModel projectModel);

    List<ProjectModel> findByCreator(String creator);
}
