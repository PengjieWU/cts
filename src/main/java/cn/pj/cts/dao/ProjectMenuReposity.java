package cn.pj.cts.dao;
import cn.pj.cts.model.ProjectMenuModel;
import cn.pj.cts.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
/**
 * @Author:Pengjie WU
 * @Description:TODO
 * @Date: Create in 20:47 2019/4/14
 * @Modify By:
 **/
@Repository
public interface ProjectMenuReposity extends JpaRepository<ProjectMenuModel,String> {

    @Modifying
    @Query(value = "update TCS_PRPJECT_MENU_INFO tpmi set " +
            " tpmi.PROJECT_MENU_ID = CASE WHEN :#{#projectMenuModel.projectMenuId} IS NULL THEN tpmi.PROJECT_MENU_ID ELSE :#{#projectMenuModel.projectMenuId} END ," +
            " tpmi.PROJECT_ID = CASE WHEN :#{#projectMenuModel.projectId} IS NULL THEN tpmi.PROJECT_ID ELSE :#{#projectMenuModel.projectId} END ," +
            " tpmi.MENU_ID = CASE WHEN :#{#projectMenuModel.menuId} IS NULL THEN tpmi.MENU_ID ELSE :#{#projectMenuModel.menuId} END ," +
            " tpmi.GRANTOR_ID = CASE WHEN :#{#projectMenuModel.grantorId} IS NULL THEN tpmi.GRANTOR_ID ELSE :#{#projectMenuModel.grantorId} END ," +
            " tpmi.RECEIVE_ID = CASE WHEN :#{#projectMenuModel.receiveId} IS NULL THEN tpmi.RECEIVE_ID ELSE :#{#projectMenuModel.receiveId} END ," +
            " tpmi.STATUS = CASE WHEN :#{#projectMenuModel.status} IS NULL THEN tpmi.STATUS ELSE :#{#projectMenuModel.status} END ," +
            " tpmi.CONTROL_WORD = CASE WHEN :#{#projectMenuModel.controlWord} IS NULL THEN tpmi.CONTROL_WORD ELSE :#{#projectMenuModel.controlWord} END ," +
            " tpmi.REMARK = CASE WHEN :#{#projectMenuModel.remark} IS NULL THEN tpmi.REMARK ELSE :#{#projectMenuModel.remark} END ," +
            " tpmi.CREATOR = CASE WHEN :#{#projectMenuModel.creator} IS NULL THEN tpmi.CREATOR ELSE :#{#projectMenuModel.creator} END ," +
            " tpmi.MODIFIER = CASE WHEN :#{#projectMenuModel.modifier} IS NULL THEN tpmi.MODIFIER ELSE :#{#projectMenuModel.modifier} END ," +
            " tpmi.REC_VER =  tpmi.REC_VER + 1 " +
            " where tpmi.PROJECT_MENU_ID = :#{#projectMenuModel.projectMenuId}",nativeQuery = true)
    int update(@Param("projectMenuModel") ProjectMenuModel projectMenuModel);
}
