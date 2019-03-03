package cn.pj.cts.model;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author:Pengjie WU
 * @Description:TODO
 * @Date: Create in 15:25 2019/3/3
 * @Modify By:
 **/
@Entity
@Table(name = "TCS_PROJECT_STORY_RESOURCE_INFO")
@GenericGenerator(name = "jpa-uuid",strategy = "uuid")
@DynamicInsert(true)
public class ProjectStoryResourceInfoModel extends BaseModel {
    @Id
    @GeneratedValue(generator = "jpa-uuid")
    @Column(name = "PROJECT_STORY_RESOURCE_ID",length = 32)
    private String projectStoryResourceId;
    @Column(name = "PROJECT_STORY_ID")
    private String projectStoryId;
    @Column(name = "PROJECT_RESOURCE_ID")
    private String projectResourceId;
    @Column(name = "PROJECT_STORY_RESOURCE_NAME")
    private String projectStoryResourceName;
    @Column(name = "PROJECT_STORY_RESOURCE_TYPE")
    private String projectStoryResourceType;

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

    public ProjectStoryResourceInfoModel() {
        super();
    }

    public String getProjectStoryResourceId() {
        return projectStoryResourceId;
    }

    public void setProjectStoryResourceId(String projectStoryResourceId) {
        this.projectStoryResourceId = projectStoryResourceId;
    }

    public String getProjectStoryId() {
        return projectStoryId;
    }

    public void setProjectStoryId(String projectStoryId) {
        this.projectStoryId = projectStoryId;
    }

    public String getProjectResourceId() {
        return projectResourceId;
    }

    public void setProjectResourceId(String projectResourceId) {
        this.projectResourceId = projectResourceId;
    }

    public String getProjectStoryResourceName() {
        return projectStoryResourceName;
    }

    public void setProjectStoryResourceName(String projectStoryResourceName) {
        this.projectStoryResourceName = projectStoryResourceName;
    }

    public String getProjectStoryResourceType() {
        return projectStoryResourceType;
    }

    public void setProjectStoryResourceType(String projectStoryResourceType) {
        this.projectStoryResourceType = projectStoryResourceType;
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
