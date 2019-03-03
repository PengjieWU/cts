package cn.pj.cts.dao;

import org.springframework.data.repository.query.Param;
import cn.pj.cts.model.UserProjectModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Repository;

/**
 * @Author:Pengjie WU
 * @Description:TODO
 * @Date: Create in 12:26 2019/2/16
 * @Modify By:
 **/
@Repository
public interface UserProjectRepository extends JpaRepository<UserProjectModel,String> {

    @Modifying
    @Query(value = "update TCS_USER_PROJECT_INFO tupi set " +
            " tupi.USER_PROJECT_ID = CASE WHEN :#{#userPorjectModel.userProjectId} IS NULL THEN tupi.USER_PROJECT_ID ELSE :#{#userPorjectModel.userProjectId} END ," +
            " tupi.USER_ID = CASE WHEN :#{#userPorjectModel.userId} IS NULL THEN tupi.USER_ID ELSE :#{#userPorjectModel.userId} END ," +
            " tupi.PROJECT_ID = CASE WHEN :#{#userPorjectModel.projectId} IS NULL THEN tupi.PROJECT_ID ELSE :#{#userPorjectModel.projectId} END ," +
            " tupi.STATUS = CASE WHEN :#{#userPorjectModel.status} IS NULL THEN tupi.STATUS ELSE :#{#userPorjectModel.status} END ," +
            " tupi.CONTROL_WORD = CASE WHEN :#{#userPorjectModel.controlWord} IS NULL THEN tupi.CONTROL_WORD ELSE :#{#userPorjectModel.controlWord} END ," +
            " tupi.REMARK = CASE WHEN :#{#userPorjectModel.remark} IS NULL THEN tupi.REMARK ELSE :#{#userPorjectModel.remark} END ," +
            " tupi.CREATOR = CASE WHEN :#{#userPorjectModel.creator} IS NULL THEN tupi.CREATOR ELSE :#{#userPorjectModel.creator} END ," +
            " tupi.MODIFIER = CASE WHEN :#{#userPorjectModel.modifier} IS NULL THEN tupi.MODIFIER ELSE :#{#userPorjectModel.modifier} END ," +
            " tupi.REC_VER =  tupi.REC_VER + 1 " +
            " where tupi.USER_PROJECT_ID = :#{#userPorjectModel.userProjectId}",nativeQuery = true)
    int update(@Param("userPorjectModel") UserProjectModel userPorjectModel);
}
