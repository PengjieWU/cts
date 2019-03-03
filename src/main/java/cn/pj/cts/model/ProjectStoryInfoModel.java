package cn.pj.cts.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author:Pengjie WU
 * @Description:TODO
 * @Date: Create in 15:05 2019/3/3
 * @Modify By:
 **/
@Entity
@Table(name = "TCS_PROJECT_STORY_INFO")
@GenericGenerator(name = "jpa-uuid",strategy = "uuid")
@DynamicInsert(true)
public class ProjectStoryInfoModel extends BaseModel {

    @Id
    @GeneratedValue(generator = "jpa-uuid")
    @Column(name = "PROJECT_STORY_ID",length = 32)
    private String projectStoryId;
    @Column(name = "STORY_MNEMONIC_CODE")
    private String storyMnemonicCode;
    @Column(name = "PROJECT_ID")
    private String projectId;
    @Column(name = "PROJECT_NAME")
    private String projectName;
    @Column(name = "TARGET_USER_ID")
    private String targetUserId;
    @Column(name = "TARGET_USER_NAME")
    private String targetUserName;
    @Column(name = "PROJECT_STORY_NAME")
    private String projectStoryName;
    @Column(name = "PROJECT_STORY_PRIORITY_CODE")
    private String projectStoryPriorityCode;
    @Column(name = "PROJECT_STORY_PRIORITY_SEQ")
    private String projectStoryPrioritySeq;
    @Column(name = "PROJECT_PARENT_STORY_ID")
    private String projectParentStoryId;
    @Column(name = "PROJECT_STORY_DESCRIPTION")
    private String projectStoryDescription;
    @Column(name = "PROJECT_STORY_TYPE_CODE")
    private String projectStoryTypeCode;
    @Column(name = "PROJECT_STORY_PROGRESS")
    private String projectStoryProgress;
    @Column(name = "PROJECT_STORY_SEQ")
    private Integer projectStorySeq;
    @Column(name = "PROJECT_STORY_DURATION_TIME")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="MM/dd/yyyy")
    private Date projectStoryDurationTime;

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

    public ProjectStoryInfoModel() {
        super();
    }

    public String getProjectStoryId() {
        return projectStoryId;
    }

    public void setProjectStoryId(String projectStoryId) {
        this.projectStoryId = projectStoryId;
    }

    public String getStoryMnemonicCode() {
        return storyMnemonicCode;
    }

    public void setStoryMnemonicCode(String storyMnemonicCode) {
        this.storyMnemonicCode = storyMnemonicCode;
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

    public String getTargetUserId() {
        return targetUserId;
    }

    public void setTargetUserId(String targetUserId) {
        this.targetUserId = targetUserId;
    }

    public String getTargetUserName() {
        return targetUserName;
    }

    public void setTargetUserName(String targetUserName) {
        this.targetUserName = targetUserName;
    }

    public String getProjectStoryName() {
        return projectStoryName;
    }

    public void setProjectStoryName(String projectStoryName) {
        this.projectStoryName = projectStoryName;
    }

    public String getProjectStoryPriorityCode() {
        return projectStoryPriorityCode;
    }

    public void setProjectStoryPriorityCode(String projectStoryPriorityCode) {
        this.projectStoryPriorityCode = projectStoryPriorityCode;
    }

    public String getProjectStoryPrioritySeq() {
        return projectStoryPrioritySeq;
    }

    public void setProjectStoryPrioritySeq(String projectStoryPrioritySeq) {
        this.projectStoryPrioritySeq = projectStoryPrioritySeq;
    }

    public String getProjectParentStoryId() {
        return projectParentStoryId;
    }

    public void setProjectParentStoryId(String projectParentStoryId) {
        this.projectParentStoryId = projectParentStoryId;
    }

    public String getProjectStoryDescription() {
        return projectStoryDescription;
    }

    public void setProjectStoryDescription(String projectStoryDescription) {
        this.projectStoryDescription = projectStoryDescription;
    }

    public String getProjectStoryTypeCode() {
        return projectStoryTypeCode;
    }

    public void setProjectStoryTypeCode(String projectStoryTypeCode) {
        this.projectStoryTypeCode = projectStoryTypeCode;
    }

    public String getProjectStoryProgress() {
        return projectStoryProgress;
    }

    public void setProjectStoryProgress(String projectStoryProgress) {
        this.projectStoryProgress = projectStoryProgress;
    }

    public Integer getProjectStorySeq() {
        return projectStorySeq;
    }

    public void setProjectStorySeq(Integer projectStorySeq) {
        this.projectStorySeq = projectStorySeq;
    }

    public Date getProjectStoryDurationTime() {
        return projectStoryDurationTime;
    }

    public void setProjectStoryDurationTime(Date projectStoryDurationTime) {
        this.projectStoryDurationTime = projectStoryDurationTime;
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
