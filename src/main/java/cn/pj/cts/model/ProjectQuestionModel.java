package cn.pj.cts.model;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author:Pengjie WU
 * @Description:TODO
 * @Date: Create in 17:45 2019/4/6
 * @Modify By:
 **/
@Entity
@Table(name = "TCS_PROJECT_QUESTION_INFO")
@GenericGenerator(name = "jpa-uuid",strategy = "uuid")
@DynamicInsert(true)
public class ProjectQuestionModel extends BaseModel {
    @Id
    @GeneratedValue(generator = "jpa-uuid")
    @Column(name = "PROJECT_QUESTION_ID",length = 32)
    private String  projectQuestionId;

    @Column(name = "PROJECT_ID")
    private String projectId;

    @Column(name = "PROJECT_QUESTION_KEYWORD")
    private String projectQuestionKeyword;

    @Column(name = "PROJECT_QUESTION_DESCRIPTION")
    private String projectQuestionDescription;

    @Column(name = "PROJECT_STORY_ID")
    private String projectStoryId;

    @Column(name = "PROJECT_STORY_NAME")
    private String projectStoryName;

    @Column(name = "PROJECT_QUESTION_ANSWER")
    private  String projectQuestionAnswer;

    @Column(name = "PROJECT_QUESTION_BELONG")
    private String projectQuestionBelong;

    @Column(name = "PROJECT_CREATOR_NAME")
    private String projectCreatorName;

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

    public String getProjectQuestionId() {
        return projectQuestionId;
    }

    public void setProjectQuestionId(String projectQuestionId) {
        this.projectQuestionId = projectQuestionId;
    }

    public String getProjectQuestionKeyword() {
        return projectQuestionKeyword;
    }

    public void setProjectQuestionKeyword(String projectQuestionKeyword) {
        this.projectQuestionKeyword = projectQuestionKeyword;
    }

    public String getProjectQuestionDescription() {
        return projectQuestionDescription;
    }

    public void setProjectQuestionDescription(String projectQuestionDescription) {
        this.projectQuestionDescription = projectQuestionDescription;
    }

    public String getProjectQuestionAnswer() {
        return projectQuestionAnswer;
    }

    public void setProjectQuestionAnswer(String projectQuestionAnswer) {
        this.projectQuestionAnswer = projectQuestionAnswer;
    }

    public String getProjectQuestionBelong() {
        return projectQuestionBelong;
    }

    public void setProjectQuestionBelong(String projectQuestionBelong) {
        this.projectQuestionBelong = projectQuestionBelong;
    }

    public String getProjectCreatorName() {
        return projectCreatorName;
    }

    public void setProjectCreatorName(String projectCreatorName) {
        this.projectCreatorName = projectCreatorName;
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

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getProjectStoryId() {
        return projectStoryId;
    }

    public void setProjectStoryId(String projectStoryId) {
        this.projectStoryId = projectStoryId;
    }

    public String getProjectStoryName() {
        return projectStoryName;
    }

    public void setProjectStoryName(String projectStoryName) {
        this.projectStoryName = projectStoryName;
    }
}
