package cn.pj.cts.entity;

/**
 * @Author:Pengjie WU
 * @Description:TODO
 * @Date: Create in 23:46 2019/3/31
 * @Modify By:
 **/
public class AddUserEntity {

    private String projectId;
    private String targetEmail;
    private String role;

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getTargetEmail() {
        return targetEmail;
    }

    public void setTargetEmail(String targetEmail) {
        this.targetEmail = targetEmail;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
