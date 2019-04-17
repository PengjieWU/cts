package cn.pj.cts.entity;

import cn.pj.cts.model.ProjectTaskInfoModel;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @Author:Pengjie WU
 * @Description:TODO
 * @Date: Create in 20:09 2019/3/17
 * @Modify By:
 **/
public class ProjectTaskInfoEntity extends ProjectTaskInfoModel {

    @JsonFormat(locale="zh", timezone="GMT+8", pattern="MM/dd/yyyy")
    private Date selectDay;

    public Date getSelectDay() {
        return selectDay;
    }

    public void setSelectDay(Date selectDay) {
        this.selectDay = selectDay;
    }
}
