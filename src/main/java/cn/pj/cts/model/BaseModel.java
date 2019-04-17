package cn.pj.cts.model;

import javax.persistence.Column;
import java.io.Serializable;

/**
 * @Author:Pengjie WU
 * @Description:TODO
 * @Date: Create in 22:57 2019/1/17
 * @Modify By:
 **/
public class BaseModel implements Serializable {
    /**BaseModel基础属性Added*/
    public final static String BAS_MODEL_ADD = "Add";
    /**BaseModel基础属性Modified*/
    public final static String BAS_MODEL_MODIFIER = "Modified";
    /**BaseModel基础属性Deleted*/
    public final static String BAS_MODEL_DELETED = "Deleted";

}
