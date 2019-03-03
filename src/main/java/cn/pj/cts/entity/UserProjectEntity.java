package cn.pj.cts.entity;

import cn.pj.cts.model.ProjectModel;
import cn.pj.cts.model.UserProjectModel;

/**
 * @Author:Pengjie WU
 * @Description:TODO
 * @Date: Create in 21:14 2019/3/2
 * @Modify By:
 **/
public class UserProjectEntity extends UserProjectModel {
    private String userId;
    private String userName;
    private String userLoginAccount;

    public UserProjectEntity() {
    }

    @Override
    public String getUserId() {
        return userId;
    }

    @Override
    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserLoginAccount() {
        return userLoginAccount;
    }

    public void setUserLoginAccount(String userLoginAccount) {
        this.userLoginAccount = userLoginAccount;
    }
}
