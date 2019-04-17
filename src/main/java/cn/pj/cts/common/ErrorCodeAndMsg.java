package cn.pj.cts.common;

import java.sql.Savepoint;

/**
 * @Author:Pengjie WU
 * @Description:TODO
 * @Date: Create in 0:11 2019/1/24
 * @Modify By:
 **/
public enum ErrorCodeAndMsg {

    Query_Condition_Missing("-1","查询缺少必要参数"),
    Save_Condition_Missing("-1","保存缺少必要参数"),
    Delete_Condition_Missing("-1","删除缺少必要参数"),
    Login_Condition_Error("-1","账号或者密码错误"),
    Login_Account_Error("-1","登录信息异常"),
    Grantor_Authority_Error("-2","菜单重复授权给同一用户"),
    Network_error("-1","网络错误，待会重试"),
    ;


    private String code;
    private String msg;


    ErrorCodeAndMsg(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }



    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }

}
