package cn.pj.cts.entity;

import cn.pj.cts.model.ProjectMenuModel;

/**
 * @Author:Pengjie WU
 * @Description:TODO
 * @Date: Create in 22:03 2019/4/14
 * @Modify By:
 **/
public class ProjectMenuEntity extends ProjectMenuModel {

    private String menuName;
    private String menuUrl;
    private String grantorName;
    private String receiveName;

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public String getGrantorName() {
        return grantorName;
    }

    public void setGrantorName(String grantorName) {
        this.grantorName = grantorName;
    }

    public String getReceiveName() {
        return receiveName;
    }

    public void setReceiveName(String receiveName) {
        this.receiveName = receiveName;
    }
}
