package cn.pj.cts.model;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author:Pengjie WU
 * @Description:TODO
 * @Date: Create in 11:20 2019/2/16
 * @Modify By:
 **/
@Entity
@Table(name = "TCS_PROJECT_INFO")
@GenericGenerator(name = "jpa-uuid",strategy = "uuid")
@DynamicInsert(true)
public class ProjectModel extends BaseModel {

    @Id
    @GeneratedValue(generator = "jpa-uuid")
    @Column(name = "PROJECT_ID",length = 32)
    private String projectId;

    @Column(name = "PROJECT_NAME")
    private String projectName;

    @Column(name = "PROJECT_COMPANY")
    private String projectCompany;

    @Column(name = "PROJECT_DESCRIPTION")
    private String projectDescription;

    @Column(name = "PROJECT_SECRECY")
    private String projectSecrecy;

    @Column(name = "PROJECT_DURATION_TIME")
    private String projectDurationTime;

    @Column(name = "PROJECT_CONTACT_EMAIL")
    private String projectContactEmail;

    @Column(name = "PROJECT_CONTACT_PHONE")
    private String projectContactPhone;

    @Column(name = "PORJECT_CONTACT_NAME")
    private String projectContactName;

    /**model共有属性状态*/
    @Column(name = "STATUS")
    private String status;
    /**model共有属性控制字*/
    @Column(name = "CONTROL_WORD")
    private String controlWord;
    /**model共有属性备注*/
    @Column(name = "REMARK")
    private String remark;
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

    public ProjectModel() {
        super();
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectCompany() {
        return projectCompany;
    }

    public void setProjectCompany(String projectCompany) {
        this.projectCompany = projectCompany;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public String getProjectSecrecy() {
        return projectSecrecy;
    }

    public void setProjectSecrecy(String projectSecrecy) {
        this.projectSecrecy = projectSecrecy;
    }

    public String getProjectDurationTime() {
        return projectDurationTime;
    }

    public void setProjectDurationTime(String projectDurationTime) {
        this.projectDurationTime = projectDurationTime;
    }

    public String getProjectContactEmail() {
        return projectContactEmail;
    }

    public void setProjectContactEmail(String projectContactEmail) {
        this.projectContactEmail = projectContactEmail;
    }

    public String getProjectContactPhone() {
        return projectContactPhone;
    }

    public void setProjectContactPhone(String projectContactPhone) {
        this.projectContactPhone = projectContactPhone;
    }

    public String getProjectContactName() {
        return projectContactName;
    }

    public void setProjectContactName(String projectContactName) {
        this.projectContactName = projectContactName;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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
