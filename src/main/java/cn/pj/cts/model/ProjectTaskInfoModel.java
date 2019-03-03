package cn.pj.cts.model;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author:Pengjie WU
 * @Description:TODO
 * @Date: Create in 15:28 2019/3/3
 * @Modify By:
 **/
@Entity
@Table(name = "TCS_PROJECT_TASK_INFO")
@GenericGenerator(name = "jpa-uuid",strategy = "uuid")
@DynamicInsert(true)
public class ProjectTaskInfoModel extends BaseModel {

    @Id
    @GeneratedValue(generator = "jpa-uuid")
    @Column(name = "PROJECT_TASK_SCHEDULE_ID",length = 32)
    private String projectTaskScheduleId;
    @Column(name = "PROJECT_ID")
    private String projectId;
    @Column(name = "PROJECT_RESOURCE_ID")
    private String projectResourceId;
    @Column(name = "PROJECT_TASK_RESOURCE_NAME")
    private String projectTaskResourceName;
    @Column(name = "PROJECT_TASK_RESOURCE_TYPE")
    private String projectTaskResourceType;
    @Column(name = "PROJECT_TASK_SCHEDULE_TYPE_CODE")
    private String projectTaskScheduleTypeCode;
    @Column(name = "PROJECT_TASK_SCHEDULE_VALUE")
    private String projectTaskScheduleValue;
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

    public ProjectTaskInfoModel() {
        super();
    }

    public String getProjectTaskScheduleId() {
        return projectTaskScheduleId;
    }

    public void setProjectTaskScheduleId(String projectTaskScheduleId) {
        this.projectTaskScheduleId = projectTaskScheduleId;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getProjectResourceId() {
        return projectResourceId;
    }

    public void setProjectResourceId(String projectResourceId) {
        this.projectResourceId = projectResourceId;
    }

    public String getProjectTaskResourceName() {
        return projectTaskResourceName;
    }

    public void setProjectTaskResourceName(String projectTaskResourceName) {
        this.projectTaskResourceName = projectTaskResourceName;
    }

    public String getProjectTaskResourceType() {
        return projectTaskResourceType;
    }

    public void setProjectTaskResourceType(String projectTaskResourceType) {
        this.projectTaskResourceType = projectTaskResourceType;
    }

    public String getProjectTaskScheduleTypeCode() {
        return projectTaskScheduleTypeCode;
    }

    public void setProjectTaskScheduleTypeCode(String projectTaskScheduleTypeCode) {
        this.projectTaskScheduleTypeCode = projectTaskScheduleTypeCode;
    }

    public String getProjectTaskScheduleValue() {
        return projectTaskScheduleValue;
    }

    public void setProjectTaskScheduleValue(String projectTaskScheduleValue) {
        this.projectTaskScheduleValue = projectTaskScheduleValue;
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
