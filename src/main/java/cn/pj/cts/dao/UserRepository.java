package cn.pj.cts.dao;

import cn.pj.cts.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @Author:Pengjie WU
 * @Description:TODO
 * @Date: Create in 23:46 2019/1/17
 * @Modify By:
 **/
@Repository
public interface UserRepository extends JpaRepository<UserModel,String> {

    @Modifying
    @Query(value = "update TCS_USER_INFO tui set " +
            " tui.USER_ID = CASE WHEN :#{#userModel.userId} IS NULL THEN tui.USER_ID ELSE :#{#userModel.userId} END ," +
            " tui.USER_LOGIN_ACCOUNT = CASE WHEN :#{#userModel.userLoginAccount} IS NULL THEN tui.USER_LOGIN_ACCOUNT ELSE :#{#userModel.userLoginAccount} END ," +
            " tui.USER_NAME = CASE WHEN :#{#userModel.userName} IS NULL THEN tui.USER_NAME ELSE :#{#userModel.userName} END ," +
            " tui.USER_PASSWORD = CASE WHEN :#{#userModel.userPassword} IS NULL THEN tui.USER_PASSWORD ELSE :#{#userModel.userPassword} END ," +
            " tui.USER_PHOTO = CASE WHEN :#{#userModel.userPhoto} IS NULL THEN tui.USER_PHOTO ELSE :#{#userModel.userPhoto} END ," +
            " tui.STATUS = CASE WHEN :#{#userModel.status} IS NULL THEN tui.STATUS ELSE :#{#userModel.status} END ," +
            " tui.CONTROL_WORD = CASE WHEN :#{#userModel.controlWord} IS NULL THEN tui.CONTROL_WORD ELSE :#{#userModel.controlWord} END ," +
            " tui.REMARK = CASE WHEN :#{#userModel.remark} IS NULL THEN tui.REMARK ELSE :#{#userModel.remark} END ," +
            " tui.CREATOR = CASE WHEN :#{#userModel.creator} IS NULL THEN tui.CREATOR ELSE :#{#userModel.creator} END ," +
            " tui.MODIFIER = CASE WHEN :#{#userModel.modifier} IS NULL THEN tui.MODIFIER ELSE :#{#userModel.modifier} END ," +
            " tui.REC_VER =  tui.REC_VER + 1 " +
            " where tui.USER_ID = :#{#userModel.userId}",nativeQuery = true)
    int update(@Param("userModel") UserModel userModel);

}
