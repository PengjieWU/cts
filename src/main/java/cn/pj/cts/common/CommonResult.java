package cn.pj.cts.common;

/**
 * @Author:Pengjie WU
 * @Description:TODO
 * @Date: Create in 23:05 2019/1/20
 * @Modify By:
 **/
public class CommonResult {

    /**返回的状态值
     * code = 0，成功
     * code = -1，失败
     */
    private Integer code;
    /**
     * 返回结果
     */
    private Object data;

    public CommonResult(){
        this.code = 0;
    }

    public CommonResult(Integer code,Object data){
        this.code = code;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
