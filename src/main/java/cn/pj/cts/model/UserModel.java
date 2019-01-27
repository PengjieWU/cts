package cn.pj.cts.model;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author:Pengjie WU
 * @Description:TODO
 * @Date: Create in 22:59 2019/1/17
 * @Modify By:
 **/
@Entity
@Table(name = "TCS_USER_INFO")
@GenericGenerator(name = "jpa-uuid",strategy = "uuid")
public class UserModel extends BaseModel {
    /**用户id*/
    @Id
    @GeneratedValue(generator = "jpa-uuid")
    @Column(name = "USER_ID",length = 32)
    private String userId;
    /**用户登录邮箱*/
    @Column(name = "USER_LOGIN_ACCOUNT")
    private String userLoginAccount;
    /**用户名称*/
    @Column(name = "USER_NAME")
    private String userName;
    /**用户密码*/
    @Column(name = "USER_PASSWORD")
    private String userPassword;
    /**用户头像*/
    @Column(name = "USER_PHOTO")
    private String userPhoto;
    /**model共有属性状态*/
    @Column(name = "STATUS")
    @Generated(GenerationTime.INSERT)
    private String status;
    /**model共有属性控制字*/
    @Column(name = "CONTROL_WORD")
    private String controlWord;
    /**model共有属性创建者*/
    @Column(name = "CREATOR")
    private String creator;
    /**model共有属性创建属性*/
    @Column(name = "CREATOR_DATETIME")
    private Date creatorDateTime;
    /**model共有属性修改者*/
    @Column(name = "MODIFIER")
    private String modifier;
    /**model共有属性修改时间*/
    @Column(name = "MODIFIER_DATETIME")
    private Date modifierDateTime;
    /**model共有属性版本控制*/
    @Column(name = "REC_VER")
    private Integer recVer;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserLoginAccount() {
        return userLoginAccount;
    }

    public void setUserLoginAccount(String userLoginAccount) {
        this.userLoginAccount = userLoginAccount;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserPhoto() {
        return userPhoto;
    }

    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto;
    }

     
    public String getStatus() {
        return status;
    }

     
    public void setStatus(String status) {
        this.status = status;
    }

     
    public String getControlWord() {
        return controlWord;
    }

     
    public void setControlWord(String controlWord) {
        this.controlWord = controlWord;
    }

     
    public String getCreator() {
        return creator;
    }

     
    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getCreatorDateTime() {
        return creatorDateTime;
    }

    public void setCreatorDateTime(Date creatorDateTime) {
        this.creatorDateTime = creatorDateTime;
    }

    public String getModifier() {
        return modifier;
    }

     
    public void setModifier(String modifier) {
        this.modifier = modifier;
    }


    public Date getModifierDateTime() {
        return modifierDateTime;
    }

    public void setModifierDateTime(Date modifierDateTime) {
        this.modifierDateTime = modifierDateTime;
    }

    public Integer getRecVer() {
        return recVer;
    }

    public void setRecVer(Integer recVer) {
        this.recVer = recVer;
    }
}
